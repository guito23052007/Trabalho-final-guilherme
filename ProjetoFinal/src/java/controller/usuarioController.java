package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Usuarios;
import model.dao.UsuariosDAO;

@WebServlet(name = "usuarioController", urlPatterns = {"/cadastrar-usuario", "/login", "/cadastro-usuario", "/logar", "/deletar-usuario"})
public class usuarioController extends HttpServlet {
    UsuariosDAO userDao = new UsuariosDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/cadastrar-usuario")) {
            String nextPage = "/WEB-INF/jsp/cadastrarUsuario.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/login")) {
            String nextPage = "/WEB-INF/jsp/login.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userId")) {
                        request.setAttribute("userId", cookie.getValue());
                        break;
                    }
                }
            }
            dispatcher.forward(request, response);
        } else if (url.equals("/deletar-usuario")) {
            int userId = Integer.parseInt(request.getParameter("id"));
            userDao.deletarUsuario(userId);
            response.sendRedirect("./HistoricoUser");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/cadastro-usuario")) {
            Usuarios user = new Usuarios();
            user.setNome(request.getParameter("nome").isEmpty() ? "" : request.getParameter("nome"));
            user.setSenha(request.getParameter("senha"));
            user.setUsuario(request.getParameter("usuario"));
            user.setTelefone(request.getParameter("telefone"));
            user.setData_nascimento(Date.valueOf(request.getParameter("data-nascimento")));
            user.setCpf(request.getParameter("cpf"));

            UsuariosDAO userD = new UsuariosDAO();
            userD.cadastrarUsuario(user);

            response.sendRedirect("./login");
        } else if (url.equals("/logar")) {
            Usuarios user = new Usuarios();
            user.setUsuario(request.getParameter("usuario"));
            user.setSenha(request.getParameter("senha"));

            UsuariosDAO userD = new UsuariosDAO();
            user = userD.buscarLogin(user);
            if (user.getId_usuario() > 0) {
                // Set cookies for login persistence using user ID
                Cookie userCookie = new Cookie("userId", String.valueOf(user.getId_usuario()));
                
                response.addCookie(userCookie);

                if (user.getStatus() == 2) {
                    response.sendRedirect("./cadastrar-produto");
                } else {
                    response.sendRedirect("./home");
                }
            } else {
                PrintWriter sout = response.getWriter();
                sout.println("<script type=\"text/javascript\">");
                sout.println("alert('login não encontrado.');");
                sout.println("window.location.href = './login';");
                sout.println("</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

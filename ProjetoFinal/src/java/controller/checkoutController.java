package controller;

import static conexao.Conexao.url;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Carrinho;
import model.bean.Pagamento;
import model.dao.CarrinhoDAO;
import model.dao.PagamentoDAO;

@WebServlet(urlPatterns = "/checkouto")
@MultipartConfig
public class checkoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getIdUsuarioFromCookie(request);
        if (userId != -1) {
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinho = carrinhoDAO.leia(userId);
            request.setAttribute("carrinho", carrinho);

            List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(userId);
            request.setAttribute("totalPreco", totalPreco);

            String nextPage = "/WEB-INF/jsp/checalt.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        int idUsuario = getIdUsuarioFromCookie(request); // Obtém o ID do usuário do cookie

        if (url.equals("/checkouto") && idUsuario != -1) {
            Pagamento newPagamento = new Pagamento();
            newPagamento.setId_usuario(idUsuario); // Define o ID do usuário

            
            String nomeSobrenome = request.getParameter("nome_sobrenome");
            String tipoPagamento = request.getParameter("tipo_pagamento");

            newPagamento.setNome_sobrenome(nomeSobrenome);
            newPagamento.setTipo_pagamento(tipoPagamento);

            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            pagamentoDAO.checalt(newPagamento); // Insere no banco de dados

            response.sendRedirect("./historicoPedidoUser"); 
        } else {
            
        }
    }

    private int getIdUsuarioFromCookie(HttpServletRequest request) {
        int idUsuario = -1;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    String cookieValue = cookie.getValue();
                    try {
                        idUsuario = Integer.parseInt(cookieValue);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return idUsuario;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

package controller;

import static conexao.Conexao.url;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Carrinho;
import model.bean.Pagamento;
import model.dao.CarrinhoDAO;
import model.dao.PagamentoDAO;

public class checkoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getIdUsuarioFromCookie(request);
        if (userId != -1) {
            // Listar produtos do carrinho
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinho = carrinhoDAO.leia(userId);
            request.setAttribute("carrinho", carrinho);

            // Calcular total do carrinho
            List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(userId);
            request.setAttribute("totalPreco", totalPreco);

            // Encaminha para a página de checkout
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

    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (url.equals("/checkout")) {
            Pagamento user = new Pagamento();
            user.setNome_sobrenome(request.getParameter("nome"));
            user.setTipo_pagamento(request.getParameter("senha"));
            

            PagamentoDAO userD = new PagamentoDAO();
              userD.checalt(user);

        response.sendRedirect("./historicoPedidoUser");
        } 
        
    }

    private int getIdUsuarioFromCookie(HttpServletRequest request) {
        int idUsuario = -1; // Valor padrão, caso não seja possível extrair o ID do usuário do cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    String cookieValue = cookie.getValue();
                    try {
                        idUsuario = Integer.parseInt(cookieValue);
                    } catch (NumberFormatException e) {
                        e.printStackTrace(); // ou outro tratamento de erro, se desejado
                    }
                    break; // Encerra o loop assim que encontrar o cookie desejado
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

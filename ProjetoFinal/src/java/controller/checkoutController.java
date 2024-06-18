/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Carrinho;
import model.bean.historico_Pedido;
import model.dao.CarrinhoDAO;
import model.dao.histroricoDAO;

/**
 *
 * @author Edson
 */
public class checkoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Verifica se há um cookie de usuário
    int userId = -1;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                userId = Integer.parseInt(cookie.getValue());
                break;
            }
        }
    }

    // Se userId for válido, lista os produtos do carrinho
    if (userId != -1) {
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        List<Carrinho> carrinho = carrinhoDAO.leia(userId);
        request.setAttribute("carrinho", carrinho);
        
      int idUsuario = getIdUsuarioFromCookie(request);

   List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(idUsuario);
            request.setAttribute("totalPreco", totalPreco);

    // Encaminha para a página de checkout (checalt.jsp)
    String nextPage = "/WEB-INF/jsp/checalt.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
    dispatcher.forward(request, response);
    }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extrai dados do formulário enviado
        String nomeProduto = request.getParameter("nome");
        float valorProduto = Float.parseFloat(request.getParameter("valor"));
        String imagemProduto = request.getParameter("imagem");
        int idUsuario = getIdUsuarioFromCookie(request);

        // Cria o objeto historico_Pedido com os dados do produto
        historico_Pedido historicoUser = new historico_Pedido();
        historicoUser.setNome_produto(nomeProduto);
        historicoUser.setValor_produto(valorProduto);
        historicoUser.setImagem_produto(imagemProduto);
        historicoUser.setIdUsuario(idUsuario);
        historicoUser.setDatahora(LocalDateTime.now());

        // Chama o método para inserir o histórico na base de dados
        histroricoDAO historicoDAO = new histroricoDAO();
        historicoDAO.inserirHistorico(historicoUser);

        // Redireciona ou encaminha para a página de histórico de pedidos do usuário
        response.sendRedirect("historicoPedidoUser");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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
                        // Em caso de falha na conversão, o idUsuario permanecerá como -1
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
    }// </editor-fold>

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.historico_Pedido;
import model.dao.histroricoDAO;

public class historicoPedidoUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém o ID do usuário a partir do cookie
        int idUsuario = getIdUsuarioFromCookie(request);

        // Instancia o DAO para buscar o histórico de pedidos do usuário
        histroricoDAO historicoDAO = new histroricoDAO();
        List<historico_Pedido> pedidos = historicoDAO.historicoUser(idUsuario);

        // Envia a lista de pedidos para o JSP
        request.setAttribute("pedidos", pedidos);

        // Encaminha para a página JSP de histórico de pedidos do usuário
        String nextPage = "/WEB-INF/jsp/HistoricoPedidosUser.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        return "Servlet para exibir histórico de pedidos do usuário";
    }
}

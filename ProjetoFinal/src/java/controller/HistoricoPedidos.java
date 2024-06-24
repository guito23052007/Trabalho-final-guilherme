package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.historico_Pedido;
import model.dao.histroricoDAO;

public class HistoricoPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Instanciando o DAO para buscar o histórico de pedidos
        histroricoDAO historicoDAO = new histroricoDAO();
        List<historico_Pedido> pedidos = historicoDAO.historico();
        
        // lista os produtos no jsp
        request.setAttribute("pedidos", pedidos);
        
        
      
        List<historico_Pedido> total = historicoDAO.Total();
        request.setAttribute("total", total);
        
       
        String nextPage = "/WEB-INF/jsp/historicoPedios.jsp";
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

    @Override
    public String getServletInfo() {
        return "Controller para exibir histórico de pedidos de um usuário";
    }
}

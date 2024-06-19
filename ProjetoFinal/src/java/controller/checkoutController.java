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
import model.bean.Pagamento; // Certifique-se de importar a classe Pagamento corretamente
import model.dao.CarrinhoDAO;
import model.dao.PagamentoDAO;

/**
 *
 * @author Edson
 */
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
        String nome_sobrenome = request.getParameter("nome_sobrenome");
      

        // Criar objeto de pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setId_usuario(getIdUsuarioFromCookie(request));
        pagamento.setNome_sobrenome(nome_sobrenome);

        // Inserir pagamento no banco de dados
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        pagamentoDAO.pagamento(pagamento);

        // Redirecionar para página de histórico de pedidos do usuário
        response.sendRedirect("historicoPedidoUser");
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

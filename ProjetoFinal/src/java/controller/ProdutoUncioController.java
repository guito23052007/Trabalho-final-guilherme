package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.bean.Produtos;
import model.dao.CarrinhoDAO;
import model.dao.ProdutosDAO;

@WebServlet(urlPatterns = {"/carrinho", "/deletar-produto"})
@MultipartConfig
public class ProdutoUncioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        // Busca o produto pelo ID
        ProdutosDAO produtoDAO = new ProdutosDAO();
        List<Produtos> produtos = produtoDAO.unicoProdutos(id);
        request.setAttribute("produtos", produtos);

        // Obtém o ID do usuário a partir do cookie
        int idUsuario = getIdUsuarioFromCookie(request);

        // Verifica se o ID do usuário foi encontrado nos cookies
        if (idUsuario != -1) {

            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinho = carrinhoDAO.leia(idUsuario);
            request.setAttribute("carrinho", carrinho);

            List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(idUsuario);
            request.setAttribute("totalPreco", totalPreco);

        }

        String url = "/WEB-INF/jsp/produtoUnico.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
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

        String url = request.getServletPath();

        if (url.equals("/deletar-produto")) {
            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            carrinhoDAO.deletarProduto(idCarrinho);
            PrintWriter sout = response.getWriter();
           
            // Após deletar o produto, redirecionar de volta para a página do carrinho
            response.sendRedirect(request.getContextPath() + "/carrinhos");
            return; // Importante retornar para encerrar o método após o redirecionamento
        }

        String action = request.getServletPath();
        if (action.equals("/carrinho")) {
            produto(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void produto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém o ID do usuário a partir do cookie
        int idUsuario = getIdUsuarioFromCookie(request);

        // Verifica se o ID do usuário foi encontrado nos cookies
        if (idUsuario != -1) {
            // Cria um novo objeto Carrinho com os dados do produto a ser adicionado

            Carrinho carrinho = new Carrinho();
            carrinho.setNomeCarrinho(request.getParameter("nome_carrinho"));
            carrinho.setPrecoCarrinho(Float.parseFloat(request.getParameter("preco_carrinho")));
            carrinho.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade_carrinho")));
            carrinho.setIdProdutos(Integer.parseInt(request.getParameter("idProdutos")));
            carrinho.setIdUsuario(idUsuario);
            carrinho.setImagemCarrinho(request.getParameter("imagem_carrinho"));

            // Insere o produto no carrinho
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            carrinhoDAO.inserirProdutoCarrinho(carrinho);

            // Redireciona de volta para a página de onde veio
            response.sendRedirect("./home");
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
    }
}

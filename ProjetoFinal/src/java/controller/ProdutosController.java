package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.Carrinho;
import model.bean.Categorias;
import model.bean.Produtos;
import model.bean.Usuarios;
import model.dao.CarrinhoDAO;
import model.dao.CategoriasDAO;
import model.dao.ProdutosDAO;
import model.dao.UsuariosDAO;

@MultipartConfig
public class ProdutosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuarios user = new Usuarios();
        UsuariosDAO userDao = new UsuariosDAO();
        Cookie[] cookies = request.getCookies();

        int userId = -1;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userId")) {
                    userId = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        ProdutosDAO produtosDAO = new ProdutosDAO();
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        List<Categorias> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categorias", categorias);
        String url = request.getServletPath();

        if (url.equals("/cadastrar-produto")) {
            String nextPage = "/WEB-INF/jsp/cadastrarProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/home")) {
            List<Produtos> produtos = produtosDAO.listarProdutos();
            request.setAttribute("produtos", produtos);

            List<Produtos> xbox = produtosDAO.ListarXbox();
            request.setAttribute("xbox", xbox);

            List<Produtos> nintendo = produtosDAO.ListarNintendo();
            request.setAttribute("nintendo", nintendo);

            List<Produtos> playStation = produtosDAO.ListarPlaystation();
            request.setAttribute("playStation", playStation);

            List<Produtos> rpg = produtosDAO.ListarRpg();
            request.setAttribute("rpg", rpg);
            int idUsuario = getIdUsuarioFromCookie(request);
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

            List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(idUsuario);
            request.setAttribute("totalPreco", totalPreco);
            String nextPage = "/WEB-INF/jsp/Home.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/Nintendos")) {
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Produtos> nintendo = produtosDAO.ListarNintendo();
        request.setAttribute("nintendo", nintendo);

      
        String nextPage = "/WEB-INF/jsp/Nintendos.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
        } else if (url.equals("/carrinhos")) {
            if (userId == -1) {
                PrintWriter sout = response.getWriter();
                sout.println("<script type=\"text/javascript\">");
                sout.println("alert('voce precisa estar logado.');");
                sout.println("window.location.href = './home';");
                sout.println("</script>");
                return;
            }
            
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            List<Carrinho> carrinho = carrinhoDAO.leia(userId);
            request.setAttribute("carrinho", carrinho);
            int idUsuario = getIdUsuarioFromCookie(request);

            List<Carrinho> totalPreco = carrinhoDAO.leiaTotal(idUsuario);
            request.setAttribute("totalPreco", totalPreco);
            String nextPage = "/WEB-INF/jsp/carrinho.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";

            if (busca.equals("")) {
                String categoria = request.getParameter("cat");
                List<Produtos> produtos = produtosDAO.buscaCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%" + busca + "%";
                List<Produtos> produtos = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }

            String nextPage = "/WEB-INF/jsp/produtos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/deletar-produto")) {
            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            carrinhoDAO.deletarProduto(idCarrinho);
            response.sendRedirect("./Home");

        }
        int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));

        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoDAO.deletarProduto(idCarrinho);

        response.sendRedirect("./carrinhos");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produtos newProduto = new Produtos();
        newProduto.setNome(request.getParameter("nome"));
        newProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setLink(request.getParameter("link"));
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));

        // Verifica se o preço do produto é maior que zero
        if (newProduto.getValor() <= 0) {
            response.sendRedirect("./home");
            return;
        }

        // Base path para salvar as imagens
        String basePath = getServletContext().getRealPath("/") + "assets";
        File uploads = new File(basePath);
        if (!uploads.exists()) {
            uploads.mkdirs();
        }

        // Primeira imagem
        Part filePart1 = request.getPart("imagem");
        String fileName1 = Paths.get(filePart1.getSubmittedFileName()).getFileName().toString();
        if (fileName1 != null && !fileName1.isEmpty()) {
            File file1 = new File(uploads, fileName1);
            try (InputStream input = filePart1.getInputStream()) {
                Files.copy(input, file1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem("assets/" + fileName1);
        } else {
            newProduto.setImagem(null);
        }

        // Segunda imagem
        Part filePart2 = request.getPart("imagem2");
        String fileName2 = Paths.get(filePart2.getSubmittedFileName()).getFileName().toString();
        if (fileName2 != null && !fileName2.isEmpty()) {
            File file2 = new File(uploads, fileName2);
            try (InputStream input = filePart2.getInputStream()) {
                Files.copy(input, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem2("assets/" + fileName2);
        } else {
            newProduto.setImagem2(null);
        }

        // Terceira imagem
        Part filePart3 = request.getPart("imagem3");
        String fileName3 = Paths.get(filePart3.getSubmittedFileName()).getFileName().toString();
        if (fileName3 != null && !fileName3.isEmpty()) {
            File file3 = new File(uploads, fileName3);
            try (InputStream input = filePart3.getInputStream()) {
                Files.copy(input, file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem3("assets/" + fileName3);
        } else {
            newProduto.setImagem3(null);
        }

        // Quarta imagem
        Part filePart4 = request.getPart("imagem4");
        String fileName4 = Paths.get(filePart4.getSubmittedFileName()).getFileName().toString();
        if (fileName4 != null && !fileName4.isEmpty()) {
            File file4 = new File(uploads, fileName4);
            try (InputStream input = filePart4.getInputStream()) {
                Files.copy(input, file4.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem4("assets/" + fileName4);
        } else {
            newProduto.setImagem4(null);
        }

        // Quinta imagem
        Part filePart5 = request.getPart("imagem5");
        String fileName5 = Paths.get(filePart5.getSubmittedFileName()).getFileName().toString();
        if (fileName5 != null && !fileName5.isEmpty()) {
            File file5 = new File(uploads, fileName5);
            try (InputStream input = filePart5.getInputStream()) {
                Files.copy(input, file5.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem5("assets/" + fileName5);
        } else {
            newProduto.setImagem5(null);
        }

        // Sexta imagem
        Part filePart6 = request.getPart("imagem6");
        String fileName6 = Paths.get(filePart6.getSubmittedFileName()).getFileName().toString();
        if (fileName6 != null && !fileName6.isEmpty()) {
            File file6 = new File(uploads, fileName6);
            try (InputStream input = filePart6.getInputStream()) {
                Files.copy(input, file6.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem6("assets/" + fileName6);
        } else {
            newProduto.setImagem6(null);
        }

        // Sétima imagem
        Part filePart7 = request.getPart("imagem7");
        String fileName7 = Paths.get(filePart7.getSubmittedFileName()).getFileName().toString();
        if (fileName7 != null && !fileName7.isEmpty()) {
            File file7 = new File(uploads, fileName7);
            try (InputStream input = filePart7.getInputStream()) {
                Files.copy(input, file7.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem7("assets/" + fileName7);
        } else {
            newProduto.setImagem7(null);
        }

        // Oitava imagem
        Part filePart8 = request.getPart("imagem8");
        String fileName8 = Paths.get(filePart8.getSubmittedFileName()).getFileName().toString();
        if (fileName8 != null && !fileName8.isEmpty()) {
            File file8 = new File(uploads, fileName8);
            try (InputStream input = filePart8.getInputStream()) {
                Files.copy(input, file8.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            newProduto.setImagem8("assets/" + fileName8);
        } else {
            newProduto.setImagem8(null);
        }

        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.cadastrarProduto(newProduto);
        response.sendRedirect("./home");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.bean.Produtos;
import model.dao.ProdutosDAO;

public final class produtoUnico_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/unico.css\">\n");
      out.write("                <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/header.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <header>\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                  <a class=\"navbar-brand\" href=\"./home\"><i class=\"fa-solid fa-house\"></i></a>\n");
      out.write("                  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    \n");
      out.write("                    <form class=\"d-flex\" action=\"buscar-produtos\" method=\"get\">\n");
      out.write("                        <input class=\"form-control me-2\" name=\"busca\" type=\"search\" placeholder=\"     Pesquisar\" aria-label=\"Search\">\n");
      out.write("                        <button class=\"btn btn-outline-success\" type=\"submit\">\n");
      out.write("                            <i class=\"fa-solid fa-magnifying-glass\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </form>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container container-categorias\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("              </nav>\n");
      out.write("        </header>\n");
      out.write("        <main>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ffe7fbbd06.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categorias}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("categoria");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <div class=\"categoria\">\n");
          out.write("                            <a href=\"./buscar-produtos?cat=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.idCategoria}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&busca=\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${categoria.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\n");
          out.write("                        </div>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("produto");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produtos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <div id=\"produto_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.idProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"produto\">\n");
          out.write("                        <h2>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h2>\n");
          out.write("                        <img src=\"data:image/jpg;base64,");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.imagemBase64}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                        <p id=\"preco\">R$: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.valor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\n");
          out.write("                        <p id=\"desc\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.descricao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\n");
          out.write("                        <button type=\"submit\" class=\"btn btn-comprar\"  id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.idProduto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" descricao=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.descricao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" nome=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" valor=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.valor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" imagem=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${produto.imagemBase64}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"\n");
          out.write("                                id=\"comprar\">\n");
          out.write("                            <i class=\"fa-solid fa-basket-shopping\"></i> Comprar\n");
          out.write("                        </button>\n");
          out.write("                                <div class=\"carrinho\"><button>Adicionar Carrinho</button></div>\n");
          out.write("                    </div>\n");
          out.write("                           </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}

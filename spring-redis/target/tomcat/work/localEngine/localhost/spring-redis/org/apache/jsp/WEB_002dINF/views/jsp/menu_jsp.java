package org.apache.jsp.WEB_002dINF.views.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"${path}/js/jquery-1.10.1.min.js\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"${path}/js/laytpl.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("    $(document).on(\"click\",\"#btn\",function(){\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type:\"POST\",\r\n");
      out.write("            url:\"/queryCity.do\",\r\n");
      out.write("            data:{id:$(\"#cityid\").val(),citycode:$(\"#citycode\").val()},\r\n");
      out.write("            datatype:json,\r\n");
      out.write("            success:function(data){\r\n");
      out.write("                var getlpl=document.getElementById(\"demo\").innerHTML;\r\n");
      out.write("                laytpl(getlpl).render(data,function(html){\r\n");
      out.write("                    document.getElementById(\"view\").innerHTML=html;\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<form id=\"form1\" action=\"queryCity.do\" method=\"post\">\r\n");
      out.write("    <span>citycode:</span>\r\n");
      out.write("    <input width=\"50\" id=\"citycode\" name=\"citycode\" />\r\n");
      out.write("    <span>id:</span>\r\n");
      out.write("    <input  width=\"30\" id=\"cityid\" name=\"id\"/>\r\n");
      out.write("    <button id=\"btn\" value=\"查询\"></button>\r\n");
      out.write("</form>\r\n");
      out.write("<span>查询结果</span>\r\n");
      out.write("<table>\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th width=\"10\">id</th>\r\n");
      out.write("        <th width=\"30\">city_code</th>\r\n");
      out.write("        <th width=\"30\">city_jb</th>\r\n");
      out.write("        <th width=\"50\">province_code</th>\r\n");
      out.write("        <th width=\"50\">state</th>\r\n");
      out.write("        <th width=\"50\">cityname</th>\r\n");
      out.write("        <th width=\"50\">city</th>\r\n");
      out.write("        <th width=\"50\">province</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    </thead>\r\n");
      out.write("\r\n");
      out.write("    <tbody id=\"view\"></tbody>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<script id=\"demo\" type=\"text/html\">\r\n");
      out.write("    {{# for (var i=0;i<d.row.length;i++){ }}\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>{{d.row[i].id}}</td>\r\n");
      out.write("                <td>{{d.row[i].citycode}}</td>\r\n");
      out.write("                <td>{{d.row[i].cityjb}}</td>\r\n");
      out.write("                <td>{{d.row[i].provincecode}}</td>\r\n");
      out.write("                <td>{{d.row[i].state}}</td>\r\n");
      out.write("                <td>{{d.row[i].cityname}}</td>\r\n");
      out.write("                <td>{{d.row[i].city}}</td>\r\n");
      out.write("                <td>{{d.row[i].province}}</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("  {{#  } }}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/views/jsp/menu.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("path");
    // /WEB-INF/views/jsp/menu.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/jsp/menu.jsp(3,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression("${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}

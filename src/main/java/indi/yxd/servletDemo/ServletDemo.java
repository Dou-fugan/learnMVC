package indi.yxd.servletDemo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.*;
public class ServletDemo extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>");
		out.println("<body>");
		out.println("");
		out.println("测试");
		out.println("</body>");
		out.println("</HTML>");
		out.flush();
	}
}

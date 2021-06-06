package indi.yxd.servletDemo;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name="ControllerServlet",urlPatterns= {"/world","/modelProessDemo"})
public class ControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		proess(request,response);
	}
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		proess(request,response);
	}
	
	public void proess(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		String dispatcherUrl=null;
		if(("world").equals(action)) {
			dispatcherUrl="jsp/world.jsp";
		}else if(("modelProessDemo").equals(action)) {
			dispatcherUrl="jsp/modelProessDemo.jsp";
			//process the model
			
			Model Model=new Model();
			Model.setName(request.getParameter("name"));
			
			//form has been omitted
			
			request.setAttribute("Model", Model);
			
			dispatcherUrl="/jsp/modelProessDemo.jsp";
		}
		
		if(dispatcherUrl!=null) {
			System.out.println(request.getAttribute("Model"));
			RequestDispatcher rd= request.getRequestDispatcher(dispatcherUrl);
			request.setCharacterEncoding("UTF-8");
			rd.forward(request, response);
		}
	}
}

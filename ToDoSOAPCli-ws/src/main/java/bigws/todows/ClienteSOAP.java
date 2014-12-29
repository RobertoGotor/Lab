package bigws.todows;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bigws.todows.*;

/**
 * Servlet implementation class ClienteSOAP
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/handler" })
public class ClienteSOAP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToDoWebServiceService hwss = new ToDoWebServiceService();
		ToDoWebService hws = hwss.getToDoWebServicePort();
		try {
			String type = request.getParameter("type");
			PrintWriter out = response.getWriter();
			ListaTareas listaTareas;
			
			switch(type){
				case "add":
					String  txt=hws.add(request.getParameter("name"),request.getParameter("context"),request.getParameter("project"),request.getParameter("priority"));
					out.println("<html><head><title>ToDo List SOAP Client!</title></head>"
							+ "<body><h2>"+txt+"</h2><br/>");
					out.print("<form action=\"http://localhost:8081\"> <input type=submit value=\"Volver\"></form>");
					out.println( "</body></html>");
					break;
				case "show":	
					listaTareas=hws.mostrar();
					out.println("<html><head><title>ToDo List SOAP Client!</title></head>"
							+ "<body><h2>Task list</h2><br/>");
					for (Tarea tarea : listaTareas.getListaTareas()) {					
						out.println( "<p>Task name: "+ tarea.getTask()
								+ "<br/>Task project: "+ tarea.getProject()
								+ "<br/>Task context: "+ tarea.getContext()
								+ "<br/>Task priority: "+ tarea.getPriority()+"<br/></p>");			
					}	
					out.print("<form action=\"http://localhost:8081\"> <input type=submit value=\"Volver\"></form>");
					out.println( "</body></html>");
					break;
				case "search":	
					listaTareas=hws.buscar(request.getParameter("name"));
					out.println("<html><head><title>ToDo List SOAP Client!</title></head>"
							+ "<body><h2>Task list</h2><br/>");
					for (Tarea tarea : listaTareas.getListaTareas()) {					
						out.println( "<p>Task name: "+ tarea.getTask()
								+ "<br/>Task project: "+ tarea.getProject()
								+ "<br/>Task context: "+ tarea.getContext()
								+ "<br/>Task priority: "+ tarea.getPriority()+"<br/></p>");			
					}	
					out.print("<form action=\"http://localhost:8081\"> <input type=submit value=\"Volver\"></form>");
					out.println( "</body></html>");
					break;
				case "delete":	
					String r=hws.delete(request.getParameter("name"));
					out.println("<html><head><title>ToDo List SOAP Client!</title></head>"
							+ "<body><h2>"+r+" </h2><br/>");
					out.print("<form action=\"http://localhost:8081\"> <input type=submit value=\"Volver\"></form>");
					out.println( "</body></html>");
					break;
				
				
			}
			
			} catch (FileNotFoundException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

package rest.todows;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 * Servlet implementation class Client
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/handler" })
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		javax.ws.rs.client.Client c = ClientBuilder.newClient();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		Response resp = null;			
		ListaTareas tl= new ListaTareas();	
		Tarea tarea;
			switch(type){
				case "add":
					tarea= new Tarea(request.getParameter("name"),request.getParameter("context"),request.getParameter("project"),request.getParameter("priority"));
					
					resp = c
					.target("http://localhost:8080/todolist")
					.request(MediaType.APPLICATION_JSON)
					.put(Entity.entity(tarea, MediaType.APPLICATION_JSON));
					tl= resp.readEntity(ListaTareas.class);
					out.println("<html><head><title>ToDoList REST Client!</title></head>"
							+ "<body><h2>Task "+ request.getParameter("name") +" added!</h2><br/>");
					break;
				case "show":	
					resp = c
					.target("http://localhost:8080/todolist")
					.request(MediaType.APPLICATION_JSON).get();
					tl= resp.readEntity(ListaTareas.class);
					out.println("<html><head><title>ToDoList REST Client!</title></head>"
							+ "<body><h2>Task list</h2><br/>");
					break;
				case "search":	
					resp = c
							.target("http://localhost:8080/todolist/"+request.getParameter("name"))
							.request(MediaType.APPLICATION_JSON).get();
					tl= resp.readEntity(ListaTareas.class);
					out.println("<html><head><title>ToDoList REST Client!</title></head>"
							+ "<body><h2>Task Searched: "+request.getParameter("name")+"</h2><br/>");
					break;
				case "delete":	
					resp = c
							.target("http://localhost:8080/todolist/"+request.getParameter("name"))
							.request()
							.delete();
					tl= resp.readEntity(ListaTareas.class);
					out.println("<html><head><title>ToDoList REST Client!</title></head>"
							+ "<body><h2>Task Deleted: "+request.getParameter("name")+"</h2><br/>");
				break;
				case "mod":	
					tarea= new Tarea(request.getParameter("name"),request.getParameter("context"),request.getParameter("project"),request.getParameter("priority"));
					
					resp = c
					.target("http://localhost:8080/todolist")
					.request(MediaType.APPLICATION_JSON)
					.post(Entity.entity(tarea, MediaType.APPLICATION_JSON));
					tl= resp.readEntity(ListaTareas.class);
					out.println("<html><head><title>ToDoList REST Client!</title></head>"
							+ "<body><h2>Task modified: "+request.getParameter("name")+"</h2><br/>");
				break;
			
			
		}
			
			
			for(Tarea t : tl.getListaTareas()){
				out.println( "<p>Task name: "+ t.getTask()
						+ "<br/>Task project: "+ t.getProject()
						+ "<br/>Task context: "+ t.getContext()
						+ "<br/>Task priority: "+ t.getPriority()+"<br/></p>");	
			}
		out.println( "</body></html>");
		
	}

}

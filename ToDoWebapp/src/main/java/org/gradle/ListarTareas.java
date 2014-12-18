package org.gradle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/listar" })
public class ListarTareas extends HttpServlet {
	public final static String DEFAULT_FILE_NAME = "toDo_list.json";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		// Read the existing address book.
		ListaTareas listaTareas = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		
		out.println("<html><head><title>ToDo List WebApp!</title></head>"
				+ "<body><h2>Task list</h2><br/>");
		for (Tarea tarea : listaTareas.getListaTareas()) {
			
			out.println( "<p>Task name: "+ tarea.getTask()
					+ "<br/>Task project: "+ tarea.getProject()
					+ "<br/>Task context: "+ tarea.getContext()
					+ "<br/>Task priority: "+ tarea.getPriority()+"<br/></p>");			
		}

		out.println( "</body></html>");
	}
	
	
}

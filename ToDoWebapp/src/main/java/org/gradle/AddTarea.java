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
@WebServlet(urlPatterns = { "/add" })
public class AddTarea extends HttpServlet {
	public final static String DEFAULT_FILE_NAME = "toDo_list.json";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String project= req.getParameter("project");
		String context= req.getParameter("context");
		String priority= req.getParameter("priority");
		add(name,project,context,priority);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Added!</title></head>"
				+ "<body><h2>Added the new task !</h2><br/>"
				+ "Task name: "+ name
				+ "<br/>Task project: "+ project
				+ "<br/>Task context: "+ context
				+ "<br/>Task priority: "+ priority
				+ "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private void add(String name,String project,String context,String priority){
		ListaTareas addressBook = new ListaTareas();
		String filename = DEFAULT_FILE_NAME;
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			addressBook = gson.fromJson(new FileReader(filename),
					ListaTareas.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		// Add an address.
		addressBook.addTarea(new Tarea(name,project,context,priority));

		// Write the new address book back to disk.
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(addressBook));
			output.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}

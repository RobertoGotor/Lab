package bigws.ToDows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;



import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
@WebService
public class ToDoWebService {
	public final static String DEFAULT_FILE_NAME = "toDo_list.json";
	@WebMethod()
	public String add(String task,String context,String project, String priority ) {
		ListaTareas lt = new ListaTareas();
		String filename = DEFAULT_FILE_NAME;
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			lt = gson.fromJson(new FileReader(filename),
					ListaTareas.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		// Add an address.
		lt.addTarea(new Tarea(task,project,context,priority));

		// Write the new address book back to disk.
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(lt));
			output.close();
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return "Task: "+task +" added!";
	}
	@WebMethod()
	public ListaTareas mostrar( ) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		ListaTareas listaTareas = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		
		return listaTareas;
	}
	@WebMethod()
	public ListaTareas buscar(String name) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		ListaTareas listaTareas = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		ListaTareas resul = new ListaTareas();
		for (Tarea tarea : listaTareas.getListaTareas()) {
			if(tarea.getTask().equals(name))
			resul.addTarea(tarea);		
		}
		
		return resul;
	}
	
	@WebMethod()
	public String delete(String task ) {
		ListaTareas lt = new ListaTareas();
		ListaTareas lt2 = new ListaTareas();
		String filename = DEFAULT_FILE_NAME;
		Gson gson = new Gson();
		try {
			lt = gson.fromJson(new FileReader(filename),
					ListaTareas.class);
		for (Tarea tarea : lt.getListaTareas()) {
			if(!tarea.getTask().equals(task)){
				lt2.addTarea(tarea);
			}
				
		}
		// Read the existing address book.
		
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		

		// Write the new address book back to disk.
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(lt2));
			output.close();
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return "task: "+task +" deleted!";
	}
}

package rest.todolist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;




import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


@Path("/todolist")
public class ToDoListService {
	public final static String DEFAULT_FILE_NAME = "toDo_list.json";

	@Inject
	ListaTareas tl;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ListaTareas getListaTareas() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		tl = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		return tl;
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public ListaTareas addTask(@Context UriInfo info, Tarea tarea) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		tl = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		
		tl.addTarea(tarea);
		
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(tl));
			output.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return tl;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public ListaTareas modificar(@Context UriInfo info, Tarea tarea) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		tl = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		ListaTareas lt= new ListaTareas();
		for (Tarea p : tl.getListaTareas()) {
			if (p.getTask().equals(tarea.getTask())) {
				lt.addTarea(tarea);
			}else{
				lt.addTarea(p);
			}
		}
		tl=lt;
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(lt));
			output.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return tl;
	}
	

	@DELETE
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListaTareas deleteTarea(@PathParam("name") String name) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		tl = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		ListaTareas lt= new ListaTareas();
		for (Tarea p : tl.getListaTareas()) {
			if (!p.getTask().equals(name)) {
				lt.addTarea(p);
			}
		}
		tl=lt;
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(lt));
			output.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return tl;
	}


	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListaTareas getTarea(@PathParam("name") String name) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		tl = gson.fromJson(new FileReader(filename),
				ListaTareas.class);
		ListaTareas lt= new ListaTareas();
		for (Tarea p : tl.getListaTareas()) {
			if (p.getTask().equals(name)) 
				lt.addTarea(p);
			}
	
		return lt;
	}

	}



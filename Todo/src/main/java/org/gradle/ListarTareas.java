package org.gradle;


import java.io.FileReader;

import com.google.gson.Gson;

class ListarTareas {
	public final static String DEFAULT_FILE_NAME = "toDo_List.json";

	// Iterates though all people in the ListaTareas and prints info about them.
	static void Print(ListaTareas addressBook) {
		for (Tarea tarea : addressBook.getListaTareas()) {
			System.out.println();
			System.out.println("-------------------------------------------");
			System.out.println("Task: " + tarea.getTask());
			System.out.println("Task priority: " + tarea.getPriority());
			System.out.println("Task context: " + tarea.getContext());
			System.out.println("Task project: " + tarea.getProject());
			
		}
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing address book.
		ListaTareas listaTareas = gson.fromJson(new FileReader(filename),
				ListaTareas.class);

		Print(listaTareas);
	}
}
package org.gradle;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.google.gson.Gson;


public class AddTarea {

	public final static String DEFAULT_FILE_NAME = "toDo_list.json";

	// This function fills in a Tarea message based on user input.
	static Tarea PromptForAddress(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		Tarea tarea = new Tarea();
		stdout.print("Enter task name: ");
		tarea.setTask(stdin.readLine());
		
		stdout.print("Enter task project: ");
		tarea.setProject(stdin.readLine());
		
		stdout.print("Enter Task priority: ");
		tarea.setPriority(Integer.valueOf(stdin.readLine()));

		stdout.print("Enter task context: ");
		tarea.setContext(stdin.readLine());

		

		return tarea;
	}

	// Main function: Reads the entire address book from a file,
	// adds one tarea based on user input, then writes it back out to the same
	// file.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		ListaTareas addressBook = new ListaTareas();
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
		addressBook.addTarea(PromptForAddress(new BufferedReader(
				new InputStreamReader(System.in)), System.out));

		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(addressBook));
		output.close();
	}
}

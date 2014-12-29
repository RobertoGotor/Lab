package rest.todows;



import java.util.ArrayList;
import java.util.List;

public class ListaTareas {

	private List<Tarea> ListaTareas = new ArrayList<Tarea>();

	public List<Tarea> getListaTareas() {
		return ListaTareas;
	}

	public void setListaTareas(List<Tarea> tareas) {
		this.ListaTareas = tareas;
	}

	public void addTarea(Tarea tarea) {
		ListaTareas.add(tarea);
	}
}

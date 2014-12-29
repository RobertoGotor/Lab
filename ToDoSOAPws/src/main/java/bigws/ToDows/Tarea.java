package bigws.ToDows;



import java.util.ArrayList;
import java.util.List;

public class Tarea {
	private String task;
	private String context;
	private String project;
	private String priority;
	
	
	public Tarea(String task, String project, String context, String priority) {
		super();
		this.task = task;
		this.context = context;
		this.project = project;
		this.priority = priority;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

}

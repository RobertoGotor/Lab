package rest.todolist;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new ListaTareas());
    }


    /**
     * Main constructor
     * @param tl a provided address book
     */
    public ApplicationConfig(final ListaTareas tl) {
    	register(ToDoListService.class);
    	register(MOXyJsonProvider.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(tl).to(ListaTareas.class);
			}});
	}	

}

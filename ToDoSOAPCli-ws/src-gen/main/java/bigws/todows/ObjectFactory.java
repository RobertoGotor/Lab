
package bigws.todows;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bigws.todows package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FileNotFoundException_QNAME = new QName("http://ToDows.bigws/", "FileNotFoundException");
    private final static QName _Delete_QNAME = new QName("http://ToDows.bigws/", "delete");
    private final static QName _Buscar_QNAME = new QName("http://ToDows.bigws/", "buscar");
    private final static QName _Add_QNAME = new QName("http://ToDows.bigws/", "add");
    private final static QName _MostrarResponse_QNAME = new QName("http://ToDows.bigws/", "mostrarResponse");
    private final static QName _AddResponse_QNAME = new QName("http://ToDows.bigws/", "addResponse");
    private final static QName _BuscarResponse_QNAME = new QName("http://ToDows.bigws/", "buscarResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://ToDows.bigws/", "deleteResponse");
    private final static QName _Mostrar_QNAME = new QName("http://ToDows.bigws/", "mostrar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bigws.todows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link Mostrar }
     * 
     */
    public Mostrar createMostrar() {
        return new Mostrar();
    }

    /**
     * Create an instance of {@link MostrarResponse }
     * 
     */
    public MostrarResponse createMostrarResponse() {
        return new MostrarResponse();
    }

    /**
     * Create an instance of {@link BuscarResponse }
     * 
     */
    public BuscarResponse createBuscarResponse() {
        return new BuscarResponse();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link FileNotFoundException }
     * 
     */
    public FileNotFoundException createFileNotFoundException() {
        return new FileNotFoundException();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link Buscar }
     * 
     */
    public Buscar createBuscar() {
        return new Buscar();
    }

    /**
     * Create an instance of {@link Tarea }
     * 
     */
    public Tarea createTarea() {
        return new Tarea();
    }

    /**
     * Create an instance of {@link ListaTareas }
     * 
     */
    public ListaTareas createListaTareas() {
        return new ListaTareas();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "FileNotFoundException")
    public JAXBElement<FileNotFoundException> createFileNotFoundException(FileNotFoundException value) {
        return new JAXBElement<FileNotFoundException>(_FileNotFoundException_QNAME, FileNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Buscar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "buscar")
    public JAXBElement<Buscar> createBuscar(Buscar value) {
        return new JAXBElement<Buscar>(_Buscar_QNAME, Buscar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "mostrarResponse")
    public JAXBElement<MostrarResponse> createMostrarResponse(MostrarResponse value) {
        return new JAXBElement<MostrarResponse>(_MostrarResponse_QNAME, MostrarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "buscarResponse")
    public JAXBElement<BuscarResponse> createBuscarResponse(BuscarResponse value) {
        return new JAXBElement<BuscarResponse>(_BuscarResponse_QNAME, BuscarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mostrar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ToDows.bigws/", name = "mostrar")
    public JAXBElement<Mostrar> createMostrar(Mostrar value) {
        return new JAXBElement<Mostrar>(_Mostrar_QNAME, Mostrar.class, null, value);
    }

}

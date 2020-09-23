import javax.ws.rs.GET;//annotation to indicate method used HTTP GET
import javax.ws.rs.Path;//annotation to specify path of resource
import javax.ws.rs.PathParam;//annotation to get parameters from URI
import javax.ws.rs.Produces;//annotation to specify type of data
import javax.xml.bind.JAXB;//utility class for common JAXB operations
import java.io.StringWriter;

@Path("http://localhost:8080/WelcomeRESTXML/webresources/welcome/John")//URI used to access the resource | welcome
public class WelcomeRESTXMLResource {

    //retrieve welcome message
    @GET // handles HTTP GET method
    @Path("{John}") // URI component containing parameter |  {name}
    @Produces("application/xml")//response formatted as XML
    public String getXml(@PathParam("John") String name){ //"name"
        String message = "Welcome to JAX-RS web services with REST and " + "XML, " + name + "!";//our welcome message
        StringWriter writer = new StringWriter();
        JAXB.marshal(message,writer);// marshal String as XML
        return writer.toString();//return XML as string
    }

    public static void main(String[] args) {

    }

}

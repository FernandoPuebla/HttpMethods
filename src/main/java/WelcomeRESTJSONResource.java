import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("http://localhost:5005/WelcomeRESTJSON/webresources/welcome/Paul")//path used to access the resource
public class WelcomeRESTJSONResource {
    //retrieve welcome message
    @GET // handles HTTP GET requests
    @Path("{Paul}") // takes name as a path parameter  {name}
    @Produces("application/json")//response formatted as JSON
    public String getJson(@PathParam("Paul") String name) { //"name"
        //add welcome message to field of TextMessage object
        TextMessage message = new TextMessage();
        message.setMessage(String.format("%s,%s!",
                "Welcome to JAX-RS web services with REST and JSON", name));
        return new Gson().toJson(message);//return JSON-wrapped message
    }

    //private class that contains the message we wish to send

    class TextMessage{
        private String message; // message we're sending

        //returns the message
        public String getMessage() {
            return message;
        }

        //sets the message
        public void setMessage(String value) {
            message = value;
        }
    }


}

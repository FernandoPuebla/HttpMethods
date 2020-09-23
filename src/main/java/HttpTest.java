import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpTest {

    public static void main(String[] args) throws IOException {
        /*
        String urlApi = "http://www.oracle.com/";
        try{
            URL url = new URL(urlApi);
            URLConnection urlConnection = new URLConnection();
            urlConnection.connect();
        }
        catch (MalformedURLException malformedURLException){
            System.out.print("The URL is malformed");
        }
        catch (IOException ioException){
            System.out.println("An exceptions has ocurred");
        }
        * */
        //getInfo();
        getInfo2();
    }

    public static void getInfo() throws IOException {
        String urlLink = "https://restcountries.eu/rest/v2/alpha/col";//https://restcountries.eu/rest/v2/all
        URL oracle = new URL(urlLink);//http://www.oracle.com/
        URLConnection urlConnection = oracle.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);
        bufferedReader.close();
    }

    public static void getInfo2() throws IOException {
        // Create a neat value object to hold the URL
        String urlLink = "https://restcountries.eu/rest/v2/all";
        URL url = new URL(urlLink);//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY

        // Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

        // This line makes the request
        InputStream responseStream = connection.getInputStream();

        // Manually converting the response body InputStream to APOD using Jackson
            System.out.println(responseStream);
        /*ObjectMapper mapper = new ObjectMapper();
        APOD apod = mapper.readValue(responseStream, APOD.class);
        * */

        // Finally we have the response
        //System.out.println(apod.title);
    }

}

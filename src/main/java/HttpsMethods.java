import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

public class HttpsMethods {

    private static HttpURLConnection connection;

    //java not 11
    public static void main(String[] args) {
        BufferedReader reader;
        String line,response;
        StringBuffer responseContent = new StringBuffer();

        try{
            //https://restcountries.eu/rest/v2/all
            String urlLink="https://restcountries.eu/rest/v2/alpha/col";//https://jsonplaceholder.typicode.com/albums
            URL url = new URL(urlLink);
            connection = (HttpURLConnection) url.openConnection();

            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
            System.out.println("Status: " + status);

            if (status > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            response = responseContent.toString();
            parse(response);
            //System.out.println(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
    }

    public static void parse(String responseBody){
        //JSONArray albums = new JSONArray(responseBody);
        //JSONObject
        Countries countries = new Countries();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String representacionJSON = gson.toJson(responseBody);
        System.out.println(representacionJSON);

    }

}

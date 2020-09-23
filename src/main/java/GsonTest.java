import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.IOException;

public class GsonTest {

    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //path can be the JSON itself
        String path="C:\\Users\\carif\\OneDrive\\Documentos\\HttpMethods\\src\\main\\resources\\Countries.json";
        Object object = gson.fromJson(new FileReader(path), Object.class);
        String json = gson.toJson(object);
        System.out.println(json);

    }
}

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GetJSONFromPath {
    public static void main(String[] args) {
        try{
            String path="C:\\Users\\carif\\OneDrive\\Documentos\\HttpMethods\\src\\main\\resources\\Countries.json";
            Reader reader = Files.newBufferedReader(Paths.get(path));//dummy.json
            Gson gson = new Gson();
            Map<?,?> dummyMap = gson.fromJson(reader,Map.class);
            System.out.println(dummyMap.get("topLevelDomain"));
            System.out.println(dummyMap.get("currencies"));
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

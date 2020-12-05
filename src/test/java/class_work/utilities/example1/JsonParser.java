package class_work.utilities.example1;


import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser {
    private final static String JSON = "src/test/resources/classwork/json/example.json";

    public void parseJSON() throws IOException {
        String input = new String((Files.readAllBytes(Paths.get(JSON))));
        JSONObject obj = new JSONObject(input);

        System.out.println(obj.getString("recipemame"));
        System.out.println(obj.getJSONArray("ingredlist").getJSONObject(0).getString("itemdescription"));
        System.out.println(obj.getNumber("pretime"));

    }

}

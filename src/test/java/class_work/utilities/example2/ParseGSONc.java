package class_work.utilities.example2;


import class_work.utilities.example3.Search;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseGSONc {
    private final static String JSON1 = "src/test/resources/classwork/json/example.json";

    public void parseGSON() throws FileNotFoundException {
        Gson gson = new Gson();
        Recipe recipe = gson.fromJson(new JsonReader(new FileReader(JSON1)), Recipe.class);
        System.out.println(recipe.recipename);
    }

    public static String fromGSON (Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }


}

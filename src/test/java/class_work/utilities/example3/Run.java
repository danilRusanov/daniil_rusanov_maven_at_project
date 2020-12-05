package class_work.utilities.example3;

import java.io.IOException;
import java.net.URISyntaxException;

public class Run {

    public static void main(String[] args) throws IOException, URISyntaxException {
//        MyHttpClientGet get = new MyHttpClientGet();
//        get.getCurrency(1);

        Search search = new Search("a", true);
        Search search1 = new Search("b", false);
        MyHttpClientPost myHttpClientPost = new MyHttpClientPost();
        myHttpClientPost.search(search);
        myHttpClientPost.search(search1);
    }
}

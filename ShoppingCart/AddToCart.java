import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Scanner;

public class AddToCart {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Id: ");
        String bookId = sc.nextLine();
        System.out.print("Enter User Id: ");
        String userId = sc.nextLine();
        sc.close();
        URIBuilder builder = new URIBuilder("http://example.com/add-to-cart");
        builder.setParameter("bookId", bookId);
        builder.setParameter("userId", userId);
        HttpPost request = new HttpPost(builder.build());
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
    }
}
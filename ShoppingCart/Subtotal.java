import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Scanner;

public class Subtotal {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User Id: ");
        String userId = sc.nextLine();
        sc.close();
        URIBuilder builder = new URIBuilder("http://example.com/subtotal");
        builder.setParameter("userId", userId);
        HttpGet request = new HttpGet(builder.build());
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        int subtotal = Integer.parseInt(response.getEntity().getContent().toString());
        System.out.println("Subtotal: " + subtotal);
    }
}
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Scanner;

public class RemoveFromCart {
    private ShoppingCart shoppingCart;

    public RemoveFromCart(ShoppingCart cart) {
        this.shoppingCart = cart;
    }

    public void removeBook(int bookId) {
        // code to remove the book with given id from the shopping cart
        List<Book> cartItems = shoppingCart.getItems();
        Iterator<Book> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            Book item = iterator.next();
            if (item.getId() == bookId) {
                iterator.remove();
                break;
            }
        }
    }
}
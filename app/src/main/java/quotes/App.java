package quotes;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
public class App {
    public static void main(String[] args) {
        try (BufferedReader readQuotes = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"))) {
            Gson gson = new Gson();
            RecentQuotes quotes[] = gson.fromJson(readQuotes, RecentQuotes[].class);
            Random random = new Random();
            int randomIndex = random.nextInt(quotes.length);

            String randomQuote = quotes[randomIndex].getText();
            String rendomAuthor = quotes[randomIndex].getAuthor();
            System.out.println("Random Quote: " + randomQuote);
            System.out.println("Author :" + rendomAuthor );
            if(randomQuote.equals(""))
            {
                System.out.println("There is no quotes for this author");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

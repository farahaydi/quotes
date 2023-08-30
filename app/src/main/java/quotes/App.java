package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        readFile();
        updateJson();
    }

    //**********************************************LAB 08**************************************************************
    public static void readFile() {
        System.out.println("ReadFile : *************************");
        try (BufferedReader readQuotes = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"))) {
            RecentQuotes[] quotes = gson.fromJson(readQuotes, RecentQuotes[].class);
            displayRandomQuote(quotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayRandomQuote(RecentQuotes[] quotes) {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        String randomQuote = quotes[randomIndex].getText();
        String randomAuthor = quotes[randomIndex].getAuthor();

        if (randomQuote.equals("")) {
            System.out.println("There is no quote for this author");
        } else {
            System.out.println("Random Quote: " + randomQuote);
            System.out.println("Author: " + randomAuthor);
        }
    }

    //******************************************LAB 09 *****************************************************************
    public static void updateJson() {
        MainQuote mainQuote = convertToObject();

        String newQuoteText = mainQuote.getQuote().getBody();
        String newQuoteAuthor = mainQuote.getQuote().getAuthor();

        RecentQuotes newQuote = new RecentQuotes(new ArrayList<String>(), newQuoteAuthor, "", newQuoteText);
        List<RecentQuotes> updatedQuotesList = new ArrayList<>(Arrays.asList(saveJson()));
        updatedQuotesList.add(newQuote);

        writeToJsonFile(updatedQuotesList);
    }
    //------------------------------------Method 01
    public static HttpURLConnection fetchData() {
        HttpURLConnection quoteConnection = null;
        try {
            URL quoteUrl = new URL("https://favqs.com/api/qotd?token=a4c5260ddff106ce351772ca2370f6d1");
            quoteConnection = (HttpURLConnection) quoteUrl.openConnection();
            quoteConnection.setRequestMethod("GET");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quoteConnection;
    }
    //------------------------------------Method 02
    public static String readApi() {
        String quoteData = null;
        try {
            InputStreamReader readQuote = new InputStreamReader(fetchData().getInputStream());
            BufferedReader readBufferQuote = new BufferedReader(readQuote);
            quoteData = readBufferQuote.readLine();
            System.out.println(quoteData);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return quoteData;
    }
    //------------------------------------Method 03
    public static MainQuote convertToObject() {
        return gson.fromJson(readApi(), MainQuote.class);
    }
    //------------------------------------Method 04
    public static RecentQuotes[] saveJson() {
        try (BufferedReader existingReader = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"))) {
            return gson.fromJson(existingReader, RecentQuotes[].class);
        } catch (IOException e) {
            return new RecentQuotes[0];
        }
    }

    //------------------------------------Method 05
    public static void writeToJsonFile(List<RecentQuotes> quotesList) {
        try (FileWriter writeToFile = new FileWriter("app/src/main/resources/recentquotes.json")) {
            gson.toJson(quotesList.toArray(new RecentQuotes[0]), writeToFile);
        } catch (IOException e) {
            System.out.println("An error occurred while trying to fetch data from the API.");
            e.printStackTrace();
            readFile();
        }


        //    public static void readFromApi() {
//        try {
//            URL quoteUrl = new URL("https://favqs.com/api/qotd?token=a4c5260ddff106ce351772ca2370f6d1");
//            HttpURLConnection quoteConnection = (HttpURLConnection) quoteUrl.openConnection();
//            quoteConnection.setRequestMethod("GET");
//            InputStreamReader readQuote = new InputStreamReader(quoteConnection.getInputStream());
//            BufferedReader readBufferQuote = new BufferedReader(readQuote);
//            String quoteData = readBufferQuote.readLine();
//            System.out.println(quoteData);
//           Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            MainQuote mainQuote = gson.fromJson(quoteData, MainQuote.class);
//            //****************************************************************
//            RecentQuotes[] existingQuotes;
//            try (BufferedReader existingReader = new BufferedReader(new FileReader("app/src/main/resources/recentquotes.json"))) {
//                existingQuotes = gson.fromJson(existingReader, RecentQuotes[].class);
//                //existingQuotes => contain file with all data
//            } catch (IOException e) {
//                existingQuotes = new RecentQuotes[0];
//            }
//            String newQuoteText = mainQuote.getQuote().getBody();
//            String newQuoteAuthor = mainQuote.getQuote().getAuthor();
//            //use constructor to pass new quote and author and pass any other data empty
//            RecentQuotes newQuote = new RecentQuotes(new ArrayList<String>(),newQuoteAuthor,"",newQuoteText);
//
//            List<RecentQuotes> updatedQuotesList = new ArrayList<>(Arrays.asList(existingQuotes));
//            updatedQuotesList.add(newQuote);
//            //******************************************************************************
//            try (FileWriter writeToFile = new FileWriter("app/src/main/resources/recentquotes.json")) {
//                gson.toJson(updatedQuotesList.toArray(new RecentQuotes[0]), writeToFile);
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while trying to fetch data from the API.");
//            e.printStackTrace();
//            readFile();
//        }
//    }
    }
}

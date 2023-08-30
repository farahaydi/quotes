package quotes;

public class MainQuote {
    private String qotd_date;
    private Quote quote;

    public MainQuote(String qotd_date, Quote quote) {
        this.qotd_date = qotd_date;
        this.quote = quote;
    }

    public Quote getQuote() {
        return quote;
    }
}

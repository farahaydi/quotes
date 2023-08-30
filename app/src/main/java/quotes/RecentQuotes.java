package quotes;

import java.util.List;

public class RecentQuotes {
    private List<String> tags;
    private String author;
    private String likes;
    private String text;

    public RecentQuotes(List<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "RecentQuotes{" +
                "text='" + text + '\'' +
                '}';
    }
}

package quotes;

import java.util.List;

public class Quote {
    private int id;
    private boolean dialogue;
    private boolean privcy;
    private List<String> tags;
    private String url;
    private int favorites_count;
    private int upvotes_count;
    private int downvotes_count;
    private String author;
    private String author_permalink;
    private String body;

    public Quote(int id, boolean dialogue, boolean privcy, List<String> tags, String url, int favorites_count, int upvotes_count, int downvotes_count, String author, String author_permalink, String body) {
        this.id = id;
        this.dialogue = dialogue;
        this.privcy = privcy;
        this.tags = tags;
        this.url = url;
        this.favorites_count = favorites_count;
        this.upvotes_count = upvotes_count;
        this.downvotes_count = downvotes_count;
        this.author = author;
        this.author_permalink = author_permalink;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }
}

package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private String content;
    private List<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost, String content) {
        super(title, category, cost);
        this.content = content;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " already exists!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " not found!");
        }
    }

    public int getContentLength() {
        if (content == null || content.isEmpty()) return 0;
        return content.split("\\s+").length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book - " + getTitle() + " - " + getCategory() + " - Cost: " + getCost() + "\n");
        sb.append("Authors: " + authors.toString() + "\n");
        sb.append("Content length: " + getContentLength() + " tokens");
        return sb.toString();
    }
}
package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

private static int nbDigitalVideoDiscs = 0; 
    private int id;


    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
    this.id = nbDigitalVideoDiscs;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public void setTitle(String title) {
    this.title = title;
}
@Override
public String toString() {
    return "DVD - " + title + " - " + (category != null ? category : "N/A") + 
           " - " + (director != null ? director : "N/A") + 
           " - " + length + ": " + cost + " $";
}
public boolean isMatch(String title) {
    return this.title.toLowerCase().contains(title.toLowerCase());
}
public int getId() {
    return id;
}
}

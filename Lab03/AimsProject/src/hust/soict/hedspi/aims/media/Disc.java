package hust.soict.hedspi.aims.media;
public abstract class Disc extends Media {
    private String director;
    private int length;
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    public Disc(String title, String category, float cost) {
        this(title, category, null, 0, cost);  // gọi constructor chính
    }
    public Disc(String title) {
        this(title, null, null, 0, 0);
    }

    public int getLength() { return length; }
    public String getDirector() { return director; }
}
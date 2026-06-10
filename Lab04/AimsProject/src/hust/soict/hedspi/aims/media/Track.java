package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public void play() {
        if (length > 0) {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            System.out.println("Track " + title + " cannot be played!");
        }
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return this.length == track.length && 
               this.title.equalsIgnoreCase(track.title);
    }
    public String getTitle() { return title; }
    public int getLength() { return length; }
    public String toString() {
        return "Track: " + title + " - Length: " + length;
    }
}
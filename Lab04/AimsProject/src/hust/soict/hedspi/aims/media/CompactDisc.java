package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track " + track.getTitle() + " already exists!");
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " not found!");
        }
    }

    // Override getLength() - tổng length các track
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("CD length: " + getLength());
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("CD " + getTitle() + " cannot be played!");
        }
    }
    public String getArtist() { return artist; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - " + getTitle() + " - " + getCategory() +
                  " - Artist: " + artist +
                  " - Director: " + getDirector() +
                  " - Length: " + getLength() +
                  " - Cost: " + getCost() + "\n");
        sb.append("Tracks:\n");
        for (int i = 0; i < tracks.size(); i++) {
            sb.append("  " + (i+1) + ". " + tracks.get(i).toString() + "\n");
        }
        return sb.toString();
    }
}
package hust.soict.hedspi.aims.media;
public class CD {
    private static int nbCDs = 0;
    private int id;
    private String title;
    private String category;
    private String artist;
    private String director;
    private float cost;
    private Track[] tracks;
    private int nbTracks = 0;
    public static final int MAX_TRACKS = 20;
    public CD(String title, String category, String artist, String director, float cost) {
        this.title = title;
        this.category = category;
        this.artist = artist;
        this.director = director;
        this.cost = cost;
        nbCDs++;
        this.id = nbCDs;
        this.tracks = new Track[MAX_TRACKS];
    }
    public void addTrack(Track track) {
        if (nbTracks < MAX_TRACKS) {
            tracks[nbTracks] = track;
            nbTracks++;
        } else {
            System.out.println("Track list is full!");
        }
    }
    public int getLength() {
        int total = 0;
        for (int i = 0; i < nbTracks; i++) {
            total += tracks[i].getLength();
        }
        return total;
    }

    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing CD: " + title + " - Length: " + getLength());
            for (int i = 0; i < nbTracks; i++) {
                tracks[i].play();
            }
        } else {
            System.out.println("CD " + title + " cannot be played!");
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - " + title + " - " + category + 
                  " - Artist: " + artist + 
                  " - Director: " + director + 
                  " - Length: " + getLength() + 
                  " - Cost: " + cost + "\n");
        sb.append("Tracks:\n");
        for (int i = 0; i < nbTracks; i++) {
            sb.append("  " + (i+1) + ". " + tracks[i].toString() + "\n");
        }
        return sb.toString();
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public float getCost() { return cost; }
}
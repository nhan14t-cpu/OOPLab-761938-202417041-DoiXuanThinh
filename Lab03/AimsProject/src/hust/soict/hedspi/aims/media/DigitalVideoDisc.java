package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
    }
    public void play() {
        if (getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("DVD " + getTitle() + " cannot be played!");
        }
    }
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() +
               " - Director: " + getDirector() +
               " - Length: " + getLength() +
               ": " + getCost() + " $";
    }

    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }
    
}
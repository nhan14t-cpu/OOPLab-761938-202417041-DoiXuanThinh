package hust.soict.hedspi.test.aims;
import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.*;
public class Polymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 12.99f);
        cd.addTrack(new Track("Come Together", 259));
        cd.addTrack(new Track("Something", 182));
        Book book = new Book("The Great Gatsby", "Novel", 15.99f, "In my younger and more vulnerable years my father gave me some advice...");
        book.addAuthor("F. Scott Fitzgerald");
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
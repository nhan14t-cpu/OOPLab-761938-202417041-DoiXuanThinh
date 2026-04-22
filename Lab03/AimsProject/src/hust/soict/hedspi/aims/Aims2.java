package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
public class Aims2 {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Bài 12: Test thêm đĩa
        System.out.println("\nLAB 2");
        System.out.println("Bai 12");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);                                               
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        anOrder.print();                                                  

        // Bài 13: Test xóa đĩa
        System.out.println("\nBai 13");
        anOrder.removeMedia(dvd2);                                      
        System.out.println("Cart after removing Star Wars:");
        anOrder.print();

        // Bài 14.1: Thêm mảng đĩa
        System.out.println("\nBai 14.1");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 21.99f);
        anOrder.addMedia(dvd4);                                         
        anOrder.addMedia(dvd5);
        anOrder.print();

        // Bài 14.2: Thêm 2 đĩa
        System.out.println("\nBai 14.2");
        Cart anOrder2 = new Cart();
        anOrder2.addMedia(dvd2);
        anOrder2.addMedia(dvd3);
        anOrder2.print();

        // Bài 7 Lab 3: Book, CD, DVD play
        System.out.println("\nLAB 3");
        Book book = new Book("The Great Gatsby", "Novel", 15.99f,
                "In my younger and more vulnerable years my father gave me some advice...");
        book.addAuthor("F. Scott Fitzgerald");
        System.out.println(book.toString());
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 12.99f);
        cd.addTrack(new Track("Come Together", 259));
        cd.addTrack(new Track("Something", 182));
        cd.addTrack(new Track("Here Comes The Sun", 185));
        System.out.println(cd.toString());
        cd.play();
        dvd1.play();
        DigitalVideoDisc dvd0 = new DigitalVideoDisc("Unknown");
        dvd0.play();
    }
}
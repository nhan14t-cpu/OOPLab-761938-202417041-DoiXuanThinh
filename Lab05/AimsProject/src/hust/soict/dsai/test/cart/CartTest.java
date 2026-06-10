package hust.soict.dsai.test.cart;

// Cập nhật lại đường dẫn package mới của DigitalVideoDisc
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class CartTest {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart cart = new Cart();

        // Tạo các đối tượng DVD và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        // Đổi addDigitalVideoDisc thành addMedia
        cart.addMedia(dvd2); 

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        // Đổi addDigitalVideoDisc thành addMedia
        cart.addMedia(dvd3); 

       
        cart.print();

        
        System.out.println("\n--- Search Results ---");
        cart.searchById(1); 
        cart.searchById(36); 
        
        cart.searchByTitle("Star"); 
        cart.searchByTitle("ManchesterUnited"); 
    }
}
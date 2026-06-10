package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException; // Nhớ import lớp Exception của bạn

public class AimsTest {
    public static void main(String[] args) {
        // 1. Tạo giỏ hàng mới
        Cart cart = new Cart();

        // 2. Tạo các loại Media
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        Book book = new Book("Java Programming", "Education", 25.0f);
        book.addAuthor("James Gosling");
        
        // Giả sử bạn đã có lớp CompactDisc và Track
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various", 15.5f, "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));

        // 3. Thêm vào giỏ hàng
        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        // 4. Kiểm tra tính Đa hình
        System.out.println("--- CHI TIẾT GIỎ HÀNG ---");
        for (Media m : cart.getItemsOrdered()) {
            if (m != null) {
                System.out.println(m.toString());
                
                // 5. Kiểm tra interface Playable (ĐÃ ĐƯỢC CẬP NHẬT TRY-CATCH)
                if (m instanceof Playable) {
                    System.out.print("Dang phat: ");
                    try {
                        // Gọi hàm play, nếu có lỗi (độ dài <= 0), nó sẽ ném ra PlayerException
                        ((Playable) m).play();
                    } catch (PlayerException e) {
                        // Bắt và in ra thông báo lỗi ngoại lệ 
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
                System.out.println("-------------------");
            }
        }

        // 6. Tổng tiền
        System.out.println("Tong chi phi: " + cart.totalCost() + " $");
    }
}
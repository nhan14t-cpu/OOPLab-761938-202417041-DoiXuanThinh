package hust.soict.dsai.test.store;

// Import đúng package mới của DigitalVideoDisc và lớp Store
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng mới
        Store store = new Store();
        
        // Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        
        System.out.println("--- KIỂM TRA THÊM MEDIA ---");
        // Sử dụng phương thức addMedia mới của lớp Store [1]
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
         
        System.out.println("\n--- KIỂM TRA XÓA MEDIA ---");
        // Sử dụng phương thức removeMedia mới để xóa [1]
        store.removeMedia(dvd2);
     
        // Thử xóa một media không có trong kho
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen");
        store.removeMedia(dvd4);
    }
}
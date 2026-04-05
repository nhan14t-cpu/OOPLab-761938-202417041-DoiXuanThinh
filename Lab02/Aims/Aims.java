package Aims;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Bài 12: Test thêm đĩa
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.printCart();

        // Bài 13: Test xóa đĩa
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Cart after removing Star Wars:");
        anOrder.printCart();
    }
}
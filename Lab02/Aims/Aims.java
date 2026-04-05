package Aims;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Bài 12: Test thêm đĩa
        System.out.println("\n12");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.printCart();

        // Bài 13: Test xóa đĩa
        System.out.println("\n13");
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Cart after removing Star Wars:");
        anOrder.printCart();
        
        //Bai 14.1: Them mot mang dia
        System.out.println("\n14.1");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 21.99f);
        DigitalVideoDisc[] dvdList = {dvd4, dvd5};
        anOrder.addDigitalVideoDisc(dvdList);
        anOrder.printCart();
        //Bai 14.2 Them 2 dia
        System.out.println("\n14.2");
        Cart anOrder2 = new Cart();
        anOrder2.addDigitalVideoDisc(dvd2, dvd3);
        anOrder2.printCart();
    }
}
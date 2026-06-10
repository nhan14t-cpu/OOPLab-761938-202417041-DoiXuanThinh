package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Thử nghiệm hàm swap cũ (truyền tham chiếu nhưng không đổi được giá trị thực)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap: jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("After swap: cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử nghiệm hàm swap thực sự (đổi nội dung bên trong đối tượng)
        trueSwap(jungleDVD, cinderellaDVD);
        System.out.println("After trueSwap: jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("After trueSwap: cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thử nghiệm hàm changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle: jungle dvd title: " + jungleDVD.getTitle());
    }

    // Hàm này KHÔNG đổi được chỗ vì Java truyền tham chiếu theo trị (pass-by-value of reference)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm này đổi được chỗ vì chúng ta can thiệp trực tiếp vào dữ liệu bên trong vùng nhớ
    public static void trueSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
        
        // Bạn có thể swap tiếp các thuộc tính khác như cost, category nếu cần
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // Dòng này sẽ làm thay đổi title thật của đối tượng
        dvd = new DigitalVideoDisc(oldTitle); // Dòng này chỉ làm thay đổi biến cục bộ 'dvd', không ảnh hưởng bên ngoài
    }
}
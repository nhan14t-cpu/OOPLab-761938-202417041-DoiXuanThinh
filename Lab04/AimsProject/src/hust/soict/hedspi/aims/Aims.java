package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f));
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 12.99f);
        cd.addTrack(new Track("Come Together", 259));
        cd.addTrack(new Track("Something", 182));
        cd.addTrack(new Track("Here Comes The Sun", 185));
        store.addMedia(cd);
        store.addMedia(new Book("The Great Gatsby", "Novel", 15.99f, "Some content"));
        
        while (true) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ==================== MENUS ====================

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ==================== VIEW STORE ====================

    public static void viewStore() {
        store.print();
        while (true) {
            storeMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMediaFromStore();
                case 4 -> seeCurrentCart();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine().trim();
        Media media = store.findByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        System.out.println(media.toString());

        // mediaDetailsMenu — Play chỉ hiện nếu là Playable
        while (true) {
            mediaDetailsMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> {
                    cart.addMedia(media);
                    return;
                }
                case 2 -> {
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine().trim();
        Media media = store.findByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        cart.addMedia(media);

        // Nếu là DVD, hiện số lượng DVD trong cart
        if (media instanceof DigitalVideoDisc) {
            System.out.println("Number of DVDs in cart: " + cart.countDVDs());
        }
    }

    public static void playMediaFromStore() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine().trim();
        Media media = store.findByTitle(title);
        if (media == null) {
            System.out.println("Media not found: " + title);
            return;
        }
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played!");
        }
    }

    // ==================== UPDATE STORE ====================

    public static void updateStore() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Choose: ");
        int choice = getChoice();
        if (choice == 1) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Enter category: ");
            String category = scanner.nextLine().trim();
            System.out.print("Enter cost: ");
            float cost = Float.parseFloat(scanner.nextLine().trim());
            store.addMedia(new DigitalVideoDisc(title, category, cost));
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine().trim();
            Media media = store.findByTitle(title);
            if (media != null) store.removeMedia(media);
            else System.out.println("Media not found!");
        }
    }

    // ==================== CART ====================

    public static void seeCurrentCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = getChoice();
            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeFromCart();
                case 4 -> playFromCart();
                case 5 -> placeOrder();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void filterCart() {
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.print("Choose: ");
        int choice = getChoice();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Choose: ");
        int choice = getChoice();
        if (choice == 1) {
            cart.sortByTitleCost();
        } else if (choice == 2) {
            cart.sortByCostTitle();
        }
        cart.print();
    }

    public static void removeFromCart() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine().trim();
        cart.removeMediaByTitle(title);
    }

    public static void playFromCart() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine().trim();
        cart.playMedia(title);
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.clear();
        System.out.println("Cart has been emptied.");
    }

    // ==================== HELPER ====================

    public static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
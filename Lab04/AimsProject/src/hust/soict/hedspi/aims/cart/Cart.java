package hust.soict.hedspi.aims.cart;
import java.util.Collections;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {    
            System.out.println("Media already in cart: " + media.getTitle());
            return;
        }
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media was not found");
        }
    }
    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }
    public int countDVDs() {
        int count = 0;
        for (Media m : itemsOrdered)
            if (m instanceof DigitalVideoDisc) count++;
        return count;
    }

    public void removeMediaByTitle(String title) {
        Media found = null;
        for (Media m : itemsOrdered)
            if (m.getTitle().equalsIgnoreCase(title)) { found = m; break; }
        if (found != null) removeMedia(found);
        else System.out.println("Media not found in cart!");
    }

    public void playMedia(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                if (m instanceof Playable) ((Playable) m).play();
                else System.out.println("This media cannot be played!");
                return;
            }
        }
        System.out.println("Media not found in cart!");
    }

    public void clear() {
        itemsOrdered.clear();
    }
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No media found with ID: " + id);
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No media found with title: " + title);
    }
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }
    public void print() {
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f%n", totalCost());
        System.out.println("************************************************");
    }
}
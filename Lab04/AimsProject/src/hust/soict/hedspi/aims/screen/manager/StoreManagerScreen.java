package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class StoreManagerScreen extends JFrame {
    private Store store;
    public StoreManagerScreen(Store store) {
        this.store = store;
        setTitle("Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });
        menu.add(viewStore);
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("AIMS");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 50));
        titleLabel.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new java.awt.Dimension(10, 10)));
        header.add(titleLabel);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new java.awt.Dimension(10, 10)));
        return header;
    }
    private JPanel createCenter() {
        JPanel center = new JPanel();
        int itemCount = store.getItemsInStore().size();
        int cols = Math.min(4, Math.max(1, itemCount));
        int rows = (itemCount == 0) ? 1 : (int) Math.ceil((double) itemCount / cols);
        center.setLayout(new GridLayout(rows, cols, 10, 10));
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            center.add(new MediaStore(store.getItemsInStore().get(i)));
        }
        if (itemCount == 0) {
            JLabel emptyLabel = new JLabel("No items in store.", JLabel.CENTER);
            emptyLabel.setFont(new Font(emptyLabel.getFont().getName(), Font.ITALIC, 18));
            emptyLabel.setForeground(Color.GRAY);
            center.add(emptyLabel);
        }
        return center;
    }
    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f));
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 12.99f);
        cd.addTrack(new Track("Come Together", 259));
        cd.addTrack(new Track("Something", 182));
        cd.addTrack(new Track("Here Comes The Sun", 185));
        store.addMedia(cd);
        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}
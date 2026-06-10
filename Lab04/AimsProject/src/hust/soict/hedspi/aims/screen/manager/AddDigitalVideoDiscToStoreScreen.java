package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfLength   = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);       
        setTitle("Add DVD");
        init();         
    }
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 5, 5));
        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Director:"));
        center.add(tfDirector);
        center.add(new JLabel("Length (min):"));
        center.add(tfLength);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);
        center.add(new JLabel(""));
        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> addDVD());
        center.add(btnAdd);
        return center;
    }
    private void addDVD() {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Title cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int length;
        try {
            length = Integer.parseInt(tfLength.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Length must be a valid integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float cost;
        try {
            cost = Float.parseFloat(tfCost.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Cost must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD \"" + title + "\" added to store!");
        new StoreManagerScreen(store);
        dispose();
    }
}
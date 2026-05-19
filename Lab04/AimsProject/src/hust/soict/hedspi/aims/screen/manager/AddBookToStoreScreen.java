package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    private JTextField tfAuthor   = new JTextField(20);
    private JTextField tfContent  = new JTextField(20);
    public AddBookToStoreScreen(Store store) {
        super(store);      
        setTitle("Add Book");
        init();            
    }
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 5, 5));
        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);
        center.add(new JLabel("Author:"));
        center.add(tfAuthor);
        center.add(new JLabel("Content:"));
        center.add(tfContent);
        center.add(new JLabel(""));
        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> addBook());
        center.add(btnAdd);
        return center;
    }
    private void addBook() {
        String title   = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String author  = tfAuthor.getText().trim();
        String content = tfContent.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Title cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
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
        Book book = new Book(title, category, cost, content);
        if (!author.isEmpty()) {
            book.addAuthor(author);
        }
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book \"" + title + "\" added to store!");
        new StoreManagerScreen(store);
        dispose();
    }
}
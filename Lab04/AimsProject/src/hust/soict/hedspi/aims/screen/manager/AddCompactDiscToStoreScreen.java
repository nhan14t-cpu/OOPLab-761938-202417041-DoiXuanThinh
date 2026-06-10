package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle    = new JTextField(20);
    private JTextField tfCategory = new JTextField(20);
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfArtist   = new JTextField(20);
    private JTextField tfCost     = new JTextField(20);
    private JTextField tfTrackTitle  = new JTextField(15);
    private JTextField tfTrackLength = new JTextField(6);
    private List<Track> pendingTracks = new ArrayList<>();
    private JPanel trackListPanel = new JPanel();

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);          
        setTitle("Add CD");
        setSize(650, 550);     
        init();                 
    }
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JPanel infoPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createTitledBorder("CD Information"));
        infoPanel.add(new JLabel("Title:"));
        infoPanel.add(tfTitle);
        infoPanel.add(new JLabel("Category:"));
        infoPanel.add(tfCategory);
        infoPanel.add(new JLabel("Director:"));
        infoPanel.add(tfDirector);
        infoPanel.add(new JLabel("Artist:"));
        infoPanel.add(tfArtist);
        infoPanel.add(new JLabel("Cost:"));
        infoPanel.add(tfCost);
        JPanel trackInputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        trackInputPanel.setBorder(BorderFactory.createTitledBorder("Add Track"));
        trackInputPanel.add(new JLabel("Track Title:"));
        trackInputPanel.add(tfTrackTitle);
        trackInputPanel.add(new JLabel("Length (seconds):"));
        trackInputPanel.add(tfTrackLength);
        JButton btnAddTrack = new JButton("+ Add Track");
        btnAddTrack.addActionListener(e -> addTrack());
        trackInputPanel.add(new JLabel(""));
        trackInputPanel.add(btnAddTrack);
        trackListPanel.setLayout(new BoxLayout(trackListPanel, BoxLayout.Y_AXIS));
        trackListPanel.setBorder(BorderFactory.createTitledBorder("Track List"));
        JLabel emptyHint = new JLabel("  No tracks added yet.");
        emptyHint.setForeground(java.awt.Color.GRAY);
        trackListPanel.add(emptyHint);
        JPanel submitPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton btnAddCD = new JButton("Add CD to Store");
        btnAddCD.addActionListener(e -> addCD());
        submitPanel.add(new JLabel(""));
        submitPanel.add(btnAddCD);
        center.add(infoPanel);
        center.add(Box.createVerticalStrut(8));
        center.add(trackInputPanel);
        center.add(Box.createVerticalStrut(5));
        center.add(trackListPanel);
        center.add(Box.createVerticalStrut(10));
        center.add(submitPanel);
        return center;
    }
    private void addTrack() {
        String trackTitle = tfTrackTitle.getText().trim();
        if (trackTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Track title cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int length;
        try {
            length = Integer.parseInt(tfTrackLength.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Track length must be a valid integer (seconds)!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Track track = new Track(trackTitle, length);
        if (pendingTracks.contains(track)) {
            JOptionPane.showMessageDialog(this,
                "Track \"" + trackTitle + "\" already added!", "Duplicate", JOptionPane.WARNING_MESSAGE);
            return;
        }
        pendingTracks.add(track);
        if (pendingTracks.size() == 1) {
            trackListPanel.removeAll();
        }
        JLabel trackLabel = new JLabel(
            "  " + pendingTracks.size() + ". " + trackTitle + " (" + length + "s)");
        trackListPanel.add(trackLabel);
        trackListPanel.revalidate();
        trackListPanel.repaint();
        tfTrackTitle.setText("");
        tfTrackLength.setText("");
    }
    private void addCD() {
        String title    = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String director = tfDirector.getText().trim();
        String artist   = tfArtist.getText().trim();
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
        CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
        for (Track t : pendingTracks) {
            cd.addTrack(t);
        }
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this,
            "CD \"" + title + "\" added to store with " + pendingTracks.size() + " track(s)!");
        new StoreManagerScreen(store);
        dispose();
    }
}
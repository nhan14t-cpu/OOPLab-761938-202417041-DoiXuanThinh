package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class MediaStore extends JPanel {
	private static final long serialVersionUID = 1L;
	private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 15));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        JLabel costLabel = new JLabel(media.getCost() + " $");
        costLabel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> playMedia());
            buttonPanel.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(titleLabel);
        this.add(costLabel);
        this.add(Box.createVerticalGlue());
        this.add(buttonPanel);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void playMedia() {
        ((Playable) media).play();
        Frame owner = (Frame) SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog(owner, "Playing: " + media.getTitle(), true);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(owner);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel info = new JLabel("Now playing: " + media.getTitle());
        info.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(Box.createVerticalGlue());
        panel.add(info);
        panel.add(Box.createVerticalGlue());
        dialog.add(panel);
        dialog.setVisible(true);
    }
}
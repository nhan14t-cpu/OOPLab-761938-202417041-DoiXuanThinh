package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        setTitle("Cart");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea cartTextArea = new JTextArea();
        cartTextArea.setEditable(false);
        cartTextArea.setText(buildCartDisplay());

        add(new JScrollPane(cartTextArea));
        setVisible(true);
    }

    private String buildCartDisplay() {
        if (cart == null) {
            return "Cart is not available.";
        }

        return cart.toString();
    }
}

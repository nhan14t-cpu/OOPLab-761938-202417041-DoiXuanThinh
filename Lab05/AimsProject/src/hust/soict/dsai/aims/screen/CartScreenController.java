package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.util.List;

@interface FXML {}

class TextField {}

class ToggleGroup {}

class TableView<T> {
    private SelectionModel<T> selectionModel = new SelectionModel<>();

    void setItems(ObservableList<T> items) {}

    SelectionModel<T> getSelectionModel() {
        return selectionModel;
    }
}

class TableColumn<S, T> {
    void setCellValueFactory(PropertyValueFactory<S, T> factory) {}
}

class Button {
    void setVisible(boolean visible) {}
}

class Label {
    void setText(String text) {}
}

class Alert {
    enum AlertType { INFORMATION, ERROR }

    Alert(AlertType type) {}

    void setTitle(String title) {}
    void setHeaderText(String headerText) {}
    void setContentText(String contentText) {}
    void showAndWait() {}
}

class PropertyValueFactory<S, T> {
    PropertyValueFactory(String property) {}
}

class FXCollections {
    static <T> ObservableList<T> observableArrayList(List<T> items) {
        return new ObservableList<>(items);
    }
}

class ObservableList<T> extends java.util.ArrayList<T> {
    ObservableList(List<T> items) {
        super(items);
    }
}

class ActionEvent {}

class SelectionModel<T> {
    private T selectedItem;

    T getSelectedItem() {
        return selectedItem;
    }

    ObjectProperty<T> selectedItemProperty() {
        return new ObjectProperty<>();
    }
}

interface ObservableValue<T> {}

interface ChangeListener<T> {
    void changed(ObservableValue<? extends T> observable, T oldValue, T newValue);
}

class ObjectProperty<T> implements ObservableValue<T> {
    void addListener(ChangeListener<? super T> listener) {}
}

public class CartScreenController {

    // ---------------------------------------------------------------- @FXML fields
    @FXML private TextField tfFilter;

    @FXML private ToggleGroup filterCategory;

    @FXML private TableView<Media>        tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float>  colMediaCost;

    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML private Label lblTotalCost;

    // ---------------------------------------------------------------- Cart data
    private Cart cart;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    // ---------------------------------------------------------------- initialize
    @FXML
    private void initialize() {
        // Cài đặt CellValueFactory cho từng cột
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Đổ dữ liệu giỏ hàng vào bảng (ArrayList → ObservableList)
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));

        // Ẩn cả hai nút lúc khởi đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // ChangeListener: khi người dùng chọn một dòng trong bảng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        );
    }

    // ---------------------------------------------------------------- helpers
    /**
     * Hiển thị/ẩn các nút tùy thuộc vào loại media đang được chọn.
     */
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    // ---------------------------------------------------------------- event handlers
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            // Làm mới bảng sau khi xóa
            tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
            // Cập nhật tổng tiền
            updateTotalCost();
            // Ẩn lại các nút
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText("Playback Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!\nTotal: " + cart.totalCost() + " $");
        alert.showAndWait();
    }

    // ---------------------------------------------------------------- private utils
    private void updateTotalCost() {
        if (lblTotalCost != null) {
            lblTotalCost.setText(cart.totalCost() + " $");
        }
    }
}
package hust.soict.dsai.javafx;

import java.util.ArrayList;
import java.util.List;

@interface FXML {}

class ActionEvent {}

class MouseEvent {
    private final double x;
    private final double y;
    public MouseEvent(double x, double y) { this.x = x; this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
}

class Pane {
    private final List<Object> children = new ArrayList<>();
    public List<Object> getChildren() { return children; }
}

class Color {
    public static final Color BLACK = new Color();
}

class Circle {
    private final double x, y, r;
    private final Color color;
    public Circle(double x, double y, double r, Color color) {
        this.x = x; this.y = y; this.r = r; this.color = color;
    }
}

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ các nét vẽ trên bảng
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Tạo một vòng tròn nhỏ tại vị trí con trỏ chuột khi kéo
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }
}

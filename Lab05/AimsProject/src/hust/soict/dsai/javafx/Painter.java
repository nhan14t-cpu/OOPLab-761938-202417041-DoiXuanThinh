package hust.soict.dsai.javafx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Tải file giao diện Painter.fxml
        // LƯU Ý: Đường dẫn ở đây phải khớp chính xác với package của bạn
        // Load the FXML from the same package
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
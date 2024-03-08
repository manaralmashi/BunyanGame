package person.bunyan;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Loading_Interface loading = new Loading_Interface();
        stage.setScene(loading.start(stage));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}



package application.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainController extends Application {

    private static final Logger logger = LogManager.getLogger(MainController.class.getName());

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/main.fxml"));

        logger.info("Loaded main.fxml");
        stage.setTitle("Typical algorithms");
        logger.info(new StringBuilder("Created window with title: ").append(stage.getTitle()));
        stage.setScene(new Scene(root, 800, 600));
        logger.info(
                new StringBuilder("Scene width: ")
                        .append(stage.getScene().getWidth())
                        .append(" and height: ")
                        .append(stage.getScene().getHeight())
        );
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

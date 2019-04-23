package application.Controllers.Abstract;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Setter
public abstract class AbstractProcessingImage {

    private static final Logger logger = LogManager.getLogger(AbstractProcessingImage.class.getName());

    private Button selectImageButton;

    private Button actionButton;

    private ImageView beforeImageView;

    private ImageView afterImageView;

    private final FileChooser fileChooser = new FileChooser();

    protected void selectPicture() {
        selectImageButton.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(selectImageButton.getScene().getWindow());
            if (file != null && file.getName().endsWith(".png")) {
                Image image = new Image(file.toURI().toString());
                beforeImageView.setImage(image);
                actionButton.setVisible(true);
            }
        });
    }

    protected void saveImage(String outputNameFile) {
        File outputFile = new File(outputNameFile);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(afterImageView.getImage(), null), "png", outputFile);
            logger.info("The image has been saved");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}

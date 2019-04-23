package application.Controllers;

import application.Controllers.Abstract.AbstractProcessingImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class HeightMapController extends AbstractProcessingImage implements Initializable {

    private static final Logger logger = LogManager.getLogger(HeightMapController.class.getName());

    @FXML
    private Button selectImageButton;

    @FXML
    private Button actionButton;

    @FXML
    private ImageView beforeImageView;

    @FXML
    private ImageView afterImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.setSelectImageButton(selectImageButton);
        super.setActionButton(actionButton);
        super.setBeforeImageView(beforeImageView);
        super.setAfterImageView(afterImageView);
        selectPicture();
        logger.info("All components have been loaded successfully");
    }

    public void selectImage() {
        selectPicture();
    }

    public void showResult() {
        afterImageView.setImage(coloringImage());
        saveImage("out");
    }

    private WritableImage coloringImage() {
        Image image = beforeImageView.getImage();
        Integer height = (int) image.getHeight();
        Integer width = (int) image.getWidth();

        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int i = 0; i < width; i++) {

            for (int j = 0; j < height; j++) {

                double x = image.getPixelReader().getColor(i, j).getBrightness();

                if (x < 0.15) {
                    pixelWriter.setColor(i, j, Color.DARKBLUE);
                }
                if (x < 0.40 && x > 0.15) {
                    pixelWriter.setColor(i, j, Color.BLUE);
                }
                if (x < 0.150 && x > 0.40) {
                    pixelWriter.setColor(i, j, Color.WHEAT);
                }
                if (x < 0.250 && x > 0.150) {
                    pixelWriter.setColor(i, j, Color.OLIVE);
                }
                if (x < 0.450 && x > 0.250) {
                    pixelWriter.setColor(i, j, Color.DARKOLIVEGREEN);
                }
                if (x < 0.600 && x > 0.450) {
                    pixelWriter.setColor(i, j, Color.SILVER);
                }
                if (x > 0.600) {
                    pixelWriter.setColor(i, j, Color.WHITE);
                }
            }
        }

        return writableImage;
    }
}

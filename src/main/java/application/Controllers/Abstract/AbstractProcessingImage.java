package application.Controllers.Abstract;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import lombok.Setter;

import java.io.File;

@Setter
public abstract class AbstractProcessingImage {

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

}

package application.Controllers;

import application.Controllers.Abstract.AbstractProcessingImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HeightMapController extends AbstractProcessingImage implements Initializable {

    @FXML
    public Button selectImageButton;

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
    }

    public void showImage() {
        selectPicture();
    }
}

package application.Controllers;

import application.Interfaces.IEulers;
import javafx.scene.control.Alert;

public class EulersController implements IEulers {

    public void showEuler1() {
        showAlertAndWait(euler1().toString());
    }

    public void showEuler4() {
        showAlertAndWait(euler4().toString());
    }

    public void showEuler5() {
        showAlertAndWait(euler5().toString());
    }

    private void showAlertAndWait(String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.showAndWait();
    }
}

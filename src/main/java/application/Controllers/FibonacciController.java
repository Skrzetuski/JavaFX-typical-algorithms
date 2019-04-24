package application.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FibonacciController implements Initializable {

    @FXML
    TextField iterationField;

    @FXML
    TextField recursiveField;

    @FXML
    TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        iterationField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!observableValue.getValue().matches("[0-9]*"))
                iterationField.setText(newValue.replaceAll("[^\\d]", ""));
            if (observableValue.getValue().length() > 2)
                iterationField.setText(newValue.substring(0, 2));
        });

        recursiveField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!observableValue.getValue().matches("[0-9]*"))
                recursiveField.setText(newValue.replaceAll("[^\\d]", ""));
            if (observableValue.getValue().length() > 2)
                recursiveField.setText(newValue.substring(0, 2));
        });

    }

    public void showFibIter() {
        textArea.setText(fibIterarion(iterationField.getText()));
    }

    private String fibIterarion(String element) {

        if (element.isEmpty()) {
            element = "3";
            iterationField.setText("3");
        }
        Long n = Long.parseLong(element);

        Long a = 1L;
        Long b = 0L;
        Long tmp = 0L;
        StringBuilder stringBuilder = new StringBuilder();
        for (; n > 0; n--) {
            tmp = a + b;
            a = b;
            b = tmp;
            stringBuilder.append(b).append(", ");
        }

        return stringBuilder.toString().substring(0, stringBuilder.length() - 2);
    }

    public void showFibRec() {
        String number = recursiveField.getText();
        if (number.isEmpty()) {
            number = "3";
            recursiveField.setText("3");
        }
        Long elements = Long.parseLong(number.trim());
        fibRecursive(elements, 1L, 0L);
    }

    private void fibRecursive(Long n, Long a, Long b) {
        n--;
        if (n == 0) {
            textArea.setText(String.valueOf(a + b));
            return;
        }
        fibRecursive(n, b, a + b);
    }

}

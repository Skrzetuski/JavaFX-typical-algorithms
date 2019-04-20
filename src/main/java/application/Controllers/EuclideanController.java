package application.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class EuclideanController implements Initializable {

    private static final Logger logger = LogManager.getLogger(EuclideanController.class.getName());

    @FXML
    private Spinner<Integer> firstSpinner;

    @FXML
    private Spinner<Integer> secondSpinner;

    public void showGCD() {
        Integer result = getGCD(firstSpinner.getValue(), secondSpinner.getValue());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(new StringBuilder("Result of GCD is ").append(result).toString());
        logger.info(
                new StringBuilder("The calculated gcd result of numbers ")
                        .append(firstSpinner.getValue()).append(" and ")
                        .append(secondSpinner.getValue()).append(" is ").append(result));
        alert.showAndWait();
    }

    private Integer getGCD(Integer first, Integer second) {
        while (!first.equals(second)) {
            if (first > second) {
                first -= second;
            } else {
                second -= first;
            }
        }
        return first;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        firstSpinner.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                if (newValue == null) {
                    firstSpinner.getValueFactory().setValue(oldValue);
                    logger.info("Someone tried to put an empty value to first spinner");
                }
            } catch (Exception e) {
                logger.error(new StringBuilder("Something went wrong with the first spinner: ").append(e.getMessage()));
            }
        });

        secondSpinner.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                if (newValue == null) {
                    secondSpinner.getValueFactory().setValue(oldValue);
                    logger.info("Someone tried to put an empty value to second spinner");
                }
            } catch (Exception e) {
                logger.error(new StringBuilder("Something went wrong with the second spinner: ").append(e.getMessage()));
            }
        });

        UnaryOperator<TextFormatter.Change> onlyNumbers = t -> {
            String text = t.getControlNewText();
            if (text.matches("[0-9]*")) {
                return t;
            }

            return null;
        };

        firstSpinner.getEditor().setTextFormatter(new TextFormatter<>(onlyNumbers));
        secondSpinner.getEditor().setTextFormatter(new TextFormatter<>(onlyNumbers));

    }

}

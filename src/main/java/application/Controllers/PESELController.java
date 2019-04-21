package application.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PESELController implements Initializable {

    private static final Logger logger = LogManager.getLogger(PESELController.class.getName());

    @FXML
    TextField textFieldPESEL;

    private boolean verifyPESEL() {

        String textPESEL = textFieldPESEL.getText();

        if (textPESEL.equals("00000000000") || textPESEL.isBlank() || textPESEL.length() < 10) {
            logger.info("The given PESEL is too short or empty or equals to 00000000000");
            return false;
        }

        List<Integer> weight = Arrays.asList(9, 7, 3, 1, 9, 7, 3, 1, 9, 7);
        List<Integer> splitPESEL = Arrays.stream(textPESEL.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer sum = IntStream.range(0, splitPESEL.size() - 1).map(i -> weight.get(i) * splitPESEL.get(i)).sum();
        Integer controlDigitFromPESEL = splitPESEL.get(splitPESEL.size() - 1);
        Integer controlDigit = sum % 10;

        logger.info(
                new StringBuilder("PESEL: ").append(textPESEL)
                                            .append("; sum: ").append(sum)
                                            .append("; control digit: ").append(controlDigit)
                                            .append("; PESEL control digit: ").append(controlDigitFromPESEL)
        );
        return controlDigit.equals(controlDigitFromPESEL);
    }

    public void showResult() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (verifyPESEL()) {
            alert.setHeaderText("Correct");
            logger.info(new StringBuilder("PESEL: ").append(textFieldPESEL.getText()).append(" is correct"));
        } else {
            alert.setHeaderText("Incorrect");
            logger.info(new StringBuilder("PESEL: ").append(textFieldPESEL.getText()).append(" is incorrect"));
        }
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textFieldPESEL.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 11) {
                textFieldPESEL.setText(newValue.substring(0, 11));
            }
            if (!newValue.matches("[0-9]*")) {
                textFieldPESEL.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
}

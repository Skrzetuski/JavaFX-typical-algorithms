package application.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import org.apache.logging.log4j.util.Strings;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BubbleSortController implements Initializable {

    @FXML
    TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("([0-9]*(\\,)*(\\ )*)*")) {
                textArea.setText(newValue.replaceAll("[^\\,\\ 0-9]", ""));
            }
        });
    }

    public void showSortedNumbers() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(sort());
        alert.showAndWait();
    }

    private String sort() {

        String numbersToSort = textArea.getText();
        List<Integer> sortedNumbers = Stream.of(numbersToSort.replace(",", " ").split(" "))
                                            .filter(Strings::isNotBlank)
                                            .map(Integer::parseInt)
                                            .sorted()
                                            .collect(Collectors.toList());

        return sortedNumbers.toString();
    }
}

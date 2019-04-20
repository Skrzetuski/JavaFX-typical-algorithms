package application.Controllers;

import javafx.scene.control.Alert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerfectNumbersController {

    private static final Logger logger = LogManager.getLogger(PerfectNumbersController.class.getName());

    private String getPerfectNumbers() {
        StringBuilder numbersBuilder = new StringBuilder();
        Integer sum = 0;

        for (int i = 3; i <= 10_000; i++) {
            sum = 0;

            for (int j = 1; j <= (i / 2); j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            if (i == sum) {
                numbersBuilder.append(sum).append(", ");
            }
        }

        numbersBuilder.delete(numbersBuilder.length() - 2, numbersBuilder.length() - 1);
        logger.info(new StringBuilder("Perfect numbers: ").append(numbersBuilder));
        return numbersBuilder.toString();
    }

    public void showPerfectNumbers() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(new StringBuilder("All perfect numbers: ").append(getPerfectNumbers()).toString());
        alert.showAndWait();
    }
}

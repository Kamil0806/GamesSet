package guesswhere;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class guesswhereController {

    @FXML
    private MenuItem oddorevenMenuItem;

    @FXML
    private MenuItem guessnumberMenuItem;

    @FXML
    private MenuItem blackjackMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Label labelText;

    @FXML
    private Button firstButton;

    @FXML
    private Button secondButton;

    @FXML
    private Button thirdButton;

    private int genNum = (int) (Math.random() * 3) + 1;

    @FXML
    void aboutMenuItemAction(ActionEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
    }

    @FXML
    void blackjackMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) firstButton.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/blackjack/blackjackWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Blackjack");
            stage.setResizable(false);
            Image image = new Image("/blackjack/Bj.png");
            stage.getIcons().add(image);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void firstButtonAction(ActionEvent event) {
        if (genNum == 1){
            firstButton.setStyle("-fx-background-color: GREEN");
        }
        else{
            firstButton.setStyle("-fx-background-color: RED");
        }
    }

    @FXML
    void guessnumberMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) firstButton.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/guessnumber/guessnumberWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Угадай число");
            javafx.scene.image.Image image = new Image("/guessnumber/Угадай число.png");
            stage.getIcons().add(image);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void oddorevenMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) firstButton.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/oddoreven/oddorevenWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Четное/Нечетное");
            Image image = new Image("/oddoreven/OddOrEven.jfif");
            stage.getIcons().add(image);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void secondButtonAction(ActionEvent event) {
        if (genNum == 2){
            secondButton.setStyle("-fx-background-color: GREEN");
        }
        else{
            secondButton.setStyle("-fx-background-color: RED");
        }
    }

    @FXML
    void thirdButtonAction(ActionEvent event) {
        if (genNum == 3){
            thirdButton.setStyle("-fx-background-color: GREEN");
        }
        else{
            thirdButton.setStyle("-fx-background-color: RED");
        }
    }

    @FXML
    void labelTextClicked(MouseEvent event) {
        firstButton.setStyle(null);
        secondButton.setStyle(null);
        thirdButton.setStyle(null);
        generate();
    }

    private void generate(){
        genNum = (int) (Math.random() * 3) + 1;
    }

}

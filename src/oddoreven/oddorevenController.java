package oddoreven;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class oddorevenController {
    private final int GEN_NUMBER = 100;
    int a = generate(GEN_NUMBER);

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label showText;

    @FXML
    private Button evenButton;

    @FXML
    private Button oddButton;

    @FXML
    private MenuItem guessnumberMenuItem;

    @FXML
    private MenuItem about;

    @FXML
    private MenuItem blackjackMenuItem;

    @FXML
    private MenuItem guesswhereMenuItem;


    @FXML
    void guesswhereMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) evenButton.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/guesswhere/guesswhereWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Угадай где");
            Image image = new Image("/guessnumber/Угадай число.png");
            stage.getIcons().add(image);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void blackjackMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) evenButton.getScene().getWindow();
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
    void aboutAction(ActionEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
    }

    @FXML
    void evenButtonClicked(MouseEvent event) {
        if (a % 2 == 0){
            showText.setText("Да! Число: " + Integer.toString(a));
            generateNum();
        }
        else{
            showText.setText("Нет! Число: " + Integer.toString(a));
            generateNum();
        }
    }

    @FXML
    void guessnumberMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) evenButton.getScene().getWindow();
        currentStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/guessnumber/guessnumberWindow.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Угадай число");
            Image image = new Image("/guessnumber/Угадай число.png");
            stage.getIcons().add(image);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void oddButtonClicked(MouseEvent event) {
        if (a % 2 != 0){
            showText.setText("Да! Число: " + Integer.toString(a));
            generateNum();
        }
        else{
            showText.setText("Нет! Число: " + Integer.toString(a));
            generateNum();
        }
    }

    public int generate(int n){
        int i = (int) (Math.random() * n) + 1;
        return i;
    }

    public void generateNum(){
        a = generate(GEN_NUMBER);
    }

}
package guessnumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class guessnumberController {
    private final int GEN_NUMBER = 10;
    int a = generate(GEN_NUMBER);

    @FXML
    private Label gameText;

    @FXML
    private TextField input;

    @FXML
    private Button againButton;

    @FXML
    private Button checkButton;

    @FXML
    private MenuItem oddorevenMenuItem;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private MenuItem blackjackMenuItem;

    @FXML
    private MenuItem guesswhereMenuItem;

    @FXML
    void guesswhereMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) againButton.getScene().getWindow();
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
        Stage currentStage = (Stage) againButton.getScene().getWindow();
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
    void aboutMenuItemAction(ActionEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
    }

    @FXML
    void againButtonClicked(MouseEvent event) {
        gameText.setText("Число от 1 до 10 загадано!");
        input.setText("");
        generateNum();
        checkButton.setDisable(true);
        againButton.setDisable(true);
    }

    @FXML
    void againButtonPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            gameText.setText("Число от 1 до 10 загадано!");
            input.setText("");
            generateNum();
            checkButton.setDisable(true);
            againButton.setDisable(true);
        }
    }

    @FXML
    void checkButtonClicked(MouseEvent event) {
        if (Integer.parseInt(input.getText()) == a){
            gameText.setText("Да! Число: " + Integer.toString(a));
            generateNum();
        }
        else {
            gameText.setText("Нет! Число: " + Integer.toString(a));
            generateNum();
        }
    }

    @FXML
    void checkButtonPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (Integer.parseInt(input.getText()) == a){
                gameText.setText("Да! Число: " + Integer.toString(a));
                generateNum();
            }
            else {
                gameText.setText("Нет! Число: " + Integer.toString(a));
                generateNum();
            }
            againButton.requestFocus();
        }
    }

    @FXML
    void onInputKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && input.getLength() > 0){
            checkButton.setDisable(false);
            againButton.setDisable(false);
            checkButton.requestFocus();
        }
    }

    @FXML
    void onInputKeyTyped(KeyEvent event) {
        if (input.getLength() == 0 && event.getCharacter().matches("0"))
            event.consume();

        if (!event.getCharacter().matches("[0-9]"))
            event.consume();

        if (input.getLength() == 1 && input.getText().charAt(0) != '1')
            event.consume();

        if (input.getLength() == 1 && !event.getCharacter().matches("0"))
            event.consume();

        if (input.getLength() == 2)
            event.consume();
    }

    public int generate(int n){
        int i = (int) (Math.random() * n) + 1;
        return i;
    }

    public void generateNum(){
        a = (int) (Math.random() * GEN_NUMBER) + 1;
    }

    public void oddorevenMenuAction(ActionEvent actionEvent) {
        Stage currentStage = (Stage) againButton.getScene().getWindow();
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
}

package blackjack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class blackjackController {
    private int diller = 0;
    private int player = 0;
    private int gameCounter = 1;
    private int dillerScoreCount = 0;
    private int playerScoreCount = 0;
    private int genNum;
    private final int GEN_NUMBER = 10;

    @FXML
    private MenuItem oddorevenMenuItem;

    @FXML
    private MenuItem guessnumberMenuItem;

    @FXML
    private MenuItem againMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Label dillerScore;

    @FXML
    private Label playerScore;

    @FXML
    private Button startButton;

    @FXML
    private Label gamesCount;

    @FXML
    private Label dillerCount;

    @FXML
    private Label playerCount;

    @FXML
    private Button stopButton;

    @FXML
    private Button hitButton;

    @FXML
    private MenuItem guesswhereMenuItem;

    @FXML
    void guesswhereMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) hitButton.getScene().getWindow();
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
    void aboutMenuItemAction(ActionEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
    }

    @FXML
    void againMenuItemAction(ActionEvent event) {
        startButton.setDisable(false);
        stopButton.setDisable(true);
        hitButton.setDisable(true);
        dillerCount.setText("0");
        playerCount.setText("0");
        dillerScore.setText("0");
        playerScore.setText("0");
        gameCounter = 1;
        gamesCount.setText("Игра номер: " + Integer.toString(gameCounter));
    }

    @FXML
    void guessnumberMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) startButton.getScene().getWindow();
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
    void hitButtonAction(ActionEvent event) {
        generateNum();
        if (genNum == 11 && player >= 13)
            player += 1;
        else
            player += genNum;
        playerCount.setText(Integer.toString(player));
        if (player > 21) {
            gamesCount.setText("Вы проиграли!");
            dillerScoreCount++;
            dillerScore.setText(Integer.toString(dillerScoreCount));
            startButton.setDisable(false);
            hitButton.setDisable(true);
            stopButton.setDisable(true);
            gameCounter++;
        }
        if (player == 21) {
            gamesCount.setText("Вы выиграли!");
            playerScoreCount++;
            playerScore.setText(Integer.toString(playerScoreCount));
            startButton.setDisable(false);
            hitButton.setDisable(true);
            stopButton.setDisable(true);
            gameCounter++;
        }

    }

    @FXML
    void oddorevenMenuItemAction(ActionEvent event) {
        Stage currentStage = (Stage) startButton.getScene().getWindow();
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
    void startButtonAction(ActionEvent event) {
        stopButton.setDisable(false);
        hitButton.setDisable(false);
        startButton.setDisable(true);
        diller = 0;
        player = 0;
        gamesCount.setText("Игра номер: " + Integer.toString(gameCounter));
        for (int i = 0; i < 2; i++) {
            generateNum();
            diller += genNum;
            generateNum();
            player += genNum;
        }
        dillerCount.setText(Integer.toString(diller));
        playerCount.setText(Integer.toString(player));
    }

    @FXML
    void stopButtonAction(ActionEvent event) {
        while (diller <= 21){
            if (diller == player){
                gamesCount.setText("Ничья!");
                startButton.setDisable(false);
                hitButton.setDisable(true);
                stopButton.setDisable(true);
                gameCounter++;
                break;
            }
            generateNum();
            if (genNum == 11 && diller >= 13)
                diller += 1;
            else
                diller += genNum;
            if (diller > 21){
                gamesCount.setText("Вы выиграли!");
                playerScoreCount++;
                playerScore.setText(Integer.toString(playerScoreCount));
                startButton.setDisable(false);
                hitButton.setDisable(true);
                stopButton.setDisable(true);
                gameCounter++;
                break;
            }
            if (diller == 17 && diller < player){
                gamesCount.setText("Вы выиграли!");
                playerScoreCount++;
                playerScore.setText(Integer.toString(playerScoreCount));
                startButton.setDisable(false);
                hitButton.setDisable(true);
                stopButton.setDisable(true);
                gameCounter++;
                break;
            }
            if (diller < 21 && diller == player){
                gamesCount.setText("Ничья!");
                startButton.setDisable(false);
                hitButton.setDisable(true);
                stopButton.setDisable(true);
                gameCounter++;
                break;
            }
            if (diller == 17 && diller > player){
                gamesCount.setText("Вы проиграли!");
                dillerScoreCount++;
                dillerScore.setText(Integer.toString(dillerScoreCount));
                startButton.setDisable(false);
                hitButton.setDisable(true);
                stopButton.setDisable(true);
                gameCounter++;
                break;
            }
        }
        dillerCount.setText(Integer.toString(diller));
    }

    private int generate(int n){
        int i = (int) (Math.random() * n) + 2;
        return i;
    }

    private void generateNum(){
        genNum = (int) (Math.random() * GEN_NUMBER) + 2;
    }

    @FXML
    void initialize() {

    }

}

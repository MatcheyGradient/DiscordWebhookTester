package DiscordWebhookTest;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField hookurl;

    @FXML
    private TextField msg;

    @FXML
    private TextField name;

    double x, y;
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() -x);
        stage.setY(event.getScreenY() -y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    void min(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    void sendmsg(ActionEvent event) {
        String url = hookurl.getText();
        String message = msg.getText();
        String hookname = name.getText();

        String webhook = url;
        DiscordWebhook discord = new DiscordWebhook(webhook); // Create the webhook client

        DiscordMessage dm = new DiscordMessage.Builder()
                .withUsername(hookname)
                .withContent(message)
                .build();

        discord.sendMessage(dm);



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

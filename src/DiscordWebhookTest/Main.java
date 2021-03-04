package DiscordWebhookTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("webhooktestGUI.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Discord Webhook Tester");
        primaryStage.setScene(new Scene(root, 365, 233));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

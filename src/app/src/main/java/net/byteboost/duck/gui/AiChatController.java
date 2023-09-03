package net.byteboost.duck.gui;

import dev.langchain4j.data.document.Document;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.byteboost.duck.utils.AIutils;

import java.net.URL;
import java.util.ResourceBundle;


public class AiChatController implements Initializable {

    private static String user;
    private static String access_lvl;
    private static Document doc;
    public static void saveUserInformation(String username, String access_level, Document document){
        user = username;
        access_lvl = access_level;
        doc = document;
    }
    @FXML
    private Button button_send;
    @FXML
    private TextField tf_question;
    @FXML
    private VBox chat;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Label question = new Label(tf_question.getText());
                question.getStylesheets().add("css/gui.css");
                question.getStyleClass().add("question");
                HBox hBoxQuestion=new HBox();
                hBoxQuestion.getChildren().add(question);
                hBoxQuestion.setAlignment(Pos.BASELINE_RIGHT);
                hBoxQuestion.setStyle("-fx-padding: 0 30 0 0");
                chat.getChildren().add(hBoxQuestion);
                chat.setSpacing(10);

                System.out.println("\nMessage Sent\n");
                System.out.println(tf_question.getText());
                System.out.print(AIutils.loadIntoHugging(doc,tf_question.getText()));

                Label response = new Label(AIutils.loadIntoHugging(doc,tf_question.getText()));
                question.getStylesheets().add("css/gui.css");
                response.getStyleClass().add("response");
                HBox hBoxResponse=new HBox();
                hBoxResponse.getChildren().add(response);
                hBoxResponse.setAlignment(Pos.BASELINE_LEFT);
                chat.getChildren().add(hBoxResponse);

            }
        });
    }
}

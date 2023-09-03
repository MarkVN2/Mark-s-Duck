package net.byteboost.duck.gui;

import dev.langchain4j.data.document.Document;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\nMessage Sent\n");
                System.out.println(tf_question.getText());
                System.out.print(AIutils.loadIntoHugging(doc,tf_question.getText()));
            }
        });
    }
}

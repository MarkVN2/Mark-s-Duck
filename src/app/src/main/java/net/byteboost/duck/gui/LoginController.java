package net.byteboost.duck.gui;

import dev.langchain4j.data.document.Document;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.byteboost.duck.utils.AIutils;
import net.byteboost.duck.utils.DButils;
import net.byteboost.duck.utils.GUIutils;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button button_login;
    @FXML
    private Button button_signup;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_username;
    @FXML
    private Button  btn_test_ai;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DButils.LogInUser(event, tf_username.getText(), tf_password.getText());
            }
        });

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              GUIutils.changeScene(event, "/fxml/signup.fxml", "Sign UP!", null , null, null);
            }
        });
        btn_test_ai.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Document document = AIutils.toDoc("/test-docs/aanatomiadoestado.pdf");

                System.out.println(AIutils.loadIntoHugging(document, "This SPECIFIC text is written by who?"));

            }
        });

    }
}

package net.byteboost.duck.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.byteboost.duck.utils.DButils;
import net.byteboost.duck.utils.GUIutils;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button button_login;
    @FXML
    private Button button_signup;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_access_level;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()  && !tf_access_level.getText().trim().isEmpty()){
                    DButils.LogInUser(event, tf_username.getText(), tf_password.getText(), tf_access_level.getText());
                }else{
                    System.out.println("Not all fields are filled");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Not all fields are filled");
                    alert.show();
                }

            }
        });

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GUIutils.changeScene(event, "login.fxml", "Login!", null , null, null);
            }
        });

    }
}

package net.byteboost.duck.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button button_about_us;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_access_level;
    @FXML
    private Label lb_e401;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()  && !tf_access_level.getText().trim().isEmpty()){

                    DButils.SingUpUser(event, tf_username.getText(), tf_password.getText(), tf_access_level.getText());

                    lb_e401.setStyle("-fx-text-fill:green");
                    lb_e401.setText(" User registered ");

                    tf_username.getStyleClass().add("filled");
                    tf_password.getStyleClass().add("filled");
                    tf_access_level.getStyleClass().add("filled");
                }
                else{
                    lb_e401.setText(" Not all fields are filled ");
                    if(tf_username.getText().trim().isEmpty()){
                        tf_username.getStyleClass().remove("filled");
                        tf_username.getStyleClass().add("not-filled");
                    }else {
                        tf_username.getStyleClass().remove("not-filled");
                        tf_username.getStyleClass().add("filled");
                    }
                    if(tf_password.getText().trim().isEmpty()){
                        tf_password.getStyleClass().remove("filled");
                        tf_password.getStyleClass().add("not-filled");
                    }else {
                        tf_password.getStyleClass().remove("not-filled");
                        tf_password.getStyleClass().add("filled");
                    }
                    if(tf_access_level.getText().trim().isEmpty()){
                        tf_access_level.getStyleClass().remove("filled");
                        tf_access_level.getStyleClass().add("not-filled");
                    }else {
                        tf_access_level.getStyleClass().remove("not-filled");
                        tf_access_level.getStyleClass().add("filled");
                    }
                    System.out.println("Not all fields are filled");
                }
            }
        });
        button_about_us.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    GUIutils.openSite("https://github.com/Byte-Boost");
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GUIutils.changeScene(event, "/fxml/login.fxml", "Login!", null , null, null, null);
            }
        });

    }
}

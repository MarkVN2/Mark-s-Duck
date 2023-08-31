package net.byteboost.duck.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.byteboost.duck.utils.GUIutils;
import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Label label_username;
    @FXML
    private Label label_access;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GUIutils.changeScene(actionEvent, "/fxml/login.fxml","Login", null , null , null );
            }
        });
    }
    public void setUserInformation(String username, String access_level){
        label_username.setText("Hello " + username + "."); 
        label_access.setText("Your access level is " + access_level);
    }
}

package net.byteboost.duck.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import net.byteboost.duck.gui.TestController;

import java.io.IOException;
import java.util.Objects;

public class GUIutils {
    public static void changeScene(ActionEvent event , String fxmlFile,String title, String username, String password, String access_level){
        Parent root = null;
        if (username != null && access_level != null){
            try {
                FXMLLoader loader = new FXMLLoader(GUIutils.class.getResource(fxmlFile));
                root = loader.load();
                TestController testController = loader.getController();
                testController.setUserInformation(username, access_level);
            }catch(IOException exception){
                exception.printStackTrace();
            }
        }else {
            try{
                FXMLLoader loader = new FXMLLoader(GUIutils.class.getResource(fxmlFile));
                root = loader.load();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,500,500));
        stage.show();
    }
}

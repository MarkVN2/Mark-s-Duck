package net.byteboost.duck.utils;

import dev.langchain4j.data.document.Document;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import net.byteboost.duck.gui.AiChatController;
import net.byteboost.duck.gui.FileUploadController;
import net.byteboost.duck.gui.TestController;

import java.io.IOException;
import java.net.URI;

/**
 * Utilities for the GUI in Duck, like changing scene, opening a site on the browser and such.
 */
public class GUIutils {
    public static void changeScene(ActionEvent event , String fxmlFile,String title, String username, String password, String access_level, Document document){
        Parent root = null;
        if (username != null && access_level != null){
            try {
                FXMLLoader loader = new FXMLLoader(GUIutils.class.getResource(fxmlFile));
                root = loader.load();
                if (fxmlFile=="/fxml/test.fxml") {
                    TestController testController = loader.getController();
                    testController.setUserInformation(username, access_level);
                }
                if (fxmlFile=="/fxml/aichat.fxml"){
                    AiChatController.saveUserInformation(username,access_level,document);
                }
                FileUploadController.saveUserInformation(username,access_level);

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
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void openSite(String url) throws Exception{
        URI u = new URI(url);
        java.awt.Desktop.getDesktop().browse(u);
    }

}

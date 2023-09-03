package net.byteboost.duck.gui;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.FileSystemDocumentLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import net.byteboost.duck.utils.GUIutils;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FileUploadController implements Initializable {

    private static String user;
    private static String access;
    @FXML
    private Button button_login;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_about_us;
    @FXML
    private Button button_upload;
    @FXML
    private Button button_upload2;
    @FXML
    private Label lb_e401;

    public static void saveUserInformation(String username, String access_level){
        user = username;
        access = access_level;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GUIutils.changeScene(event, "/fxml/login.fxml", "Login!", null , null, null, null);
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
        button_upload.setOnAction(new EventHandler<ActionEvent>() {
            FileChooser fileChooser = new FileChooser();

            @Override
            public void handle(ActionEvent event) {
                Node node = (Node) event.getSource();
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("txt,html,pdf,docx files", "*.txt","*.htm","*.pdf","*.docx")
                );
                File selectedFile = fileChooser.showOpenDialog(node.getScene().getWindow());
                if (selectedFile != null){

                    Document doc = FileSystemDocumentLoader.loadDocument(selectedFile.getPath());
                    GUIutils.changeScene(event,"/fxml/aichat.fxml", "Test", user,null , access, doc);
                }

            }
        });

    }

}

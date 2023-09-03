
package net.byteboost.duck;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.util.Objects;

/*TODO

- not use OpenAI for the AI;
- add support for more types of files;
- create user interface for upload of files and consultation with the AI;

-Logical process of the app experience in my mind
    
    -upload(doc,doc_perm_lvl)
    -convert(doc)

    -saveWithUniqueId[or variable if not trying to save in db](convert)

    -questionAbout(doc_id,question)
    -canAnswer?(perm_lvl, doc_perm_lvl)

    -Yes:
    -answerAbout(doc_id)
    -returns answer and user who asked about it [save time,date and user who asked about the doc into a db]
    
    -No:
    -returns permission error and user who asked about it [save time,date and user who asked about the doc into a db]

*/

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        stage.getIcons().add(new Image("https://imgs.search.brave.com/DfVipCWP3AbGQz2s-09ugYiziBPcnMKv_q58H2woa4U/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9jZG4t/aWNvbnMtcG5nLmZs/YXRpY29uLmNvbS8x/MjgvNjgxLzY4MTQ5/NC5wbmc"));

        final boolean resizable = stage.isResizable();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
        stage.setTitle("Login");
        stage.setResizable(!resizable);
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
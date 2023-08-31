
package net.byteboost.duck;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.byteboost.duck.utils.AIutils;
import dev.langchain4j.data.document.Document;

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

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/sign_up.fxml")));
        stage.setTitle("Login");
        stage.setScene(new Scene(root,500,500));
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
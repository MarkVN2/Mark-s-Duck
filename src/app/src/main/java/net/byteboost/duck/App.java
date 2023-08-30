
package net.byteboost.duck;

import net.byteboost.duck.functions.AIutils;
import dev.langchain4j.data.document.Document;

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

public class App {

    public static void main(String[] args) {

        // OpenAiChatModel model = OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY);

        // AiMessage answer = model.sendUserMessage("Hello anyone there?");

        // System.out.println(answer.text());

        String test_txt0 = "/test-docs/aanatomiadoestado.pdf";
        
        String test_txt1 = "/test-docs/patrimonial-analysis-of-financial-stability.txt";

        Document  converted_txt = AIutils.toDoc(test_txt1);
        
        System.out.println(converted_txt);

        System.out.println(AIutils.loadIntoOpenAI(converted_txt, "how many times does 'lorem' appears in the  text?"));

    }
}

package net.byteboost.duck;

import net.byteboost.duck.functions.Loader;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class App {

    public static void main(String[] args) {

        // OpenAiChatModel model = OpenAiChatModel.withApiKey(ApiKeys.OPENAI_API_KEY);

        // AiMessage answer = model.sendUserMessage("Hello anyone there?");

        // System.out.println(answer.text());
       
        String test_txt = "a.txt";
        Document  converted_txt= Loader.load(test_txt);
        System.out.println(Loader.loadintoAI(converted_txt));

    }
}
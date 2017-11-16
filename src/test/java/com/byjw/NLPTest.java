package com.byjw;

import com.byjw.NLP.NLAnalyze;
import com.byjw.NLP.NLAnalyzeVO;
import com.google.cloud.language.v1beta2.Entity;
import com.google.cloud.language.v1beta2.EntityMention;
import com.google.cloud.language.v1beta2.Sentiment;
import com.google.cloud.language.v1beta2.Token;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class NLPTest {

    private String text = "The easiest and recommended way for most users to use the Google Cloud Natural Language API is with our provided client libraries. They provide an optimized developer experience by using each supported language's natural conventions and styles. They also reduce the boilerplate code you have to write because they're designed to enable you to work with service metaphors in mind, rather than implementation details or service API concepts. You can find out more about client libraries for Cloud APIs in Client Libraries Explained.";

    @Test
    public void test_nlp_get_entities() {

        List<Entity> entityList = NLAnalyze.getInstance().analyzeEntities(text);


        System.out.println("\n\n========== Entities ==========\n\n");

        for (Entity entity : entityList) {

            for (EntityMention mention : entity.getMentionsList()) {
                System.out.printf("Content: %s\n", mention.getText().getContent());
                System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
                System.out.printf("Type: %s\n", mention.getType());
            }

            System.out.printf("Entity: %s", entity.getName());
            System.out.printf("Salience: %.3f\n", entity.getSalience());
            System.out.println("Metadata: ");

            for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
                System.out.printf("%s : %s", entry.getKey(), entry.getValue());
            }

            System.out.println("\n\n-------------------\n\n");

        }
    }

    @Test
    public void test_nlp_get_sentiment() {
        Sentiment sentiment = NLAnalyze.getInstance().analyzeSentiment(text);

        System.out.println("\n\n========== Sentiment ==========\n\n");

        System.out.println("getMagnitude() : " + sentiment.getMagnitude());
        System.out.println("getScore() : " + sentiment.getScore());

    }

    @Test
    public void test_nlp_get_syntex() {
        List<Token> tokenList = NLAnalyze.getInstance().analyzeSyntax(text);

        System.out.println("\n\n========== Syntax ==========\n\n");

        for (Token token : tokenList) {
            System.out.printf("\tText: %s\n", token.getText().getContent());
            System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
            System.out.println("\n-------------------\n");
            System.out.printf("Lemma: %s\n", token.getLemma());
            System.out.println("\n-------------------\n");
            System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
            System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
            System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
            System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
            System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
            System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
            System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
            System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
            System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
            System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
            System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
            System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
            System.out.println("\n-------------------\n");
            System.out.println("DependencyEdge");
            System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
            System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
        }
    }


    @Test
    public void test_nlp_get_analyze() {
        NLAnalyzeVO vo = NLAnalyze.getInstance().analyze(text);

        List<String> nouns = vo.getNouns();
        List<String> adjs = vo.getAdjs();

        System.out.println("\n\n========== Nouns ==========\n\n");

        for (String noun : nouns) {
            System.out.printf("noun : %s\n", noun);
        }


        System.out.println("\n\n========== Ajds ==========\n\n");

        for (String adj : adjs) {
            System.out.printf("adj : %s\n", adj);
        }

    }

}

package com.byjw.NLP;

import com.google.cloud.language.v1beta2.*;
import java.util.List;

public class NLAnalyzeV2 {

    private static NLAnalyzeV2 instance = new NLAnalyzeV2();
    private static Document document;
    private static LanguageServiceClient languageServiceClient;

    public static NLAnalyzeV2 getInstance() {
        return instance;
    }


    public void analyze(String text) {
        try {
            languageServiceClient = LanguageServiceClient.create();
            document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Entity> analyzeEntities(String text) {
        try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
                    .setDocument(document)
                    .setEncodingType(EncodingType.UTF16)
                    .build();

            AnalyzeEntitiesResponse response = languageServiceClient.analyzeEntities(request);

            return response.getEntitiesList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Sentiment analyzeSentiment(String text) {
        try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeSentimentResponse response = languageServiceClient.analyzeSentiment(document);
            return response.getDocumentSentiment();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Token> analyzeSyntax(String text) {
        try (LanguageServiceClient languageServiceClient = LanguageServiceClient.create()) {
            Document document = Document.newBuilder().setContent(text).setType(Document.Type.PLAIN_TEXT).build();

            AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
                    .setDocument(document)
                    .setEncodingType(EncodingType.UTF16)
                    .build();

            AnalyzeSyntaxResponse response = languageServiceClient.analyzeSyntax(request);

            return response.getTokensList();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

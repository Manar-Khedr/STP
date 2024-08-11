package com.sumerge.oop;

import java.util.*;

public class TrueFalseQuestion implements Questionable {

    private String questionText;
    private String correctAnswer;

    public TrueFalseQuestion(String questionText, String correctAnswer) {
        setQuestionText(questionText);
        setCorrectAnswer(correctAnswer);
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public void setQuestionText(String questionText) {
        if (questionText == null || questionText.isEmpty()) {
            throw new IllegalArgumentException("Question text CANNOT be empty.");
        }
        this.questionText = questionText;
    }

    @Override
    public List<String> getOptions() {
        return Collections.unmodifiableList(List.of("True", "False"));
    }

    @Override
    public void setOptions(List<String> options) {
        throw new UnsupportedOperationException("Options for True/False questions CANNOT be changed.");
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        if (!"True".equalsIgnoreCase(correctAnswer) && !"False".equalsIgnoreCase(correctAnswer)) {
            throw new IllegalArgumentException("The answer MUST BE 'True' or 'False'.");
        }
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
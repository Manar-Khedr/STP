package com.sumerge.oop;
import java.util.*;

public class MultipleChoiceQuestion implements Questionable {

    private String questionText;
    private List<String> options;
    private String correctAnswer;

    public MultipleChoiceQuestion(String questionText, List<String> options, String correctAnswer) {
        setQuestionText(questionText);
        setOptions(options);
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
        return options;
    }

    @Override
    public void setOptions(List<String> options) {
        if (options == null || options.size() < 2) {
            throw new IllegalArgumentException("A multiple-choice question must have ATLEAST 2 options.");
        }
        this.options = options;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public void setCorrectAnswer(String correctAnswer) {
        if (!isValidOption(correctAnswer)) {
            throw new IllegalArgumentException("The correct answer MUST BE one of the provided options.");
        }
        this.correctAnswer = correctAnswer;
    }

    private boolean isValidOption(String answer) {
        return options.stream().anyMatch(option -> option.trim().equalsIgnoreCase(answer.trim()));
    }

    @Override
    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
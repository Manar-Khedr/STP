package com.sumerge.oop;
import java.util.*;

public interface Questionable {

    String getQuestionText();
    void setQuestionText(String questionText);

    List<String> getOptions();
    void setOptions(List<String> options);

    String getCorrectAnswer();
    void setCorrectAnswer(String correctAnswer);

    boolean checkAnswer(String answer);

}

package com.sumerge.oop;

import java.util.*;

public class Quiz {
    private List<Questionable> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Questionable question) {
        questions.add(question);
    }

    public void takeQuiz(User user) {
        Scanner scanner = new Scanner(System.in);
        if (questions.isEmpty()) {
            System.out.println("\033[0;31m" + "No questions available in the quiz." + "\033[0m");
            return;
        }

        System.out.print("How many questions would you like to answer? ");
        int numberOfQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numberOfQuestions > questions.size()) {
            numberOfQuestions = questions.size();
            System.out.println("Only " + numberOfQuestions + " questions are available. The quiz will include all available questions.");
        }

        Collections.shuffle(questions); // Shuffle the questions to ensure randomness
        List<Questionable> selectedQuestions = questions.subList(0, numberOfQuestions);

        int score = 0;

        for (int i = 0; i < selectedQuestions.size(); i++) {
            Questionable question = selectedQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestionText());

            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char) ('a' + j) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (question.checkAnswer(userAnswer)) {
                score++;
                System.out.println("\u001B[32m" + "Correct!" +  "\u001B[0m");
            } else {
                System.out.println("\033[0;31m" + "Incorrect! The correct answer was: " + question.getCorrectAnswer() + "\033[0m");
            }

            System.out.println("\u001B[38;5;214m" + "Your current score: " + score + "/" + (i + 1) + "\u001B[0m");
        }

        System.out.println("Quiz completed! Your final score: " + score + "/" + numberOfQuestions);
    }
}

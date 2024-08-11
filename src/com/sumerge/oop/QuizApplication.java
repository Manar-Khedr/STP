package com.sumerge.oop;

import java.util.*;

public class QuizApplication {
    private Quiz quiz;
    private List<User> users;

    public QuizApplication() {
        this.quiz = new Quiz();
        this.users = new ArrayList<>();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name);
        users.add(user);
    }

    public void addQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        if ("Admin".equalsIgnoreCase(name)) {
            System.out.print("How many questions do you want to add? ");
            int numberOfQuestions = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberOfQuestions; i++) {
                System.out.print("Enter the type of question (1 for Multiple Choice, 2 for True/False): ");
                int type = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter the question text: ");
                String questionText = scanner.nextLine();

                if (type == 1) {
                    System.out.println("Enter options (separated by commas): ");
                    String[] optionsArray = scanner.nextLine().split(",");
                    List<String> options = new ArrayList<>();
                    for (String option : optionsArray) {
                        options.add(option.trim());
                    }
                    System.out.print("Enter the correct answer: ");
                    String correctAnswer = scanner.nextLine();

                    Questionable question = new MultipleChoiceQuestion(questionText, options, correctAnswer);
                    quiz.addQuestion(question);

                } else if (type == 2) {
                    System.out.print("Enter the correct answer (True/False): ");
                    String correctAnswer = scanner.nextLine();

                    Questionable question = new TrueFalseQuestion(questionText, correctAnswer);
                    quiz.addQuestion(question);

                } else {
                    printError("INVALID TYPE.");
                }
            }
        } else {
            printError("ONLY Admin can add questions.");
        }
    }

    public void startQuiz() {
        if (users.isEmpty()) {
            printError("No users available. Please create a user first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a user:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName());
        }
        int userIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (userIndex < 0 || userIndex >= users.size()) {
            printError("INVALID USER SELECTION.");
            return;
        }

        User selectedUser = users.get(userIndex);

        if ("Admin".equalsIgnoreCase(selectedUser.getName())) {
            printError("As Admin, you CANNOT take the quiz. Please create normal users to take the quiz.");
        } else {
            quiz.takeQuiz(selectedUser);
        }
    }

    public void printError(String message) {
        System.out.println("\033[0;31m" + message + "\033[0m");
    }

    public void exitApplication(){
        System.out.println("\u001B[34m" + "Thank you for using our application! Exiting now ..." + "\u001B[0m");
    }

}

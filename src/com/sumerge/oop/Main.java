package com.sumerge.oop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        QuizApplication app = new QuizApplication();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[34m" + "Welcome to Random Trivia Question Application!" + "\u001B[0m");

        while (true) {
            System.out.println("\u001B[34m" + "Please select from the options below:" + "\u001B[0m");
            System.out.println("1. Create User");
            System.out.println("2. Add Question");
            System.out.println("3. Start Quiz");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    app.createUser();
                    break;
                case 2:
                    app.addQuestion();
                    break;
                case 3:
                    app.startQuiz();
                    break;
                case 4:
                    app.exitApplication();
                    break;
                default:
                    app.printError("Invalid option. Please try again.");
            }
        }
    }
}

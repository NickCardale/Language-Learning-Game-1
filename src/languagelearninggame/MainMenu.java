/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Language Learning Game ===");
            System.out.println("1. Spanish Quiz");
            System.out.println("2. French Quiz");
            System.out.println("3. Italian Quiz");
            System.out.println("4. Exit");
            System.out.print("Select a language: ");
            int languageChoice = getValidIntegerInput(1, 4, scan);

            switch (languageChoice) {
                case 1:
                    showDifficultyMenu("Spanish");
                    break;
                case 2:
                    showDifficultyMenu("French");
                    break;
                case 3:
                    showDifficultyMenu("Italian");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }

        System.out.println("Thank you for playing!");
    }

    private static void showDifficultyMenu(String language) {
        Scanner scan = new Scanner(System.in);
        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("=== " + language + " Quiz ===");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select a difficulty level: ");
            int difficultyChoice = getValidIntegerInput(1, 4, scan);

            switch (difficultyChoice) {
                case 1:
                    startQuiz(language, "Easy");
                    break;
                case 2:
                    startQuiz(language, "Medium");
                    break;
                case 3:
                    startQuiz(language, "Hard");
                    break;
                case 4:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }
    }

    private static void startQuiz(String language, String difficulty) {
        Quiz quiz = null;

        switch (language) {
            case "Spanish":
                switch (difficulty) {
                    case "Easy":
                        quiz = new SpanishQuizEasy();
                        break;
                    case "Medium":
                        quiz = new SpanishQuizMedium();
                        break;
                    case "Hard":
                        quiz = new SpanishQuizHard();
                        break;
                }
                break;
            case "French":
                switch (difficulty) {
                    case "Easy":
                        quiz = new FrenchQuizEasy();
                        break;
                    case "Medium":
                        quiz = new FrenchQuizMedium();
                        break;
                    case "Hard":
                        quiz = new FrenchQuizHard();
                        break;
                }
                break;
            case "Italian":
                switch (difficulty) {
                    case "Easy":
                        quiz = new ItalianQuizEasy();
                        break;
                    case "Medium":
                        quiz = new ItalianQuizMedium();
                        break;
                    case "Hard":
                        quiz = new ItalianQuizHard();
                        break;
                }
                break;
        }

        if (quiz != null) {
            quiz.displayQuestions();
        } else {
            System.out.println("Error: Unable to start quiz.");
        }
    }
//ChatGPT helped to create this section below, to catch invalid inputs
    private static int getValidIntegerInput(int min, int max, Scanner scan) {
        int choice = -1;
        while (true) {
            try {
                choice = scan.nextInt();
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                scan.next();
            }
        }
        return choice;
    }
}


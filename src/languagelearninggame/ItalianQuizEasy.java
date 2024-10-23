/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class ItalianQuizEasy extends Quiz {

    public ItalianQuizEasy() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Italian word for \"apple\"?\n"
                + "a) Arancia\n"
                + "b) Mela\n"
                + "c) Uva\n"
                + "d) Pera",
            "Question: How do you say \"Good morning\" in Italian?\n"
                + "a) Buona sera\n"
                + "b) Buona notte\n"
                + "c) Buongiorno\n"
                + "d) Ciao",
            "Question: How do you say \"Thank you\" in Italian?\n"
                + "a) Mi scusi\n"
                + "b) Grazie\n"
                + "c) Per favore\n"
                + "d) Di nulla",
            "Question: What is the Italian word for \"house\"?\n"
                + "a) Casa\n"
                + "b) Scuola\n"
                + "c) Negozio\n"
                + "d) Città",
            "Question: What is the Italian word for \"water\"?\n"
                + "a) Acqua\n"
                + "b) Succo\n"
                + "c) Vino\n"
                + "d) Latte"
        };
        
        this.answers = new String[] {"b", "c", "b", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Italian Easy Quiz!");
        System.out.println("Please answer each question by entering the letter of your choice.");
        System.out.println();

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            responses[i] = scan.next();

            // Validate the answer
            while (!responses[i].matches("[a-dA-D]")) {
                System.out.print("Invalid choice. Please enter a valid letter (a, b, c, or d): ");
                responses[i] = scan.next();
            }
        }

        // Calculate score and display
        score = calculateScore(responses);
        System.out.println();
        System.out.println("Score: " + score + "/5");

        if (score == 5) {
            System.out.println("Excellent! You got all the answers right. Good job!");
        } else if (score >= 3) {
            System.out.println("Good job! You got most of the answers correct.");
        } else {
            System.out.println("You need to study more. Keep practicing!");
        }

        // Save the score to file
        saveScore("Italian Easy Quiz", score);
    }

    @Override
    public int calculateScore(String[] responses) {
        int score = 0;
        for (int i = 0; i < responses.length; i++) {
            if (responses[i].equalsIgnoreCase(answers[i])) {
                score++;
            }
        }
        return score;
    }
}

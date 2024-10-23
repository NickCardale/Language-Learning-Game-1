/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class ItalianQuizMedium extends Quiz {

    public ItalianQuizMedium() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Italian word for \"fireplace\"?\n"
                + "a) Finestra\n"
                + "b) Camino\n"
                + "c) Porta\n"
                + "d) Tetto",
            "Question: How do you say \"library\" in Italian?\n"
                + "a) Biblioteca\n"
                + "b) Libreria\n"
                + "c) Scuola\n"
                + "d) Chiesa",
            "Question: How do you say \"post office\" in Italian?\n"
                + "a) Ufficio postale\n"
                + "b) Farmacia\n"
                + "c) Municipio\n"
                + "d) Negozio",
            "Question: What is the Italian word for \"garden\"?\n"
                + "a) Giardino\n"
                + "b) Parco\n"
                + "c) Campo\n"
                + "d) Piazza",
            "Question: What is the Italian word for \"statue\"?\n"
                + "a) Dipinto\n"
                + "b) Statua\n"
                + "c) Fotografia\n"
                + "d) Disegno"
        };
        
        this.answers = new String[] {"b", "a", "a", "a", "b"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Italian Medium Quiz!");
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
        saveScore("Italian Medium Quiz", score);
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

       

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class SpanishQuizMedium extends Quiz {

    public SpanishQuizMedium() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Spanish word for \"sunflower\"?\n"
                + "a) Rosa\n"
                + "b) Girasol\n"
                + "c) Lirio\n"
                + "d) Tulipán",
            "Question: How do you say \"airplane\" in Spanish?\n"
                + "a) Barco\n"
                + "b) Avión\n"
                + "c) Tren\n"
                + "d) Coche",
            "Question: How do you say \"bookstore\" in Spanish?\n"
                + "a) Biblioteca\n"
                + "b) Librería\n"
                + "c) Mercado\n"
                + "d) Oficina",
            "Question: What is the Spanish word for \"calendar\"?\n"
                + "a) Agenda\n"
                + "b) Calendario\n"
                + "c) Diario\n"
                + "d) Libro",
            "Question: What is the Spanish word for \"bicycle\"?\n"
                + "a) Moto\n"
                + "b) Bicicleta\n"
                + "c) Camión\n"
                + "d) Barco"
        };
        
        this.answers = new String[] {"b", "b", "b", "b", "b"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Spanish Medium Quiz!");
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
        saveScore("Spanish Medium Quiz", score);
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

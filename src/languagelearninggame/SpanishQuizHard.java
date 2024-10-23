/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class SpanishQuizHard extends Quiz {

    public SpanishQuizHard() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Spanish word for \"unbelievable\"?\n"
                + "a) Increíble\n"
                + "b) Impresionante\n"
                + "c) Asombroso\n"
                + "d) Inusual",
            "Question: How do you say \"neighborhood\" in Spanish?\n"
                + "a) Barrio\n"
                + "b) Ciudad\n"
                + "c) Región\n"
                + "d) Área",
            "Question: How do you say \"congratulations\" in Spanish?\n"
                + "a) Felicitaciones\n"
                + "b) Gracias\n"
                + "c) Buen trabajo\n"
                + "d) Bien hecho",
            "Question: What is the Spanish word for \"freight\"?\n"
                + "a) Carga\n"
                + "b) Transporte\n"
                + "c) Envío\n"
                + "d) Mercancía",
            "Question: What is the Spanish word for \"heritage\"?\n"
                + "a) Patrimonio\n"
                + "b) Legado\n"
                + "c) Historia\n"
                + "d) Tradición"
        };
        
        this.answers = new String[] {"a", "a", "a", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Spanish Hard Quiz!");
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
        saveScore("Spanish Hard Quiz", score);
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


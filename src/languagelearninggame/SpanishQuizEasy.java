/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class SpanishQuizEasy extends Quiz {

    public SpanishQuizEasy() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Spanish word for \"apple\"?\n"
                + "a) Naranja\n"
                + "b) Manzana\n"
                + "c) Uva\n"
                + "d) Pera",
            "Question: How do you say \"Good morning\" in Spanish?\n"
                + "a) Buenas tardes\n"
                + "b) Buenas noches\n"
                + "c) Buenos días\n"
                + "d) Hola",
            "Question: How do you say \"Thank you\" in Spanish?\n"
                + "a) Lo siento\n"
                + "b) Gracias\n"
                + "c) Por favor\n"
                + "d) De nada",
            "Question: What is the Spanish word for \"house\"?\n"
                + "a) Casa\n"
                + "b) Escuela\n"
                + "c) Tienda\n"
                + "d) Ciudad",
            "Question: What is the Spanish word for \"water\"?\n"
                + "a) Agua\n"
                + "b) Jugo\n"
                + "c) Vino\n"
                + "d) Leche"
        };
        
        this.answers = new String[] {"b", "c", "b", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Spanish Easy Quiz!");
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
        saveScore("Spanish Easy Quiz", score);
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

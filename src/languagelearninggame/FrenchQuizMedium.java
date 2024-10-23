/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class FrenchQuizMedium extends Quiz {

    public FrenchQuizMedium() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the French word for \"chandelier\"?\n"
                + "a) Lustre\n"
                + "b) Lampe\n"
                + "c) Bougie\n"
                + "d) Éclairage",
            "Question: How do you say \"train station\" in French?\n"
                + "a) Gare\n"
                + "b) Aéroport\n"
                + "c) Métro\n"
                + "d) Parc",
            "Question: How do you say \"museum\" in French?\n"
                + "a) Galerie\n"
                + "b) Bibliothèque\n"
                + "c) Musée\n"
                + "d) Théâtre",
            "Question: What is the French word for \"oven\"?\n"
                + "a) Four\n"
                + "b) Réfrigérateur\n"
                + "c) Plaque\n"
                + "d) Grille-pain",
            "Question: What is the French word for \"mountain\"?\n"
                + "a) Plage\n"
                + "b) Montagne\n"
                + "c) Vallée\n"
                + "d) Lac"
        };
        
        this.answers = new String[] {"a", "a", "c", "a", "b"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the French Medium Quiz!");
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
        saveScore("French Medium Quiz", score);
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

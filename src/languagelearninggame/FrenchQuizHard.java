/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class FrenchQuizHard extends Quiz {

    public FrenchQuizHard() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the French word for \"extraordinary\"?\n"
                + "a) Extraordinaire\n"
                + "b) Exceptionnel\n"
                + "c) Étonnant\n"
                + "d) Remarquable",
            "Question: How do you say \"academic\" in French?\n"
                + "a) Universitaire\n"
                + "b) Scolaire\n"
                + "c) Éducatif\n"
                + "d) Savant",
            "Question: How do you say \"charity\" in French?\n"
                + "a) Charité\n"
                + "b) Bienfaisance\n"
                + "c) Aide\n"
                + "d) Don",
            "Question: What is the French word for \"strategy\"?\n"
                + "a) Stratégie\n"
                + "b) Tactique\n"
                + "c) Plan\n"
                + "d) Méthode",
            "Question: What is the French word for \"environment\"?\n"
                + "a) Environnement\n"
                + "b) Nature\n"
                + "c) Écosystème\n"
                + "d) Milieu"
        };
        
        this.answers = new String[] {"a", "a", "a", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the French Hard Quiz!");
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
        saveScore("French Hard Quiz", score);
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


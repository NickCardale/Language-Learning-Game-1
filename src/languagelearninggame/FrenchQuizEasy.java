/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

/**
 *
 * @author nicho
 */
import java.util.Scanner;

public class FrenchQuizEasy extends Quiz {

    public FrenchQuizEasy() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the French word for \"apple\"?\n"
                + "a) Orange\n"
                + "b) Pomme\n"
                + "c) Raisin\n"
                + "d) Poire",
            "Question: How do you say \"Good morning\" in French?\n"
                + "a) Bonsoir\n"
                + "b) Bonne nuit\n"
                + "c) Bonjour\n"
                + "d) Salut",
            "Question: How do you say \"Thank you\" in French?\n"
                + "a) Excusez-moi\n"
                + "b) Merci\n"
                + "c) S'il vous plaît\n"
                + "d) De rien",
            "Question: What is the French word for \"house\"?\n"
                + "a) Maison\n"
                + "b) École\n"
                + "c) Boutique\n"
                + "d) Ville",
            "Question: What is the French word for \"water\"?\n"
                + "a) Eau\n"
                + "b) Jus\n"
                + "c) Vin\n"
                + "d) Lait"
        };
        
        this.answers = new String[] {"b", "c", "b", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the French Easy Quiz!");
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
        saveScore("French Easy Quiz", score);
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

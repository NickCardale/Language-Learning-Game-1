/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

import java.util.Scanner;

public class ItalianQuizHard extends Quiz {

    public ItalianQuizHard() {
        // Initialize questions and answers
        this.questions = new String[] {
            "Question: What is the Italian word for \"achievement\"?\n"
                + "a) Successo\n"
                + "b) Realizzazione\n"
                + "c) Risultato\n"
                + "d) Traguardo",
            "Question: How do you say \"philosophy\" in Italian?\n"
                + "a) Filosofia\n"
                + "b) Scienza\n"
                + "c) Teoria\n"
                + "d) Studio",
            "Question: How do you say \"conference\" in Italian?\n"
                + "a) Conferenza\n"
                + "b) Seminario\n"
                + "c) Congresso\n"
                + "d) Incontro",
            "Question: What is the Italian word for \"reliability\"?\n"
                + "a) Affidabilità\n"
                + "b) Sicurezza\n"
                + "c) Flessibilità\n"
                + "d) Stabilità",
            "Question: What is the Italian word for \"ecosystem\"?\n"
                + "a) Ecosistema\n"
                + "b) Ambiente\n"
                + "c) Natura\n"
                + "d) Habitat"
        };
        
        this.answers = new String[] {"d", "a", "a", "a", "a"};
    }

    @Override
    public void displayQuestions() {
        Scanner scan = new Scanner(System.in);
        String[] responses = new String[questions.length];
        int score = 0;

        System.out.println("Welcome to the Italian Hard Quiz!");
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
        saveScore("Italian Hard Quiz", score);
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

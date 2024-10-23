/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package languagelearninggame;

/**
 *
 * @author nicho
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Quiz {
protected String[] questions;
    protected String[] answers;

    public abstract void displayQuestions();
    public abstract int calculateScore(String[] responses);
// ChatGPT helped to Create the File Save Section Beacuase it kept Saving to Wrong place
    public void saveScore(String gameName, int score) {
        try (FileWriter fileWriter = new FileWriter("score.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Game: " + gameName);
            printWriter.println("Score: " + score + "/5");
            printWriter.println();
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }
}

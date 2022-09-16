
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author padilla
 */
public class Question {
    String question;
    String[] choices;
    String correctAnswer;

    public Question setQuestion(String question) {
        this.question = question;
        
        return this;
    }

    public Question setChoices(String...choices) {
        this.choices = choices;
        
        return this;
    }

    public Question setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public static ArrayList<Question> setQuestion() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question()
                .setQuestion("What is the capital of the Philippines?")
                .setChoices("Manila", "Quezon City", "Makati", "Cavite")
                .setCorrectAnswer("Manila"));
        
        questions.add(new Question()
                .setQuestion("Who is the National Hero of the Philipines?")
                .setChoices("Andres Bonifacio", "Apolinario Mabini", "Juan Luna", "Jose Rizal")
                .setCorrectAnswer("Jose Rizal"));
        
        questions.add(new Question()
                .setQuestion("Who named the Philippines?")
                .setChoices("Magellan", "Ruy Lopez de Villlalobos", "King Philip ll", "Antonio Banderas")
                .setCorrectAnswer("Magellan"));
        
        questions.add(new Question()
                .setQuestion("Who killed Magellan?")
                .setChoices("Raja Solayman", "Lapu-lapu", "Meliodas", "Son Goku")
                .setCorrectAnswer("Lapu-lapu"));
        
        questions.add(new Question()
                .setQuestion("Who is the founder of KKK?")
                .setChoices("Emilio Aguinaldo", "Andres Bonifacio", "Antonio Luna", "Jose Rizl;")
                .setCorrectAnswer("Andres Bonifacio"));
        

        return questions;

    }
    
    
    
}

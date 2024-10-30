import java.util.ArrayList;
import java.util.Scanner;

// Question class to store question text, options, and correct answer
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

// Quiz class to manage questions and handle the quiz workflow
class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    // Add a question to the quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Conduct the quiz by displaying each question and evaluating answers
    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int userAnswer = 0;
            boolean validInput = false;

            // Input validation loop
            while (!validInput) {
                System.out.print("Your answer (1-" + options.length + "): ");
                try {
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer >= 1 && userAnswer <= options.length) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a valid option number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Check if answer is correct and update the score
            if (userAnswer == q.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + q.getCorrectAnswer() + ".");
            }
            System.out.println();
        }

        // Display the final score after all questions are answered
        System.out.println("Quiz Complete!");
        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

// Main class to set up the quiz and run the program
public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add sample questions to the quiz
        quiz.addQuestion(new Question(
            "What is the capital of France?",
            new String[]{"Berlin", "Paris", "Rome", "Madrid"},
            2
        ));

        quiz.addQuestion(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"Earth", "Mars", "Jupiter", "Saturn"},
            2
        ));

        quiz.addQuestion(new Question(
            "What is the largest ocean on Earth?",
            new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"},
            4
        ));

        // Start the quiz
        quiz.start();
    }
}

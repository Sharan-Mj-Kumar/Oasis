import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGG extends JFrame {
    private int randomNumber;
    private int attemptsLeft = 10;
    private int currentRound = 1;
    private final int totalRounds = 3;
    private int[] scores = new int[totalRounds];
    private JTextField guessField;
    private JLabel messageLabel;

    public NumberGG() {
        setTitle("Number-Guessing-Game(NGG)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Generate random number between 1 and 100
        generateRandomNumber();

        // Guess input field
        guessField = new JTextField();
        add(guessField);

        // Check button
        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new CheckButtonListener());
        add(checkButton);

        // Message label
        messageLabel = new JLabel("Round 1: I've chosen a number between 1 and 100. Start guessing!");
        add(messageLabel);

        setVisible(true);
    }

    private void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }

    private class CheckButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                attemptsLeft--;

                if (guess == randomNumber) {
                    scores[currentRound - 1] = 10 - attemptsLeft;
                    messageLabel.setText("Congratulations! You guessed it in " + scores[currentRound - 1] + " attempts.");
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            nextRound();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (attemptsLeft == 0) {
                    scores[currentRound - 1] = 10;
                    messageLabel.setText("You ran out of attempts! The number was " + randomNumber);
                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            nextRound();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (guess < randomNumber) {
                    messageLabel.setText(guess + " is Too low! Guess higher. Attempts left: " + attemptsLeft);
                } else {
                    messageLabel.setText(guess + " is Too high! Guess lower. Attempts left: " + attemptsLeft);
                }

                guessField.setText("");
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number.");
            }
        }
    }

    private void nextRound() {
        if (currentRound < totalRounds) {
            currentRound++;
            attemptsLeft = 10;
            generateRandomNumber();
            messageLabel.setText("Round " + currentRound + ": I've chosen a number between 1 and 100. Start guessing!");
        } else {
            endGame();
        }
    }

    private void endGame() {
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        messageLabel.setText("Game over! Your total score after " + totalRounds + " rounds is: " + totalScore);
        guessField.setEnabled(false);
    }

    public static void main(String[] args) {
        new NumberGG();
    }
}
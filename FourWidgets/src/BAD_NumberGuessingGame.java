// Bryson Davis
// CS-2463-TW01S
// 4-2-2023

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BAD_NumberGuessingGame extends JPanel {
	Font appFontLarge = new Font("Arial", Font.PLAIN, 30);
	Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
	int randomNum;
	int numOfGuesses;
	
	BAD_NumberGuessingGame() {
		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel upperInput = new JPanel();
		JPanel lowerInput = new JPanel();
		JPanel guessPanel = new JPanel();
		JPanel upperGuess = new JPanel();
		JPanel lowerGuess = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel rangePanel = new JPanel();
		JPanel answerPanel = new JPanel();
		JPanel upperAns = new JPanel();
		JPanel lowerAns = new JPanel();
		
		JLabel titleLabel = new JLabel("Number guessing game!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);
		
		JSlider numRange = new JSlider(0, 100, 50);
		numRange.setPaintTrack(true);
		numRange.setPaintTicks(true);
		numRange.setPaintLabels(true);
		numRange.setMajorTickSpacing(50);
		
		JLabel inputValue = new JLabel("Value: " + numRange.getValue());
		inputValue.setFont(appFontSmall);
		JButton setBtn = new JButton("Set");
		
		rangePanel.setLayout(new BorderLayout());
		upperInput.add(numRange);
		lowerInput.add(inputValue);
		lowerInput.add(setBtn);
		rangePanel.add(upperInput, BorderLayout.NORTH);
		rangePanel.add(lowerInput);
		
		JTextField guessField = new JTextField();
		guessField.setFont(appFontSmall);
		guessField.setColumns(5);
		JButton guessBtn = new JButton("Guess");
		
		upperGuess.add(guessField);
		lowerGuess.add(guessBtn);
		guessPanel.setLayout(new BorderLayout());
		guessPanel.add(upperGuess, BorderLayout.NORTH);
		guessPanel.add(lowerGuess);
		
		centerPanel.setLayout(new GridLayout(2,1));
		centerPanel.add(rangePanel, BorderLayout.NORTH);
		centerPanel.add(guessPanel);
		
		JLabel answer = new JLabel("");
		JLabel numOfGuess = new JLabel("Number of guesses: " + numOfGuesses);
		upperAns.setLayout(new BorderLayout());
		upperAns.add(answer, BorderLayout.NORTH);
		upperAns.add(numOfGuess, BorderLayout.SOUTH);
		JButton restart = new JButton("Restart");
		lowerAns.add(restart);
		
		answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		answerPanel.add(upperAns, BorderLayout.NORTH);
		answerPanel.add(lowerAns, BorderLayout.SOUTH);
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(centerPanel);
		this.add(answerPanel, BorderLayout.SOUTH);
		guessPanel.setVisible(false);
		answerPanel.setVisible(false);
		
		numRange.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				inputValue.setText("Value: " + numRange.getValue());
			}
		});
		
		setBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Random rand = new Random();
				randomNum = rand.nextInt(numRange.getMinimum(), numRange.getValue());
				rangePanel.setVisible(false);
				guessPanel.setVisible(true);
			}
		});
		
		guessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				answerPanel.setVisible(true);
				if(Integer.parseInt(guessField.getText()) == randomNum) {
					answer.setText("CORRECT!!!");
				} else {
					answer.setText("Wrong...");
				}
				numOfGuesses++;
				numOfGuess.setText("Number of Guesses: " + numOfGuesses);
			}
		});
		
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				numOfGuesses = 0;
				guessField.setText(" ");
				numRange.setValue(50);
				answerPanel.setVisible(false);
				guessPanel.setVisible(false);
				rangePanel.setVisible(true);
			}
		});
	}
}

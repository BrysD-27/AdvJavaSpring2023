// Bryson Davis
// CS-2463-TW01S
// 4-2-2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BAD_Magic8Ball extends JPanel {
	
	String [] answers = new String[] {
			"Yes",
			"No",
			"The world is your oyster!",
			"Ask again later",
			"Maybe in another life",
			"Without a doubt",
			"Nope no way",
			"Outlook good",
			"A big no",
			"Real hazy"
	};
	
	Font appFontLarge = new Font("Arial", Font.PLAIN, 30);
	Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
	
	JTextArea questionBox;
	JButton askBtn;
	JLabel answerLabel;
	
	BAD_Magic8Ball() {
		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel answerPanel = new JPanel();
		
		JLabel titleLabel = new JLabel("Ask the Magic 8 Ball a question!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);
		
		questionBox = new JTextArea(10, 30);
		questionBox.setFont(appFontSmall);
		inputPanel.add(questionBox);
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		askBtn = new JButton("Ask");
		askBtn.setFont(appFontSmall);
		inputPanel.add(askBtn);
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				
		answerLabel = new JLabel();
		answerLabel.setFont(appFontLarge);
		answerPanel.add(answerLabel);
		
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(inputPanel, BorderLayout.CENTER);
		this.add(answerPanel, BorderLayout.SOUTH);
		
		askBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Random rand = new Random();
				int randomNum = rand.nextInt(10);
				answerLabel.setText(answers[randomNum]);
			}
		});
	}
}

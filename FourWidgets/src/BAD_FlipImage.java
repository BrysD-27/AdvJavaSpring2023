// Bryson Davis
// CS-2463-TW01S
// 4-2-2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BAD_FlipImage extends JPanel {
	int index;
	String imageName[];
	ImageIcon img;
	Font appFontLarge = new Font("Arial", Font.PLAIN, 30);
	Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
	
	BAD_FlipImage() {
		index = 0;
		imageName = new String[2];
		imageName[0] = "D:\\Documents\\AdvJavaSpring2023\\FourWidgets\\BAD_Media\\car.jpg";
		imageName[1] = "D:\\Documents\\AdvJavaSpring2023\\FourWidgets\\BAD_Media\\car-flip.jpg";
		
		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		
		JButton flipBtn = new JButton("Flip");
		flipBtn.setFont(appFontSmall);
		buttonPanel.add(flipBtn);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel imageLabel = new JLabel();
		
		JLabel titleLabel = new JLabel("Flip the car!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);
		
		img = new ImageIcon(imageName[index]);
		imageLabel.setIcon(img);
		imagePanel.add(imageLabel);
		imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(mainPanel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.add(imagePanel, BorderLayout.SOUTH);
		
		flipBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(index == 0) {
					index = 1;
					img = new ImageIcon(imageName[index]);
					imageLabel.setIcon(img);
				} else {
					index = 0;
					img = new ImageIcon(imageName[index]);
					imageLabel.setIcon(img);
				}
			}
		});
	}
}

// Bryson Davis
// CS-2463-TW01S
// 4-2-2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BAD_FavoriteCake extends JPanel {	
	JRadioButton flavor_chocolate, flavor_vanilla, flavor_redVelvet;
	ButtonGroup flavorGroup;
	int index;
	String imageName[];
	ImageIcon img;
	
	BAD_FavoriteCake() {
		index = 0;
		imageName = new String[3];
		imageName[0] = "D:\\Documents\\AdvJavaSpring2023\\FourWidgets\\BAD_Media\\chocolate-cake.jpg";
		imageName[1] = "D:\\Documents\\AdvJavaSpring2023\\FourWidgets\\BAD_Media\\vanilla-cake.jpg";
		imageName[2] = "D:\\Documents\\AdvJavaSpring2023\\FourWidgets\\BAD_Media\\red-velvet.jpg";

		this.setLayout(new BorderLayout());
		JPanel titlePanel = new JPanel();
		JPanel optionsPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		
		JLabel imageLabel = new JLabel();
		
		Font appFontLarge = new Font("Arial", Font.PLAIN, 30);
		Font appFontSmall = new Font("Arial", Font.PLAIN, 18);
		
		JLabel titleLabel = new JLabel("Pick your favorite flavor of cake!");
		titleLabel.setFont(appFontLarge);
		titlePanel.add(titleLabel);
		
		flavor_chocolate = new JRadioButton("Chocolate");
		flavor_vanilla = new JRadioButton("Vanilla");
		flavor_redVelvet = new JRadioButton("Red Velvet");
		
		flavor_chocolate.setFont(appFontSmall);
		flavor_vanilla.setFont(appFontSmall);
		flavor_redVelvet.setFont(appFontSmall);
		
		flavorGroup = new ButtonGroup();
		flavorGroup.add(flavor_chocolate);
		flavorGroup.add(flavor_vanilla);
		flavorGroup.add(flavor_redVelvet);
		flavor_chocolate.setSelected(true);
		
		optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		optionsPanel.add(flavor_chocolate);
		optionsPanel.add(flavor_vanilla);
		optionsPanel.add(flavor_redVelvet);
		
		img = new ImageIcon(imageName[index]);
		imageLabel.setIcon(img);
		imagePanel.add(imageLabel);
		imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		mainPanel.setLayout(new GridLayout(3,1));
		
		mainPanel.add(titlePanel);
		
		this.add(mainPanel, BorderLayout.NORTH);
		this.add(optionsPanel, BorderLayout.CENTER);
		this.add(imagePanel, BorderLayout.SOUTH);
		
		flavor_chocolate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				index = 0;
				img = new ImageIcon(imageName[index]);
				imageLabel.setIcon(img);
			}
		});
		
		flavor_vanilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				index = 1;
				img = new ImageIcon(imageName[index]);
				imageLabel.setIcon(img);
			}
		});
		
		flavor_redVelvet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				index = 2;
				img = new ImageIcon(imageName[index]);
				imageLabel.setIcon(img);
			}
		});
	}
}

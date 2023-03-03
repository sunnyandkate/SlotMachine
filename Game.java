package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JFrame{

	private JPanel imgPanel, textPanel;
	private JLabel image1, image2, image3, textLabel, textContent;
	private JButton startButton;
	private int imgIndex1, imgIndex2, imgIndex3;
	
	float amount = 100;
	
	
	class MeinListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("start")) {
				startGame();
			}
			
		}		
		
	}
	public Game(String title) {
		super(title);
		
		initGUI();
		
		setLayout(new GridLayout(2,1));		
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void initGUI() {
		
		
		textPanel = new JPanel();
		
		textContent = new JLabel("Your budget: ");
		textLabel = new JLabel();
		textLabel.setText(Float.toString(amount));
		
		textPanel.add(textContent);
		textPanel.add(textLabel);
		
		
		imgPanel = new JPanel();
				
		image1 = new JLabel();				
		image2 = new JLabel();		
		image3 = new JLabel();
		
		imgPanel.setLayout(new FlowLayout());
				
		imgPanel.add(image1);
		imgPanel.add(image2);
		imgPanel.add(image3);
		
		showImages();

	
		startButton = new JButton("start");
		
		startButton.setPreferredSize(new Dimension(80, 40));
		startButton.setActionCommand("start");
		imgPanel.add(startButton);
		
		//ActionListener
		MeinListener listener = new MeinListener();
		startButton.addActionListener(listener);
		
		
	
		add(imgPanel);
		add(textPanel);
		
	
		
	}
	public void showImages() {
		
		String [] images = {"icons/Chichen Itza 12.jpg", "icons/Misol Ha.jpg", "icons/ocean.jpg", "icons/Sumidero Canyon 4.jpg", "icons/Thailand.jpg", "icons/Xpu-Ha8.jpg"};
		
		
		imgIndex1 = (int) Math.floor(Math.random() * (images.length));
		imgIndex2 = (int) Math.floor(Math.random() * (images.length));
		imgIndex3 = (int) Math.floor(Math.random() * (images.length));
	
		
		image1.setIcon( new ImageIcon(new ImageIcon(images[imgIndex1]).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		image2.setIcon( new ImageIcon(new ImageIcon(images[imgIndex2]).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		image3.setIcon( new ImageIcon(new ImageIcon(images[imgIndex3]).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));


		
	}
	
	public void startGame() {
		
		showImages();
			
		amount = amount - 10;
		
		textLabel.setText(Float.toString(amount));
				
		compareImages();
				
		if(amount < 10) {
			endGame();
		}
	}
	public void compareImages() {
		
		
		
		if(imgIndex1 == imgIndex2 && imgIndex2 == imgIndex3 && imgIndex1 == imgIndex3) {
			amount= amount + 100;			
			JOptionPane.showMessageDialog(null, "You have 3 matches. You win $ 100");
		}
		
		
		textLabel.setText(Float.toString(amount));
		
		
	}
	public void endGame() {
		
		 JOptionPane.showMessageDialog(null, "You have no money left.Game over!");
		 System.exit(0);
	}
}

package main_package;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallCanvas extends JPanel {

	private ArrayList balls = new ArrayList<>();
	private Dimension preferredSize; 
	public BallCanvas(){
		preferredSize = new Dimension(400, 400);
		setPreferredSize(preferredSize);
	}
	
	
	public void add(Ball b) {

		balls.add(b);
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < balls.size(); i++) {

			Ball b = (Ball) balls.get(i);
			b.draw(g2);
		}

	}

	public Object podajkoncowyobiekt(){
		
		return balls.get(balls.lastIndexOf(balls));
	}
	
}

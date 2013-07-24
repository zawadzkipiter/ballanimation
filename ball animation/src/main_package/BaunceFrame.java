package main_package;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaunceFrame extends JFrame implements MouseListener {
	final static boolean shouldFill = true;
	private BallThread thread;
	private String groupName = "Watki";
	private ThreadGroup t = new ThreadGroup(groupName);
	BallListener b = null;
	Obsluga_Zdarzenia obsluga = null;
	Ball ball = null;
	Vector<BallListener> Blisteners = new Vector<>();

	public BaunceFrame() {

		obsluga = new Obsluga_Zdarzenia("panel tekstowy", 100);
		Container contentPane = getContentPane();
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		BallThread thread = null;
		// Dimension d = new Dimension(1000,400);
		// setMinimumSize(d);
		setSize(WIDTH, HEIGHT);
		setTitle("Ramka g³ówna");
//TODO	 addMouseListener(this);
		canvas = new BallCanvas();
		canvas.setSize(400, 400);
		canvas.addMouseListener(this);
		JPanel button = new JPanel();
		addButton(button, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 1; i++) {
					addBall();
				}
				// System.out.println( Thread.currentThread().getName());
			}

		});

		addButton(button, "stop", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stopBall();

			}

		});

		addButton(button, "stopAll", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stopAllBall();

			}

		});
		addButton(button, "resume", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resumeAllBall();

			}

		});
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(button, c);

		c.insets = new Insets(10, 20, 100, 20);

		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;

		contentPane.add(canvas, c);

		// c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(10, 10, 10, 10);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.NONE;
		contentPane.add(obsluga, c);
		
		Blisteners.add(obsluga);
		
		pack();

	}

	public void addButton(Container c, String title, ActionListener listener) {

		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);

	}

	public void addBall() {

		ball = new Ball(canvas);
		canvas.add(ball);
		thread = new BallThread(ball, t, "watek nr1");
		thread.start();
		// Thread thread2 = new Th

	}

	public void stopBall() {
		// canvas.podajkoncowyobiekt();
		thread.setStop();

	}

	public void stopAllBall() {
		// canvas.podajkoncowyobiekt();
		t.suspend();

	}

	public void resumeAllBall() {
		// canvas.podajkoncowyobiekt();
		t.resume();
		System.out.println(t.activeCount());

	}

	public BallCanvas canvas;
	public static final int WEIGHT = 1850;
	public static final int HEIGHT = 650;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getX() + " " + e.getY());
//		try {
//			System.out.println(" test ");
//			// b.jestTarget(new Target(canvas, 100, 100, e.getX(), e.getY(),
//			// "dupa"));
//			
////			for (BallListener b : Blisteners) {
////				b.jestTarget(new Target(canvas, ball.dajX(), ball.dajY(), e.getX(), e.getY(),
////						"dupa"));
////			}
//			for (BallListener b : Blisteners) {
//				b.jestTarget(new Target(ball, ball.dajX(), ball.dajY(), e.getX(), e.getY(),
//						"dupa",ball.dajxsize()));
//			}
//		
//		} catch (Exception exc) {
//			System.out.println(" blad ");
//		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX() + " " + e.getY());
		try {
			System.out.println(" test ");
			// b.jestTarget(new Target(canvas, 100, 100, e.getX(), e.getY(),
			// "dupa"));
			
//			for (BallListener b : Blisteners) {
//				b.jestTarget(new Target(canvas, ball.dajX(), ball.dajY(), e.getX(), e.getY(),
//						"dupa"));
//			}
			for (BallListener b : Blisteners) {
				b.jestTarget(new Target(ball, ball.dajX(), ball.dajY(), e.getX(), e.getY(),
						"dupa",ball.dajxsize()));
			}
		
		} catch (Exception exc) {
			System.out.println(" blad ");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

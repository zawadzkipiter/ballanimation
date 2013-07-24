package main_package;

public class BallThread extends Thread {

	
	private Ball b;
	private boolean stop = false;
	public BallThread(Ball aball, ThreadGroup tG, String titleT) {
		
		super(tG,titleT);
		b = aball;

	}

	public void run() {
		try {

			while (!interrupted() && !stop) {
				for (int i = 0; i < 100; i++) {
					b.move();
					sleep(5);
//					System.out.println(Thread.currentThread().isAlive());
				}
			}
		} catch (InterruptedException exc) {
			Thread.currentThread().interrupt();
		}
		finally {
			
			
		}

	}

	public void setStop(){
		stop = true;
	}
	public Object dajBall (){
		return b;
	}
}

package main_package;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.EventObject;
import java.util.Random;

public class Ball {
	
	Random rand = new Random();
	
	float r = rand.nextFloat();
	float g = rand.nextFloat();
	float b = rand.nextFloat();
	private Component canvas;
	private int XSIZE = rand.nextInt(50)+20;
	private int YSIZE = XSIZE;
	private int x = rand.nextInt(XSIZE);
	private int y = rand.nextInt(YSIZE);
	private int dy = rand.nextInt(2)+1;
	private int dx = rand.nextInt(2)+1;
	
	public Ball(Component c){
	
		canvas = c;
		}
	
	
	public void move(){
		x+=dx;
		y+=dy;
//		System.out.println(x);
//		System.out.println(y);
		
		if(x<0){
			x=0;
			dx=-dx;
		}
		if(x+XSIZE>=canvas.getWidth()){
			x= canvas.getWidth() - XSIZE;
			dx=-dx;
			
		}
		if(y<0){
			y=0;
			dy=-dy;
		}
		if(y+YSIZE>=canvas.getHeight()){
			y= canvas.getHeight() - YSIZE;
			dy=-dy;
			
		}
		canvas.repaint();
	}
	

	Color randomColor = new Color(r, g, b);
	
	public void draw(Graphics2D g2) {
		g2.setPaint(randomColor);
		g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

	}
	
	public int dajX(){
		return x;
	}
	
	public int dajY(){
		return y;
	}
	
	public int dajxsize(){
		return XSIZE;
	}
}

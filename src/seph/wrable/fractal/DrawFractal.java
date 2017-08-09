package seph.wrable.fractal;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawFractal extends JPanel {
	
	private int x,y,steplong;
	private double iangle , oldx , oldy,angle;
	private String lSystemValue;
	
	/**
	 * @param x szerokosc okna
	 * @param y wysokosc okna 
	 * @param steplong krok 
	 */
	public DrawFractal(int x, int y, int steplong,double iangle, String lSystemValue) {
		super();
		this.x = x/2;
		this.y = y;
		this.steplong = steplong;
		this.lSystemValue = lSystemValue;
		this.iangle = iangle;
		this.angle=0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSteplong() {
		return steplong;
	}

	public void setSteplong(int steplong) {
		this.steplong = steplong;
	}

	
	//dx=odleglosc*cos(kierunek), dy=odleglosc*sin(kierunek)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		for (char ch : this.lSystemValue.toCharArray())
		{
			if (ch == 'F')
			{
		        oldx = x;
		        oldy = y;
		        x += steplong * Math.cos(Math.toRadians(angle));
		        y += steplong * Math.sin(Math.toRadians(angle));
		        g.drawLine((int)oldx,(int)oldy, x, y);
				
			}
			if (ch == '-')
			{
				angle -= iangle;
			}
			if (ch == '+')
			{
				angle += iangle;
			}
		}
		setSteplong(getSteplong()/4);
	}

	
//	public class Turtle {
//	    private double x, y;     // turtle is at (x, y)
//	    private double angle;    // facing this many degrees counterclockwise from the x-axis
//
//	    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
//	    public Turtle(double x0, double y0, double a0) {
//	        x = x0;
//	        y = y0;
//	        angle = a0;
//	    }
//
//	    // rotate orientation delta degrees counterclockwise
//	    public void turnLeft(double delta) {
//	        angle += delta;
//	    }
//
//	    // move forward the given amount, with the pen down
//	    public void goForward(double step) {
//	
//	        StdDraw.line(oldx, oldy, x, y);
//	    }
}

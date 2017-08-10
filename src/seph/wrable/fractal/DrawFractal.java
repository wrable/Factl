package seph.wrable.fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class DrawFractal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x, y, steplong, iangle, oldx, oldy, angle;
	private String lSystemValue;

	public DrawFractal(double x, double y, double steplong, double iangle, String lSystemValue) {
		super();
		this.x = x / 2;
		this.y = y;
		this.steplong = steplong;
		this.lSystemValue = lSystemValue;
		this.iangle = iangle;
		this.angle = 0;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSteplong() {
		return steplong;
	}

	public void setSteplong(double steplong) {
		this.steplong = steplong;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		Graphics2D g2 = (Graphics2D) g;
		for (char ch : this.lSystemValue.toCharArray()) {
			if (ch == 'F') {
				oldx = x;
				oldy = y;
				x += (steplong * Math.cos(Math.toRadians(angle)));
				y += (steplong * Math.sin(Math.toRadians(angle)));
				Shape l = new Line2D.Double(oldx, oldy, x, y);
				g2.draw(l);
			}
			if (ch == '-') {
				angle -= iangle;
			}
			if (ch == '+') {
				angle += iangle;
			}
		}
	}
}

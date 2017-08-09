package seph.wrable.fractal;


import javax.swing.JFrame;

public class Okienko {

	 public static void main(String[] args) {
		 JFrame f = new JFrame("Nowe okno");
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setSize(800, 800);		 
		 f.setVisible(true);
		 DrawFractal d = new DrawFractal(200,200,60,"F+F+F+F+F+F+F");
		 f.add(d);

		 }
}

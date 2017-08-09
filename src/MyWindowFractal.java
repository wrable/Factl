import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import seph.wrable.fractal.DrawFractal;
import seph.wrable.fractal.GenFractal;

public class MyWindowFractal extends JFrame implements ActionListener {

	JButton bGenerujLSystem, bWyjscie;
	JLabel  lAksjomat, lRegula;
	JTextField tWprowadzAksjomat, tWprowadzRegule,tWyświetlLSystem;

	static GenFractal Fractal;

	public MyWindowFractal() {
		setSize(500, 400);
		setTitle("Generator Fractali");
		setLayout(null); // layout menager

		bGenerujLSystem = new JButton("Generuj L-System");
		bGenerujLSystem.setBounds(100, 130, 300, 20); // pozycja rozmiar
		add(bGenerujLSystem); // dodawanie komponetu do panelu
		bGenerujLSystem.addActionListener(this); // dodanie action listenera

		bWyjscie = new JButton("Wyjscie");
		bWyjscie.setBounds(100, 330, 300, 20); // pozycja rozmiar
		add(bWyjscie);
		bWyjscie.addActionListener(this);

		tWyświetlLSystem = new JTextField("Wynik");
		tWyświetlLSystem.setBounds(100, 170, 300, 20);
		add(tWyświetlLSystem);

		lRegula = new JLabel("Reguła [F: ]");
		lRegula.setBounds(100, 80, 300, 20);
		add(lRegula);

		lAksjomat = new JLabel("Aksjomat [F]");
		lAksjomat.setBounds(100, 30, 300, 20);
		add(lAksjomat);

		tWprowadzAksjomat = new JTextField("F++F++F");
		tWprowadzAksjomat.setBounds(100, 50, 300, 20);
		add(tWprowadzAksjomat);

		tWprowadzRegule = new JTextField("F-F++F-F");
		tWprowadzRegule.setBounds(100, 100, 300, 20);
		add(tWprowadzRegule);

		
	}

	public static void main(String[] args) {
		MyWindowFractal newWindow = new MyWindowFractal();
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // domyślna reakcja na x
		newWindow.setVisible(true); // visible true
		Fractal = new GenFractal();
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == bGenerujLSystem) {
			Fractal.setAksjomat(tWprowadzAksjomat.getText());
			Fractal.setRegula(tWprowadzRegule.getText());
			tWyświetlLSystem.setText(Fractal.FGenFractal());
			JFrame f = new JFrame("Nowe okno");
			 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 f.setSize(800, 1200);		 			
			 f.setVisible(true);
			 DrawFractal d = new DrawFractal(100,300,60,Fractal.FGenFractal());
			 f.add(d);
			
		}
		if (source == bWyjscie) {
			dispose(); // zamyka okno
		}

	}

}

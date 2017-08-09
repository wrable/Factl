import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import seph.wrable.fractal.GenFractal;
import seph.wrable.fractal.DrawFractal;

public class MyWindowFractal extends JFrame implements ActionListener {

	JButton bGenerujLSystem, bWyjscie;
	JLabel  lAksjomat, lRegula;
	JTextField tWprowadzAksjomat, tWprowadzRegule,tWyœwietlLSystem;

	static GenFractal Fractal;
	static DrawFractal rysuj;

	public MyWindowFractal() {
		setSize(500, 400);
		setTitle("Generator Fractali");
		setLayout(null); // layout menager

//		bGenerujLSystem = new JButton("Generuj L-System");
//		bGenerujLSystem.setBounds(100, 130, 300, 20); // pozycja rozmiar
//		add(bGenerujLSystem); // dodawanie komponetu do panelu
//		bGenerujLSystem.addActionListener(this); // dodanie action listenera
//
//		bWyjscie = new JButton("Wyjscie");
//		bWyjscie.setBounds(100, 330, 300, 20); // pozycja rozmiar
//		add(bWyjscie);
//		bWyjscie.addActionListener(this);
//
//		tWyœwietlLSystem = new JTextField("Wynik");
//		tWyœwietlLSystem.setBounds(100, 170, 300, 20);
//		add(tWyœwietlLSystem);
//
//		lRegula = new JLabel("Regu³a [F: ]");
//		lRegula.setBounds(100, 80, 300, 20);
//		add(lRegula);
//
//		lAksjomat = new JLabel("Aksjomat [F]");
//		lAksjomat.setBounds(100, 30, 300, 20);
//		add(lAksjomat);
//
//		tWprowadzAksjomat = new JTextField("F");
//		tWprowadzAksjomat.setBounds(100, 50, 300, 20);
//		add(tWprowadzAksjomat);
//
//		tWprowadzRegule = new JTextField("FF");
//		tWprowadzRegule.setBounds(100, 100, 300, 20);
//		add(tWprowadzRegule);
		rysuj = new DrawFractal();
		
	}

	public static void main(String[] args) {
		MyWindowFractal newWindow = new MyWindowFractal();
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // domyœlna reakcja na x
		newWindow.setVisible(true); // visible true
		Fractal = new GenFractal();
		newWindow.add(rysuj);
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == bGenerujLSystem) {
			Fractal.setAksjomat(tWprowadzAksjomat.getText());
			Fractal.setRegula(tWprowadzRegule.getText());
			tWyœwietlLSystem.setText(Fractal.FGenFractal());
			
		}
		if (source == bWyjscie) {
			dispose(); // zamyka okno
		}

	}

}

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import seph.wrable.fractal.*;

public class MyWindowFractal extends JFrame implements ActionListener {
	
	JButton bGenerujLSystem , bWyjscie;
	JLabel lWyœwietlLSystem; 
	JTextField tWprowadz;

	public MyWindowFractal() {
		setSize(500, 400);
		setTitle("Moje okienko");
		setLayout(null); // layout menager
		
		bGenerujLSystem = new JButton("Generuj L-System");
		bGenerujLSystem.setBounds(100, 300, 300, 20); // pozycja rozmiar
		add(bGenerujLSystem); // dodawanie komponetu do panelu
		bGenerujLSystem.addActionListener(this); // dodanie action listenera

		bWyjscie = new JButton("Wyjscie");
		bWyjscie.setBounds(100, 200, 300, 20); // pozycja rozmiar
		add(bWyjscie);
		bWyjscie.addActionListener(this);
		
		lWyœwietlLSystem = new JLabel("test text");
		lWyœwietlLSystem.setBounds(100, 250, 300, 20);
		lWyœwietlLSystem.setForeground(Color.red);
		add(lWyœwietlLSystem);
		
		tWprowadz = new JTextField();
		tWprowadz.setBounds(100, 50, 300, 20);
		add(tWprowadz);
		
	}

	public static void main(String[] args) {
		MyWindowFractal newWindow = new MyWindowFractal();
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // domyœlna reakcja na x
		newWindow.setVisible(true); // visible true
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == bGenerujLSystem) {
//			System.out.println(new Date());
			lWyœwietlLSystem.setText((new Date().toString()));
		}
		if (source == bWyjscie) {
			dispose(); // zamyka okno 
		}
			

	}

}

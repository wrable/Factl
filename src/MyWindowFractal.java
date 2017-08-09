import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import seph.wrable.fractal.*;

public class MyWindowFractal extends JFrame implements ActionListener {

	JButton bGenerujLSystem, bWyjscie;
	JLabel lWyœwietlLSystem, lAksjomat, lRegula;
	JTextField tWprowadzAksjomat, tWprowadzRegule;
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

		lWyœwietlLSystem = new JLabel("Wynik");
		lWyœwietlLSystem.setBounds(100, 150, 300, 100);
		add(lWyœwietlLSystem);

		lRegula = new JLabel("Regu³a");
		lRegula.setBounds(100, 80, 300, 20);
		add(lRegula);

		lAksjomat = new JLabel("Aksjomat");
		lAksjomat.setBounds(100, 30, 300, 20);
		add(lAksjomat);

		tWprowadzAksjomat = new JTextField();
		tWprowadzAksjomat.setBounds(100, 50, 300, 20);
		add(tWprowadzAksjomat);

		tWprowadzRegule = new JTextField();
		tWprowadzRegule.setBounds(100, 100, 300, 20);
		add(tWprowadzRegule);
	}

	public static void main(String[] args) {
		MyWindowFractal newWindow = new MyWindowFractal();
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // domyœlna reakcja na x
		newWindow.setVisible(true); // visible true
		Fractal = new GenFractal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == bGenerujLSystem) {
			Fractal.setAksjomat(tWprowadzAksjomat.getText());
			Fractal.setRegula(tWprowadzRegule.getText());
			lWyœwietlLSystem.setText(Fractal.FGenFractal());
		}
		if (source == bWyjscie) {
			dispose(); // zamyka okno
		}

	}

}

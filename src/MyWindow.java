import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow extends JFrame implements ActionListener {
	
	JButton bGenerujLSystem , bWyjscie;

	public MyWindow() {
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
	}

	public static void main(String[] args) {
		MyWindow newWindow = new MyWindow();
		newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // domyœlna reakcja na x
		newWindow.setVisible(true); // visible true
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == bGenerujLSystem) {
			System.out.println(new Date());
		}
		if (source == bWyjscie) {
			dispose();
		}

	}

}

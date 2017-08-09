import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import seph.wrable.fractal.DrawFractal;
import seph.wrable.fractal.GenFractal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class MainWindow {

	private JFrame frame;
	private JTextField txtAksjomat;
	private JTextField txtRegula;
	private JTextField txtKat;
	static GenFractal Fraktal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Fraktal = new GenFractal();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1122, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAksjomat = new JLabel("Aksjomat");
		lblAksjomat.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblAksjomat);
		
		JLabel lblRegula = new JLabel("Regula");
		lblRegula.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblRegula);
		
		JLabel lblKat = new JLabel("Kat");
		lblKat.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblKat);
		
		txtAksjomat = new JTextField();
		txtAksjomat.setText("F");
		txtAksjomat.setBounds(66, 8, 344, 20);
		frame.getContentPane().add(txtAksjomat);
		txtAksjomat.setColumns(10);
		
		txtRegula = new JTextField();
		txtRegula.setText("F+F-F--F+F+F");
		txtRegula.setBounds(66, 33, 344, 20);
		frame.getContentPane().add(txtRegula);
		txtRegula.setColumns(10);
		
		txtKat = new JTextField();
		txtKat.setText("72");
		txtKat.setBounds(66, 58, 344, 20);
		frame.getContentPane().add(txtKat);
		txtKat.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 134, 400, 191);
		frame.getContentPane().add(textArea);
		
		JLabel lblDebug = new JLabel("Debug");
		lblDebug.setBounds(10, 113, 46, 14);
		frame.getContentPane().add(lblDebug);
		
		JButton btnGenerujLsystem = new JButton("Generuj L-System");
		btnGenerujLsystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			Fraktal.setAksjomat(txtAksjomat.getText());
			Fraktal.setRegula(txtRegula.getText());	
			textArea.setText(Fraktal.FGenFractal());
			DrawFractal d= new DrawFractal(200, 200, 20, Integer.parseInt(txtKat.getText()), Fraktal.FGenFractal());
			frame.add(d);
			}
		});
		btnGenerujLsystem.setBounds(10, 86, 400, 23);
		frame.getContentPane().add(btnGenerujLsystem);
		
		
		
		
	}
}

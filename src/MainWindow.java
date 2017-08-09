import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField txtAksjomat;
	private JTextField txtRegula;
	private JTextField txtKat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 440, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 250, 400, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		txtAksjomat.setText("Aksjomat");
		txtAksjomat.setBounds(66, 8, 344, 20);
		frame.getContentPane().add(txtAksjomat);
		txtAksjomat.setColumns(10);
		
		txtRegula = new JTextField();
		txtRegula.setText("Regula");
		txtRegula.setBounds(66, 33, 344, 20);
		frame.getContentPane().add(txtRegula);
		txtRegula.setColumns(10);
		
		txtKat = new JTextField();
		txtKat.setText("Kat");
		txtKat.setBounds(66, 58, 344, 20);
		frame.getContentPane().add(txtKat);
		txtKat.setColumns(10);
		
		JButton btnGenerujLsystem = new JButton("Generuj L-System");
		btnGenerujLsystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtAksjomat.setText("klik³o mi siê");
			}
		});
		btnGenerujLsystem.setBounds(10, 86, 400, 23);
		frame.getContentPane().add(btnGenerujLsystem);
	}
}

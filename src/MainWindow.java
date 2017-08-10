import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import seph.wrable.fractal.DrawFractal;
import seph.wrable.fractal.GenFractal;

public class MainWindow {
	public enum Preset {
		trójk¹t_Sierpinskiego("F+F+F", "F+F-F-F+F", "120"), p³atek_œniegu_kocha("F++F++F", "F-F++F-F",
				"60"), pentadendryt("F", "F+F-F--F+F+F", "72");
		private String aksjomat;
		private String rule;
		private String angle;

		private Preset(String aksjomat, String rule, String angle) {
			this.aksjomat = aksjomat;
			this.rule = rule;
			this.angle = angle;
		}
	}
	private JFrame frame;
	private JTextField txtAksjomat;
	private JTextField txtRegula;
	private JTextField txtKat;
	public double size;
	static GenFractal Fraktal;
	private JTextField txtDlugoscOdcinka;

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
		frame.setTitle("L-Systemy");
		frame.setBounds(100, 100, 435, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAksjomat = new JLabel("Aksjomat");
		lblAksjomat.setBounds(10, 40, 83, 14);
		frame.getContentPane().add(lblAksjomat);

		JLabel lblRegula = new JLabel("Regula");
		lblRegula.setBounds(10, 68, 83, 14);
		frame.getContentPane().add(lblRegula);

		JLabel lblKat = new JLabel("Kat");
		lblKat.setBounds(10, 93, 83, 14);
		frame.getContentPane().add(lblKat);

		txtAksjomat = new JTextField();
		txtAksjomat.setText("");
		txtAksjomat.setBounds(99, 37, 311, 20);
		frame.getContentPane().add(txtAksjomat);
		txtAksjomat.setColumns(10);

		txtRegula = new JTextField();
		txtRegula.setText("");
		txtRegula.setBounds(99, 65, 311, 20);
		frame.getContentPane().add(txtRegula);
		txtRegula.setColumns(10);

		txtKat = new JTextField();
		txtKat.setText("");
		txtKat.setBounds(99, 90, 311, 20);
		frame.getContentPane().add(txtKat);
		txtKat.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(9, 214, 400, 325);
		frame.getContentPane().add(textArea);

		JLabel lblDebug = new JLabel("Debug");
		lblDebug.setBounds(10, 189, 46, 14);
		frame.getContentPane().add(lblDebug);

		JButton btnGenerujLsystem = new JButton("Generuj L-System");
		btnGenerujLsystem.setBounds(10, 155, 400, 23);
		frame.getContentPane().add(btnGenerujLsystem);

		JLabel lblPreset = new JLabel("Preset");
		lblPreset.setBounds(11, 11, 82, 14);
		frame.getContentPane().add(lblPreset);

		JComboBox<Preset> comboBox = new JComboBox<Preset>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (Preset.trójk¹t_Sierpinskiego == comboBox.getSelectedItem())
				{
					txtAksjomat.setText(Preset.trójk¹t_Sierpinskiego.aksjomat);
					txtRegula.setText(Preset.trójk¹t_Sierpinskiego.rule);
					txtKat.setText(Preset.trójk¹t_Sierpinskiego.angle);
				}
				if (Preset.p³atek_œniegu_kocha == comboBox.getSelectedItem())
				{
					txtAksjomat.setText(Preset.p³atek_œniegu_kocha.aksjomat);
					txtRegula.setText(Preset.p³atek_œniegu_kocha.rule);
					txtKat.setText(Preset.p³atek_œniegu_kocha.angle);
				}
				if (Preset.pentadendryt == comboBox.getSelectedItem())
				{
					txtAksjomat.setText(Preset.pentadendryt.aksjomat);
					txtRegula.setText(Preset.pentadendryt.rule);
					txtKat.setText(Preset.pentadendryt.angle);
				}
				Fraktal.setbuildervalue(null);
			}
		});
		comboBox.setBounds(99, 8, 311, 20);
		frame.getContentPane().add(comboBox);
		
		txtDlugoscOdcinka = new JTextField();
		txtDlugoscOdcinka.setText("30");
		txtDlugoscOdcinka.setBounds(99, 115, 310, 20);
		frame.getContentPane().add(txtDlugoscOdcinka);
		txtDlugoscOdcinka.setColumns(10);
		
		JLabel lblLOdcinka = new JLabel("L odcinka");
		lblLOdcinka.setBounds(10, 118, 46, 14);
		frame.getContentPane().add(lblLOdcinka);
		comboBox.addItem(Preset.pentadendryt);
		comboBox.addItem(Preset.trójk¹t_Sierpinskiego);
		comboBox.addItem(Preset.p³atek_œniegu_kocha);
		
		btnGenerujLsystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fraktal.setAksjomat(txtAksjomat.getText());
				Fraktal.setRegula(txtRegula.getText());
				textArea.setText(Fraktal.FGenFractal());

				JFrame f = new JFrame("Nowe okno");
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setSize(800, 1200);
				f.setVisible(true);
				DrawFractal d = new DrawFractal(200, 500, Integer.parseInt(txtDlugoscOdcinka.getText()), Integer.parseInt(txtKat.getText()), Fraktal.FGenFractal());
				f.getContentPane().add(d);
			}
		});
	}
}

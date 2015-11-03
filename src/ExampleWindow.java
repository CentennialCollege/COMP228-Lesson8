import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

// EXAMPLE WINDOW CLASS ++++++++++++++++++++++++++++++++++++++++++
public class ExampleWindow extends JFrame {
	// PRIVATE INSTANCE VARIABLES +++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _helloLabel;
	private JLabel _nameLabel;
	private JTextField _nameTextField;
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++++++++++++
	public JLabel getHelloLabel() {
		return this._helloLabel;
	}

	public void setHelloLabel(JLabel helloLabel) {
		this._helloLabel = helloLabel;
	}

	// CONSTRUCTOR METHOD +++++++++++++++++++++++++++++++++++++++
	public ExampleWindow() {
		this._initialize();
		this._addUIComponents();
	}
	
	// PRIVATE METHODS +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
		
	}

	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);
		
		// Hello Label
		this._helloLabel = new JLabel("New label");
		this._helloLabel.setBounds(5, 6, 96, 23);
		this._contentPane.add(this._helloLabel);
		
		// Name Label
		this._nameLabel = new JLabel("Enter Name:");
		this._nameLabel.setBounds(5, 41, 96, 23);
		this._contentPane.add(_nameLabel);
		
		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(99, 35, 131, 29);
		this._nameTextField.setText("");
		this._contentPane.add(_nameTextField);
		
		
	}

}

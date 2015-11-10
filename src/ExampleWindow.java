import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Dimension;

// EXAMPLE WINDOW CLASS ++++++++++++++++++++++++++++++++++++++++++
public class ExampleWindow extends JFrame implements ActionListener {
	// PRIVATE INSTANCE VARIABLES +++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _helloLabel;
	private JLabel _nameLabel;
	private JTextField _nameTextField;
	private JButton _goodbyeButton;
	private JLabel _ageLabel;
	private JTextField _ageTextField;
	private JComboBox _todoComboBox;
	private JPanel _todoPanel;
	private JScrollPane _todoScrollPane;
	private ArrayList<TodoTextField> _todoArrayList;
	
	private Border _redLine, _blackLine;
	
	
	
	//private NameTextFieldHandler _nameTextFieldHandler;
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++++++++++++
	public JLabel getHelloLabel() {
		return this._helloLabel;
	}

	public void setHelloLabel(JLabel helloLabel) {
		this._contentPane.remove(this._helloLabel);
		this._helloLabel = helloLabel;
		this._addHelloLabel();
	}

	// CONSTRUCTOR METHOD +++++++++++++++++++++++++++++++++++++++
	public ExampleWindow() {
		this._initialize();
		this._setupBorders();
		this._addUIComponents();
		
		// Register event handler for Action Listeners
		this._nameTextField.addActionListener(this);
		
		this._goodbyeButton.addActionListener(this);
		
		this._ageTextField.addActionListener(this);
		
		this._todoComboBox.addActionListener(this);
	}
	
	// PRIVATE METHODS +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
		
	}
	
	private void _setupBorders() {
		this._blackLine = BorderFactory.createLineBorder(Color.black);
		this._redLine = BorderFactory.createLineBorder(Color.red);
	}
	
	private void _addHelloLabel() {
		this._helloLabel.setBounds(5, 6, 225, 23);
		this._contentPane.add(this._helloLabel);
	}

	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);
		
		// Hello Label
		this._helloLabel = new JLabel("New label");
		this._addHelloLabel();
		
		// Name Label
		this._nameLabel = new JLabel("Enter Name:");
		this._nameLabel.setBounds(5, 35, 96, 30);
		this._contentPane.add(_nameLabel);
		
		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(100, 35, 130, 30);
		this._nameTextField.setText("");
		this._nameTextField.setBorder(this._blackLine);
		this._contentPane.add(this._nameTextField);
		
		this._goodbyeButton = new JButton("Click Me!");
		this._goodbyeButton.setBounds(5, 224, 86, 29);
		this._contentPane.add(this._goodbyeButton);
		
		this._ageLabel = new JLabel("Enter Age:");
		this._ageLabel.setBounds(5, 80, 76, 30);
		this._contentPane.add(this._ageLabel);
		
		this._ageTextField = new JTextField();
		this._ageTextField.setBounds(100, 80, 130, 30);
		this._ageTextField.setBorder(this._blackLine);
		this._contentPane.add(this._ageTextField);
		
		this._todoComboBox = new JComboBox();
		this._todoComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		this._todoComboBox.setSelectedIndex(0);
		this._todoComboBox.setBounds(5, 120, 64, 38);
		this._contentPane.add(this._todoComboBox);
		
		// Container for our Todos
		this._todoPanel = new JPanel();
		
		// Add Scrollpane to contain our TodoPanel
		this._todoScrollPane = new JScrollPane(this._todoPanel);
		_todoScrollPane.setBounds(100, 120, 194, 152 );
		this._todoScrollPane.setPreferredSize(new Dimension(8, 8));
		this._todoScrollPane.setAutoscrolls(true);
		
		// Define a GridBagLayout for our use
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {171};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		//set the todoPanel to the GridBagLayout defined above
		this._todoPanel.setLayout(gridBagLayout);
		this._contentPane.add(this._todoScrollPane);
		
		//add a default todoTextField to the todoPanel
		this._todoArrayList = new ArrayList<TodoTextField>();
		this._todoArrayList.add(new TodoTextField(this._todoPanel, 0));
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == this._nameTextField) {
			
			this._helloLabel.setText(this._nameTextField.getText());
		}
		
		if(event.getSource() == this._goodbyeButton) {
			this._helloLabel.setText("goodbyeButton - clicked");
		}
		
		if(event.getSource() == this._ageTextField) {
			
			try {
				int ageDifference = 46 - Integer.parseInt(this._ageTextField.getText());
				this._helloLabel.setText(Integer.toString(ageDifference));
				this._ageTextField.setBorder(this._blackLine);
			
				
			} catch (Exception e) {
				this._helloLabel.setText("Hey that was just wrong");
				this._ageTextField.selectAll();
				this._ageTextField.setBorder(this._redLine);
			}
		}
		
		if(event.getSource() == this._todoComboBox) {
			// store the selected index item
			int numTodoFields = this._todoComboBox.getSelectedIndex() + 1;
			
			//clear the todoPanel 
			this._todoPanel.removeAll();

			// clear the todoArrayList
			this._todoArrayList.clear();
			
			// add the selected number of rows to the todoArrayList 
			for(int index = 0; index < numTodoFields; index++) {
				this._todoArrayList.add(new TodoTextField(this._todoPanel, index));
			}
			
			// redraw the todoPanel
			this._todoPanel.revalidate();	
		}
		
	}
}

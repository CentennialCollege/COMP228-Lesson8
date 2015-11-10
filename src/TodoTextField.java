import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class TodoTextField extends JTextField {

	public TodoTextField(JPanel todoPanel, int gridy) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.gridx = 0;
		constraints.gridy = gridy;
		todoPanel.add(this, constraints);
		this.setColumns(10);
	}

}

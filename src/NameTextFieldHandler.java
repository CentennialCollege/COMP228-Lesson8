import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NameTextFieldHandler implements ActionListener {
	private ExampleWindow _callingWindow;
	
	public NameTextFieldHandler(ExampleWindow callingWindow) {
		this._callingWindow = callingWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		this._callingWindow.getHelloLabel().setText("You Pressed Enter");
		
	}

}

import javax.swing.JLabel;

// DRIVER CLASS ++++++++++++++++++++++++++++++++
public class Program {

	// MAIN STATIC METHOD ++++++++++++++++++++++
	public static void main(String[] args) {
		try {
			
			// EXAMPLE WINDOWS LIVES AND DIES HERE ++++
			ExampleWindow frame = new ExampleWindow();
			frame.setVisible(true);
			
			JLabel myLabel = new JLabel("GoodBye!!!");
			
			
			frame.getHelloLabel().setText("Hello World!");
			frame.setHelloLabel(myLabel);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

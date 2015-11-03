// DRIVER CLASS ++++++++++++++++++++++++++++++++
public class Program {

	// MAIN STATIC METHOD ++++++++++++++++++++++
	public static void main(String[] args) {
		try {
			
			// EXAMPLE WINDOWS LIVES AND DIES HERE ++++
			ExampleWindow frame = new ExampleWindow();
			frame.setVisible(true);
			
			frame.getHelloLabel().setText("Hello World!");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

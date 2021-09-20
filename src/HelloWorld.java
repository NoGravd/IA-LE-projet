import lejos.hardware.Button;
import lejos.utility.Delay;

public class HelloWorld {

	public static void main(String[] args) {
try {
			
		System.out.println("Hugo, T beau !");
		Button.ENTER.waitForPress();
		
		} catch (Throwable t) {
			t.printStackTrace();
			Delay.msDelay(10000);
			System.exit(0);
		}
	}

}
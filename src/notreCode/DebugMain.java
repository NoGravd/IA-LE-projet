package notreCode;

import lejos.utility.Delay;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;


public class DebugMain {

	
	public static void main(String[] args) {
		Roues R = new Roues();
		for (int ii=0; ii<10;ii++) {
			R.pivote(180);
		}
		
	}
}
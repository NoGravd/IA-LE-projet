import lejos.hardware.Button;
import lejos.utility.Delay;
import lejos.hardware.motor.*;





public class TestNono {
	static final int SPEED = 100, TIME = 300, TIMEPINCE = 3000;
	

	public static void avance (BaseRegulatedMotor moteurA, BaseRegulatedMotor moteurC, BaseRegulatedMotor[] list) {
		
		
		//try {
		int i=0;
		while(i<20) {
		moteurA.setSpeed(SPEED*i);
		moteurC.setSpeed(SPEED*i);

		moteurA.forward();
		moteurC.forward();
		Delay.msDelay(TIME);
		i++;
		}
		moteurA.synchronizeWith(list);
		moteurA.startSynchronization();
		moteurC.stop();
		moteurA.stop();
		moteurA.endSynchronization();
	}
	
	public static void droite (BaseRegulatedMotor moteurA, BaseRegulatedMotor moteurC, BaseRegulatedMotor[] list) {
		moteurC.rotate(360);
		
	}
	
	public static void gauche (BaseRegulatedMotor moteurA, BaseRegulatedMotor moteurC, BaseRegulatedMotor[] list) {
		moteurA.rotate(360);
	}
	
	public static void demi_tour (BaseRegulatedMotor moteurA, BaseRegulatedMotor moteurC, BaseRegulatedMotor[] list) {
		moteurA.rotate(360);
		moteurA.rotate(360);
	}
	
	public static void main(String[] args) {
		BaseRegulatedMotor mA = Motor.A;
		BaseRegulatedMotor mB = Motor.B;
		BaseRegulatedMotor mC = Motor.C;
		BaseRegulatedMotor[] l = new BaseRegulatedMotor[] {mC};
		
		
		mB.forward();
		Delay.msDelay(TIMEPINCE);
		mB.stop();
		
		mB.backward();
		Delay.msDelay(TIMEPINCE);
		mB.stop();
		//avance(mA,mC,l);
		
		//demi_tour(mA,mC,l);
		//droite(mA,mC,l);
		//gauche(mA,mC,l);
		//avance(mA,mC,l);
		   //while(Motor.A.isMoving()Thread.yield();
		   //int angle = Motor.A.getTachoCount(); // should be -360
		   //LCD.drawInt(angle,0,0);
		/*	} catch (Throwable t) {
			t.printStackTrace();
			Delay.msDelay(10000);
			System.exit(0);
		}*/
		
	}
	
	
}
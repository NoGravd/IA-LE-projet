import lejos.hardware.Button;
import lejos.utility.Delay;
import notreCode.Capteur;
import lejos.hardware.motor.*;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.*;




public class TestNono {
	static final int SPEED = 100, TIME = 300, TIMEPINCE = 3000;
	static final BaseRegulatedMotor mA = Motor.A;//moteur roue
	static final BaseRegulatedMotor mP = Motor.B;//moteur pince
	static final BaseRegulatedMotor mC = Motor.C;//moteur roue
	static final BaseRegulatedMotor[] l = new BaseRegulatedMotor[] {mC};
//	static final EV3ColorSensor cS = (EV3ColorSensor) SensorPort.S1;
//	static final EV3TouchSensor tS = (EV3TouchSensor) SensorPort.S3;
//	static final EV3UltrasonicSensor usS = (EV3UltrasonicSensor) SensorPort.S2;
	static boolean etatPince = false; // false = fermé ; true = ouvert
	
	
	
//	sensor1 = couleur
//	sensor2 = bouton
//	sensor3 = ultra sons
	
 	public static void avance() {
//		for (int i=0; i<20; i++) {
//			mA.setSpeed(SPEED*i);
//			mC.setSpeed(SPEED*i);
//			mA.forward();
//			mC.forward();
//			Delay.msDelay(TIME);
//		}
		//accélération
		int nAcc = 200; //definition du nb de marches d'accélération
		int maxSpeed = 500; //vitesse max = 100xVbatterie
		for (int i=0; i<nAcc; i++) {
			mA.setSpeed(maxSpeed/nAcc*i);//change la vitesse
			mC.setSpeed(maxSpeed/nAcc*i);
			mA.forward();//lance le moteur 
			mC.forward();
			Delay.msDelay(1);// attend 3ms
		}
		stopM();
//		mA.synchronizeWith(l);
//		mA.startSynchronization();
//		mC.stop();
//		mA.stop();
//		mA.endSynchronization();
	}
 	
 	public static void avanceTQmur(float distanceMin) {
 		Port p3 = lejos.hardware.port.SensorPort.S3;
		EV3UltrasonicSensor capteurSe = new EV3UltrasonicSensor(p3);
		capteurSe.enable();
		float[] f = new float[1];
		capteurSe.getDistanceMode().fetchSample(f, 0);
		int nAcc = 200; //definition du nb de marches d'accélération
		int maxSpeed = 500; //vitesse max = 100xVbatterie
		for (int i=0; i<nAcc; i++) {
			mA.setSpeed(maxSpeed/nAcc*i);//change la vitesse
			mC.setSpeed(maxSpeed/nAcc*i);
			mA.forward();//lance le moteur 
			mC.forward();
			Delay.msDelay(1);
			// attend 3ms
		}
		while(f[0]>distanceMin) {
			mA.forward();//lance le moteur 
			mC.forward();
			Delay.msDelay(1);
			capteurSe.getDistanceMode().fetchSample(f, 0);
		}
		stopM();
		capteurSe.disable();
		
//		mA.synchronizeWith(l);
//		mA.startSynchronization();
//		mC.stop();
//		mA.stop();
//		mA.endSynchronization();
	}
 	
 	public static void avanceTQPression() {
 		Port p2 = lejos.hardware.port.SensorPort.S2;
		TouchSensor capteurTa = new TouchSensor(p2);
		int nAcc = 200; //definition du nb de marches d'accélération
		int maxSpeed = 500; //vitesse max = 100xVbatterie
		for (int i=0; i<nAcc; i++) {
			mA.setSpeed(maxSpeed/nAcc*i);//change la vitesse
			mC.setSpeed(maxSpeed/nAcc*i);
			mA.forward();//lance le moteur 
			mC.forward();
			Delay.msDelay(1);
			//attend 3ms
		}
		int i =1;
		while (capteurTa.isPressed()==false) {
			mA.forward();
			//Button.ENTER.waitForPress();
			//lance le moteur 
			//mC.forward();
			Delay.msDelay(1);
		}
		stopM();
		
//		mA.synchronizeWith(l);
//		mA.startSynchronization();
//		mC.stop();
//		mA.stop();
//		mA.endSynchronization();
	}
 	
 	public static void avanceTQpalet() {
 		Port p2 = lejos.hardware.port.SensorPort.S2;
 		EV3TouchSensor capteurTa = new EV3TouchSensor (p2);
// 		capteurTa.getTouchMode().fetchSample(sample, offset);
 		
 	}
 	
 	public static void stopM() {
 		mA.synchronizeWith(l);
		mA.startSynchronization();
		mC.stop();
		mA.stop();
		mA.endSynchronization();
 	}
	
	public static void droite() {
		mC.rotate(360);
	}
	
	public static void gauche() {
		mA.rotate(360);
	}
	
	public static void demi_tour() {
		mA.rotate(360);
		mA.rotate(360);
	}
	
	public static void oPince() {
		if (!etatPince) {//si pinces fermées
			mP.forward();
			Delay.msDelay(TIMEPINCE);
			mP.stop();
			etatPince = true;
		}
	}
	
	public static void fPince() {
		if (etatPince) {//si pinces ouvertes
			mP.backward();
			Delay.msDelay(TIMEPINCE);
			mP.stop();
			etatPince = false;
		}
	}
	
	public static void recule() {
		//accélération
				int nAcc = 200; //definition du nb de marches d'accélération
				int maxSpeed = 300; //vitesse max = 100xVbatterie
				for (int i=0; i<nAcc; i++) {
					mA.setSpeed(maxSpeed/nAcc*i);//change la vitesse
					mC.setSpeed(maxSpeed/nAcc*i);
					mA.backward();//lance le moteur 
					mC.backward();
					Delay.msDelay(1);// attend 3ms
				}
				stopM();
	}
	
	
	
	public static void main(String[] args) {
		
		Port p1 = lejos.hardware.port.SensorPort.S1;
		EV3ColorSensor capteurCo = new EV3ColorSensor(p1);
		
		try {
			
			System.out.println(capteurCo.getColorID());
			Button.ENTER.waitForPress();
			
			} catch (Throwable t) {
				t.printStackTrace();
				Delay.msDelay(10000);
				System.exit(0);
			}
		
//			avanceTQmur((float)0.4);
			
			
		
		/*Capteur c = new Capteur();
		c.distanceOb();
		System.out.println(c.donneeSe[0]);*/
		
		
		
		
		
		
		
//		fPince();
//		avance();
////		if (tS.capteurTactileActif())
////			fPince();
//		
//		recule();
//		
		
		
		/**
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
		//
		
	}
	
	
}
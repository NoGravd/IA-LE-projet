package notreCode;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Roues {
	static final BaseRegulatedMotor mA = Motor.A;
	static final BaseRegulatedMotor mC = Motor.C;
	static final BaseRegulatedMotor[] l = new BaseRegulatedMotor[] {mC};
	static final int vitMax = 400;//vitesse max = 100xVbatterie
	public Memoire memoire;

	
	public Roues (Memoire mem) {
		memoire = mem;
	}
	
	public Roues() {
	}
	
	
	
 	public static void demarre() {
		//accélération
		int nAcc = 200; //definition du nb de marches d'accélération
//		int maxSpeed = 400; //vitesse max = 100xVbatterie
		for (int i=0; i<nAcc; i++) {
			mA.setSpeed(vitMax/nAcc*i);//change la vitesse
			mC.setSpeed(vitMax/nAcc*i);
			mA.forward();//lance le moteur 
			mC.forward();
			Delay.msDelay(1);// attend 3ms
		}
//		stop();
 	}
 	
 	public static void stop() {
 		mA.synchronizeWith(l);
		mA.startSynchronization();
		mC.stop();
		mA.stop();
		mA.endSynchronization();
 	}
 	
 	public static void droite90() {
		mC.rotate(360);
//		mC.rotate(180);
//		mA.rotate(-180);
	}
	
	public static void gauche90() {
		mA.rotate(360);
//		mC.rotate(-180);
//		mA.rotate(180);
	}
	
	public static void demi_tour_droite() {
		mC.rotate(360);
		mA.rotate(-360);
	}
	
	public static void demi_tour_gauche() {
		mA.rotate(360);
		mC.rotate(-360);
	}
	
	public static void demi_tour() {
		int random= (int) Math.round(Math.random());
		if (random==0)
			demi_tour_gauche();
		else
			demi_tour_droite();
	}
	
	public static void recule() {
		//accélération
				int nAcc = 200; //definition du nb de marches d'accélération
//				int maxSpeed = 400; //vitesse max = 100xVbatterie
				for (int i=0; i<nAcc; i++) {
					mA.setSpeed(vitMax/nAcc*i);//change la vitesse
					mC.setSpeed(vitMax/nAcc*i);
					mA.backward();//lance le moteur 
					mC.backward();
					Delay.msDelay(1);// attend 3ms
				}
				stop();
	}
	
	public static void rouleSeconde (int tmps) {
		mA.setSpeed(vitMax);
		mC.setSpeed(vitMax);
		Delay.msDelay(tmps*1000);
	}
	
	public static void pivote (int degre) {
//		mA.synchronizeWith(l);
//		mA.startSynchronization();
		int fcorr = 11; //facteur de correction pour angle vrai, à / par 10
		mA.rotate(-(degre*2*fcorr/10));
		mC.rotate(degre*2*fcorr/10);//Sur 10 demitour il se décal de 25° de trop
//		mA.endSynchronization();
		
		/**
		int dTheta = 10;
		for (int theta=0; theta<degre/dTheta; theta++) {
			mC.rotate(2*dTheta*11/10);
			mA.rotate(-2*dTheta*11/10);
			System.out.println("theta : "+theta);
//			Delay.msDelay(1); 

		}*/
	}
	
	public static void rouleCm (int cm) {
		//TODO
	}
	
}

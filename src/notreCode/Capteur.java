package notreCode;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.*;



public class Capteur {
	
	//Trouver les ports correspondant au bon capteurs
	private Port p1 = lejos.hardware.port.SensorPort.S1;
	private Port p2 = lejos.hardware.port.SensorPort.S2;
	private Port p3 = lejos.hardware.port.SensorPort.S3;
	
	
	
	//Initialisation des instances des 3 capteurs (Ultrason,Couleur et Tactile)
	private EV3UltrasonicSensor capteurSe = new EV3UltrasonicSensor(p3);
	private EV3ColorSensor capteurCo = new EV3ColorSensor(p1);
	private EV3TouchSensor capteurTa = new EV3TouchSensor(p2);
	
	
	
	//Tableau de Float contenant les donnees des differents capteurs
	public float[] donneeSe = new float[1];//ultrason
	public float[] donneeCo = new float[1];//couleur
	public float[] donneeTa = new float[1];//tactile actif
	
	
	
	//Allume le capteur UltraSon
	public void demarrerLeCapteurUltraSon() {
		capteurSe.enable();
	}
	
	//Eteindre le capteur UltraSon
	public void eteindreLeCapteurUltraSon() {
		capteurSe.disable();
	}
	
	//Affecte la distance de l'obstacle le plus proche et met dans le tableau
	public void distanceOb() {
		//Donne le rslt en String
		
		// SampleProvider ?
		
		//debug :
//		System.out.println("=== Capteur ultrason ===");
//		System.out.println("getName = "+capteurSe.getName());
//		System.out.println("getDistanceMode = "+capteurSe.getDistanceMode());
		
		capteurSe.enable();
		capteurSe.getDistanceMode(); 
		//debug
		capteurSe.fetchSample(donneeSe, 0);
		System.out.println("getDistanceMode = "+donneeSe);
		//debug
		capteurSe.disable();
	}
	
	//Donne la distance de l'obstacle le plus proche (en Metre)
	public float getDistanceOb() {
		return donneeSe[0];
	}
	
	
	
	//Permet de savoir si le capteur Tactile est actif (il detect qlqch)
	public boolean capteurTactileActif() {
		capteurTa.getTouchMode().fetchSample(donneeTa, 0);
		
		if(donneeTa[0] == 1) {
			System.out.print("T");
			return true;
		} else {
			System.out.print("F");
			return false;
		}
//		System.out.println(capteurTa.getTouchMode().fetchSample(donneeTa, 0));//debug
	}
	
	
	
	//Donner l'ID de la couleur detectee par le capteur de couleur
	public int couleurDetectee() {
		//Donne la couleur en mode RGB
		return capteurCo.getColorID();
	}
	
}

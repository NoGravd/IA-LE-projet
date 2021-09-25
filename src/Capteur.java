import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.hardware.port.*;



public class Capteur {
	
	//Trouver les ports correspondant au bon capteur;
	
	Port p1 = lejos.hardware.port.SensorPort.S1;
	Port p2 = lejos.hardware.port.SensorPort.S2;
	Port p3 = lejos.hardware.port.SensorPort.S3;
	Port p4 = lejos.hardware.port.SensorPort.S4;
	
	//Initialisation des instances des 3 capteur (Ultrason,Couleur et tactil)
	
	EV3UltrasonicSensor capteurSe = new EV3UltrasonicSensor(p1);
	EV3ColorSensor capteurCo = new EV3ColorSensor(p2);
	EV3TouchSensor capteurTa = new EV3TouchSensor(p3);
	
	
	//Tableau de Float contennant les données des différent capteur
	
	float[] donneeSe = new float[1];
	//float[] donneeCo = new float[];
	float[] donneeTa = new float[1];
	
	//Allume le capteur UltraSon
	
	public void demarrerLeCapteurUltraSon(){
		
		capteurSe.enable();
		
	}
	
	//Eteindre le capteur UltraSon
	
	public void eteindreLeCapteurUltraSon(){
			
		capteurSe.disable();
		
	}
	
	//Affecte la distance de l'obstacle le plus proche en metre dans le tableau
	
	public void distanceOb(){
		
		//Retourne une String pour voir qu'elle résultat cela nous donne
		// SampleProvider ?
		
		System.out.println("=== Capteur ultrason ==");
		
		System.out.println("getName = "+capteurSe.getName());
		System.out.println("getDistanceMode = "+capteurSe.getDistanceMode());
		
		capteurSe.getDistanceMode().fetchSample(donneeSe, 0);
		
	}
	
	//Donne la distance de l'obstacle le plus proche (en Metre)
	
	public float getDistanceOb(){
		
		return donneeSe[0];
		
	}
	
	//Permet de savoir si le capteur Tactile est activee
	
	public boolean capteurTactileActif(){
		
		capteurTa.getTouchMode().fetchSample(donneeTa, 0);
		
		if(donneeTa[0] == 1){
			
			return true;
			
		}else{
			
			return false;
			
		}
	}

	//Donner l'ID de la couleur détecter par le capteur de couleur
	
	public int couleurDetectee(){
		
		//Une fonction qui est capable de donner la couleur en mode RGB
		
		return capteurCo.getColorID();
		
	}
	
}

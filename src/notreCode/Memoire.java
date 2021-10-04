package notreCode;

public class Memoire {
	private static boolean avoirPalet = false;
	private static boolean etreBase = false;
	private static boolean [][] positionCertaine;
	private static boolean [][] positionIncertaine;
	private static boolean etatPince;
	
	
	
	public Memoire (boolean [][] position, boolean pince) {
		positionCertaine = position;
		positionIncertaine = position;
		etatPince = pince;
	}
	
	
	
	//----------Color :--------------------
	
	public static void lignePasBlanche() {
		etreBase = false;
	}
	
	public static void ligneBlanche() {
		if (etreBase)
			etreBase = false;
		else
			etreBase = true;
	}
	
	
	
	//----------Pince :---------------------
	
	public static void mvmtPince (boolean boul) {
		etatPince = boul;
	}
	
	
	
	
	//------------Les get :--------------
	
	public static boolean getEtatPince() {
		return etatPince;
	}
	
	public static boolean getEtreBase() {
		return etreBase;
	}
	
	public static boolean getAvoirPalet() {
		return avoirPalet;
	}
	
}

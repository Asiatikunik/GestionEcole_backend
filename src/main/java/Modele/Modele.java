package Modele;

//TODO: not used...
public class Modele {
	private fr.uvsq.isty.gestionecole.modeles.Ecole ecole;
	
	public Modele() {
		super();
		this.ecole = new fr.uvsq.isty.gestionecole.modeles.Ecole();
	}

	public fr.uvsq.isty.gestionecole.modeles.Ecole getEcole() {
		return ecole;
	}

	public void setEcole(fr.uvsq.isty.gestionecole.modeles.Ecole ecole) {
		this.ecole = ecole;
	}
	
}

package Modele;

/**
 * Une session represente un cours, avec une UE, une promotion qui va suivre le cours
 * et un creneau temporel sur lequel le cours va avoir lieu.
 * @author Simon
 *
 */
public class Session {
	

	private UniteEnseignement uniteEnseigment; 	//L'ue enseignee durant la session
	private Promotion promotion; 	//La promotion qui va suivre le cours
	private Creneau creneau; 	//Le creneau temporel sur lequel la session a lieu
	
	/**
	 * Construitu ne nouvelle session
	 * @param ue : L'ue enseignee durant la session
	 * @param promotion : La promotion qui va suivre le cours
	 * @param creneau : Le creneau temporel sur lequel la session a lieu
	 */
	public Session(UniteEnseignement ue, Promotion promotion, Creneau creneau) {
		this.uniteEnseigment = ue;
		this.promotion = promotion;
		this.creneau = creneau;
	}

	/**
	 * Construit une session vide
	 */
	public Session() {
		super();
	}
	
	/**
	 * Getter pour l'UE
	 * @return l'UE
	 */
	public UniteEnseignement getUniteEnseigment() {
		return uniteEnseigment;
	}

	/**
	 * Setter pour l'UE
	 * @param uniteEnseigment : la nouvelle UE
	 */
	public void setUniteEnseigment(UniteEnseignement uniteEnseigment) {
		this.uniteEnseigment = uniteEnseigment;
	}

	/**
	 * Getter pour la promotion
	 * @return la promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * Setter pour la promotion
	 * @param promotion : la nouvelle promotion
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/**
	 * Getter pour le creneau temporel
	 * @return le creneau temporel
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/**
	 * Setter pour le creneau temporel
	 * @param creneau : le nouveau creneau temporel
	 */
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	
	public String toString() {
		return this.uniteEnseigment + " - " + this.promotion + " - " + this.creneau;
	}
	
}

package models;

public class PurpleArtifacts extends Artifacts {
private String bonusStatus;

	public PurpleArtifacts(String title, String type, int attack, String bonusStatus) {
	super(title, type, attack);
	this.bonusStatus = bonusStatus;
}
	//overiding
	public int damage(int damage) {
		damage = getAttack() * 100;
		return damage;
	
	}
	public String getBonusStatus() {
	return bonusStatus;
}

public void setBonusStatus(String bonusStatus) {
	this.bonusStatus = bonusStatus;
}

	public PurpleArtifacts() {
		// TODO Auto-generated constructor stub
	}


}

package models;

public class GoldenArtifacts extends Artifacts {
private double multiplier;

	public GoldenArtifacts(String title, String type, int attack, double multiplier) {
	super(title, type, attack);
	this.multiplier = multiplier;
}
	//pverriding
	public int damage(int damage) {
		damage = (int) ((getAttack() * multiplier) * 100);
		return damage;
		
	}
	
	public double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	public GoldenArtifacts() {
		// TODO Auto-generated constructor stub
	}


}

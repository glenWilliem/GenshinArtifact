package models;

public abstract class Artifacts {
	String title,type;
	int attack;
	
	
	public Artifacts(String title, String type, int attack) {
		super();
		this.title = title;
		this.type = type;
		this.attack = attack;
	}

	public int damage(int damage) {
		
		return damage;
	}
	

	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public int getAttack() {
		return attack;
	}




	public void setAttack(int attack) {
		this.attack = attack;
	}




	public Artifacts() {
		// TODO Auto-generated constructor stub
	}


}
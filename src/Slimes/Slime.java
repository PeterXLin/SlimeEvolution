package Slimes;

public class Slime {
	
	protected String name;
	protected String URL;
	protected int attack;
	protected int HP;
	protected double moveSpeed;
	protected int shootSpeed;
	protected int shootAmount;
	protected String attackURL;
	
	public Slime(){
	}
	
	public String getName() {
		return name;
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		this.URL = url;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getHP() {
		return HP;
	}
	
	public double getMoveSpeed() {
		return moveSpeed;
	}
	
	public int getShootSpeed() {
		return shootSpeed;
	}
	public int getShootAmount() {
		return shootAmount;
	}
	public String getAttackURL() {
		return attackURL;
	}
	
	
}

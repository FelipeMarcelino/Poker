package player;

public class Player {
	
	private String name;
	private int id;
	private double chips;
	
	
	public Player(String name,int id){
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getId(){
		return this.id;
	}
	

}

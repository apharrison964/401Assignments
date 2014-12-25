package ScoreBoard;

public class Team {
	
	private String name;
	private String mascot;
	
	Team(String name, String mascot){
		this.name = name;
		this.mascot = mascot;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMascot(){
		return mascot;
	}

}

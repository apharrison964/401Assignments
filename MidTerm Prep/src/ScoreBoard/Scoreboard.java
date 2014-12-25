package ScoreBoard;

public class Scoreboard {

	private Team home;
	private Team visitor;
	
	private int homeScore;
	private int visitorScore;
	
	Scoreboard(Team home, Team visitor){
		this.home = home;
		this.visitor = visitor;
	}
	
	Scoreboard(String home_name, String home_mascot, String visitor_name, String visitor_mascot){
		
		this(new Team(home_name, home_mascot), new Team(visitor_name, visitor_mascot));
		homeScore = 0;
		visitorScore = 0;
	}
	
	public String getCurrentLeader(){
		if(homeScore > visitorScore){
			return home.getName();
		}else{
			return visitor.getName();
		}
		
	}
	
	public int getHomeScore(){
		return homeScore;
	}
	
	public int getVisitorScore(){
		return visitorScore;
	}
	
	public int scoreTwo(Team who){
		if(who == home){
			homeScore += 2;
			return homeScore;
		}else{
			visitorScore += 2;
			return visitorScore;
		}
	}
	public int scoreThree(Team who){
		if(who == home){
			homeScore += 3;
			return homeScore;
		}else{
			visitorScore += 3;
			return visitorScore;
		}
	}
		
}
	


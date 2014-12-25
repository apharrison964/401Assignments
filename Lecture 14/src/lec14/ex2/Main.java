package lec14.ex2;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Game[] games = new Game[3];
		games[0] = new GameImpl("Basketball", "Duke", "UNC");
		games[1] = new GameImpl("Baseball", "UNC" , "NCState");
		games[2] = new GameImpl("Lacrosse", "Duke", "Georgetown");
		
		UNCFan tar_heel = new UNCFan();
		DukeFan dookie = new DukeFan();

		for (Game g : games) {
			g.addObserver(tar_heel);
			g.addObserver(dookie);
		}
		
		while (s.hasNext()) {
			int gidx = s.nextInt();
			
			String team = s.next();
			int points_to_add = s.nextInt();
			
			games[gidx].scorePoints(team, points_to_add);
			games[gidx].printScore();
		}
	}
}
// But in real life we cheer when the score changes, so instead of cheering
//when Duke scores but we are still winning, we need to change
// the state
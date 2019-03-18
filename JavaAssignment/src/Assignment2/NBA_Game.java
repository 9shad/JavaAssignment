package Assignment2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class NBA_Game {
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	
	public NBA_Game(){}
	public NBA_Game(String homeTeam, String awayTeam, int homeScreen,
			int awayScore) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScreen;
		this.awayScore = awayScore;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}	
	
	public ArrayList<NBA_Game> getData(){
		ArrayList<NBA_Game> games = new ArrayList<NBA_Game>();
		games.add(new NBA_Game("Rockets", "Lakers", 108, 100));//1 T
		games.add(new NBA_Game("Spurs", "Clippers", 110, 112));//2 C
		games.add(new NBA_Game("Spurs", "Rockets", 99, 107));//3 
		games.add(new NBA_Game("Mavericks", "Clippers", 98, 103));//4 C 
		games.add(new NBA_Game("Warriors", "Rockets", 117, 103));//C 
		games.add(new NBA_Game("Lakers", "Mavericks", 89, 111));//T
		games.add(new NBA_Game("Rockets", "Spurs", 104, 101));//5 
		games.add(new NBA_Game("Rockets", "Warriors", 97, 105));//6 C
		games.add(new NBA_Game("Warriors", "Lakers", 120, 91));
		games.add(new NBA_Game("Clippers", "Kings", 112, 111));//7
		games.add(new NBA_Game("Rockets", "Mavericks", 120, 91));
		games.add(new NBA_Game("Clippers", "Spurs", 110, 101));//8
		games.add(new NBA_Game("Rockets", "Warriors", 197, 105));//6 C
		return games;
	}
	
	public Set<String> getUniqueTeams(){
		Set<String> teams = new LinkedHashSet<String>();
		for(NBA_Game obj: getData()){
			teams.add(obj.homeTeam);
			teams.add(obj.awayTeam);
		}
		return teams;
	}
}

package Assignment2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Solutions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solutions obj = new Solutions();
		obj.problem1();
		System.out.println();
		obj.problem2();
		System.out.println();
		obj.problem3();
		System.out.println();
		obj.problem4();
		System.out.println();
		obj.problem5();
		System.out.println();
		obj.problem6();
		System.out.println();
		obj.problem7();
		System.out.println();
		obj.problem8();
		System.out.println();
		obj.problem9();
		System.out.println();
		obj.problem10();
		System.out.println();
		obj.problem11();
		System.out.println();
		obj.problem12();
		System.out.println();
		obj.problem13();
		System.out.println();
	}
	
	//Write a program to calculate from the data if the difference of scores between two teams 
	//is smaller than or equal to 10, what is the winning rate of a home team.
	public void problem1(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		int teamCount =0, homeTeamWinningCount=0;
		for(NBA_Game obj : games){
			if( Math.abs(obj.getHomeScore() - obj.getAwayScore())<=10){
				teamCount++;
				if(obj.getHomeScore() > obj.getAwayScore()){
					homeTeamWinningCount++;
				}
			}
		}
		System.out.println("Winning rate of home team is: " + (homeTeamWinningCount / (float)teamCount)*100+"%");
	}
	
	//print out the team name(s) which can win at least two games in a row.
	public void problem2(){
		NBA_Game nbaObj = new NBA_Game();
		Set<String> teams = nbaObj.getUniqueTeams(); 
		ArrayList<NBA_Game> games = nbaObj.getData();
		ArrayList<String> winningTeams = new ArrayList<String>();  
		for(String currentTeam : teams){
			boolean previousGame = false;
			boolean currentGame = false;
			for(NBA_Game game : games){
				if(game.getHomeTeam().equals(currentTeam) && game.getHomeScore() > game.getAwayScore()){
					currentGame = true;
				}else if(game.getAwayTeam().equals(currentTeam) && game.getAwayScore() > game.getHomeScore()){
					currentGame = true;
				}
				if(currentGame){
					if(previousGame){
						winningTeams.add(currentTeam);
						break;
					}else{
						currentGame = false;
						previousGame=true;
					}
				}
			}
		}
		System.out.println("Teams who won two games in a row are: "+ winningTeams);
	}

	//there are four teams from California (Clippers, Lakers, Kings and Warriors) and 
	//there are 3 teams from Texas (Mavericks, Rockets and Spurs). 
	//Write a program to display the number of wins of each State in which 
	//the teams are from different States (one from California and the other from Texas).
	public void problem3(){
		ArrayList<String> teamCali = new ArrayList<String>();
		ArrayList<String> teamTex = new ArrayList<String>();
		teamCali.add("Clippers");
		teamCali.add("Lakers");
		teamCali.add("Kings");
		teamCali.add("Warriors");
		
		teamTex.add("Mavericks");
		teamTex.add("Rockets");
		teamTex.add("Spurs");
		
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		int winCountCali = 0;
		int winCountTex = 0;
		
		for(NBA_Game game : games){
			if(teamCali.contains(game.getHomeTeam()) && teamTex.contains(game.getAwayTeam())){
				if(game.getHomeScore() > game.getAwayScore()){
					winCountCali++;
				}else{
					winCountTex++;
				}
				//System.out.println(game.getHomeTeam() + " " +game.getAwayTeam());
			}else if(teamTex.contains(game.getHomeTeam()) && teamCali.contains(game.getAwayTeam())){
				if(game.getHomeScore() > game.getAwayScore()){
					winCountTex++;
				}else{
					winCountCali++;
				}
				//System.out.println(game.getHomeTeam() + " " +game.getAwayTeam());
			}
		}
		System.out.println("California State Wins: "+winCountCali + " Texas State Wins: "+winCountTex);
	}
	
	//given a team’s name, calculate the average score of the games it won and the average score of the games it lost. 
	//Display the results in your program.
	public void problem4(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		int winScoreTotal = 0;
		int loosingScoreTotal = 0;
		int totalGames = 0;
		Set<String> teams = nbaObj.getUniqueTeams(); 
		Random r = new Random();
		String teamName = (String) teams.toArray()[r.nextInt(teams.size())];
		
		for(NBA_Game game : games){
			if(game.getHomeTeam().equals(teamName)){
				if(game.getHomeScore() > game.getAwayScore()){
					winScoreTotal += game.getHomeScore();
				}else{
					loosingScoreTotal += game.getAwayScore();
				}
				totalGames++;
			}else if(game.getAwayTeam().equals(teamName)){
				if(game.getAwayScore() > game.getHomeScore()){
					winScoreTotal += game.getHomeScore();
				}else{
					loosingScoreTotal += game.getAwayScore();
				}
				totalGames++;
			}
		}
		System.out.println(teamName +" Winning avg score: "+ winScoreTotal/(float)totalGames +" Loosing avg score: "+ loosingScoreTotal/(float)totalGames);
	}
	
	//find the game(s) which has the largest difference in scores. 
	//Display the information of the game, including its teams and scores. 
	//If it has more than one game with the largest difference, display the info for all of the games.
	public void problem5(){
		int largestDifference = 0;
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();		
		for(NBA_Game game : games){
			int difference = Math.abs(game.getHomeScore()-game.getAwayScore());
			if(difference > largestDifference){
				largestDifference = difference; 
			}
		}
		System.out.println("Largest Difference: "+largestDifference);
		for(NBA_Game game : games){
			int difference = Math.abs(game.getHomeScore()-game.getAwayScore());
			if(difference == largestDifference)
				System.out.println("Home Team: "+game.getHomeTeam() +",Away Team: "+game.getAwayTeam() +",Home Score: "+game.getHomeScore() +",Away Score: "+game.getAwayScore());	
		}
	}
	
	//display the teams that never lose games in a row. 
	//If no such a team, display “every team used to lose games in a row”.
	public void problem6(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Set<String> teams = nbaObj.getUniqueTeams();
		ArrayList<String> notLost = new ArrayList<String>();
		
		for(String team : teams){
			boolean previousGameWon = false;
			boolean currentGameWon = false;
			boolean notLostInaRow = false;
			int count = 0;
			for(NBA_Game game : games){
				if(game.getHomeTeam().equals(team)){
					if(game.getHomeScore() > game.getAwayScore()){
						currentGameWon = true;
						//System.out.println(team +" won");
					}else{
						currentGameWon = false;
						//System.out.println(team +" lost");
					}
				}else if(game.getAwayTeam().equals(team)){
					if(game.getHomeScore() < game.getAwayScore()){
						currentGameWon = true;
						//System.out.println(team +" won");
					}else{
						currentGameWon = false;
						//System.out.println(team +" lost");
					}
				}
				if(game.getHomeTeam().equals(team) || game.getAwayTeam().equals(team)){
					if(count!=0){ //this is not the first game we are comparing
						if(!currentGameWon && !previousGameWon){
							notLostInaRow = false;
							break;
						}else{
							notLostInaRow = true;
						}
					}
					previousGameWon = currentGameWon;
					currentGameWon = false;
					count++;
				}
			}
			if(notLostInaRow){
				notLost.add(team);
			}
		}
		if(notLost.size()!=0)
			System.out.println("Teams that have not lost games in a row: "+notLost);
		else
			System.out.println("Every team used to lose games in a row");
	}
	
	
	//which team has the highest average score per game? Write a program to display the team’s name and its average score.
	public void problem7(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Set<String> teams = nbaObj.getUniqueTeams();
		String teamName="";
		double highestAverageScore = 0.0;
		
		for(String team : teams){
			int countOfGamesPlayed = 0;
			int totalScore = 0;
			for(NBA_Game game : games){
				if(game.getHomeTeam().equals(team)){
					totalScore+=game.getHomeScore();
					countOfGamesPlayed++;
				}else if(game.getAwayTeam().equals(team)){
					totalScore+=game.getAwayScore();
					countOfGamesPlayed++;
				}
			}
			double averageScore = totalScore / (double)countOfGamesPlayed;
			System.out.println(team + " average score per game: "+ averageScore);
			
			if(averageScore>highestAverageScore){
				teamName = team;
				highestAverageScore = averageScore;
			}
		}
		System.out.println();
		System.out.println(teamName + " have the highest average score of "+highestAverageScore);
	}
	
	//rank all of the teams based on their winning rate 
	public void problem8(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Set<String> teams = nbaObj.getUniqueTeams();
		ArrayList<WinningRate> teamsWithWinningRate = new ArrayList<WinningRate>();
		
		for(String team : teams){
			int countOfGames = 0;
			int countOfWin = 0;
			for(NBA_Game game : games){
				if(game.getHomeTeam().equals(team)){
					if(game.getHomeScore() > game.getAwayScore()){
						countOfWin++;
					}
					countOfGames++;
				}else if(game.getAwayTeam().equals(team)){
					if(game.getAwayScore() > game.getHomeScore()){
						countOfWin++;
					}
					countOfGames++;
				}
			}
			WinningRate obj = new WinningRate();
			obj.setTeamName(team);
			obj.setWinningRate(countOfWin/(double)countOfGames);
			teamsWithWinningRate.add(obj);
		}
		
		for(int i=0;i<teamsWithWinningRate.size()-1;i++){
			for(int j=i+1;j<teamsWithWinningRate.size();j++){
				if(teamsWithWinningRate.get(i).getWinningRate() < teamsWithWinningRate.get(j).getWinningRate()){
					WinningRate temp = teamsWithWinningRate.get(i);
					teamsWithWinningRate.set(i, teamsWithWinningRate.get(j));
					teamsWithWinningRate.set(j, temp);
				}
			}
		}
		for(WinningRate obj : teamsWithWinningRate){
			System.out.println("Team: "+obj.getTeamName() + " Rate: "+obj.getWinningRate());
		}
	}
	//write a program to test whether or 
	//not there are two teams complete two games between them and each team is a home team in one game 
	public void problem9(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Object[] teams = nbaObj.getUniqueTeams().toArray();
		System.out.println("Two teams who complete two games between them and each team is a home team in one game are:");
		for(int i=0;i<teams.length-1;i++){
			for(int j=i+1;j<teams.length;j++){
				int gameCount=0;
				int homeGameCount=0;
				int awayGameCount=0;
				for(NBA_Game game:games){
					if(game.getHomeTeam().equals(teams[i]) && game.getAwayTeam().equals(teams[j])){
						gameCount++;
						homeGameCount++;
					}else if(game.getHomeTeam().equals(teams[j]) && game.getAwayTeam().equals(teams[i])){
						gameCount++;
						awayGameCount++;
					}
				}
				if(gameCount == 2 && homeGameCount == 1 && awayGameCount == 1){
					System.out.println(teams[i] +" vs "+ teams[j]);
				}
			}
		}
	}
	
	//which team is the best Texas team against 
	//California teams (based on its winning rate of the games against California teams)
	public void problem10(){
		ArrayList<String> teamCali = new ArrayList<String>();
		ArrayList<String> teamTex = new ArrayList<String>();
		
		teamCali.add("Clippers");
		teamCali.add("Lakers");
		teamCali.add("Kings");
		teamCali.add("Warriors");
		
		teamTex.add("Mavericks");
		teamTex.add("Rockets");
		teamTex.add("Spurs");
		
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		ArrayList<WinningRate> teamsWithWinningRate = new ArrayList<WinningRate>();
		for(int i=0;i<teamTex.size();i++){
			int countOfGamesPlayed = 0;
			int countOfGamesWon = 0;
			for(int j=0;j<teamCali.size();j++){
				for(NBA_Game game : games){
					if(game.getHomeTeam().equals(teamTex.get(i)) && game.getAwayTeam().equals(teamCali.get(j))){
						if(game.getHomeScore()>game.getAwayScore()){
							countOfGamesWon++;
						}
						countOfGamesPlayed++;
					}else if(game.getAwayTeam().equals(teamTex.get(i)) && game.getHomeTeam().equals(teamCali.get(j))){
						if(game.getHomeScore()<game.getAwayScore()){
							countOfGamesWon++;
						}
						countOfGamesPlayed++;
					}
				}
			}
			WinningRate obj = new WinningRate();
			obj.setTeamName(teamTex.get(i));
			obj.setWinningRate(countOfGamesWon/(double)countOfGamesPlayed);
			teamsWithWinningRate.add(obj);
		}
		for(int i=0;i<teamsWithWinningRate.size();i++){
			for(int j=0;j<teamsWithWinningRate.size()-1;j++){
				if(teamsWithWinningRate.get(i).getWinningRate() > teamsWithWinningRate.get(j).getWinningRate()){
					WinningRate temp = teamsWithWinningRate.get(i);
					teamsWithWinningRate.set(i, teamsWithWinningRate.get(j));
					teamsWithWinningRate.set(j, temp);
				}
			}
		}
		if(teamsWithWinningRate.size() !=0)
			System.out.println("The best Texan team against California Team is : "+teamsWithWinningRate.get(0).getTeamName() + " with winning rate: "+teamsWithWinningRate.get(0).getWinningRate());
	}
	
	//given an array of all teams’ names, write a program to determine which team(s) has the largest number of winning games in a row. 
	//If it has more than one team having the largest number, list all teams’ names and the number. 
	public void problem11(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Set<String> teams = nbaObj.getUniqueTeams();
		int[] gamesWonInRowByEachTeam = new int[teams.size()];
		int highestGamesWonInARow = 0;
		int index=0;
		for(String team : teams){
			boolean previousGameWon = false;
			boolean currentGameWon = false;
			int countOfGameWon = 0;
			int count = 0;
			for(NBA_Game game : games){
				if(game.getHomeTeam().equals(team)){
					if(game.getHomeScore() > game.getAwayScore()){
						currentGameWon = true;
						countOfGameWon++;
					}
				}else if(game.getAwayTeam().equals(team)){
					if(game.getHomeScore() < game.getAwayScore()){
						currentGameWon = true;
						countOfGameWon++;
					}
				}
				if(game.getHomeTeam().equals(team) || game.getAwayTeam().equals(team)){
					if(count!=0){ //this is not the first game we are comparing
						if(!currentGameWon || !previousGameWon){//if loose any game then count becomes zero
							countOfGameWon = 0;
						}
					}
					previousGameWon = currentGameWon;
					currentGameWon = false;
					count++;
				}
			}
			if(countOfGameWon >= highestGamesWonInARow){
				highestGamesWonInARow = countOfGameWon;
			}
			gamesWonInRowByEachTeam[index++] = countOfGameWon;
		}
		for(int i=0;i<teams.size();i++){
			if(gamesWonInRowByEachTeam[i] == highestGamesWonInARow){
				System.out.println(teams.toArray()[i]+" "+gamesWonInRowByEachTeam[i]);
			}
		}
	}
	
	//given an array of all team names, write a program to determine whether or not there is a team satisfying that: 
	//once it loses a game to a team, it will win back immediately next time they meet. 
	//If it has multiple of such teams, list all of them. Otherwise, just print out a message for no such a team. 
	public void problem12(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Object[] teams = nbaObj.getUniqueTeams().toArray();
		ArrayList<String> teamsWon = new ArrayList<String>();
		for(int i=0;i<teams.length;i++){
			for(int j=0; j<teams.length;j++){
				if(!teams[i].equals(teams[j])){
					boolean currentGame = false;
					boolean previousGame = false;
					int count = 0;
					for(NBA_Game game : games){
						if(game.getHomeTeam().equals(teams[i]) && game.getAwayTeam().equals(teams[j])){
							if(game.getHomeScore() > game.getAwayScore()){
								currentGame = true;
							}
							if(count!=0){
								if(!previousGame && currentGame){
									teamsWon.add(teams[i]+" won against "+teams[j] +" after loosing its previous game");
									break;
								}
							}
							previousGame = currentGame;
							count++;
						}else if(game.getHomeTeam().equals(teams[j]) && game.getAwayTeam().equals(teams[i])){
							if(game.getHomeScore() < game.getAwayScore()){
								currentGame = true;
							}
							if(count!=0){
								if(!previousGame && currentGame){
									teamsWon.add(teams[j]+" won against "+teams[i] +" after loosing its previous game");
									break;
								}
							}
							previousGame = currentGame;
							count++;
						}
					}
				}
			}
		}
		if(teamsWon.size()>0){
			for(String s : teamsWon){
				System.out.println(s);
			}
		}else{
			System.out.println("No such a team");
		}
	}
	//A defets B, B defets C, C defets A 
	public void problem13(){
		NBA_Game nbaObj = new NBA_Game();
		ArrayList<NBA_Game> games = nbaObj.getData();
		Object[] teams = nbaObj.getUniqueTeams().toArray();
		boolean aDefB = false, bDefC = false, cDefA = false;
		boolean bDefA = false, cDefB = false, aDefC = false;
		for(int a=0;a<teams.length-2;a++){
			for(int b = a+1; b<teams.length-1;b++){
				for(int c = b+1;c<teams.length;c++){
					System.out.println(teams[a] + " "+teams[b]+" "+teams[c]);
					for(NBA_Game game : games){
						if(game.getHomeTeam().equals(teams[a]) && game.getAwayTeam().equals(teams[b])){
							if(game.getHomeScore() > game.getAwayScore()){
								aDefB = true;
								//System.out.println(teams[a] + " defeats "+ teams[b] );
							}else{
								bDefA = true;
								//System.out.println(teams[b] + " defeats "+ teams[a] );
							}
						}else if(game.getHomeTeam().equals(teams[b]) && game.getAwayTeam().equals(teams[a])){
							if(game.getAwayScore() > game.getHomeScore()){
								aDefB = true;
								//System.out.println(teams[a] + " defeats "+ teams[b] );
							}else{
								bDefA = true;
								//System.out.println(teams[b] + " defeats "+ teams[a] );
							}
						}
						if(game.getHomeTeam().equals(teams[b]) && game.getAwayTeam().equals(teams[c])){
							if(game.getHomeScore() > game.getAwayScore()){
								bDefC = true;
								//System.out.println(teams[b] + " defeats "+ teams[c] );
							}else{
								cDefB = true;
								//System.out.println(teams[c] + " defeats "+ teams[b] );
							}
						}else if(game.getHomeTeam().equals(teams[c]) && game.getAwayTeam().equals(teams[b])){
							if(game.getAwayScore() > game.getHomeScore()){
								bDefC = true;
								//System.out.println(teams[b] + " defeats "+ teams[c] );
							}else{
								cDefB = true;
								//System.out.println(teams[c] + " defeats "+ teams[b] );
							}
						}
						if(game.getHomeTeam().equals(teams[c]) && game.getAwayTeam().equals(teams[a])){
							if(game.getHomeScore() > game.getAwayScore()){
								cDefA = true;
								//System.out.println(teams[c] + " defeats "+ teams[a] );
							}else{
								aDefC = true;
								//System.out.println(teams[c] + " defeats "+ teams[a] );
							}
						}else if(game.getHomeTeam().equals(teams[a]) && game.getAwayTeam().equals(teams[c])){
							if(game.getAwayScore() > game.getHomeScore()){
								cDefA = true;
							}else{
								aDefC = true;
							}
						}
					}
					if(aDefB && bDefC && cDefA){
						System.out.println(teams[a] +" defeats "+ teams[b]+" defeats "+teams[c] + " defeats "+teams[a]);
					}else if(aDefC && cDefB && bDefA){
						System.out.println(teams[a] +" defeats "+ teams[c]+" defeats "+teams[b] + " defeats "+teams[a]);
					}
					bDefC = cDefA = aDefC = cDefB = false; 
				}				
			}
			aDefB = bDefA = false;
		}
		
		//DecimalFormat df = new DecimalFormat("#0.00");
		//System.out.println("%.2f");
		//String.format("%.2f", 1.23456); 
	}
}

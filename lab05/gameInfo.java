/*
Lab 05

Author: Thuc Duong

Course number: 1968

Revision:
   20181014(TD): original version

*/

public class gameInfo
{
  private String winner = "";
  private int turns = 0;
  private int totalWars = 0;
  private int warsWonbyPlayer1 = 0;
  private int warsWonbyPlayer2 = 0;
  private int gamesWonbyPlayer1 = 0;
  private int gamesWonbyPlayer2 = 0;
 
  public gameInfo(int turns, int totalWars, int warsWonbyPlayer1, int warsWonbyPlayer2, int hand1Len, int hand2Len)
  {
    this.turns = turns;
    this.totalWars = totalWars;
    this.warsWonbyPlayer1 = warsWonbyPlayer1;
    this.warsWonbyPlayer2 = warsWonbyPlayer2;
    
    if(hand1Len == 0 && hand2Len != 0 && turns != 10000)
    {
      this.winner = "Player 2";
      this.gamesWonbyPlayer2++;
    }else if(hand2Len == 0 && hand1Len != 0 && turns != 10000)
    {
      this.winner = "Player 1";
      this.gamesWonbyPlayer1++;
    }else if((hand2Len == 0 && hand1Len == 0) || turns == 10000)
    {
      this.winner = "No one";
    }
  }

  public int getTurns()
  {
     return this.turns;
  }
 
  public int getTotalWars()
  {
     return this.totalWars;
  }

  public int getWarswonByplayer1()
  {
     return this.warsWonbyPlayer1;
  }

  public int getWarswonByplayer2()
  {
     return this.warsWonbyPlayer2;
  }

  public String getWinner()
  {
     return this.winner;
  }
  
  public int getGamesWonByPlayer1()
  {
     return this.gamesWonbyPlayer1;
  }
  
  public int getGamesWonByPlayer2()
  {
     return this.gamesWonbyPlayer2;
  }
  
  public String toString()
  {
     String retval = "";
     retval = this.winner + " wins.\n";
     retval += "The total of turns for this game is " + this.turns + "\n";
     retval += "The number of total wars in this game is " + this.totalWars + "\n";
     retval += "The number of wars won by player 1 is " + this.warsWonbyPlayer1 + "\n";
     retval += "The number of wars won by player 2 is " + this.warsWonbyPlayer2 + "\n";
     return retval; 
  }
  
 public static void main(String args[])
 {
    gameInfo GameInfo = new gameInfo(0,0,0,0,0,0);
    System.out.println(GameInfo);
 }

}

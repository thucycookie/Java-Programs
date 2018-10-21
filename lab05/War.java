/*
Lab 05

Author: Thuc Duong

Best version

Course number: 1968

Revision:
   20181014(TD): original version

Note:
   20181014(TD): a class called gameInfo was created
                 to store information about each
                 game simulated

*/
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Math;

public class War
{
  public static void main(String args[]) throws HolderException,CardException
  {
    Deck d = new Deck();
    d.shuffle();
    Holder hand1 = new Holder(false);
    Holder hand2 = new Holder(false);
    Holder table = new Holder(false);
    int turns = 0;
    Card val1;
    Card val2;
    boolean thereIsAWar = false;
    int numberOfWarsWonByPlayer1 = 0;
    int numberOfWarsWonByPlayer2 = 0;
    int numberOfWarsTotal = 0;
    int count = 0; //count how many cards have been inserted into the table 
    
    //ask the user how many games to simulate
    //
    Scanner kb = new Scanner(System.in);
    System.out.println("How many games do you want to simulate?");
    int numberOfGames = kb.nextInt();
    int numberOfGamesSimulated = 0;    
    
    //an array to store each game information as an gameInfo
    //object, check out the gameInfo class for further references
    //about how this object is set up
    //
    gameInfo arrayOfallTheGames[] = new gameInfo[numberOfGames];
    int index = 0;
    
    int averageTurnsPerGame = 0;
    int averageWarsPerGame = 0;
    double fractionOfGamesWonbyPlayer1 = 0;
    double fractionOfGamesWonbyPlayer2 = 0;
    double fractionOfGamesTied = 0;
    
    //deals the cards from a shuffed deck into hand1 and hand2 alternatively
    //

    for(int i = 0; i < d.len; i++)
    {
     if(i % 2 == 0)
     {
        hand1.theHolder[i/2] = d.theHolder[i];
     }else 
     {
        hand2.theHolder[(i-1)/2] = d.theHolder[i];
     }
    }
   
   //start of the war game
   //
   while(numberOfGamesSimulated < numberOfGames)
   {
    while(turns != 10000)
    {
      val1 = hand1.removeCard();
      table.insertCardintoTable(val1);
      val2 = hand2.removeCard();
      table.insertCardintoTable(val2);
      count += 2;
          
      turns++;

      //debug purpose System.out.println(val1 + " " + val2 + " " + table.tableLen);
          
      if(val1.getValue() > val2.getValue())
      { 
    
        for(int i = 0; i < count; i++)
        {
           hand1.insertCard(table.theHolder[i]); 
        }
       
        for(int a = 0; a < count; a++)
        {
           table.removeCardfromTable();
        }
       
        count = 0; 

        if(thereIsAWar == true)
        {
           numberOfWarsWonByPlayer1++;
        }
 
        thereIsAWar = false;

      }else if(val2.getValue() > val1.getValue())
      {
        for(int a = 0; a < count; a++)
        {
           hand2.insertCard(table.theHolder[a]);
        }

        for(int b = 0; b < count; b++)
        {
           table.removeCardfromTable();
        }
      
        count = 0;
       
        if(thereIsAWar == true) 
        {
           numberOfWarsWonByPlayer2++;
        }
    
        thereIsAWar = false;

      }else
      {    //if one of the hand does not have enough cards to out down
           //when a war occurs (when the cards from hand 1 and 2 are the same
           //rank), put down as much as the hand can but leave 1 last card, which
           //will be compared (by the code at the top)
           if(hand1.len <= 3 || hand2.len <= 3)
           { 
             for(int c = 0; c < Math.min(hand1.len,hand2.len) - 1; c++)
             {
              val1 = hand1.removeCard();
              val2 = hand2.removeCard();
              table.insertCardintoTable(val1);
              table.insertCardintoTable(val2);
              count+=2;
             }
           }else if(hand1.len > 3 && hand2.len > 3)
           {
            for(int b = 0; b < 3; b++) //each player puts down 3 cards 
            {  
              val1 = hand1.removeCard();
              table.insertCardintoTable(val1);
              val2 = hand2.removeCard();
              table.insertCardintoTable(val2);
              count+=2;
            }
           }
          thereIsAWar = true; 
      }
      
      //game ends if one of the hands is empty
      //
      if(hand1.len < 1 || hand2.len < 1)
      {
        break;
      }

    }
   //inner while loop exits whenever a game ends
   //create a new gameInfo object and appends it to the array
   //
   numberOfWarsTotal = numberOfWarsWonByPlayer1 + numberOfWarsWonByPlayer2; 
   arrayOfallTheGames[index] = new gameInfo(turns, numberOfWarsTotal, numberOfWarsWonByPlayer1, numberOfWarsWonByPlayer2, hand1.len, hand2.len);
   numberOfGamesSimulated++;
   index++;
   
   //debug
   //
   System.out.println("Table starts her:"); //debug
   System.out.println(table); //debug
   System.out.println("hand1 starts here");
   System.out.println(hand1); //debug
   System.out.println("hand2 starts here"); //debug
   System.out.println(hand2); //debug   

   //re-initialize for a new game
   //
   numberOfWarsWonByPlayer1 = 0;
   numberOfWarsWonByPlayer2 = 0;
   turns = 0;
   count = 0;
   hand1 = new Holder(false);
   hand2 = new Holder(false);
   table = new Holder(false);
   d.shuffle();
   for(int i = 0; i < d.len; i++)
   {
     if(i % 2 == 0)
     {
        hand1.theHolder[i/2] = d.theHolder[i];
     }else
     {
        hand2.theHolder[(i-1)/2] = d.theHolder[i];
     }
   } 
   
   }
    //prints out info about each game simulated
    //
    for(int i = 0; i < arrayOfallTheGames.length; i++)
    {  
       int GameNumber = i + 1;
       System.out.println("Game " + GameNumber + " info is:");
       System.out.println(arrayOfallTheGames[i]);
       averageTurnsPerGame += arrayOfallTheGames[i].getTurns(); //add to get the total number of turns and then divide it by the number of games simulated
       averageWarsPerGame += arrayOfallTheGames[i].getTotalWars();//add to get the total number of wars and then divide it by the number of games simulated
       fractionOfGamesWonbyPlayer1 += arrayOfallTheGames[i].getGamesWonByPlayer1(); //same concept as above
       fractionOfGamesWonbyPlayer2 += arrayOfallTheGames[i].getGamesWonByPlayer2(); //same concept as above
    }
   //do math
   //
   averageTurnsPerGame /= numberOfGames;
   averageWarsPerGame /= numberOfGames;
   fractionOfGamesWonbyPlayer1 = 100.0 * (fractionOfGamesWonbyPlayer1/numberOfGames);
   fractionOfGamesWonbyPlayer2 = 100.0 * (fractionOfGamesWonbyPlayer2/numberOfGames);
   fractionOfGamesTied = 100.0 - (fractionOfGamesWonbyPlayer1 + fractionOfGamesWonbyPlayer2);   
   
   //prints out sumary analysis
   //
   System.out.println("Summary analysis");
   System.out.println(numberOfGames + " games were played."); 
   System.out.println("The average turns per game is " + Math.round(averageTurnsPerGame));
   System.out.println("The average wars per game is " + Math.round(averageWarsPerGame));
   System.out.println("Player 1 wins about " + String.format("%.2f", fractionOfGamesWonbyPlayer1) + "%");
   System.out.println("Player 2 wins about " + String.format("%.2f", fractionOfGamesWonbyPlayer2) + "%");
   System.out.println("Amount of tie games is about " + String.format("%.2f", fractionOfGamesTied) + "%");
   
  }
}

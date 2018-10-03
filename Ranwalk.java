/*
Second program

Lab 02

Author: Thuc Duong

Course number: 1968

Revision:
	20180912(TD): original version
*/

import java.util.Random;
import java.util.Scanner;

public class Ranwalk
{
  public static int ranwalk(int numSteps)
  {
    //define the necessary variables
    //
    boolean headOrTail = true; //initilize the coin variable
    Random Ran = new Random(); //create a Random number generator
    int currentLocation = numSteps; //your current locations

    for(int i = 0; i < numSteps; i++) //flip a coin numSteps times
    {
      headOrTail = Ran.nextBoolean(); //generate a new number and assign that tocoin variable
        
      if(headOrTail == false)
      {
        currentLocation--; //move left if it is false
      }else
      {
        currentLocation++; //move right if it is true
      }
    }

    return currentLocation; //return the final position after you moved numSteps steps and flipped the coin each time
  }

  public static void main(String args[])
  {

    //ask the user for the number of steps
    System.out.println("What is the number of steps?");
    Scanner numStepskb = new Scanner(System.in);
    int numSteps = numStepskb.nextInt();

    //an array of ending locations
    int [] arrOfLocationsWhereTheWalkEnded = new int[2*numSteps + 1];

    //ask for the number of repetition
    System.out.println("What is the number of repetition?");
    Scanner numRepskb = new Scanner(System.in);
    int numReps = numRepskb.nextInt();	

    //call ran walk
    //
    for(int a = 0; a < numReps; a++)
    {
       arrOfLocationsWhereTheWalkEnded[ranwalk(numSteps)] ++;
    }
    

    //print out the location for each of the 65 locations
    System.out.println("Locations vs count");
    
    for(int b = 0; b < 2*numSteps+1; b++)
    {
      System.out.println(b + " " + arrOfLocationsWhereTheWalkEnded[b]);
    }

    //exit gracefully
  }
}

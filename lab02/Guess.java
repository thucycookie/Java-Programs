/* 

Lab 02

Author: Thuc Duong

Course number: 1968

Revision:
	20180919(TD): original version

*/

import java.util.Scanner;
import java.lang.Math;

public class Guess
{
  public static void main(String args[])
  {
    //print stdout to ask the user a number to memorize
    //
    System.out.println("Please think of a number between 1 and 100 but don't tell me!");
    
    //create a scanner and initialize some variables for the prog
    //
    Scanner input_from_user = new Scanner(System.in);
    int num_from_user = 1; //starts the game at the top
    double Current_Guess_Number = 50; //guessing starts at the middle
    double Previous_Guess_Number = 0; 
    double temp = 0;
    int numberOfRounds = 1; //how many times it takes to get it right
    
    //guessing begins her
    //
    while(num_from_user != 0)
    {
      while(num_from_user != 0)
      { 
        temp = Current_Guess_Number; //stores the current to temp
        numberOfRounds++; //count guess times
        System.out.println("Enter 1 if " + Current_Guess_Number + " is bigger than your number\nEnter 0 if " + Current_Guess_Number + " is your number\nEnter -1 if " + Current_Guess_Number + " is less than your number\n");
        num_from_user = input_from_user.nextInt();
          if(num_from_user == 1)
          { 
            if(Previous_Guess_Number > Current_Guess_Number)
            {
             Current_Guess_Number -= Math.ceil((Previous_Guess_Number - Current_Guess_Number)/2);
            }else
            {
             Current_Guess_Number -= Math.ceil((Current_Guess_Number - Previous_Guess_Number)/2);
            }
          }else if(num_from_user == -1)
          {
            if(Previous_Guess_Number > Current_Guess_Number)
            {
             Current_Guess_Number += Math.ceil((Previous_Guess_Number - Current_Guess_Number)/2);
            }else
            {
             Current_Guess_Number += Math.ceil((Current_Guess_Number - Previous_Guess_Number)/2);
            }
            
            if(Current_Guess_Number > 100)
            {
             Current_Guess_Number = 100;
            }
            }else if(num_from_user == 0)
          {
            break; 
          }else
          {
            System.out.println("Invalid Input! Only -1, 0 and 1 are accepted.");
          }
         Previous_Guess_Number = temp;
          
       }
         System.out.println("Enter 1 to play again and 0 to quit!");
         //re-initialize whenever a user chose to play again
         //
         num_from_user = input_from_user.nextInt();
         Current_Guess_Number = 50; 
         Previous_Guess_Number = 0;   
         numberOfRounds = 1;
}
    //player exited by hitting 0
    //

    System.out.println("Thank you, I took me " + numberOfRounds + " times to guess your number. Have a nice day!");
    //exit gracefully
    //

  }
}

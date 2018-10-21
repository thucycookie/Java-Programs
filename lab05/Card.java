/*
Lab 05

Author: Paul LaFollette, Thuc Duong

Course number: 1968

Revision:

20181014(TD): changed the condition in the
              constructor that constraints 
              the input value from 2 to 14 
              (instead of the original 1 to
              13), I did this so I can move
              the Ace string from being first 
              element to the last element
              in the array vals below.

20181013(TD): put in another print command
              that outputs a string to inform
              a user the range of values for
              the cards that the program can 
              accept.

20181010(PL): original version


*/

import java.util.Scanner;
public class Card
{
  private String suit;
  private int value;

  public Card(int v, String s) throws CardException
  {
    if (v < 2 || v > 14)
    {
      throw new CardException("Illegal card value " + v);
    }
    s = s.toUpperCase();
    if (!s.equals("C") && !s.equals("D") && !s.equals("H") && !s.equals("S"))
    {
      System.out.println("suit = " + s);
      throw new CardException("Illegal card suit " + s);
    }
    this.value = v;
    this.suit = s;
  }

  public int getValue()
  {
    return this.value;
  }
 
  public String getSuit()
  {
    return this.suit;
  }

  public String toString()
  {
    String vals[] = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    String s = "wrong";
    if (this.suit.equals("C"))
      s = "Clubs";
    else if (this.suit.equals("D"))
      s = "Diamonds"; 
    else if (this.suit.equals("H"))
      s = "Hearts";
    else if (this.suit.equals("S"))
      s = "Spades";
    else
      System.err.println("Please submit a software error report.");

    String v = vals[this.value-2];
    return "The " + v + " of " + s;
  }

  public static void main(String args[]) throws CardException
  {
    Scanner kb = new Scanner(System.in);
    Card c1 = null;
    int val;
    String suit;

    Boolean goodCard = false;
    
    while (!goodCard)
    {
      System.out.println("The lowest value is 2 to represent a 2 card while the highest value is 14 to represent an Ace card.");
      System.out.println("Enter value:");
      val = kb.nextInt();
      System.out.println("Enter suit:");
      suit = kb.next();
         
      try
      {
        System.out.println(val + " "  + suit);
        c1 = new Card(val, suit);
        goodCard = true;
      }
      catch (CardException e)
      {
        System.out.println(c1 + " is a bad card.  Try again:");
        goodCard = false;
      }
    }
    System.out.println(c1.getSuit() + " " + c1.getValue() + " " + c1);
  }

}

/*
Lab 05

Author: Paul LaFollette

Course number: 1968

Revision:
   20181014(TD): added a variable to
                 store a seed for
                 debugging purposes
   20181010(PL): original version

*/


import java.util.Random;

public class Deck extends Holder
{
  private Boolean shuffled;
  private final int TIMES = 1000;
  protected Card ArrayOfShuffledCards[];

  public Deck() throws HolderException, CardException
  {
    super(true);
    this.shuffled = false;
  }

  public Boolean isShuffled()
  {
    return this.shuffled;
  }

  public void shuffle()
  {
    //remove seed as an argument to generate random numbers
    //seed is for debugging purposes only 
    //long seed = 20000000;
    Random ran = new Random();
    Card temp;

    shuffled = true;
    for (int i = 0; i < TIMES; i++)
    {
      int where = ran.nextInt(super.len);        
      temp = super.theHolder[where];
      super.theHolder[where] = super.theHolder[0];
      super.theHolder[0] = temp;
    }
    this.ArrayOfShuffledCards = new Card[52];
    for (int a = 0; a < super.theHolder.length; a++)
    {
      ArrayOfShuffledCards[a] = super.theHolder[a];
    }

 }

  public static void main(String args[]) throws HolderException, CardException
  {
    Deck d = new Deck();
    System.out.println(d);
    d.shuffle();
    System.out.println("\n\n\n" + d);
    Card c = d.removeCard();
    System.out.println(c);
  }
}  

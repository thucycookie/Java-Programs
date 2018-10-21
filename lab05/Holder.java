/*
Lab 05

Author: Paul Lafollette, Thuc Duong

Course number: 1968

Revision:
    20181014(TD): created another variable called tableLen,
made changes to the else condition in the constructor, made changes
to removeCard(), insertCard() methods, added 2 new methods called
removeCardfromTable() and insertCardintoTable(Card c); 

    20181009(PL): original version

*/

public class Holder
{
  private final int SIZE = 52;
  protected Card theHolder[];
  protected int len;
  protected int tableLen;  
  
  public Holder(Boolean fill) throws CardException
  {
    String suits[] = {"C", "D", "H", "S"};
    if (fill)
    {
      this.theHolder = new Card[SIZE];
      this.len = SIZE;
      for (int i = 0; i < SIZE; i++)
      {
        String s = suits[i/13];
        int v = (i % 13) + 2;
        this.theHolder[i] = new Card(v, s);
      }
    }
    else
    {
      this.theHolder = new Card[SIZE]; 
      this.len = 26; //starts out with 26, this is to keep track of hand1 and hand2
      this.tableLen = 0; //starts out with 0, this is to keep track of the table
    }
  }

  public int getLength()
  {
    return this.len;
  }

  public Card removeCard() throws HolderException
  {
    if (this.len < 1)
    {
      throw new HolderException("Removing card from empty Holder");
    }
    Card retval = this.theHolder[0];
    for (int i = 0; i < len-1; i++)
    {
      this.theHolder[i] = this.theHolder[i+1];
    }
    this.len--;
    this.theHolder[this.len] = null; //declares the last element to be null to
                                     //prevent repetition if the hand is lost 
                                     //because hand might be lost many times
                                     //and the for-loop may moves things one element
                                     //forward and still keeps the old elements in
                                     //the back
    return retval;
  }

  public Card removeCardfromTable() throws HolderException
  {
    if (this.tableLen < 0) //do not have to worry since in War.java, we will
                           //have to insert in the table first before removing
                           //anything from it
    {
     throw new HolderException("Removing card from empty table Holder");
    }
    Card retval = this.theHolder[0];
    for (int i = 0; i < tableLen-1; i++)
    {
      this.theHolder[i] = this.theHolder[i+1];
    }
    
    this.tableLen--;
    this.theHolder[this.tableLen] = null; //same null concept for removeCard()
    
    return retval;
  }

  public void insertCard(Card c) throws HolderException
  {
    
    if (len >= SIZE)
    {
      throw new HolderException("Inserting card into full Holder");
    }
    this.theHolder[this.len] = c;
    this.len++;
  } 
  
  public void insertCardintoTable(Card c) throws HolderException
  {
   if(tableLen >= SIZE)
   {
     throw new HolderException("Inserting card into full table Holder");
   } 
    this.theHolder[this.tableLen] = c;
    this.tableLen++;
  }

  public String toString()
  {
    String retval = "";
    for (int i = 0; i < this.len; i++)
    {
      retval += this.theHolder[i] + "\n";
    }
    return retval;
  }
  
  public static void main(String args[]) throws HolderException, CardException
  {
    Holder myDeck = new Holder(true);  
    System.out.println(myDeck);
  }
}

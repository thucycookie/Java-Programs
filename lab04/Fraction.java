/*

Fourth program 

Lab 04

Author: Thuc Duong

Course number: 1968

Revisions:
	20181003(TD):original version
*/

import java.util.Scanner;

//create a Fraction class
//
public class Fraction
{
  private int top;//numerator
  private int bot;//denominater always > 0

  //a constructor that accepts 2 ints as the parameter
  //
  public Fraction(int num, int den)
  {
    if(den == 0)
    {
      System.err.println("Zero denominator.");
      System.exit(1);
    }
    else if (den < 0)
    {
      den = -den;
      num = -num;
    }
    this.top = num;
    this.bot = den;
  }
  
  //a constructor that accepts one int as the parameter, this is called when the  //input from the user is an integer that is represented as int/1 in fraction 
  //in fraction form
  //
  public Fraction(int num)
  {
    this(num, 1);
  } 

  //the default constructor when there is no input from the user
  //
  public Fraction()
  {
    this(0, 1);
  }
  //a getter method to get the numerator
  //
  public int getNumerator()
  {
    return this.top;
  }
  //a getter method to get the denominator
  //
  public int getDenominator()
  {
    return this.bot;
  }
  //a toString method that is called whenever we prints out an object of this 
  //Fraction class
  //
  public String toString()
  {
    return this.top + "/" + this.bot;
  }
  
  //a method to converts both the numerator and the denominator as doubles
  //
  public double asDouble()
  {
    return (double)top / (double)bot;
  }
  //an add method that adds both fraction together
  //
  public Fraction add(Fraction rhs)
  {
    int num = this.top * rhs.bot + this.bot * rhs.top;
    int den = this.bot * rhs.bot;
    return normalize(new Fraction(num, den));
  }
  //a subtraction method that subtracts the first one fraction by the second one
  //
  public Fraction sub(Fraction rhs)
  {
   int num = this.top * rhs.bot - this.bot * rhs.top;
   int den = this.bot * rhs.bot;
   return normalize(new Fraction(num, den));
  }
  //a multiplication method that multiply the first one by the second one
  //
  public Fraction mul(Fraction rhs)
  {
   int num = this.top * rhs.top;
   int den = this.bot * rhs.bot;
   return normalize(new Fraction(num, den));
  }
  //a division method that divides the first one by the second one
  //
  public Fraction div(Fraction rhs)
  {
    Fraction div = new Fraction(rhs.bot, rhs.top);
    return normalize(this.mul(div));
  }
  //a method to compare the first one and the second one
  //
  public String compareTo(Fraction rhs)
  {
    if(this.top * rhs.bot > this.bot * rhs.top)
    {
       return "The first fraction is larger than the second one.";
    }else if(this.top * rhs.bot == this.bot * rhs.top)
    {
       return "The fractions are equal to each other.";
    }else
    {
       return "The second fraction is larger than the first one";
    } 
  }
  //a private method to find the greatest common divisor to reduce the fraction
  //down 
  private static int GCD(Fraction rhs)
  {
    int num = rhs.top; //divisor
    int den = rhs.bot; //dividend
    int remainder = 0;

    while(num != 0)
    {
     remainder = den % num;
     den = num;
     num = remainder; 
    }
    return den;
  }
  private Fraction normalize(Fraction rhs)
  {
    int GCD = GCD(rhs);
    if(GCD > 1)
    {
      rhs.top /= GCD;
      rhs.bot /= GCD;
    }
    return new Fraction(rhs.top, rhs.bot);
  }

  public static void main(String args[])
  {  
     Scanner input_from_user = new Scanner(System.in);
     Scanner input_from_user2 = new Scanner(System.in);
     System.out.println("Enter the numerator of your first fraction.");
     int num_1 = input_from_user.nextInt();
     System.out.println("Enter the denominator of your first fraction.");
     int den_2 = input_from_user.nextInt();
     System.out.println("Enter the numerator of your second fraction.");
     int num_a = input_from_user.nextInt();
     System.out.println("Enter the denominator of your second fraction.");
     int den_b = input_from_user.nextInt();

     System.out.println("Type c to compare two fractions.\nType a to add the two fractions.\nType s to subtract.\nType m to multiply.\nType d to divide.");
     Fraction first = new Fraction(num_1, den_2);
     Fraction second = new Fraction(num_a, den_b);
     String user_choice = input_from_user2.nextLine();
     if(user_choice.compareTo("a") == 0)
     {
       System.out.println("The sum is:");
       System.out.println(first.add(second));
     }else if(user_choice.compareTo("s") == 0 ) //built-in compareTo method for comparing strings
     {
       System.out.println("The subtraction is:");
       System.out.println(first.sub(second));
     }else if(user_choice.compareTo("m") == 0) //built-in compareTo method
     {
       System.out.println("The multiplication is:");
       System.out.println(first.mul(second));
     }else if(user_choice.compareTo("d") == 0) //built-in compareTo method
     {
       System.out.println("The division is: ");
       System.out.println(first.div(second));
     }else if(user_choice.compareTo("c") == 0) //built-in compareTo method
     {
       System.out.println(first.compareTo(second)); //compareTo Instance method
     }else
     {
       System.out.println("Invalid input");
     }
  }

}





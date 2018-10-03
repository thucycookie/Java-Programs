/*
First program

Author: Thuc Duong

Course number: 1968

Revision:

	20180905(TD): original version
 */


import java.util.Scanner ;

public class Add
{
    public static void main(String args[])
    {
	Scanner keyboard = new Scanner(System.in);
	int numA, numB;
	int sum;

	System.out.println("Enter a number:");
	numA = keyboard.nextInt();
	System.out.println("Enter another number:");
	numB = keyboard.nextInt();

	sum = numA + numB;
	System.out.println("The total is " + sum);
    }
}

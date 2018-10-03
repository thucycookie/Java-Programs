/*
Fourth program 

Lab 03

Author: Thuc Duong

Course number: 1968

Revision:
	20180929(TD): original version

Need a while loop for each of the sub-routines that has an else statement that prints out an error message if a user input an Arabic number when using Roman to Arabic conversion or if a user inputs a Roman number when using Arabic to Roman conversion

*/

import java.util.Scanner;
import java.util.HashMap;

public class Roman
{
	//function to convert Roman numerals to Arabic
	//
	public static int Roman_to_Arabic(String inputFromUser)
	{	
		//declare a dictionary that stores each individual Roman number with the corresponding Arabic numerics as its value
		HashMap<String, Integer> myDict = new HashMap<>();
		myDict.put("I", 1);
		myDict.put("V", 5);
		myDict.put("X", 10);
		myDict.put("L", 50);
		myDict.put("C", 100);
		myDict.put("D", 500);
		myDict.put("M", 1000);
		
		//initialize the Arabic number
		//
		int numArabic = 0;

		//a for loop that goes through each individual Roman numeral
		//
		for(int i = 0; i < inputFromUser.length(); i++){
			
			//convert each character to a string because we will look up the numeral in the dictionary and the keys are of String data type
			//
			String c = Character.toString(inputFromUser.charAt(i));
			
			//this runs if it is the last character (or the last Roman numeral) in a string that is consisted of multiple Roman numeral. This prevents the program from throwing an error because we will use an if statement to compare the current Roman numeral with the next Roman numeral later. If we remove this if statement, an out-of-index error will occur
			//
			if(i == inputFromUser.length()-1){

				//if there is only one Roman numeral as an input, this will run and break out of the loop. If this is removed, an out-of-index error will occur
				//
				if(inputFromUser.length() == 1){

				//add the corresponding Arabic value of the Roman numeral to the numArabic variable
				//
					numArabic += myDict.get(c);
					break;
				}

				//the code in here will run if the last character is larger than the one before that
				//it breaks to prevent numArabic from going over the correct Arabic value because somewhere below here, there will be a line that compares the current Roman numeral to the next one, if the next one is larger then the result of that larger next Roman numeral's Arabic value is subtracted to the current Roman numeral's Arabic value. 
				
				if(myDict.get(Character.toString(inputFromUser.charAt(i-1))) < myDict.get(c)){
					break;
			}else{
				//if the last character is not less than the one that is before it, it will add the corresponding Arabic numerical value to numArabic variable
				//	
					numArabic += myDict.get(c);
				
				//System.out.println(numArabic);
				//	
					break;
			}
		}

			//if the next Roman numeral is larger than the current one then we will add the result of: that next larger Roman numeral's Arabic value - the current Roman  numeral's Arabic value to numArabic variable.
			//
			if(myDict.get(c) < myDict.get(Character.toString(inputFromUser.charAt(i+1))) ){
				
				numArabic += myDict.get(Character.toString(inputFromUser.charAt(i+1)))-myDict.get(c);				
				
			}else if(myDict.get(c) > myDict.get(Character.toString(inputFromUser.charAt(i-1)))){
				
				numArabic += 0;
				
				//if the current Roman numeral is larger than the one before that, the math in the previous if statement has been done, so it would be redudant to do it again and makes the result in accurate so we add zero
				//
			}else{

			//if not, just add the corresponding Arabic numerical value to numArabic variable
			//
				numArabic += myDict.get(c); 
				System.out.println(myDict.get(c));
			}

		
		}

		//return value and exit gracefully
		//
		return numArabic;
	}

	// a function to convert Arabic numerals to Roman numerals
	//
	public static String Arabic_to_Roman(int inputFromUser)
	{
		// a dictionary with Arabic numerals with their corresponding Roman numerals
		//
		HashMap<Integer, String> myDict = new HashMap<>();
                myDict.put(1,"I");
                myDict.put(5,"V");
                myDict.put(10,"X");
                myDict.put(50,"L");
                myDict.put(100,"C");
                myDict.put(500,"D");
                myDict.put(1000,"M");
		
		//an array with all the Arabic values of Roman numerals I,V,X,L,C,D,M in increasing order
		//
		int[] arr = {1,5,10,50,100,500,1000};
		
		//a decrement variable to decrement to the lower Arabic value of the arr array 
		//
		int decrement = 6;
		
		//this helps keep track how many Roman numeral would be needed 
		//example: if the Arabic number is 1300 -> it would be 1300 - 1000 = 300 so we will need one M in the Roman numeral, then 300 - 100 = 200, so we add a D in the numeral (now it is MD), then 200 - 100= 100, so we add another D in the numeral (now it is MDD). Keep subtracting from the original Arabic numerical input to reach 0.
		int theThingWeAreSubtractingFrom = arr[decrement];
		
		//initialize the String for return
		//
		String ArabictoRoman = "";
		
		//a while loop that keep subtracting the input until it reaches 0
		//
		while(inputFromUser > 0){

			//if what we are currently subtracting from the original input is negative, we move back one index (in the arr array). We also have to make sure that the decrement is larger than 0.
			if(inputFromUser - theThingWeAreSubtractingFrom < 0 && decrement > 0){
				
				decrement -= 1;
				
				theThingWeAreSubtractingFrom = arr[decrement];
			}else{
			// if not keep subtracting, append the correspoding Roman numeral to the return string 
				
				inputFromUser -= theThingWeAreSubtractingFrom;
				
				ArabictoRoman += myDict.get(theThingWeAreSubtractingFrom);
			}
		}

		//exit gracefully
		//
		return ArabictoRoman;

	}

	public static void main(String args[])
	{	
		//initialize some scanners
		//
		Scanner input_from_user = new Scanner(System.in);
		Scanner input_ATR = new Scanner(System.in);
		Scanner input_RTA = new Scanner(System.in);
		System.out.println("Type 1 to convert from Arabic to Roman\nType 2 to convert from Roman to Arabic\nType 3 to exit the program.");
		int input_a = input_from_user.nextInt();
		
		//a while loop that exits only if the user enters 3
		while(input_a != 3)
		{	
			//calls Arabic to Roman function if it is 1
			// 
			if(input_a == 1){
                        	
				System.out.println("Type your Arabic number");
                        	
				int input_b = input_ATR.nextInt();
                        	
				System.out.println(Arabic_to_Roman(input_b));
                	
			}else if(input_a == 2){
                        	
				System.out.println("Type your Roman number");
                        	
				String input_c = input_RTA.nextLine();
                        	
				//calls Roman to Arabic function if it is 2
				//
				System.out.println(Roman_to_Arabic(input_c));
                	}else{
                        	System.out.println("Invalid input");
                	}
			
			System.out.println("Type 1 to convert from Arabic to Roman\nType 2 to convert from Roman to Arabic\nType 3 to exit the program.");
			
			input_a = input_from_user.nextInt();
		}
		
		if(input_a == 3)
		{
			System.out.println("Have a nice day!");
		}
		
		//exit gracefully
		//
	}
} 

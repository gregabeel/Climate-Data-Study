/*Greg Abeel and Mike Nikouzi
Climate Study
Team 8
12/2/2021
*/


import java.io.*;
import java.util.Scanner;
import java.util.*;				// For Scanner and InputMismatchException
import javax.swing.JOptionPane; //For the JOptionaPane class

public class ParallelArraysGregMikeWork {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String [] args)throws IOException
	{
		final int ARRAY_SIZE = 20;
		double [] temphigh = new double[ARRAY_SIZE];				//Temp Highest
		double [] templow = new double [ARRAY_SIZE];				//Temp Lowest
		//double [] temptobs = new double [ARRAY_SIZE];				//Temp Time of Observation
		String [] date = new String[ARRAY_SIZE];					//Date
		String input;												// String FileName to be inputed
		String [] tokens;											//Tokens to split up data

		File myFile = new File("DateTemp.csv");						//File Name
		Scanner inputFile = new Scanner(myFile);					//scanner to input file name
		try
		{
			//try (//Try to display one too many array elements.
						//myFile = new File("DateTemp.csv");
			//Scanner inputFile = new Scanner(myFile)) {
			//}
			for (int i = 0; i <= templow.length; i++);
			for (int i = 0; i <= temphigh.length; i++);
			//System.out.println(temphigh[i]);
			//System.out.println(templow[i]);
		}

		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Invalid array index exceeds Array Size.");					//catch block to declare the array index was too large
		/* }
		catch (FileNotFoundException e)
		{*/
			System.out.println("The File was not Found, please download file with name DateTemp.csv");
			System.exit(1);
		}




		for (int i = 0; i < temphigh.length; i++)					//If index is less than length of temp high increment
		{

			input = inputFile.nextLine();
			tokens = input.split(",");								//split items in array to tokens seperated by , symbol
			date[i] = tokens[0];									//Date token assignment
			temphigh[i] = Double.parseDouble(tokens[1]);			//high temp token assignment
			templow[i] = Double.parseDouble(tokens[2]);				//low temp token assignment



			System.out.println("line " + i + " from DateTemp.csv: " + input					//System output for temp high, low, and time of observation
			+ " date: " + date[i] + " Hightemp: " + temphigh[i] + " LowTemp: " + templow[i] /*+ " temptobs " + temptobs[i]*/);
		}

		double highest = getHighest(temphigh);						//assigns temp highest to double
		System.out.println("The highest daily average temperature is: " + highest);		//prints out "the highest temp is temp

		int index0 = getIndex(temphigh, highest);					//assign index to int variable

		System.out.println("The highest average daily temperature is: " + highest + " occurred on: " + date[index0]);
		//double average = getAvg(hightemp);

		//System.out.println("The average temp is: " + average);

		/*double highest = getAvg(temphigh);
		System.out.println ("The avg highest temp is: " + highest);

		int index0 = getIndex(temphigh, highest);*/



		double lowest = getLowest(templow);									//assigns temp highest to double
		System.out.println("The lowest daily average temperature is: " + lowest);		//prints out "the highest temp is temp

		int index1 = getIndex(templow, lowest);								//assign index to int variable

		System.out.println("The Lowest daily average temperature is: " + lowest + " occurred on: " + date[index1]);
		//double average = getAvg(hightemp);

		//System.out.println("The average temp is: " + average);



	}//end of main method

	public static int getIndex(double[] r, double v) {				//index = 0, if index is lower than r length then continue increment +1
		for (int i = 0; i < r.length; i++){							// if value is equal to index return index
			if (v == r[i])
				return i;

		}
		return -1;
	}
	public static double getHighest(double [] r) {					//get highest array
		double highest = r[0];										//
		for (int i = 1; i < r.length; i++)
		{
			if (r[i] > highest) {
				highest = r[i];
			}
		}
		return highest;
	}

	public static double getLowest(double [] r) {					//get lowest array
			double lowest = r[0];
			for (int i = 2; i < r.length; i++)
			{
				if (r[i] < lowest) {
					lowest = r[i];
				}
			}
			return lowest;
	}



	public static double getAvg(double [] r)						//getavg array
	{
		double total = 0.0;

		for (int i = 0; i < r.length; i++)							//if index is lower
		{
			total += r[i];
		}

		double average = total/r.length;
		return average;

	}

}// end of Array class
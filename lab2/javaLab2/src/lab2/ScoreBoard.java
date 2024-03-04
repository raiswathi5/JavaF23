//Swathi Rai, Andrew-id: swathir
package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreBoard {
	StringBuilder fileContent = new StringBuilder();
	int[] scoreSums;
	double[] scoreAverages;
	int grandTotal;
	double grandAverage;
	
	//DO NOT not change this method
	/**  initiates the program and runs all other methods in a sequence
	 **/
	public static void main(String[] args) {
		ScoreBoard sb = new ScoreBoard();
		sb.readFile("Scores.txt");
		sb.computeScores();
		sb.printReport();
	}
	
	//complete this method
	/** readFile() method reads the file data into fileContent. 
	 * It preserves the line-breaks.
	 * @param fileName
	 */
	public void readFile(String fileName) {
		//write your code here
		Scanner input = null;
		try {
            input = new Scanner(new File (fileName));
    		while (input.hasNext()) {
    			fileContent.append(input.nextLine() + "\n");
    		}
		} catch (FileNotFoundException e) {              
		            e.printStackTrace();
		}
		
	}
	
	//complete this method
	/** computeScores() takes the fileContent and calculates four things
	 * 1. For each player, the total score in scoreSums array
	 * 2. For each player, the average score in scoreAverages array
	 * 3. The grand total of all scores in grandTotal
	 * 4. The grand average of all scores in grandAverage
	 */
	public void computeScores() {
		//write your code here
		String[] rows = fileContent.toString().split("\n");
		scoreSums = new int[rows.length];
		scoreAverages = new double[rows.length];
		for(int i=0; i<rows.length; i++) {
			String[] cols = rows[i].split(",");
			for(int j=0; j<cols.length; j++) {
				scoreSums[i] += Integer.parseInt(cols[j].toString().trim());
			}
			scoreAverages[i] = (double) scoreSums[i] / cols.length;
			grandTotal += scoreSums[i];
		}
		
		grandAverage = (double) grandTotal / rows.length;
	}
	
	//complete this method
	/** printReport() prints the output as shown in the problem statement
	 *  */
	public void printReport() {
		//write your code here
		for(int i=0; i<scoreSums.length; i++) {
			System.out.println("Player" + (i+1) + ". Total score = " + scoreSums[i] + "   Average score = " + scoreAverages[i]);
		}
		System.out.println("-----------------------------------");
		System.out.println("Grand total score" + grandTotal + ". Grand total average = " + grandAverage);
	}
}

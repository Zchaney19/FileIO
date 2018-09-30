/**
 * ScoreTrakker class
 * Reads from a file and outputs the student name and scores
 * 
 * @author Zachary Aparicio
 * @author Zachary Chaney
 * 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	/**
	 * Method which reads in the name and scores of students from a file.
	 * 
	 * @param fileName The name of the input file name
	 * @throws FileNotFoundException
	 */
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		
		String nextName = "", nextLine = "";
		int nextScore=0;
		//Here we loop through the file which should contain the student name followed by their score as an int.
		//	We throw a FileNotFoundException if the file cannot be opened and catch a NumberFormatException if
		//	the score is not an int.
		while(in.hasNextLine()) {
			try {
				nextName = in.nextLine();
				nextLine = in.nextLine();
				nextScore = Integer.parseInt(nextLine);
				studentList.add(new Student(nextName,nextScore));
			} catch (NumberFormatException e){
				System.out.println("Incorrect format for " + nextName + " not a valid score: " + nextLine + "\n");
			}
			
		}
		in.close();
	}
	
	/**
	 * Method which displays the students and their scores in increasing order of their scores.
	 */
	public void printInOrder() {
		Collections.sort(studentList);
		System.out.println("Student Score List");
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("");
	}
	
	/**
	 * Method which calls loadDataFromFile() and printInOrder().
	 * If the file cannot open we catch the FileNotFoundException here and display an error message.
	 * 
	 * @throws FileNotFoundException
	 */
	public void processFiles() throws FileNotFoundException {
		for(String str:files) {
			try {
				loadDataFromFile(str);
				printInOrder();
				studentList.clear();
			} catch(FileNotFoundException e) {
				System.out.println("Can't open file: " + str);
			}
			
		}
	}
	
	/**
	 * Main method which creates a new ScoreTrakker object and processes the files in the array files.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker scores = new ScoreTrakker();
		scores.processFiles();
	}
}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		
		String nextName = "", nextLine = "";
		int nextScore=0;
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
	
	public void printInOrder() {
		Collections.sort(studentList);
		System.out.println("Student Score List");
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("");
	}
	
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
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker scores = new ScoreTrakker();
		scores.processFiles();
	}
}

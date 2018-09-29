import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker{
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while(in.hasNextLine()) {
			String nextName = in.nextLine();
			int nextScore = Integer.parseInt(in.nextLine());
			studentList.add(new Student(nextName,nextScore));
		}
		in.close();
	}
	
	public void printInOrder() {
		Collections.sort(studentList);
		for(Student s:studentList) {
			System.out.println(s);
		}
	}
	
	public void processFiles() throws FileNotFoundException {
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker scores = new ScoreTrakker();
		scores.processFiles();
	}
}

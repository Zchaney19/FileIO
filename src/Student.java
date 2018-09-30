/**
 * Student class
 * Contains a private name and score for each student.
 * 
 * @author Zachary Aparicio
 * @author Zachary Chaney
 * 
 */

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	/**
	 * Constructor for the Student class.
	 * 
	 * @param name
	 * @param score
	 */
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	/**
	 * compareTo() method is used to make Student comparable and uses the score to apply an order.
	 */
	@Override
	public int compareTo(Student o) {
		if(this.score > o.score) {
			return 1;
		}
		return -1;
	}

	/**
	 * toString() method to generate output similar to the example.
	 */
	@Override
	public String toString() {
		return name + " " + score;
	}
	
}

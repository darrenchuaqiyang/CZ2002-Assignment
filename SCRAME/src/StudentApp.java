/*
 * Documentation 
 * https://www.tutorialspoint.com/java/java_documentation.htm
 * 
 * List explanation
 * https://www.geeksforgeeks.org/list-interface-java-examples/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	// GET METHOD
	
    /*
     * Retrieve the list of all students
     * @return student object list
     */
    public List<Student> getStudentList(){
        return studentList;
    }
    
    /*
     * Prints out the student IDs and student names
     */
    public void printStudentList(){
        System.out.printf(" ID\tStudent Name\n");
        for(int i = 0; i<studentList.size(); i++){
            System.out.printf("%6d\t%-30s\n", studentList.get(i).getStudentID(), studentList.get(i).getStudentName().toUpperCase());
        }
    }
    
    /*
     * Retrieve student information by student ID
     * @param student identification number
     * @return student object
     */
    public Student getStudentByID(int studentID) {
    	for (int i=0; i<studentList.size(); i++) {
    		Student tempStudent = studentList.get(i);
    		if (tempStudent.getStudentID() == studentID)
    			return tempStudent;
    	}
    	return null;
    }
    
    public Student getStudentByName(String studentName) {
    	for (int i=0; i<studentList.size(); i++) {
    		Student tempStudent = studentList.get(i);
    		if (tempStudent.getStudentName() == studentName.toUpperCase())
    			return tempStudent;
    	}
    	return null;
    }
      
    // SET METHOD
    
    /*
     * Add student information into the database
     * @param student identification number, student name
     */
    public void addStudent(int studentID, String studentName) {
    	studentList.add(new Student(studentID, studentName));
    }
    
    // CHECKING METHOD
    
    /*
     * Check whether the given student identification number exists in the database
     * @param student identification number
     * @return true if studentID exists
     */
    public boolean isExistingStudentID(int studentID) {
    	for (int i=0; i<studentList.size(); i++) {
    		if (studentList.get(i).getStudentID() == studentID)
    			return true;
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	int choice;
    	int student_id;
    	String student_name;
        
        StudentApp student = new StudentApp();
    	Scanner sc = new Scanner(System.in);

        System.out.println("(1) Add a student ");
        System.out.println("(2) Here are a list of students ");
        System.out.println("(3) Register student for a course (this include registering for Tutorial/Lab classes)");
        System.out.println("(4) Check available slot in a class (vacancy in a class)");
        System.out.println("(5) Print student list by lecture, tutorial or laboratory session for a course.");
        System.out.println("(6) Enter course assessment components weightage");
        System.out.println("(7) Enter coursework mark");
        System.out.println("(8) Enter exam mark");
        System.out.println("(9) Print course statistics ");
        System.out.println("(10) Print student transcript");
        System.out.println("(11) Exit");

        do {
            System.out.println();
            System.out.print("Enter the number of your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: // Add a student
                		System.out.println("Student ID: ");
                		student_id = sc.nextInt();
                		System.out.print("Student Name: \n");
                		sc.nextLine();
                		student_name = sc.nextLine();
                		student.addStudent(student_id, student_name);
                		break;
                		
                case 2: // Show list of students
                		student.printStudentList();
                		break;
                		
                case 3: // Check through student ID if the student is an existing student
                		System.out.println("Student ID: ");
                		student_id = sc.nextInt();
                		if (student.isExistingStudentID(student_id) == true)
                			System.out.println(student_id + " is an existing student!");
                		else
                			System.out.println(student_id + " does not exist!");
                		break;
                		
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                case 9: break;
                case 10: break;
                case 11: break;
                case 12: break;
            }

        } while (choice < 12);
    	
    }
}

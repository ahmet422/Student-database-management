package studentDatabaseApplication;

import java.util.Scanner;

public class Students {
	private String name;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private double balance;
	private final String[] courses = {"History 101", "Mathematics 101", "English 101", "Chemistry 101","Computer Science 101"};
	private String appliedCourses;
	private static final int costOfCourse = 600;
	private static int id = 1000;
	// constructor
	public Students() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Student First Name: ");
		this.name = scan.nextLine();
		System.out.println("Student Last Name: ");
		this.lastName = scan.nextLine();
		System.out.printf("\nPlease select the grade year for %s %s\n1 - Freshmen \n2 - Sophomore \n3 - Junior \n4 - Senior \nPlease enter the number : ", getName(),getLastName());
		this.gradeYear = scan.nextInt();
		setStudentId();
		appliedCourses="";
		
	}
	// generate an ID
	private String setStudentId() {
		this.id++;
		this.studentId = getGradeYear() + ""+ this.id;
		return studentId;
	}
	// enroll in courses
	public void enroll() {
	
		enrollToClasses();
		System.out.println("Course selection is done. Your new balance is: " + getBalance());
		showSelectedCourses();
	}
	/**
	 * 
	 */
	private void enrollToClasses() {
		int number = 0;
		int choice = 0 ;
		
		Scanner scan = new Scanner(System.in);
		while(choice!=6) {
			System.out.println("***************COURSES****************");
			for (String course : this.courses) {
				number++;
				System.out.println(number + " " + course);
			}
			number=0;
			System.out.println("6 Exit");
			System.out.println("************************************");
			System.out.println("Please select one course or select EXIT ");
			choice = scan.nextInt();
			if(choice==6) {
				System.out.println("You selected exit");
				break;
			}
			this.appliedCourses = getAppliedCourses() + choice;
			this.balance = getBalance()- costOfCourse;
			System.out.println("You have chosen " + courses[choice-1]);
			
		}
	}
	/**
	 * 
	 */
	private void showSelectedCourses() {
		System.out.println("You have selected : ");
		for (int i = 0; i < getAppliedCourses().length(); i++) {
			int selectedCourse = Character.getNumericValue(getAppliedCourses().charAt(i));
		    System.out.println(courses[selectedCourse-1]);
     	}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getGradeYear() {
		return gradeYear;
	}
	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAppliedCourses() {
		return appliedCourses;
	}
	public void setAppliedCourses(String appliedCourses) {
		this.appliedCourses = appliedCourses;
	}
	
	// pay tuition
	public void payTuition() {
		double paymentAmount = 0.00;
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to pay?");
		paymentAmount = scan.nextDouble();
		this.balance = getBalance() + paymentAmount;
		System.out.println("Thank you for the payment, your new balance is:" + getBalance());
		
	}
	// show status
	public void showStatus() {
		System.out.println("----------------------\nStudent name: " + getName() + " " + getLastName() + "\nStudent ID: " + getStudentId());
		showSelectedCourses();
		System.out.println("The total balance is: " + getBalance());
	}
}

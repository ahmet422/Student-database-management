package studentDatabaseApplication;

import java.util.Scanner;

public class StudentDatabaseAppTest {

	public static void main(String[] args) {
		
		Students[] studentArray = createStudents(3);
        
      for (Students student : studentArray) {
		showMenu(student);
	}
      for (Students student : studentArray) {
  		student.showStatus();
  	}
		System.out.println("All is done.");
	}

	/**
	 * @return
	 */
	private static Students[] createStudents(int n) {
        Students[] studentArray = new Students[n];
        for (int i = 0; i < n; i++) {
			studentArray[i]= new Students();
		}
		return studentArray;
	}

	private static void showMenu(Students student) {
		int selected = 0;
		while(selected!=4) {
			Scanner scan = new Scanner(System.in);
			System.out.println("---------------------------------------------");
			System.out.println(student.getName() + " " + student.getLastName());
			System.out.println("\nChoose what would you like to do: \n1 Select Cources \n2 Pay Tuition \n3 View Status \n4 Exit");
			selected = scan.nextInt();
			if(selected==1)
				student.enroll();
			if(selected==2)
				student.payTuition();
			if(selected==3)
				student.showStatus();	
			
		}
	}

}

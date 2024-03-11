package studentManagementSystem;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		StudentManagementSystem s1 = new StudentManagementSystem();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(choice != 5) {
			 	System.out.println("\n┌────────────────────────────────────────────────┐");
	            System.out.println("│            Student Management System           │");
	            System.out.println("├────────────────────────────────────────────────┤");
	            System.out.println("│ 1. Add Student                                 │");
	            System.out.println("│ 2. Remove Student                              │");
	            System.out.println("│ 3. Search Student                              │");
	            System.out.println("│ 4. Display All Students                        │");
	            System.out.println("│ 5. Exit                                        │");
	            System.out.println("└────────────────────────────────────────────────┘");
	            System.out.println();
	            System.out.print("Enter the choice : ");
	            choice = sc.nextInt();
	            sc.nextLine();
	            switch(choice) {
	            case 1:
		            {
		            	System.out.print("Enter the Name : ");
		            	String name =sc.nextLine();
		            	System.out.print("Enter the Roll number : ");
		            	int rollNo = sc.nextInt();
		            	sc.nextLine();
		            	System.out.print("Enter the Standard : ");
		            	int standard = sc.nextInt();
		            	sc.nextLine();
		            	int scienceMark = 0;
		            	int mathMark = 0;
		            	int englishMark = 0;
		            	do {
							try {
								System.out.print("Enter the Science Marks(?/100) : ");
								scienceMark = sc.nextInt();
								sc.nextLine();
								System.out.print("Enter the Math Marks(?/100) : ");
								mathMark = sc.nextInt();
								sc.nextLine();
								System.out.print("Enter the English Marks(?/100) : ");
								englishMark = sc.nextInt();
								sc.nextLine();
								if(scienceMark>100 || scienceMark<0 || mathMark>100 || mathMark<0 || englishMark>100 || englishMark<0) {
									throw new InvalidMarks();
								}
							} catch (InvalidMarks I) {
								// TODO Auto-generated catch block
								System.out.println(I.getMessage());
							}
						} while (scienceMark>100 || scienceMark<0 || mathMark>100 || mathMark<0 || englishMark>100 || englishMark<0);
						Student student = StudentFactory.createStudent(name, rollNo, standard, scienceMark, mathMark, englishMark);
		            	s1.insertData(student);
		            }
		            break;
	            case 2:
		            {
		            	System.out.print("Enter the Roll number : ");
		            	int rollNo = sc.nextInt();
		            	sc.nextLine();
		            	s1.deleteData(rollNo);
		            }
		            break;
	            case 3:
		            {
		            	System.out.print("Enter the Roll number : ");
		            	int rollNo = sc.nextInt();
		            	sc.nextLine();
		            	s1.searchData(rollNo);
		            }
		            break;
	            case 4:
		            {
		            	s1.displayAllData();
		            }
		            break;
	            case 5:
		            {
		            	System.out.println("System Exited Successfully...!");
		            	s1.closeConnection();
		            }
		            break;
		        default:
			        {
			        	System.out.println("Invalid Input...!");
			        }
			        break;
	            }
	            
		}
		
		sc.close();	
	}

}

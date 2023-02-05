package Studentmanagement;


import java.util.Scanner;

public class StudentMgtSystem {

	Scanner in = new Scanner(System.in); // Create a Scanner object

	String n;
	String D;
	int r;


	public static void main(String[] args) {

		StudentMgtSystem demo = new StudentMgtSystem();
		int choice;
		do {
			choice = demo.menu();
			demo.process(choice);
		} while (choice != 0);


	}

	public int menu() {
		System.out.println();
		System.out.println("** MENU **");
		System.out.println("Before adding the student check Table Is present In Database Or Not???");
		System.out.println("Add Student.........1");
		System.out.println("Search Student......2");
		System.out.println("Update Student Details...3");
		System.out.println("Delete Student...4");
		System.out.println("Table creating With Name (StudentMang).....5");
		System.out.println("List of all student.....6");
		System.out.println("Delete Table Name (StudentMang).....7");
		System.out.println("Exit.............0");
		System.out.println("------------------");
		System.out.println("Please enter your choice:");

		int input = in.nextInt();
		return input;
	}

	public void process(int choice) {

		StudentMgtService service = new StudentMgtService();


		switch (choice) {

			case 1:
				//add a student


				//to get all the student values
				Scanner s = new Scanner(System.in);

				System.out.println("enter the name");
				n = s.nextLine();

				System.out.println("enter the roll");
				r = s.nextInt();

				s.nextLine();
				System.out.println("enter the Department");
				D = s.nextLine();

				Student student = new Student(n, r, D);

				service.save(student);


				break;

			case 2:
				//search a student by rollNo

				System.out.println("student ko search karenge");

				Scanner r1 = new Scanner(System.in);
				System.out.println("enter roll to search");
				int rolltosearch = r1.nextInt();

				service.find(rolltosearch);


				break;


			case 3:

				//update a student data

				Scanner s3 = new Scanner(System.in);
				System.out.println("enter the rollno to update");
				int rollNumbertoupdate = s3.nextInt();

				System.out.println("enter the name to update");
				s3.nextLine();
				String n3 = s3.nextLine();

				System.out.println("enter the department");
				String depart = s3.nextLine();

				Student obj3 = new Student(n3, rollNumbertoupdate, depart);

				service.update(obj3);


				break;


			case 4:

				//to delete a student

				System.out.println("student ko delete karenge");

				Scanner s4 = new Scanner(System.in);
				System.out.println("enter the rollno to delete");
				int rollNumbertodelete = s4.nextInt();

				Student obj4 = new Student(n, r, D);

				service.delete(rollNumbertodelete);


				break;
			case 5:

				// Table Creating.......
				Scanner s5 = new Scanner(System.in);
				StudentMgtDAL obj = new StudentMgtDAL();

				System.out.println(" Table Name With Field is : StudentMang( rollNo number,Name varchar(20), dept varchar(20))");
				obj.tableCreate();


				break;

			case 6:
				// List all student
				service.Allstudentlist();

				break;

			case 7:
				// Drop table
		     	service.DeleteTable();

				break;

			case 0:
				// exiting
				System.out.println("Thanks for using");
				break;

			default:
				break;
		}

	}

}

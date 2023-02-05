package Studentmanagement;

import java.sql.*;
import java.util.Scanner;


public class StudentMgtDAL {

	public void save(Student obj) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");

			String tempname = obj.getName();
			String tempdepart = obj.getDepartment();
			int temproll = obj.getRollNumber();

			PreparedStatement psmt = con.prepareStatement("insert into StudentMang values(?,?,?)");


			psmt.setInt(1, temproll);
			psmt.setString(2, tempname);
			psmt.setString(3, tempdepart);


			psmt.executeUpdate();
			System.out.println("Student Added Successfully");


		} catch (Exception a) {

			System.out.println("Table Not Exist Kindly Create Table By Pressing 5 Do other Task");
		}

	}


	public void find(int rollNumber) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");


			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from StudentMang where  ROLLNO=" + rollNumber  );

			while (rs.next()) {
				int tempRoll = rs.getInt(1);
				String tempName = rs.getString(2);
				String tempDept = rs.getString(3);

				System.out.println(" Student roll is :  " + tempRoll);
				System.out.println(" Student name is : " + tempName);
				System.out.println(" Student dept is : " + tempDept);

			}

			rs.close();
			System.out.println("Search Sucessfully Done!!!!");


		} catch (Exception a) {

			System.out.println("exception" + a);
		}


	}


	public void update(Student obj3) {


		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");

			String s = "update StudentMang set name =? , dept=? where rollno=?";

			int tempRoll = obj3.getRollNumber();
			String UpdatedName = obj3.getName();
			String updatedDept = obj3.getDepartment();

			PreparedStatement psmt = con.prepareStatement(s);
			psmt.setString(1, UpdatedName);
			psmt.setString(2, updatedDept);
			psmt.setInt(3, tempRoll);

			psmt.executeUpdate();
			con.close();

			System.out.println("Student Name And Dept Is Updated!!!!");


		} catch (Exception a) {

			System.out.println(a);
		}


	}


	public void delete(int rollNumbertodelete) {


		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");

			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("delete  from StudentMang where rollno=" + rollNumbertodelete);

			rs.close();
			con.close();
			System.out.println(" row Deleted sucessfully !!!!!");

		} catch (Exception a) {

			System.out.println("exception" + a);
		}


	}

	public void tableCreate() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");


			Statement smt = con.createStatement();
			smt.execute("create table StudentMang( rollNo number,Name varchar(20), dept varchar(20))");

			System.out.println("Table Created Sucessfully !!!!!");

		} catch (Exception e) {

			System.out.println("Table Already Exist Please Insert Data Into Table");
		}


	}


	public void Allstudentlist() {


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");

			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from StudentMang");


			System.out.println("Student Details  !!!!!!\n");
			while (rs.next()) {

				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				String dept = rs.getString(3);

				System.out.println("The rollno is :" + rollno);
				System.out.println("The  Name :" + name);
				System.out.println("The  dept :" + dept);
				System.out.println("\n..............................");

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}


	public void DeleteTable() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "cdac123");


			Statement smt = con.createStatement();
			smt.execute("drop table StudentMang");

			System.out.println("Table Deleted Sucessfully !!!!!");

		} catch (Exception e) {

			System.out.println("Table Already Exist Please Insert Data Into Table");
		}


	}


}



package Studentmanagement;

public class StudentMgtService {


	public void save(Student obj)
	{
		//save this info in DB/variable
		StudentMgtDAL dal = new StudentMgtDAL();

		dal.save(obj);

	}

	public void find(int rollNumber) {
		StudentMgtDAL dal = new StudentMgtDAL();
		 dal.find(rollNumber);

	}

	public void update(Student obj1) {
		StudentMgtDAL dal = new StudentMgtDAL();
		dal.update(obj1);

	}


	public void delete(int rollNumbertodelete) {

		StudentMgtDAL dal = new StudentMgtDAL();
		 dal.delete(rollNumbertodelete);

	}


	public void Allstudentlist() {

		StudentMgtDAL dal = new StudentMgtDAL();
		 dal.Allstudentlist();

	}


public void DeleteTable(){

	StudentMgtDAL dal = new StudentMgtDAL();
	dal.DeleteTable();
}





}

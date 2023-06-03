package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ApplicationCentrale extends UDPServer{
	ArrayList<Employee> ListEmployee;


	public ApplicationCentrale() {
		ListEmployee = new ArrayList<Employee>();
		new Thread(this).start();

	}

	@Override
	void Reception(Timeclock elem) {
		addPointage(elem);
	}

	public ArrayList<Employee> getEmployees() {
 		return ListEmployee;

	}
	public Employee getEmployee(int id) {
		for (Employee empl : ListEmployee)
		{
			if (empl.getId() == id)
			{
				return empl;
			}
		}
		return null;
   }	
	
	public void addEmployee(Employee param) {
		ListEmployee.add(param);

	}

	
	public void deleteEmployee(Employee param) {
		ListEmployee.remove(param);
	}

	
	public void addPointage(Timeclock param) {
		Employee empl = getEmployee(param.getterId());
		empl.addTimeclock(param);

	}

	
	public Timeclock[] getTimeclock() {
		return null;
	}

	
	public float calculateTimeCredit(Employee param) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void saveData() {
		try (FileOutputStream fos = new FileOutputStream("listData");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(ListEmployee);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public void getData() {
		try (FileInputStream fis = new FileInputStream("listData");
		    ObjectInputStream ois = new ObjectInputStream(fis);) {

		  ListEmployee = (ArrayList<Employee>) ois.readObject();
		} catch (IOException ioe) {
		  ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
		  System.out.println("Class not found");
		  c.printStackTrace();
		}

	}

}

package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Application implements ApplicationCentrale {
	ArrayList<Employee> ListEmployee;
	ArrayList<Timeclock> ListTimeclock;
	int Nbemployee;
	int Nbtimeclock;

	public Application() {
		Nbemployee = 0;
		Nbtimeclock = 0;
		ListEmployee = new ArrayList<Employee>();
		ListTimeclock = new ArrayList<Timeclock>();
	}

	@Override
	public ArrayList<Employee> getEmployee() {
 		return ListEmployee;

	}

	@Override
	public void addEmployee(Employee param) {
		ListEmployee.add(param);
		Nbtimeclock++;

	}

	@Override
	public void deleteEmployee(Employee param) {
		ListEmployee.remove(param);
	}

	@Override
	public void addPointage(Timeclock param) {
		// TODO Auto-generated method stub

	}

	@Override
	public Timeclock[] getTimeclock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateTimeCredit(Employee param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
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
	@Override
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

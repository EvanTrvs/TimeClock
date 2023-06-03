package packaging;

import java.io.Serializable;
import java.util.ArrayList;

import serial.WorkSession;
import serial.Timeclock;

public class Employee implements Serializable{
	private int UUID;

	private String Name;

	private String FirstName;

	private WorkSession currentSession;
	private ArrayList<WorkSession> historique;
	
	private ArrayList<Shedule> list = new ArrayList<>(7);

	private static int nbEmployee;
	
	public Employee() {
		UUID = 0;
		Name = "None";
		FirstName = "None";
		nbEmployee = getNbEmployee() + 1;
	}
	
	public Employee( String name, String firstname ) {
		UUID = 0;
		this.setName(name);
		this.setFirstname(firstname);
		nbEmployee = getNbEmployee() + 1;
	}
	
	@Override
	protected void finalize() {
		nbEmployee = getNbEmployee() - 1;
	}
	
	public int getUUID() {
		return UUID;
	}

	public void setUUID(int uUID) {
		UUID = uUID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFirstname() {
		return FirstName;
	}

	public void setFirstname(String firstname) {
		FirstName = firstname;
	}

	public static int getNbEmployee() {
		return nbEmployee;
	}

	public Shedule getShedule(Day day) {
		try {
			return list.get(Day.GetId(day));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setList(Shedule shedule,Day day) {
		list.set(Day.GetId(day), shedule);
	}

	public void addTimeclock(Timeclock timeclock)
	{
		if (currentSession != null)
		{
			currentSession.setEnd(timeclock.getTime());
			historique.add(currentSession);
			currentSession = null;
		}
		else
		{
			currentSession = new WorkSession(timeclock.getTime());
		}
	}
}

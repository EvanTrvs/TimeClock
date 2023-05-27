package packaging;

import java.util.ArrayList;

public class Employee {
	private int UUID;

	private String Name;

	private String FirstName;

	//private JavaDateTime timeCredit;
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setList(Shedule shedule,Day day) {
		list.set(Day.GetId(day), shedule);
	}
}

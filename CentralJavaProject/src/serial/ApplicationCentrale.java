package serial;

import java.util.ArrayList;

public interface ApplicationCentrale {
	ArrayList<Employee> getEmployee();
	void addEmployee(Employee param);
	void deleteEmployee(Employee param);
	
	void addPointage(Timeclock param);
	Timeclock[] getTimeclock();
	
	float calculateTimeCredit(Employee param);
	
	void saveData();
	void getData();
}

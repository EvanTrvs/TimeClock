package serial;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Random;

public class Employee implements Serializable{
	
	static ArrayList<Integer> listId = new ArrayList<>();
	private String name;
	private static final long serialVersionUID = 1L;
	private int id;
	private WorkSession currentSession;
	private ArrayList<WorkSession> historique;
	public Employee(){
		currentSession = null;
		historique = new ArrayList<WorkSession>();
		return;
	}
	public Employee(String name){
		this.setName(name);
		currentSession = null;
		historique = new ArrayList<WorkSession>();
		id = getNewId();
		return;
	}
	public void finalize()
	{
		listId.remove(this.id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkSession getCurrentSession() {
		return currentSession;
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
	
	public int GetTimeWorkInWeek(int num_week)
	{
		//LocalDate today = LocalDate.now();
		//int num_week= today.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		int sum = 0;
		for (WorkSession worksession : historique)
		{
			if (worksession.getWeek() == num_week)
			{
				try {
					sum +=worksession.getDuration();
				} catch (Exception e) {
				}
			}
		}
		return sum;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNewId()
	{
		Random rn = new Random();
		int id = 0;
		while (listId.contains(id))
		{
			id = rn.nextInt(1000);
		}
		return id;
	}
}
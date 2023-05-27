package serial;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private String name;
	private static final long serialVersionUID = 1L;

	public Employee(){
		return;
	}
	public Employee(String name){
		this.setName(name);
		return;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package serial;

public class main {
	public static void main(String[] args) {
		//new Thread(new UDPServerHello()).start();
		//new Thread(new UDPClientHello()).start();
		ApplicationCentrale test = new ApplicationCentrale();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		
		test.addEmployee(emp1);
		test.addEmployee(emp3);
		test.addEmployee(emp2);
		test.saveData();
		test.getData();
		
	}
}

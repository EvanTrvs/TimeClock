package serial;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ApplicationTest {
	@Test
	public void filegestion()
	{
		//new Thread(new UDPServerHello()).start();
		//new Thread(new UDPClientHello()).start();
		Application test = new Application();
		Employee emp1 = new Employee("Michel");
		Employee emp2 = new Employee("Michelle");
		Employee emp3 = new Employee("Samuel");
		
		test.addEmployee(emp1);
		test.addEmployee(emp3);
		test.addEmployee(emp2);
		test.saveData();
		
		Application test2 = new Application();
		test2.getData();
		test2.getEmployee();
		
		ArrayList<Employee> l1,l2;
		l1 = test.getEmployee();
		l2= test2.getEmployee();
		assertEquals(l1.size(),l2.size());
		for (int i= 0;i<l1.size();i++)
		{
			assertEquals(l1.get(i).getName(),l2.get(i).getName());
		}
		assertEquals(1,1);
	}
}

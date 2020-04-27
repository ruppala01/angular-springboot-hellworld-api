package own.practice.angularspringboothellworldapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import own.practice.angularspringboothellworldapi.model.Employee;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/employees")
public class EmployeeController {
	private List<Employee> employees = createList();

	@GetMapping( produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}
	
	@DeleteMapping(value="{id}")
	public List<Employee> deleteEmployee(@PathVariable int id) {
		Employee deletedEmp=null;
		for (Employee emp:employees) {
			if((Integer.parseInt(emp.getEmpId())==id)) {
				employees.remove(emp);
				deletedEmp=emp;
				break;
			}
		}
		return employees;
	}
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		employees.add(emp);
		return emp;
	}
	
	private static List<Employee> createList() {
		
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}
}
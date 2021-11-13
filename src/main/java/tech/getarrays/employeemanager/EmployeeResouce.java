package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    private  final EmployeeService employeeService;

    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")Long id){
        Employee employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee newEmployee1 = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newEmployee1,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee>upadteEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}

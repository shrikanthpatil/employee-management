package controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import entity.Employee;
import service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return service.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}


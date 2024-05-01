package net.javaguides.employeeservice.controller;


import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {

        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);


        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long id)
    {
        ApiResponseDto apiResponseDto= employeeService.getEmployeeById(id);

        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

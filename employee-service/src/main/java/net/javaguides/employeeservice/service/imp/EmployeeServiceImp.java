package net.javaguides.employeeservice.service.imp;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;
    //private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto emloyeeDto) {

        Employee employee=new Employee(

                emloyeeDto.getId(),
                emloyeeDto.getFirstName(),
        emloyeeDto.getLastName(),
        emloyeeDto.getEmail(),
                emloyeeDto.getDepartmentCode()
        );

        Employee saveEmployee=employeeRepository.save(employee);

        EmployeeDto saveEmployeeDto=new EmployeeDto(

                saveEmployee.getId(),
                saveEmployee.getFirstName(),
        saveEmployee.getLastName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );

        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {


        Employee employee = employeeRepository.findById(employeeId).get();

      /* ResponseEntity<DepartmentDto> responseEntity =restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(),
                DepartmentDto.class);

       DepartmentDto departmentDto=responseEntity.getBody();*/


   /*   DepartmentDto departmentDto= webClient.get()
               .uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
               .retrieve()
               .bodyToMono(DepartmentDto.class)
               .block();*/

       DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto= new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto=new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}

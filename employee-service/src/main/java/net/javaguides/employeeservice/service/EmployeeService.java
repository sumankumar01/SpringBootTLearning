package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService
{
    EmployeeDto saveEmployee(EmployeeDto emloyeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);
}

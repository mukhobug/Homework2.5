package com.example.homework2dot5.services;

import com.example.homework2dot5.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.homework2dot5.services.Constants.*;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    void shouldReturnMinSalaryEmployee() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_1ST);
        assertEquals(EMPLOYEE_1ST, out.minSalary(1));
    }

    @Test
    void shouldReturnMaxSalaryEmployee() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_3RD);
        assertEquals(EMPLOYEE_3RD, out.maxSalary(1));
    }

    @Test
    void shouldReturnListOfEmployeesInDepartment() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_3RD);
        assertThat(LIST_OF_1ST_DEPARTMENT).isEqualTo(out.allEmployeeInDepart(1));
    }

    @Test
    void shouldReturnMapOfEmployeesByDepartments() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_3RD);
        assertThat(MAP_OF_GROUPED_EMPLOYEES).isEqualTo(out.allEmployeeByDepart());
    }

    @Test
    public void shouldThrowNotFoundExceptionMin() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_1ST);
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(3));
    }

    @Test
    public void shouldThrowNotFoundExceptionMax() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_1ST);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(3));
    }

    @Test
    void shouldReturnEmptyListOfEmployeesInDepartment() {
        when(employeeServiceMock.allEmployee()).thenReturn(MAP_OF_EMPLOYEE_1ST);
        assertEquals(emptyList(), out.allEmployeeInDepart(3));
    }

}
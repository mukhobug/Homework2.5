package com.example.homework2dot5.services;

import com.example.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework2dot5.exceptions.EmployeeNotFoundException;
import com.example.homework2dot5.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.homework2dot5.services.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl out;

    @BeforeEach
    public void setUp(){
        out = new EmployeeServiceImpl();
    }

    @Test
    void shouldReturnMapEmployeeBook() {
        out.addEmployee("bob", "first", 111, 1);
        assertEquals(MAP_OF_EMPLOYEE_1ST, out.allEmployee());
    }

    @Test
    void shouldAddEmployee() {
        assertEquals(EMPLOYEE_1ST, out.addEmployee("bob", "first", 111, 1));
    }

    @Test
    void shouldRemoveEmployee() {
        out.addEmployee("bob", "first", 111, 1);
        assertEquals(EMPLOYEE_1ST, out.removeEmployee("bob", "first"));
    }

    @Test
    void shouldFindEmployee() {
        out.addEmployee("bob", "fIRST", 111, 1);
        assertEquals(EMPLOYEE_1ST, out.findEmployee("bob", "first"));
    }

    @Test
    public void shouldThrowBadNameException(){
        assertThrows(InvalidInputException.class,
                () -> out.addEmployee("bob1", "last2", 100, 1));
    }

    @Test
    public void shouldThrowExistException(){
        out.addEmployee("bob", "first", 100, 1);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee("bob", "first", 100, 1));
    }

    @Test
    public void shouldThrowNotFoundException(){
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee("bob", "first"));
    }
}
package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String sayHello(){
        return "Hello welcome here";
    }

    @GetMapping("/address")
    public String Address(){
        return "Nimzari,Shirpur";
    }

    @GetMapping("/service")
    public String service(){
        return "Import/Export";
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResponseEntity.ok("Employee Data saved Successfully");
    }

    @PutMapping("update/{empId}")
    public ResponseEntity<String> update(int empId,Employee employee){
        employeeService.update(empId, employee);
        return ResponseEntity.ok("Data Updated Successfully");
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeService.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteById(){
        employeeService.deleteAll();
        return ResponseEntity.ok("All data Gone...");
    }
}

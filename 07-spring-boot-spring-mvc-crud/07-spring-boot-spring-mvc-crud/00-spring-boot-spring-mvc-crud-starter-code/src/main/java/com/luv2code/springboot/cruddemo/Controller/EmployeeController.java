package com.luv2code.springboot.cruddemo.Controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //inject the service
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String Employeelist(Model model)
    {
        //get the employee ffrom table
        List<Employee> theEmployee = employeeService.findAll();

        //add it to model Attribute
        model.addAttribute("employees",theEmployee);

        return "employees/list-employees";
    }

    @GetMapping("showFormToAdd")
    public String showForm(Model theModel)
    {
        //Bind the class data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employees",theEmployee);

        return "employees/Employee-form";
    }

    //Prepopulate the form
    @GetMapping("/showFormToUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int theId , Model model)
    {
        //get the emmployee
        Employee theEmployee = employeeService.findById(theId);

        //set the employee in model
        model.addAttribute("employees" , theEmployee);

        //send over to our form
        return "employees/Employee-form";
    }

    @PostMapping("/save")
    public String savedata(@ModelAttribute("employees") Employee theEmployee)
    {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/deleteId")
    public String deleteuser(@RequestParam("employeeId") int theId)
    {
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
}

package com.hellokoding.account.web;   
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import com.hellokoding.account.model.Employee;
import com.hellokoding.account.model.Role;
import com.hellokoding.account.service.EmployeeService;
import com.hellokoding.account.service.SecurityService;
import com.hellokoding.account.service.UserService;  

@Controller  
public class EmployeeController {  
       
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    SecurityService securityService;
 
    @RequestMapping("/employeeform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Employee());
    	return "employeeform"; 
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("employee") Employee emp){  
    	employeeService.save(emp);  
        return "redirect:/viewemployee";//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewemployee")  
    public String viewemp(Model m){  
    	Set<Role> roles = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getRoles();
        List<Employee> list=employeeService.getAllEmployees();  
        boolean isAdmin = false;
        ArrayList<Long> roleIds = new ArrayList<Long>();
        roles.forEach(role -> {
        	Long id = role.getId();
        	roleIds.add(id);
        });
        for (int i = 0; i < roleIds.size(); i++) {
        	if (roleIds.get(i) == 2L) {
        		isAdmin = true;
        	}
        }
        m.addAttribute("list",list);
        m.addAttribute("isAdmin",isAdmin);
        return "viewemployee";  
    }  
  
    @RequestMapping(value="/editemployee/{id}")  
    public String edit(@PathVariable long id, Model m){  
    	Employee emp=employeeService.findById(id);  
        m.addAttribute("emp",emp);
        return "employeeeditform";  
    }  
 
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("employee") Employee emp){  
    	employeeService.save(emp);  
        return "redirect:/viewemployee";  
    }  

    @RequestMapping(value="/deleteemployee/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id){  
    	Employee emp=employeeService.findById(id);
    	employeeService.delete(emp);  
        return "redirect:/viewemployee";  
    }   
}  
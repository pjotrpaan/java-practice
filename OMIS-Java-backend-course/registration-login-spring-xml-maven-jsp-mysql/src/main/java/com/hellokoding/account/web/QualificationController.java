package com.hellokoding.account.web;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellokoding.account.model.Employee;
import com.hellokoding.account.model.Qualification;
import com.hellokoding.account.repository.EmployeeRepository;
import com.hellokoding.account.repository.QualificationDao;
import com.hellokoding.account.service.EmployeeService;
import com.hellokoding.account.service.QualificationService;  
@Controller 
@RequestMapping("qualification")
public class QualificationController {  
	
	@Autowired
	QualificationDao qualificationDao;
    
    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    QualificationService qualificationService;
    
    @Autowired
    EmployeeRepository employeeRepository;
 
    @RequestMapping("/qualificationform/{id}")  
    public String showform(@PathVariable long id, Model m){  
    	Employee emp=employeeService.findById(id); 
    	m.addAttribute("command", new Qualification());
    	m.addAttribute("emp", emp);
    	return "qualificationform"; 
    }  

    @RequestMapping(value="/qualificationform/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Qualification qual){  
    	qualificationService.save(qual);  
        return "redirect:/qualification/viewqualification/" + qual.getEmployeeId();//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewqualification/{id}")  
    public String viewemp(@PathVariable long id, Model m){  
        List<Qualification> list=qualificationService.getAllQualifications();  
        m.addAttribute("list",list);
        
        Employee emp=employeeService.findById(id);
        m.addAttribute("emp", emp);
        return "viewqualification";  
    }

    @RequestMapping(value="/deletequalification/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id){  
    	Qualification qual=qualificationService.findById(id);  
    	long empId = qual.getEmployeeId();
    	qualificationService.delete(id);
        return "redirect:/qualification/viewqualification/" + empId;  
    }   
}  
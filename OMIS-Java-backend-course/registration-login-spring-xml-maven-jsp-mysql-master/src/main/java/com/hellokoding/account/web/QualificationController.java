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
import com.hellokoding.account.repository.EmployeeDao;
import com.hellokoding.account.repository.QualificationDao;
import com.hellokoding.account.service.EmployeeService;  
@Controller 
@RequestMapping("qualification")
public class QualificationController {  
    @Autowired  
    QualificationDao dao;//will inject dao from xml file  
    
    @Autowired
    EmployeeDao employeeDao;
    
    @Autowired
    EmployeeService employeeService;
 
    @RequestMapping("/qualificationform/{id}")  
    public String showform(@PathVariable long id, Model m){  
    	Employee emp=employeeService.findById(id);
    	m.addAttribute("command", new Qualification());
    	m.addAttribute("emp", emp);
    	return "qualificationform"; 
    }  

    @RequestMapping(value="/qualificationform/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Qualification emp){  
        dao.save(emp);  
        return "redirect:/qualification/viewqualification/" + emp.getEmployeeId();//will redirect to viewemp request mapping  
    }  

    @RequestMapping("/viewqualification/{id}")  
    public String viewemp(@PathVariable long id, Model m){  
    	Employee emp = employeeService.findById(id);
        List<Qualification> list=emp.getQualifications();  
        m.addAttribute("list",list);
        m.addAttribute("emp", emp);
        return "viewqualification";  
    }  
  
    @RequestMapping(value="/editqualification/{id}")  
    public String edit(@PathVariable long id, Model m){  
    	Employee emp=employeeService.findById(id);
        Qualification qual=dao.getQualificationById(id);  
        m.addAttribute("command",qual);
        m.addAttribute("emp", emp);
        return "qualificationeditform";  
    }  
 
//    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
//    public String editsave(@ModelAttribute("emp") Qualification emp){  
//        dao.update(emp);  
//        return "redirect:/viewemp";  
//    }  

    @RequestMapping(value="/deletequalification/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable long id){  
    	Qualification qual=dao.getQualificationById(id);  
        long empId = qual.getEmployeeId();
//        dao.delete(id);
        return "redirect:/qualification/viewqualification/" + empId;  
    }   
}  
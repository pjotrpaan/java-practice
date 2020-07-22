package com.hellokoding.account.repository;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.hellokoding.account.model.Employee;  
  
public class EmployeeDao {  
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}
	public int update(Employee p){  
	    String sql="update employee set firstName='"+p.getFirstName()+"', lastName='"+p.getLastName()+"',personalId='"+p.getPersonalId()+"',designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from Employee where id="+id+"";  
	    return template.update(sql);  
	}  
	public Employee getEmployeeById(int id){  
		System.out.println(id);
	    String sql="select * from employee where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));  
	}  
	public List<Employee> getEmployees(){  
	    return template.query("select * from employee",new RowMapper<Employee>(){  
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
	        	System.out.println(rs);
	        	Employee e=new Employee();  
	            e.setId(rs.getInt(1));  
	            e.setFirstName(rs.getString(2));  
	            e.setLastName(rs.getString(3));  
	            e.setPersonalId(rs.getString(5)); 
	            e.setDesignation(rs.getString(4));
	            e.setDate(rs.getString(7));
	            e.setArchived(rs.getBoolean(6));
	            System.out.println(e);
	            return e;  
	        }  
	    });  
	}
}  
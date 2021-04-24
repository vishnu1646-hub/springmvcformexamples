package com.techouts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/empform")
	public String showform(Model model) {
		model.addAttribute("command", new Employee());
		return "empform.jsp";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp) {
		employeeDao.save(emp);
		return "redirect:/viewemp.jsp";
	}

	@RequestMapping("/viewemp")
	public String viewemp(Model model) {
		List<Employee> list = employeeDao.getEmployees();
		model.addAttribute("list", list);
		return "viewemp.jsp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = employeeDao.getEmployeeById(id);
		m.addAttribute("command", emp);
		return "empeditform.jsp";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Employee emp) {
		employeeDao.update(emp);
		return "redirect:/viewemp.jsp";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		employeeDao.delete(id);
		return "redirect:/viewemp.jsp";
	}
}

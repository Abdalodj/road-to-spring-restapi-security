package sn.devkiller.restapi.app.Controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.devkiller.restapi.app.Models.Student;
import sn.devkiller.restapi.app.Services.StudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	

  @GetMapping
	public Iterable<Student> index() {
		return studentService.getStudents();
	}

	@PostMapping
	public Object store(@RequestBody @Valid Student student, BindingResult bResult) {
		if (bResult.hasErrors()) {
			return bResult.getAllErrors();
		}
		return studentService.save(student);
	}

	@PutMapping(path = "{id}")
	public Object update(
		@RequestBody
		@Valid Student student,
		BindingResult bResult
	) {
		if (bResult.hasErrors()) {
			return bResult.getAllErrors();
		}
		return studentService.save(student);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") Long id) {
		studentService.delete(id);
	}
  
}

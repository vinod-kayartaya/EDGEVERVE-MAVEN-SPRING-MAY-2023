package com.infosys.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.model.CustomResponse;
import com.infosys.model.EmployeeDTO;
import com.infosys.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<EmployeeDTO> handleGetAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> handleGetOne(@PathVariable Integer id) {
		EmployeeDTO employee = service.getById(id);
		if (employee == null) {
			CustomResponse err = new CustomResponse("No data found for id " + id, new Date());
			return ResponseEntity.status(404).body(err);
		}

		return ResponseEntity.ok(employee);
	}
}

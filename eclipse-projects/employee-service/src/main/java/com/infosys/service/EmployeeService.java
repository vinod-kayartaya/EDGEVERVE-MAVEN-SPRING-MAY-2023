package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Employee;
import com.infosys.model.EmployeeDTO;
import com.infosys.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	private EmployeeDTO toDto(Employee entity) {
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public EmployeeDTO getById(Integer id) {
		Optional<Employee> result = repo.findById(id);

		if(result.isEmpty()) {
			return null;
		}
		
		return toDto(result.get());
	}
	
	public List<EmployeeDTO> getAll(){
		return repo.findAll()		// List<Employee>
				.stream()			// Stream<Employee>
				.map(this::toDto)	// Stream<EmployeeDTO>
				.toList();			// List<EMployeeDTO>
	}
}







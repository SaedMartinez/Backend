package com.sami.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sami.empleados.exceptions.ResourceNotFoundException;
import com.sami.empleados.model.Empleado;
import com.sami.empleados.repository.IEmpleadoRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200/")
public class EmpleadoController {

	@Autowired
	private IEmpleadoRepository erepo;

	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados() {
		return erepo.findAll();
	}
	
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado emp) {
		return erepo.save(emp);
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id){
		Empleado emp= erepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No encontrams el ID : "+ id));
		return ResponseEntity.ok(emp);
	}
	
}

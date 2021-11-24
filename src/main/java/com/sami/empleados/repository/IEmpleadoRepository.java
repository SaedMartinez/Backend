package com.sami.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sami.empleados.model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long>{

}

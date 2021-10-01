package com.dh.clinicaOdontologicaTI.repository;

import com.dh.clinicaOdontologicaTI.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

    @Query("from Paciente p where p.apellido like %:apellido%")
    List<Paciente> buscarPacienteByApellido(@Param("apellido") String apellido);

}

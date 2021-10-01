package com.dh.clinicaOdontologicaTI.repository;

import com.dh.clinicaOdontologicaTI.entity.Odontologo;
import com.dh.clinicaOdontologicaTI.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long>{

}

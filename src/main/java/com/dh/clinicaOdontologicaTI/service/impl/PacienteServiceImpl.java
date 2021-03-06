package com.dh.clinicaOdontologicaTI.service.impl;

import com.dh.clinicaOdontologicaTI.entity.Paciente;
import com.dh.clinicaOdontologicaTI.repository.IPacienteRepository;
import com.dh.clinicaOdontologicaTI.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PacienteServiceImpl implements IService<Paciente> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        paciente.setFechaIngreso(new Date());
        pacienteRepository.save(paciente);
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }


    public List<Paciente> buscarPacienteByApellido(String apellido){
        List<Paciente> pacientes = pacienteRepository.buscarPacienteByApellido(apellido);
        return pacientes;
    }

}

package com.dh.clinicaOdontologicaTI.service.impl;

import com.dh.clinicaOdontologicaTI.entity.Turno;
import com.dh.clinicaOdontologicaTI.repository.ITurnoRepository;
import com.dh.clinicaOdontologicaTI.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements IService<Turno> {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno guardar(Turno turno) {
        turnoRepository.save(turno);
        return turno;
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Turno> buscarPorId(Long id) {
        return turnoRepository.findById(id);
    }

}

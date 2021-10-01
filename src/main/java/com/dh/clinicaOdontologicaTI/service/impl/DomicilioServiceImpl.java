package com.dh.clinicaOdontologicaTI.service.impl;

import com.dh.clinicaOdontologicaTI.entity.Domicilio;
import com.dh.clinicaOdontologicaTI.repository.IDomicilioRepository;
import com.dh.clinicaOdontologicaTI.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements IService<Domicilio> {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Domicilio> listar() {
        return domicilioRepository.findAll();
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Domicilio> buscarPorId(Long id) {
        return domicilioRepository.findById(id);
    }

}

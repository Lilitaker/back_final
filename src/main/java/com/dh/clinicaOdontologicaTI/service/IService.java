package com.dh.clinicaOdontologicaTI.service;

import com.dh.clinicaOdontologicaTI.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IService<T>{

    List<T> listar();

    T guardar(T t);

    void eliminar(Long id);

    Optional<T> buscarPorId(Long id);

}

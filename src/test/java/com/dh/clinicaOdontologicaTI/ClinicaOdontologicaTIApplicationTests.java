package com.dh.clinicaOdontologicaTI;

import com.dh.clinicaOdontologicaTI.entity.Domicilio;
import com.dh.clinicaOdontologicaTI.entity.Odontologo;
import com.dh.clinicaOdontologicaTI.entity.Paciente;
import com.dh.clinicaOdontologicaTI.service.impl.OdontologoServiceImpl;
import com.dh.clinicaOdontologicaTI.service.impl.PacienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClinicaOdontologicaTIApplicationTests {

    @Autowired
    OdontologoServiceImpl odontologoService;
    @Autowired
    PacienteServiceImpl pacienteService;

    @Test
    void contextLoads() {

        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Vasquez");
        odontologo.setNombre("Liliana");
        odontologo.setMatricula(7890);

        odontologoService.guardar(odontologo);

        Collection<Odontologo> odontologos = odontologoService.listar();
        boolean resultado = odontologos.size() > 0 && odontologos.size()<2;

        assertTrue(resultado);

    }

    @Test
    public void test() {

        Domicilio domicilio = new Domicilio();
        domicilio.setProvincia("Bogotá");
        domicilio.setLocalidad("San Cristobal");
        domicilio.setCalle("Julio");
        domicilio.setNumero("20");

        Paciente paciente = new Paciente();
        paciente.setDomicilio(domicilio);
        paciente.setNombre("Marina");
        paciente.setApellido("Saiz");
        paciente.setDni("56987458");

        pacienteService.guardar(paciente);

        Collection<Paciente> pacientes = pacienteService.listar();

        boolean resultado = pacientes.size()>0;

        assertTrue(resultado);

    }

}



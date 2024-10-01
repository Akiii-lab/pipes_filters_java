package com.datos;

import java.util.ArrayList;

import filtros.FiltroAtencion;
import filtros.FiltroPrioridadCitas;
import filtros.FiltroPrioridadUrg;
import filtros.FiltroSeparacionUrg;

public class Main {

    public static void main(String[] args) {

        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan", "Perez", 12345678, 30, "M", Triaje.LEVE, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Maria", "Gomez", 87654321, 45, "F", Triaje.MODERADO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Luis", "Martinez", 34567890, 60, "M", Triaje.CRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Ana", "Fernandez", 45678901, 25, "F", Triaje.MUYCRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Carlos", "Lopez", 56789012, 50, "M", Triaje.HIPERCRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Laura", "Garcia", 67890123, 35, "F", Triaje.LEVE, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Pedro", "Sanchez", 78901234, 55, "M", Triaje.MODERADO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Elena", "Diaz", 89012345, 40, "F", Triaje.CRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Santiago", "Vazquez", 90123456, 33, "M", Triaje.MUYCRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Lucia", "Jimenez", 12345098, 2, "F", Triaje.HIPERCRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Diego", "Castro", 23456109, 29, "M", Triaje.LEVE, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Sofia", "Molina", 34567012, 37, "F", Triaje.MODERADO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Tomas", "Romero", 45678123, 43, "M", Triaje.CRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Valeria", "Torres", 56789098, 26, "F", Triaje.MUYCRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Jorge", "Mendez", 67890109, 58, "M", Triaje.HIPERCRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Isabel", "Ortiz", 78901201, 48, "F", Triaje.LEVE, Atencion.URGENCIA));
        pacientes.add(new Paciente("Hector", "Guerrero", 89012398, 6, "M", Triaje.MODERADO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Marta", "Alvarez", 90123409, 44, "F", Triaje.CRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Roberto", "Navarro", 12345012, 28, "M", Triaje.MUYCRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Patricia", "Ruiz", 23456123, 9, "F", Triaje.HIPERCRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Gonzalo", "Silva", 34567098, 9, "M", Triaje.LEVE, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Raquel", "Cortes", 45678109, 53, "F", Triaje.MODERADO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Oscar", "Reyes", 56789001, 31, "M", Triaje.CRITICO, Atencion.CITA_PROGRAMADA));
        pacientes.add(new Paciente("Andrea", "Moreno", 67890198, 27, "F", Triaje.MUYCRITICO, Atencion.URGENCIA));
        pacientes.add(new Paciente("Alberto", "Hernandez", 78901209, 14, "M", Triaje.HIPERCRITICO, Atencion.CITA_PROGRAMADA));
    
        //separacion de citas y urgencias
        FiltroAtencion filtroAtencion = new FiltroAtencion();
        filtroAtencion.filtrar(pacientes);

        //ordenar las citas y enviar la informacion por un tubo
        Tubo prioridadCitas = new Tubo(new FiltroPrioridadCitas());
        ArrayList<Paciente> citas = prioridadCitas.transfer(filtroAtencion.FiltroCitas());

        //separar la urgencia del adulto mayor de las demas
        FiltroSeparacionUrg filtroSeparacionUrg = new FiltroSeparacionUrg();
        filtroSeparacionUrg.filtrar(filtroAtencion.FiltroUrgencias());

        Tubo prioridadUrgencias = new Tubo(new FiltroPrioridadUrg());
        ArrayList<Paciente> urgenciasx = prioridadUrgencias.transfer(filtroSeparacionUrg.FiltroUrgencias());

        Tubo adultomayor = new Tubo(new FiltroPrioridadUrg());
        ArrayList<Paciente> urgadultomayor = adultomayor.transfer(filtroSeparacionUrg.FiltroAdultomayor());

        //imprimir resultados
        System.out.println("////////////////////////////////////////////////Citas: ////////////////////////////////////////////////");
        for (Paciente p : citas) {
            System.out.println("****************************");
            System.out.println("Nombre completo: " + p.getNombre() + " " + p.getApellido());
            System.out.println("Documento: " + p.getDocumento());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Sexo: " + (p.getSexo().equals("M") ? "Masculino" : "Femenino"));
            System.out.println("Triaje: " + p.getTriaje());
            System.out.println("Atención: " + p.getAtencion());
            System.out.println("****************************\n");
        }

        System.out.println("////////////////////////////////////////////////Urgencias: ////////////////////////////////////////////////");
        for (Paciente p : urgenciasx) {
            System.out.println("****************************");
            System.out.println("Nombre completo: " + p.getNombre() + " " + p.getApellido());
            System.out.println("Documento: " + p.getDocumento());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Sexo: " + (p.getSexo().equals("M") ? "Masculino" : "Femenino"));
            System.out.println("Triaje: " + p.getTriaje());
            System.out.println("Atención: " + p.getAtencion());
            System.out.println("****************************\n");
        }

        System.out.println("////////////////////////////////////////////////Urgencias Adulto mayor: ////////////////////////////////////////////////");
        for (Paciente p : urgadultomayor) {
            System.out.println("****************************");
            System.out.println("Nombre completo: " + p.getNombre() + " " + p.getApellido());
            System.out.println("Documento: " + p.getDocumento());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("Sexo: " + (p.getSexo().equals("M") ? "Masculino" : "Femenino"));
            System.out.println("Triaje: " + p.getTriaje());
            System.out.println("Atención: " + p.getAtencion());
            System.out.println("****************************\n");
        }
    }
}

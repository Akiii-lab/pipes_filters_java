package com.datos;

import java.util.ArrayList;

import filtros.Filtro;

public class Tubo {
    private Filtro filtro;

    public Tubo(Filtro filtro) {
        this.filtro = filtro;
    }

    public ArrayList<Paciente> transfer(ArrayList<Paciente> pacientes) {
        return this.filtro.filtrar(pacientes);
    }
}

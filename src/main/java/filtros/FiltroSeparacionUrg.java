package filtros;

import java.util.ArrayList;

import com.datos.Paciente;

public class FiltroSeparacionUrg implements Filtro {

    private ArrayList<Paciente> adultomayor = new ArrayList<>();
    private ArrayList<Paciente> Urgencias = new ArrayList<>();
    @Override
    public ArrayList<Paciente> filtrar(ArrayList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            if (paciente.getEdad() >= 60) {
                adultomayor.add(paciente);
            }else
                Urgencias.add(paciente);
        }
        return null;
    }
    public ArrayList<Paciente> FiltroUrgencias(ArrayList<Paciente> Urgencias) {
        return Urgencias;
    }
    public ArrayList<Paciente> FiltroAdultomayor(ArrayList<Paciente> adultomayor) {
        return adultomayor;
    }
}

package filtros;

import java.util.ArrayList;

import com.datos.Paciente;

public class FiltroAtencion implements Filtro {

    private ArrayList<Paciente> Urgencias = new ArrayList<>();
    private ArrayList<Paciente> Citas = new ArrayList<>();

    @Override
    public ArrayList<Paciente> filtrar(ArrayList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            switch (paciente.getAtencion()) {
                case CITA_PROGRAMADA -> Citas.add(paciente);
                case URGENCIA -> Urgencias.add(paciente);
            }
        }
        return null;
    }

    public ArrayList<Paciente> FiltroCitas(ArrayList<Paciente> pacientes) {
        return Citas;
    }

    public ArrayList<Paciente> FiltroUrgencias(ArrayList<Paciente> pacientes) {
        return Urgencias;
    }
}

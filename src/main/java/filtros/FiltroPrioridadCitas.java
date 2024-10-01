package filtros;

import java.util.ArrayList;

import com.datos.Paciente;

public class FiltroPrioridadCitas implements Filtro {

    @Override
    public ArrayList<Paciente> filtrar(ArrayList<Paciente> pacientes) {

        ArrayList<Paciente> niños = new ArrayList<>();
        ArrayList<Paciente> adulto = new ArrayList<>();
        ArrayList<Paciente> Citas = new ArrayList<>();

        for (Paciente paciente : pacientes) {

            if (paciente.getEdad() <= 15) {
                niños.add(paciente);
            } else {
                adulto.add(paciente);
            }
        }

        Citas.addAll(niños);
        Citas.addAll(adulto);
        return Citas;        
    }
}

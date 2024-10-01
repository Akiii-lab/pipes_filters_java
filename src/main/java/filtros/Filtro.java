package filtros;

import java.util.ArrayList;

import com.datos.Paciente;

public interface Filtro {
    ArrayList<Paciente> filtrar(ArrayList<Paciente> pacientes); 
}

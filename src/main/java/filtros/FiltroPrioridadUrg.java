package filtros;

import java.util.ArrayList;

import com.datos.Paciente;

public class FiltroPrioridadUrg implements Filtro{

    @Override
    public ArrayList<Paciente> filtrar(ArrayList<Paciente> Urgencias) {
        ArrayList<Paciente> UrgenciasLeve = new ArrayList<>();
        ArrayList<Paciente> UrgenciasModerada = new ArrayList<>();
        ArrayList<Paciente> UrgenciasCritica = new ArrayList<>();
        ArrayList<Paciente> UrgenciasMuyCritica = new ArrayList<>();
        ArrayList<Paciente> UrgenciasHiperCritica = new ArrayList<>();
        ArrayList<Paciente> UrgenciasAux = new ArrayList<>();
        for(Paciente paciente : Urgencias){
            switch (paciente.getTriaje()) {
                case LEVE -> UrgenciasLeve.add(paciente);
                case MODERADO -> UrgenciasModerada.add(paciente);
                case CRITICO -> UrgenciasCritica.add(paciente);
                case MUYCRITICO -> UrgenciasMuyCritica.add(paciente);
                case HIPERCRITICO -> UrgenciasHiperCritica.add(paciente);
                default -> throw new AssertionError();
            }
        }
        UrgenciasAux.addAll(UrgenciasHiperCritica);
        UrgenciasAux.addAll(UrgenciasMuyCritica);
        UrgenciasAux.addAll(UrgenciasCritica);
        UrgenciasAux.addAll(UrgenciasModerada);
        UrgenciasAux.addAll(UrgenciasLeve);
        return UrgenciasAux;
    }
}

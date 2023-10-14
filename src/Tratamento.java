import java.util.ArrayList;

public class Tratamento {
    private int dias;
    private Tarefa tarefas;
    private String medicamento;
    private String estilo;

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Tarefa getTarefas() {
        return tarefas;
    }

    public void setTarefas(Tarefa tarefas) {
        this.tarefas = tarefas;
    }

    public String getMedicamentos() {
        return medicamento;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamento = medicamentos;
    }

    public Tratamento(int dias, Tarefa tarefas, Medicamento medicamentos, String estilo) {
        this.dias = dias;
        this.tarefas = tarefas;
        this.medicamento = String.valueOf(medicamentos);
        this.estilo = estilo;
    }
}
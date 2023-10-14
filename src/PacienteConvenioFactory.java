public class PacienteConvenioFactory implements PacienteFactory {

    @Override
    public Paciente criarPaciente(String nome, String idade, String CPF, String medicoResponsavel, boolean alergia, boolean deficienciaFisica, boolean deficienciaPsico, boolean usaMedicamento, PlanoStrategy tratamentoStrategy) {
        return Paciente.getInstance(nome, idade, CPF, medicoResponsavel, alergia, deficienciaFisica, deficienciaPsico, usaMedicamento, tratamentoStrategy);
    }
}

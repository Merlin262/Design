public interface PacienteFactory {

    Paciente criarPaciente(String nome, String idade, String CPF, String medicoResponsavel, boolean alergia, boolean deficienciaFisica, boolean deficienciaPsico, boolean usaMedicamento, PlanoStrategy tratamentoStrategy);
}

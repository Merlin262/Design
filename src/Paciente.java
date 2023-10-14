public class Paciente extends Pessoa {
    private String nome;
    private String idade;
    private String CPF;
    private String medicoResponsavel;
    private boolean alergia;
    private boolean defienciaFisica;
    private boolean deficienciaPsico;
    private boolean UsaMedicamento;
    private static Paciente instancia;

    private PlanoStrategy planoStrategy;

    public void receberTratamento() {
        planoStrategy.aplicarPlano();
    }

    // Construtor privado para evitar a criação de instâncias a partir de fora da classe.
    private Paciente(String nome, String idade, String CPF, String medicoResponsavel, boolean alergia, boolean defienciaFisica, boolean deficienciaPsico, boolean UsaMedicamento) {
        super(nome, idade);
        this.planoStrategy = planoStrategy;
        this.CPF = CPF;
    }

    // Método estático para obter a instância única da classe.
    public static Paciente getInstance(String nome, String idade, String CPF, String medicoResponsavel, boolean alergia, boolean defienciaFisica, boolean deficienciaPsico, boolean UsaMedicamento, PlanoStrategy tratamentoStrategy) {
        if (instancia == null) {
            instancia = new Paciente(nome, idade, CPF, medicoResponsavel, false, false, false, false);
        }
        return instancia;
    }

    // Métodos de acesso aos atributos


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getIdade() {
        return idade;
    }

    @Override
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(String medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public boolean isDefienciaFisica() {
        return defienciaFisica;
    }

    public void setDefienciaFisica(boolean defienciaFisica) {
        this.defienciaFisica = defienciaFisica;
    }

    public boolean isDeficienciaPsico() {
        return deficienciaPsico;
    }

    public void setDeficienciaPsico(boolean deficienciaPsico) {
        this.deficienciaPsico = deficienciaPsico;
    }

    public boolean isUsaMedicamento() {
        return UsaMedicamento;
    }

    public void setUsaMedicamento(boolean usaMedicamento) {
        UsaMedicamento = usaMedicamento;
    }


    public static Paciente getInstancia() {
        return instancia;
    }

    public static void setInstancia(Paciente instancia) {
        Paciente.instancia = instancia;
    }

    public PlanoStrategy getPlanoStrategy() {
        return planoStrategy;
    }

    public void setPlanoStrategy(PlanoStrategy planoStrategy) {
        this.planoStrategy = planoStrategy;
    }


}

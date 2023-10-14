public class Medico extends Pessoa{
    private String CRM;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Medico(String nome, String idade, String CRM) {
        super(nome, idade);
        this.CRM = CRM;
    }

}

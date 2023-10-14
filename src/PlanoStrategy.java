// Interface para definir diferentes estratégias de tratamento
public interface PlanoStrategy {

    String estilo = null;
    void aplicarPlano();

    Medicamento medicamento1 = new Medicamento("Curitybina");
    Medicamento medicamento2 = new Medicamento("Metoprololtartrat");
    Medicamento medicamento3 = new Medicamento("Felodipinratiopharm");
}



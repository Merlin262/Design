// Implementações específicas de estratégias de tratamento
public class PlanoFisioterapia implements PlanoStrategy {

//    Medicamento medicamento1 = new Medicamento("Curitybina");
    Medicamento medicamento2 = new Medicamento("Metoprololtartrat");
    Medicamento medicamento3 = new Medicamento("Felodipinratiopharm");

    public void aplicarPlano() {
        System.out.println("Será realizado plano com fisioterapia.");
        System.out.println("Com medicamento: " + medicamento1.getNome());
    }


}

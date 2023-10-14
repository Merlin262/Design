import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

public class Interface {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner leitura = new Scanner(System.in);

        String nome;
        String idade;
        String CPF;
        while (true) {

            System.out.println("Digite seu nome: ");
            nome = leitura.nextLine();
            System.out.println("Digite sua idade: ");
            idade = leitura.nextLine();
            System.out.println("Digite seu CPF: ");
            CPF = leitura.nextLine();

            int idadeInt = Integer.parseInt(idade);

            if (nome.isEmpty() || idade.isEmpty() || CPF.isEmpty()) {
                System.out.println("Por favor, preencha todos os campos corretamente.");
            }

            Medico medico1 = new Medico("Doutor João das Couves", "53", "12331412-34");
            Medico medico2 = new Medico("Doutor Paulo Matias", "57", "23423556-34");
            Medico medico3 = new Medico("Doutor Pedro Lauro", "62", "234512312-74");

            ArrayList<String> medicos = new ArrayList<>();
            medicos.add(medico1.getNome());
            medicos.add(medico2.getNome());
            medicos.add(medico3.getNome());

            for (int i = 0; i < 3; i++) {
                System.out.println((i + 1) + " - " + medicos.get(i));
            }

            String medicoSelecionado = null;

            System.out.println("Escolha seu médico: ");
            int escolha = leitura.nextInt();

            if (escolha == 1) {
                System.out.println("CRM: " + medico1.getCRM());
                System.out.println("O médico selecionado foi: " + medico1.getNome());
                medicoSelecionado = medico1.getNome();
            } else if (escolha == 2) {
                System.out.println("CRM: " + medico2.getCRM());
                System.out.println("O médico selecionado foi: " + medico2.getNome());
                medicoSelecionado = medico2.getNome();
            } else if (escolha == 2) {
                System.out.println("CRM: " + medico3.getCRM());
                System.out.println("O médico selecionado foi: " + medico3.getNome());
                medicoSelecionado = medico3.getNome();
            }

            PlanoStrategy fisioterapia = new PlanoFisioterapia();
            PlanoStrategy medicacao = new PlanoTerapeutico();

            //singleton implementado para apenas uma instancia de Paciente
            //Paciente paciente = Paciente.getInstance(nome, idade, CPF, medicoSelecionado, false, false, false, false, null);
            System.out.println("Possui convenio médico? 1 - sim; 2- Não");
            int convenio = leitura.nextInt();

            Paciente paciente;
            // padrão de projeto Factory Method
            if (convenio==1) {
                PacienteParticularFactory factoryParticular = new PacienteParticularFactory();
                paciente = factoryParticular.criarPaciente(nome, idade, CPF, medicoSelecionado, false, false, false, false, null);
            }else {
                PacienteConvenioFactory factoryConvenio = new PacienteConvenioFactory();
                paciente = factoryConvenio.criarPaciente(nome, idade, CPF, medicoSelecionado, false, false, false, false, null);
            }

            paciente.setMedicoResponsavel(medicoSelecionado);
            paciente.setNome(nome);
            paciente.setIdade(idade);

            System.out.println("Escolha seu tratamento: " + "\n 1 - fisioterapia" + "\n 2 - medicacao");
            int escolhaplano = leitura.nextInt();
            if (escolhaplano == 1) {
                paciente.setPlanoStrategy(fisioterapia);
            } else if (escolhaplano == 3) {
                paciente.setPlanoStrategy(medicacao);
            }


            System.out.println("O paciente possui algum tipo de deficiencia Física? " + "\n 1 - sim" + "\n 2 - não");
            int defisc = leitura.nextInt();
            if (defisc == 1) {
                paciente.setDefienciaFisica(true);
            }
            System.out.println("O paciente possui algum tipo de deficiencia Psicologica? " + "\n 1 - sim" + "\n 2 - não");
            int defpsic = leitura.nextInt();
            if (defpsic == 1) {
                paciente.setDeficienciaPsico(true);
            }
            System.out.println("O paciente possui alguma alergia? " + "\n 1 - sim" + "\n 2 - não");
            int alergia = leitura.nextInt();
            if (alergia == 1) {
                paciente.setAlergia(true);
            }
            System.out.println("O paciente utiliza algum remédio continuo? " + "\n 1 - sim" + "\n 2 - não");
            int remedio = leitura.nextInt();
            if (remedio == 1) {
                paciente.setUsaMedicamento(true);
            }

            Medicamento medicamento1 = new Medicamento("Curitybina");
            Medicamento medicamento2 = new Medicamento("Metoprololtartrat");
            Medicamento medicamento3 = new Medicamento("Felodipinratiopharm");

            Tarefa tarefa1 = new Tarefa("Terapia");
            Tarefa tarefa2 = new Tarefa("Conversar com seus pais");
            Tarefa tarefa3 = new Tarefa("Banho de Sol");

            Tratamento tratamento1 = new Tratamento(7, tarefa1, medicamento1, "Reclusão completa");
            tratamento1.setTarefas(tarefa1);
            Tratamento tratamento2 = new Tratamento(14, tarefa2, medicamento2, "Reclusão parcial");
            tratamento2.setTarefas(tarefa2);
            Tratamento tratamento3 = new Tratamento(21, tarefa3, medicamento3, "Reclusão parcial");
            tratamento3.setTarefas(tarefa3);

            System.out.println("Relaótrio Final de Cadastro");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Idade: " + paciente.getIdade());
            System.out.println("CPF: " + paciente.getCPF());
            paciente.receberTratamento();
            System.out.println("Estilo do tratamento: " + tratamento1.getEstilo());
            System.out.println("Médico escolhido: " + paciente.getMedicoResponsavel());
            System.out.println("É deficiente físico: " + paciente.isDefienciaFisica());
            System.out.println("É deficiente psicologico: " + paciente.isDeficienciaPsico());
            System.out.println("Possui alguma alergia: " + paciente.isAlergia());
            System.out.println("Usa remédio de uso continuo: " + paciente.isUsaMedicamento());

            InserirDadosNoBanco.inserirDados(nome, Integer.parseInt(idade), CPF);
            break;

        }
    }
}
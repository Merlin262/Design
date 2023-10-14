import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDadosNoBanco {
    public static void inserirDados(String nome, int idade, String cpf) {
        try (Connection conn = ConexaoComBancoDeDados.obterConexao()) {
            String sql = "INSERT INTO tabela (nome, idade, cpf) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, cpf);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

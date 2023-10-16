import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexaoComBancoDeDados {
    private static String url = "jdbc:mysql://localhost:3306/Clinica";
    private static String usuario = "";
    private static String senha = "";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}

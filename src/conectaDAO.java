
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class conectaDAO {
    
   private Connection conexao;
    
    /**
     * Obtém a conexão atual.
     *
     * @return a conexão atual com o banco de dados.
     */
    public Connection getConexao() {
        return conexao;
    }

    
    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/uc11", "root", "Bruno1008961996");
            System.out.println("SUCESSO NA CONEXÃO: ");
        } catch (ClassNotFoundException e) {
            System.out.println("FALHA NA CONEXÃO!");
        } catch (SQLException ex) {
            System.out.println("Falha ao conectar com o banco. Erro de SQL!");
        }
    }

    /**
     * Encerra a conexão com o banco de dados.
     *
     * Este método é usado para encerrar a conexão com o banco de dados após o
     * término das operações.
     */
    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("DESCONECTADO COM SUCESSO!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar");
        }
    }

    public java.sql.PreparedStatement prepareStatement(String sql) throws SQLException {
    return getConexao().prepareStatement(sql);
}

}



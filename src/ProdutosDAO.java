import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class ProdutosDAO {

    public  static boolean cadastrarProduto(ProdutosDTO p) throws SQLException {
        try {
            //conexão com o banco

            conectaDAO conexao = new conectaDAO();
            conexao.conectar();

        
            String sql = "INSERT INTO Produtos ( nome,valor,status) values (?, ?, ?)";
            
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, p.getNome());
            query.setInt(2, p.getValor());
            query.setString(3, p.getStatus());
            query.execute();
            conexao.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar registro no banco de dados");
        }
        return false;
    }

    
        public static List<ProdutosDTO> listarTodos() {

        List<ProdutosDTO> lista = new ArrayList<>();


        try {  
            conectaDAO conexao = new conectaDAO();
            conexao.conectar();

            String sql = "SELECT * FROM produtos";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                ProdutosDTO p = new ProdutosDTO();

                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getInt("valor"));
                p.setStatus(resposta.getString("status"));
                
                
                lista.add(p);
            }
            //desconectar do banco
            conexao.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar registro no banco de dados");

        }
        return lista;

    }
}
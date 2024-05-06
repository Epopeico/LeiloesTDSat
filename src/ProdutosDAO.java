
import java.sql.SQLException;
import java.sql.PreparedStatement;
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

   /*public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    } */

}
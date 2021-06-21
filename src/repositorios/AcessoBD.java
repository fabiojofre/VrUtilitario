package repositorios;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AcessoBD {
	
	public static String URL;// = "jdbc:postgresql://192.168.25.248:5432/lojaopresumido";
	public static int ativos;
	public static String usuario = "postgres";
	public static String senha= "VrPost@Server";
	public static Connection conexao;
        public static int loja;
        public static String nomeLoja;

	

	public void conectar(){
		try {
			conexao = DriverManager.getConnection(URL,usuario,senha);
			conexao.setAutoCommit(false);
			//JOptionPane.showMessageDialog(null, "Conectou!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void desconectar() throws SQLException {
		conexao.close();
	}
	
	public void consultar() throws SQLException {
		
	}
	
	public String mostrarInformacoesBase() throws SQLException {
		DatabaseMetaData meta =  conexao.getMetaData();
		String fabricante = meta.getDatabaseProductName();
		String versao = meta.getDriverVersion();
		return "Banco: "+fabricante+" \n"+"Versao: "+versao;
	}

}

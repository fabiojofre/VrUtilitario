/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Loja;

/**
 *
 * @author fabio
 */
public class ListaLoja {
    public List<Loja> listar() throws SQLException, IOException {
		String sql = "SELECT ID, DESCRICAO FROM LOJA WHERE ID_SITUACAOCADASTRO = 1 ORDER BY ID";
                
		Statement stm = AcessoBD.conexao.createStatement();
		ResultSet rs = stm.executeQuery(sql);
                
		List<Loja> loja = new ArrayList<>();
		while (rs.next()) {
                    loja.add(new Loja(rs.getInt(1),rs.getString(2)));	
		}return loja;
	}
}

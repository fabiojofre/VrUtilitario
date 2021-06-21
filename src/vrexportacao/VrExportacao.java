/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrexportacao;

import java.io.IOException;
import repositorios.AcessoBD;
import repositorios.ListaLoja;
import sun.security.krb5.internal.ktab.KeyTabConstants;
import telas.Login;
import util.Autenticacao;
import util.CarregaProperties;

/**
 *
 * @author fabio
 */
public class VrExportacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CarregaProperties.carregar();
        AcessoBD con = new AcessoBD();
	con.conectar();
        Login login = new Login();
        login.setVisible(true);
//       Autenticacao a = new Autenticacao();
//       a.autenticar("", "");
    }
    
}

package telas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

import repositorios.AcessoBD;
import repositorios.ExportarFornecedorContato;
import repositorios.ExportarProdutoFornecedor;
import repositorios.ListaLoja;
import util.CarregaProperties;

public class TesteClasse {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
//		AcessoBD con = new AcessoBD();
//		ListaLoja ex1 = new ListaLoja();
//		CarregaProperties.carregar();
//		con.conectar();
//                    for(int i=0;i<ex1.listar().size();i++){
//                    System.out.println("ID: "+ex1.listar().get(0).getIdloja()+" Loja: "+ex1.listar().get(0).getDescricao());
//                }
//		          
//		con.desconectar();

            Tarefa1();
		
	}
        
        public static void Tarefa1(){
            
            Timer timer1 = new Timer();
        int delay = 2000;   // delay de 2 seg.
        int interval = 5000;  // intervalo de 1 seg.       

        timer1.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            JOptionPane.showMessageDialog(null, AcessoBD.nomeLoja);         
        }
        }, delay, interval);
    }
	
}

package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import repositorios.AcessoBD;

public class CarregaProperties {
	public static Properties getProp() throws IOException, FileNotFoundException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("C:\\vr\\implantacao\\vrimplantacao.properties");
        props.load(file);
        return props;
    }
	public static void carregar()throws IOException{
	     Properties prop = getProp();   
	     AcessoBD.URL = "jdbc:postgresql://"+prop.getProperty("database.ip")+":"+prop.getProperty("database.porta")
	     				+"/"+prop.getProperty("database.nome");
	        //JOptionPane.showMessageDialog(null, "IP = "+prop.getProperty("database.ip")+"\n"+"Banco = "+prop.getProperty("database.nome")+"\n"+"Porta = "+prop.getProperty("database.porta")+"\n"+"Loja = "+prop.getProperty("system.numeroloja"));
	 }
}

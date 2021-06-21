
package util;

import java.util.Calendar;

public class Autenticacao {
       Calendar c = Calendar.getInstance();
      
    public boolean autenticar(String usuario, String senha){
       String dia;
       String mes = Integer.toString(c.get(Calendar.MONTH)+1);
       String ano = Integer.toString(c.get(Calendar.YEAR)).substring(2,4);
       String diaTemp = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        if(diaTemp.length() == 1){
        dia = "0"+ diaTemp;
        }else
            dia =diaTemp;
       String senhaVr = "VR"+mes+dia+ano+"OFT";
        
        if(usuario.equalsIgnoreCase("VRSOFTWARE")&&senha.equalsIgnoreCase(senhaVr)){
            return true;
        }else 
        return false;
    }
    
}

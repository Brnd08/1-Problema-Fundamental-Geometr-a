// Made by Velazquez Tellez Brandon
package problema_fundamental;
import java.util.Scanner;

public class EntradaEcuacion {
    //vars de instancia
       
    private int ecuacion [] = new int [3]; //datos de entrada
    
    final private String literal [] = {"x", "y", " c"}; //Strings para desplegar 
    
    private boolean esEcuacion = true;
    
    public EntradaEcuacion(){
    }
    // Metodos 

    public void pedirEcuacion (){        
        
        Scanner entrada = new Scanner (System.in); //objeto tipo Scanner
    
        System.out.println("\tSOLUCIONADOR DEL 1er PROBLEMA FUNDAMENTAL");
        System.out.println("\n Ingrese a continuacion los valores de la ecuacion*\t " + "\b*De la forma: aX+bY+c=0");
        System.out.println();
         
        for (int i = 0; i < ecuacion.length ; i++) { // se pide en ciclo los valores de la ecuacion

            System.out.print( " Valor de " + literal[i] + " -> " );
            ecuacion[i]= entrada.nextInt();
        }
        
        if( ecuacion[0] ==0 & ecuacion[1] ==0){
            esEcuacion=false;
        }
    }
    
    public void simplificarEcuacion(){
        String outF = "%36s\u2193\u2193\u2193\n";
        String simplificarS = String.format(outF, "Ecuacion Resultante ");
        
        if (esEcuacion){
            
            int mcd =Mcd_Recursivo.mcd(ecuacion [0], ecuacion [1], ecuacion [2]);
            
            if (mcd != 1 ) 
                simplificarS = String.format(outF, "Al dividir entre " + mcd +  " tenemos  " );
            
            if(mcd != 1)
                for (int i = 0; i < 3; i++) // AQUI SE DIVIDE LA ECUACION ENTRE EL MCD 
                    ecuacion[i] = ecuacion[i]/mcd; 
        }
        
        System.out.print("\n" + simplificarS);
    }
                                                        //    vX                "x"           vY                   "y"       vI                   
    public String imprimirEcuacion (){

        String ecuacionS = "0 = 0";
        if (ecuacion[0]!=0 || ecuacion[1]!=0 || ecuacion[2] !=0 ) 
           ecuacionS =                         
           (	(ecuacion[0] > 0)? " " + ecuacion[0] + literal[0] : (ecuacion[0] <0)? ecuacion[0] + literal[0] : "" ) +	
           (	(ecuacion[1] > 0)? (ecuacion[0] ==0 ? ecuacion[1] + literal[1] : " + " + ecuacion[1] + literal[1]): (ecuacion[1] <0)? " " + ecuacion[1] + literal[1] : "" ) +
           (      (ecuacion[2] > 0)? ( ecuacion[0] ==0 && ecuacion[1] == 0 ?  ecuacion[2] : " + " + ecuacion[2] )   : (ecuacion[2] <0)?  " " + ecuacion[2] : "")  + 
           (      ((ecuacion[0]==0 & ecuacion[1]==0 & ecuacion[2]==0)? "0 = 0" : " = 0") + "\n");

        System.out.printf( "%39s",ecuacionS);

        String noValidoS ="";
        if(!esEcuacion){
            noValidoS ="Esta expresion no es una ecuacion valida :( ";
            System.out.println("\n" + noValidoS);
        }
        return ecuacionS;
    }//quite el signo mas en la primera varible y ademas en todas puse >= 0   

    public int[] getEcuacion() {
        return ecuacion;
    }

    public String[] getLiteral() {
        return literal;
    }

    public boolean isEsEcuacion() {
        return esEcuacion;
    }
}

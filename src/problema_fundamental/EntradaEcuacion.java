// Made by Velazquez Tellez Brandon
package problema_fundamental;
import java.util.Scanner;

public class EntradaEcuacion {
    //vars de instancia
       
    private int ecuacion [] = new int [3]; //datos de entrada
    
    final private String literal [] = {"x", "y", " c"}; //Strings para desplegar 
    
    private boolean esEcuacion = true;
    
    // Metodos 
    
    public void pedirEcuacion (){        
        
        Scanner Scanear = new Scanner (System.in); //objeto tipo Scanner
    
        System.out.println("\tSOLUCIONADOR DEL 1er PROBLEMA FUNDAMENTAL");
        System.out.println("\n Ingrese a continuacion los valores de la ecuacion*\t " + "\b*De la forma: aX+bY+c=0");
        System.out.println();
         
        for (int i = 0; i < ecuacion.length ; i++) { // se pide en ciclo los valores de la ecuacion

            System.out.print( " Valor de " + literal[i] + " -> " );
            ecuacion[i]= Scanear.nextInt();
        }
        
        if( ecuacion[0] ==0 & ecuacion[1] ==0){
            esEcuacion=false;
        }
    }
    
    public void simplificarEcuacion(){
        int a = ecuacion [0];
        int b = ecuacion [1];
        int c = ecuacion [2];
        int mcd =Mcd_Recursivo.mcd(a, b, c);
        for (int k = 0; k < 3; k++) // AQUI SE DIVIDE ENTRE EL MCD DE LA ECUACION
            ecuacion[k] = ecuacion[k]/mcd; 
        
        System.out.printf("%36s\u2193\u2193\u2193\n", "Simplificando al dividir entre " + mcd +  "tenemos  ");
      
    }
                                                        //    vX                "x"           vY                   "y"       vI                   
    public void imprimirEcuacion (){
         
             System.out.print("\n ECUACION RESULTANTE -->\t" );
             System.out.print  	(	(ecuacion[0] != 0)?((ecuacion[0] > 0)? " " + ecuacion[0] + literal[0]: (ecuacion[0] <0)? ecuacion[0] + literal[0] : ""): "" );		
             System.out.print	(	(ecuacion[1] != 0)?((ecuacion[1] > 0)?" + " + ecuacion[1] + literal[1]: (ecuacion[1] <0)? ecuacion[1] + literal[1] : ""): "" );
             System.out.print	(                  ((ecuacion[2] != 0)?((ecuacion[2] > 0)?" + " + ecuacion[2] +  ""  : (ecuacion[2] <0)? ecuacion[2] +  ""    : ""): ""  ) + 
                                                         (    (ecuacion[0]==0 & ecuacion[1]==0 & ecuacion[2]==0)? "0 = 0" : " = 0") + "\n");
       if(!esEcuacion)
            System.out.println("\nEsta expresion no es una ecuacion valida :(");
           
        
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

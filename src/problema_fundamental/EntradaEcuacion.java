// Made by Velazquez Tellez Brandon
package problema_fundamental;
import java.util.Scanner;

public class EntradaEcuacion {
    //vars de instancia

    private final int [] ecuacion  = new int [3]; //datos de entrada

    private final String [] literal = {"x", "y"}; //Strings para desplegar 

    private boolean esEcuacion = true;


   // Metodos 

    public void pedirEcuacion (){        
        
        Scanner entrada = new Scanner (System.in); //objeto tipo Scanner
    
        System.out.println("\tSOLUCIONADOR DEL 1er PROBLEMA FUNDAMENTAL");
        System.out.println("\n Ingrese a continuacion los valores de la ecuacion*\t\b*De la forma: aX+bY+c=0");
        System.out.println();
        
        String[] paraPedir = {"a", "b", "c"};
        for (int i = 0; i < ecuacion.length ; i++) { // se pide en ciclo los valores de la ecuacion

            System.out.print( " Valor de " + paraPedir[i] + " -> " );
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

            if(mcd != 1){
                simplificarS = String.format(outF, "Al dividir entre " + mcd +  " tenemos  " );

                for (int i = 0; i < 3; i++) // AQUI SE DIVIDE LA ECUACION ENTRE EL MCD 
                    ecuacion[i] = ecuacion[i]/mcd; 
            }
        }
        
        System.out.print("\n" + simplificarS);
    }

    public String imprimirEcuacion (){

        String ecuacionS = "0 = 0";
        
        if (ecuacion[0]!=0 || ecuacion[1]!=0 || ecuacion[2] !=0 ) 
           ecuacionS = (  (ecuacion[0] > 0) ?" " + ecuacion[0] + literal[0] :(ecuacion[0] <0) ?ecuacion[0] + literal[0] :""  )
                   + (  (ecuacion[1] > 0) ?( ecuacion[0] ==0 ?ecuacion[1] + literal[1] :" +" + ecuacion[1] + literal[1]) :(ecuacion[1] <0) ?" " + ecuacion[1] + literal[1] :""  )
                   + (  (ecuacion[2] > 0) ?( ecuacion[0] ==0 && ecuacion[1] == 0 ?ecuacion[2] :" +" + ecuacion[2] ) :(ecuacion[2] <0) ?" " + ecuacion[2] :""  )
                   + " = 0";

        System.out.printf( "%39s\n",ecuacionS);
        
        if(!esEcuacion){
            String noValidoS ="Esta expresion no es una ecuacion valida :( ";
            System.out.println("\n" + noValidoS);
        }

        return ecuacionS;
    }

    public int[] getEcuacion() {
        return ecuacion.clone();
    }

    public String[] getLiteral() {
        return literal.clone();
    }

    public boolean isEsEcuacion() {
        return esEcuacion;
    }
}

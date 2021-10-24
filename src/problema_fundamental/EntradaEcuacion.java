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
        int a=Math.abs(ecuacion[0]);//abs x
        int b=Math.abs(ecuacion[1]);//abs y
        int c=Math.abs(ecuacion[2]);//abs c
        int menor1 = a;
        int mayor1 = a;
        
        for (int i = 1; i < 2; i++) { //Encuentre el valor minimo, maximo de los valores absolutos de la ecuacion
            if(menor1 == 0)
                menor1=Math.abs(ecuacion[i]);
                
            if( Math.abs(ecuacion[i]) < menor1 & ecuacion[i]!=0 )     
                menor1=Math.abs(ecuacion[i]);                
            
            if( Math.abs(ecuacion[i]) > mayor1)
                mayor1=Math.abs(ecuacion[i]);
            }
        
        int mcdAb=menor1;        
        
        while( mayor1%menor1!=0){//calcula el MCD de A y B  partir de el Algoritmo de Euclides
            menor1= mayor1%menor1;
            mcdAb=menor1;            
            mayor1=mcdAb;            
        }
        
        int mcdFinal=mcdAb;
        if (c>0){   //si c = 0 se queda 
            
            int menor2 = Math.min(mcdAb, c);
            int mayor2 = Math.max(mcdAb, c);            
            
            int mcdC=menor2;
            
            while( mayor2%menor2!=0){//calcula el MCD de MCD (a,b) y C  partir de el Algoritmo de Euclides
                menor2= mayor2%menor2;
                mcdC=menor2;            
                mayor2=mcdC;            
            }
            mcdFinal=mcdC;
        }                
        
        System.out.printf("%36s\u2193\u2193\u2193\n", "Simplificando tenemos  ");
        for (int k = 0; k < 3; k++) // AQUI SE DIVIDE ENTRE EL MCD DE LA ECUACION
            ecuacion[k] = ecuacion[k]/mcdFinal; 
        
      
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


package problema_fundamental;

import static java.lang.Double.isInfinite;


public class Paso_3 {
        
    private int ecuacion[] = new int[3];
    private  float pendiente;
    private String variables[] = new String[3];
    

    Paso_3(int[] ecuacion, String[] variables) {
        this.ecuacion = ecuacion;
        this.variables = variables;
        this.pendiente = this.calcularPendiente(ecuacion);
        System.out.println();
        
        System.out.println("\n 3)  SIMETRIAS:");
    }
        
     private float calcularPendiente(int [] ecuacion2){
        //pendiente = - a/b
        int b = ecuacion2[1];
        int a = ecuacion2[0];
        String sPendiente = (-a)+ "/" + (b) + " = ";
        float pendiente2 ;
        try{
            pendiente2 = (float) -a/b;
            System.out.println(" Pendiente:\t" + sPendiente +  pendiente2);
        }            
        catch(Exception e){
            pendiente2 = (float) -a/b;
            System.out.println(" Pendiente:\t" + sPendiente +  pendiente2);
        }
         return pendiente2;
    }
    public void simetrias(){
        
    System.out.print("\n Eje X \t");
    
    if (this.esSimetricaX())
            System.out.println("\tSimetria respecto a eje X");
    else 
            System.out.println("\tNo existe simetria en el eje X");
    
    
    System.out.print("\n Eje Y \t");
    
    if (this.esSimetricaY())
            System.out.println("\tSimetria respecto a eje Y");
    else 
            System.out.println("\tNo existe simetria en el eje Y");
    
    
    System.out.print("\n Origen Y \t");
    
    if (this.esSimetricaOrigen())
            System.out.println("Simetria respecto al Origen");
    else 
            System.out.println("No existe simetria respecto al Origen");   
    
    }

    private  boolean  esSimetricaX (){

        return isInfinite(pendiente);
    }

    private  boolean esSimetricaY (){

        return (pendiente == 0.0f); 
    }

    private  boolean esSimetricaOrigen (){

        return ecuacion[2] == 0;
    }

    public float getPendiente() {
        return pendiente;
    }
        
     
}

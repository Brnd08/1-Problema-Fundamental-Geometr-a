package ppf;

import static java.lang.Double.isInfinite;


public class Paso_3 {
        
    private int ecuacion[] = new int[3];
    private float pendiente;
    private String variables[] = new String[3];
    

    Paso_3(int[] ecuacion, String[] variables) {
        this.ecuacion = ecuacion;
        this.variables = variables;
        this.pendiente = this.calcularPendiente(ecuacion);
        
        System.out.println("\n\n 3)  SIMETRIAS:");
    }
        
     private float calcularPendiente(int [] ecuacion2){
        /*
         * pendiente = - a/b
         */
        
        int b = ecuacion2[1];
        int a = ecuacion2[0];
        
        String sPendiente = (-a)+ "/" + b + " = ";
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
     
    public String[] simetrias() {
        String simetriasS[] = {"default X", "default Y", "default O"};

        if ( this.esSimetricaX() )
                simetriasS[0] = "Simetria en eje X";
            else 
                simetriasS[0] = "Sin simetria en eje X";

        if ( this.esSimetricaY() )
                simetriasS[1] =String.format("Simetria en eje Y");
            else 
                simetriasS[1] =String.format("Sin simetria en eje Y");

        if ( this.esSimetricaOrigen() )
                simetriasS[2] =String.format("Simetria en Origen");
            else 
                simetriasS[2] =String.format("Sin simetria en Origen");   

        System.out.print( "\n Eje X \t" + simetriasS[0] );
        System.out.print( "\n Eje Y \t" + simetriasS[1] );
        System.out.print( "\n Origen Y \t" + simetriasS[2] );
                
        return simetriasS.clone();
    }

    private  boolean  esSimetricaX (){
        return isInfinite(pendiente);
    }

    private  boolean esSimetricaY (){
        return  (pendiente == 0.0f ); 
    }

    private  boolean esSimetricaOrigen (){
        return ecuacion[2] == 0;
    }

    public float getPendiente() {
        return pendiente;
    }
        
     
}

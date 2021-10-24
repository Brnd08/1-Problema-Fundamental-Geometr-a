package problema_fundamental;

public class Paso_4 {    
    
    private int ecuacion[] = new int[3];
    private String variable[] = new String[3];

    Paso_4(int[] ecuacion, String[] variable) {
        this.ecuacion = ecuacion;
        this.variable = variable;
        System.out.println();
        System.out.println("\n 4)  INTERSECCIONES EN LOS EJES:");
        //+ Arrays.toString(ecuacion) + Arrays.toString(variable)   //por si se ofrece
    }
    
    public void interseccionX(int [] ecuacion2, String tipo){
        // if y=0 we have
        //aX + bY + c = 0 --> aX + b(0) + c= 0 --> aX = -c --> X=-c/a
        System.out.print( "\n " +"Interseccion en Eje X    ---->" + "\t " );
         float interseccionXFloat;
         switch (tipo) 
        {
             case "indefinido" :    System.out.print("No tiene\n");
                                                break;
             case "fijo" :      System.out.print("Nunca llega el Eje");      

                                        break;
             case "normal":       int c = ecuacion2[2];
                                            int a = ecuacion2[0];
                                            String interseccionX = (a!=0 & a!=1)?  (-c+"/" +a) :  (-c!=1)?Integer.toString(-c) : Integer.toString(c);
                                            interseccionXFloat = (float)-c/a;           
                                            System.out.printf("P ( %s ,%d )\n",interseccionX,0);           
                                        break;
        }
         
    }

    public void interseccionY(int [] ecuacion2, String tipo){
        // if X=0 we have
        //aX + bY + c = 0 --> a(0) + bY + c= 0 --> bY = -c --> Y=-c/b
        float interseccionYFloat;    

        System.out.print( "\n " +"Interseccion en Eje Y    ---->" + "\t " );
        switch (tipo) 
        {
             case "indefinido" :    System.out.print("No tiene\n");
                                                break;
             case "fijo" :      System.out.print("Nunca llega el Eje");      

                                        break;
             case "normal":       int c = ecuacion2[2];
                                            int b = ecuacion2[1];
                                            String interseccionY = (b!=0 & b!=1)?  (-c+"/" +b) :  (-c!=1)?Integer.toString(-c) : Integer.toString(c); //-c+"/" +b;           
                                            System.out.printf("P ( %d ,%s )\n",0,interseccionY);                    
                                            System.out.printf("P ( %s ,%d )\n",interseccionY,0);           
                                            
                                        break;
        }
    }

    public int devolverPendiente(int [] ecuacion2){
        //pendiente = - a/b
        int b = ecuacion2[1];
        int a = ecuacion2[0];
        int pendiente;
        try{
            pendiente = a/b;
            System.out.println(" Pendiente igual a ->" + pendiente);
        }            
        catch(Exception e){
            System.out.println(" Pendiente igual a cero");
            pendiente =0;
        }
         return pendiente;
    }

}

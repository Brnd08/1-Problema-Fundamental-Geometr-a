package problema_fundamental;

public class Paso_2  {

    private int ecuacion[] = new int[3];
    private String variable[] = new String[3];

    Paso_2(int[] ecuacion, String[] variable) {
        this.ecuacion = ecuacion;
        this.variable = variable;
        
        System.out.println("\n\n 2)  EXTENCION:");
    }
    
     public String extencionX (String definicionX){
         String extencionX = "Default \n";
         System.out.print( "\n Extension de X       ---->\t " );
         
         switch (definicionX) {
             
             case "indefinido", "normal"
                     -> extencionX = String.format("%s \u2208 %s \u2234 [%3s ,%3s]\n", variable[0], "R" , "-\u221e", "+\u221e");// byte order mark
                 
             case "pFijo" 
                     -> extencionX = String.format("%s \u2234 = (%s)\n", variable[0]
                             , (ecuacion[0] == -1) ?ecuacion[2] : -ecuacion[2] + (ecuacion[0] == 1 ?"" :"/" + ecuacion[0])  );// byte order mark
        }
                  
        System.out.print( extencionX );        
        return extencionX;
    }

     public String extencionY (String defY){
         String extencionY = "Default \n";
         System.out.print( "\n Extension de Y       ---->\t " );
         
         switch (defY) {
             
             case "indefinido", "normal" 
                     -> extencionY = String.format("%s \u2208 %s \u2234 [%3s ,%3s]\n", variable[1], "R" , "-\u221e", "+\u221e");// byte order mark
                                                
             case "pFijo" 
                     -> extencionY = String.format("%s \u2234 = ( %s)\n", variable[1],
                             ecuacion[1] == -1? ecuacion[2] : (-ecuacion[2] + ( ecuacion[1] == 1?  "" :  "/" + ecuacion[1]) ));// byte order mark
        }
         
         System.out.println( extencionY );         
         return extencionY;
    }
}

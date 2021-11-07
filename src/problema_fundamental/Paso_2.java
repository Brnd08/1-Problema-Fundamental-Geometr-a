package problema_fundamental;

public class Paso_2  {

    private int ecuacion[] = new int[3];
    private String variable[] = new String[3];

    Paso_2(int[] ecuacion, String[] variable) {
        this.ecuacion = ecuacion;
        this.variable = variable;
        System.out.println();
        System.out.println("\n 2)  EXTENCION:");
        //+ Arrays.toString(ecuacion) + Arrays.toString(variable)   //por si se ofrece
    }
    
     public void extencionX (String defX){
         switch (defX) 
        {
             case "indefinido" :    System.out.print( "\n " +"Extension de X 1      ---->" + "\t " );
                                                    System.out.printf("%s \u2208 %s \u2234 "+"[%3s ,%3s]\n", variable[0],"R" , "-\u221e", "+\u221e");
                                                break;
             case "pFijo" :      System.out.print( "\n " +"Extension de X 2      ---->" + "\t " );
                                        System.out.printf("%s   \u2234 = "+"( %s)\n", variable[0] , ecuacion[0] == -1? ecuacion[2] : (-ecuacion[2] + ( ecuacion[0] == 1?  "" :  "/" + ecuacion[0]) ) );
                                        
                                        break;
             case "normal":    if(ecuacion[0] != 0 & ecuacion[0] ==  ecuacion[0])  //entero diferente de 0
                                                {                                      
                                                    System.out.print( "\n " +"Extension de X 3      ---->" + "\t " );
                                                    System.out.printf("%s \u2208 %s \u2234 "+"[%3s ,%3s]\n", variable[0],"R" , "-\u221e", "+\u221e");
                                                } 
                                                break;
        }
    }

     public void extencionY (String defY){
         switch (defY) 
        {
             case "indefinido" :    System.out.print( "\n " +"Extension de Y 1      ---->" + "\t " );
                                                    System.out.printf("%s \u2208 %s \u2234 "+"[%3s ,%3s]\n", variable[1],"R" , "-\u221e", "+\u221e");
                                                break;
             case "pFijo" :      System.out.print( "\n " +"Extension de Y 2     ---->" + "\t " );
                                        System.out.printf("%s \u2234 = "+"( %s)\n", variable[1] , ecuacion[1] == -1? ecuacion[2] : (-ecuacion[2] + ( ecuacion[1] == 1?  "" :  "/" + ecuacion[1]) ));
                                        
                                        break;
             case "normal":    if(ecuacion[1] != 0 & ecuacion[1] ==  ecuacion[1])  //entero diferente de 0
                                                {                                      
                                                    System.out.print( "\n " +"Extension de Y 3      ---->" + "\t " );
                                                    System.out.printf("%s \u2208 %s \u2234 "+"[%3s ,%3s]\n", variable[0],"R" , "-\u221e", "+\u221e");
                                                } 
                                                break;
        }
    }
}

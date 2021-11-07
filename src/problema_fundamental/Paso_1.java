// Made by Velazquez Tellez Brandon
package problema_fundamental;

public class Paso_1 {
    
    private int ecuacion []= new int [3];
    private String variable [] = new String [3];

    private String definicionX=null;
    private String definicionY=null;
        
    Paso_1 (int [] ecuacion, String [] variable){
            this.ecuacion = ecuacion;
            this.variable = variable;
            System.out.println();
            System.out.println("\n 1)  DESPEJES:");
            //+ Arrays.toString(ecuacion) + Arrays.toString(variable)   //por si se ofrece
    } //constructor
    
    public void despejeX (){
        
        System.out.print( "\n " +"Despeje de X       ---->" + "\t " );
            if (ecuacion[0]==0 ){
                System.out.print	(variable[0] + " = " +  " indefinido" + "\n");       
                definicionX = "indefinido";
            }
            else 
                if(ecuacion[1]==0){
                    System.out.print	(variable[0] + " = " + -ecuacion[2] + ( ecuacion[0] == 1?  "\n" :  "/" + ecuacion[0])  );
                    definicionX ="pFijo";
                }
            else {        
                System.out.print(   variable[0] + " = " + ((ecuacion[0] != 0 && ecuacion[0] != 1)?"(":""));//var 
                System.out.print(   (-ecuacion[1] != 0)?((-ecuacion[1] > 0)?"" + -ecuacion[1] + variable[1]: (-ecuacion[1] <0)? -ecuacion[1] + variable[1] : ""): "" );
                System.out.print(  ((-ecuacion[2] != 0)?((-ecuacion[2] > 0)?"+" + (-ecuacion[2]) +  ""  : (-ecuacion[2] <0)? -ecuacion[2] +  ""    : ""): ""  ) ); //queda intacto
                System.out.print(  ((ecuacion[0] != 0 && ecuacion[0] != 1)?((ecuacion[0] > 0)? ")/" + ecuacion[0]: ")/" + ecuacion[0]): "" ) + "\n");
                definicionX ="normal";
           }
    }
    
    public void despejeY (){
        System.out.print( "\n " +"Despeje de Y       ---->" + "\t");
            if (ecuacion[1]==0 ) {// x=0 y c=0
                System.out.print	(variable[1] + " = " +  " indefinido" + "\n");            
                definicionY = "indefinido";
            }
            else 
                if(ecuacion[0]==0){
                    System.out.print	(variable[1] + " = " + -ecuacion[2]  + ( ecuacion[1] == 1?  "\n" :  "/" + ecuacion[1] ) );
                    definicionY = "pFijo";
                }
            else {
                System.out.print(   variable[1] + " = " + ((ecuacion[1] != 0&& ecuacion[1] != 1)?"(":""));
                System.out.print(   (-ecuacion[0] != 0)?((-ecuacion[0] > 0)?"" + -ecuacion[0] + variable[0]: (-ecuacion[0] <0)? -ecuacion[0] + variable[0] : ""): "" );
                System.out.print(  ((-ecuacion[2] != 0 )?((-ecuacion[2] > 0)?"+" + (-ecuacion[2]) +  ""  : (-ecuacion[2] <0)? -ecuacion[2] +  ""    : ""): ""  ) );  // queda intacta
                System.out.print(   ((ecuacion[1] != 0&& ecuacion[1] != 1)?((ecuacion[1] > 0)? ")/" + ecuacion[1]: ")/" + ecuacion[1]): "" ) + "\n");
                definicionY = "normal";
            }
        }
    
    public String getDefinicionX() {
        return definicionX;
    }

    public String getDefinicionY() {
        return definicionY;
    }
}

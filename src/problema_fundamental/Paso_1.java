// Made by Velazquez Tellez Brandon
package problema_fundamental;

public class Paso_1 {
    
    private int ecuacion []= new int [3];
    private String variable [] = new String [3];

    private String definicionX=null;
    private String definicionY=null;
        
    public Paso_1 (int [] ecuacion, String [] variable){
            this.ecuacion = ecuacion;
            this.variable = variable;
            
            System.out.println();
            System.out.println("\n 1)  DESPEJES:");
    } 
    
    public String despejeX (){
        
        System.out.print( "\n " +"Despeje de X       ---->" + "\t " );
        String despejeXS;
        
            if (ecuacion[0]==0 ){
                despejeXS = variable[0] + " =  indefinido";
                System.out.print	(despejeXS + "\n");
                definicionX = "indefinido";
            }
            else 
                if(ecuacion[1]==0){
                    despejeXS =(variable[0] + " = " + -ecuacion[2] + ( ecuacion[0] == 1?  "" :  "/" + ecuacion[0]) );
                    System.out.print (despejeXS + "\n");
                    definicionX ="pFijo";
                }
            else {
                despejeXS = 
                (   variable[0] + " = " + ( (ecuacion[0] != 0 && ecuacion[0] != 1) ? "(" : "") ) +
                (    (-ecuacion[1] > 0)?"" + -ecuacion[1] + variable[1] : (-ecuacion[1] <0)? -ecuacion[1] + variable[1] : "" ) +
                (    (-ecuacion[2] > 0)?"+" + (-ecuacion[2]) +  ""  : (-ecuacion[2] <0)? -ecuacion[2] +  ""    : ""  ) + //queda intacto
                (    ((ecuacion[0] != 0 && ecuacion[0] != 1)?((ecuacion[0] > 0)? ")/" + ecuacion[0]: ")/" + ecuacion[0]): "" ) + "\n");
                    System.out.print(despejeXS);
                definicionX ="normal";
           }
            
            return despejeXS;
    }
    
    public String despejeY (){
        System.out.print( "\n " +"Despeje de Y       ---->" + "\t");
        String despejeYS;
        
            if (ecuacion[1]==0 ) {// x=0 y c=0
                despejeYS =variable[1] + " = " +  " indefinido" ;
                System.out.print( despejeYS + "\n" );            
                definicionY = "indefinido";
            }
            else 
                if(ecuacion[0]==0){
                    despejeYS = ( variable[1] + " = " + -ecuacion[2]  + ( ecuacion[1] == 1?  "" :  "/" + ecuacion[1] ) );
                    System.out.print (despejeYS + "\n");
                    definicionY = "pFijo";
                }
            else {
                despejeYS =
                (   variable[1] + " = " + ((ecuacion[1] != 0&& ecuacion[1] != 1)?"(":"")) +
                (   (-ecuacion[0] > 0)?"" + -ecuacion[0] + variable[0]: (-ecuacion[0] <0)? -ecuacion[0] + variable[0] : "") +
                (   (-ecuacion[2] > 0)?"+" + (-ecuacion[2]) +  ""  : (-ecuacion[2] <0)? -ecuacion[2] +  ""    : "" ) +  // queda intacta
                (   ((ecuacion[1] != 0&& ecuacion[1] != 1)?((ecuacion[1] > 0)? ")/" + ecuacion[1]: ")/" + ecuacion[1]): "" ) + "\n");
                System.out.print(despejeYS);
                definicionY = "normal";
            }
            
            return despejeYS;
        }
    
    public String getDefinicionX() {
        return definicionX;
    }

    public String getDefinicionY() {
        return definicionY;
    }
}

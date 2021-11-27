// Made by Velazquez Tellez Brandon
package ppf;

public class Paso_1 {
    
    private int [] ecuacion = new int [3];
    private String [] variable  = new String [3];

    private String definicionX = "" ;
    private String definicionY = "" ;
        
    public Paso_1 (int [] ecuacion, String [] variable){
            this.ecuacion = ecuacion;
            this.variable = variable;
            
            System.out.println("\n\n 1)  DESPEJES:");
    } 
    
    public String despejeX (){
        System.out.print( "\n Despeje de X       ----> \t" );
        String despejeXS;
        
            if (ecuacion[0] == 0){
                despejeXS = variable[0] + " = indefinido" ;
                
                definicionX = "indefinido";
            }
            else 
                if(ecuacion[1] == 0){
                    despejeXS =( variable[0] + " = " + ( -ecuacion[2] ) + ( ecuacion[0] == 1 ? ""  :"/" + ecuacion[0]) );
                    
                    definicionX ="pFijo";
                }
                else {
                        despejeXS = (  variable[0] + " = " + ( (ecuacion[0] != 0 && ecuacion[0] != 1) ?"(" :"" )  )
                                + (  ( -ecuacion[1] > 0 ) ?-ecuacion[1] + variable[1] :( -ecuacion[1] <0 ) ?-ecuacion[1] + variable[1] :""  )
                                + (  ( -ecuacion[2] > 0 ) ?" +" + (-ecuacion[2]) :( ( -ecuacion[2] <0 ) ?-ecuacion[2] :"" )  )
                                + (  ( ecuacion[0] != 0 && ecuacion[0] != 1) ?")/" + ecuacion[0] :""  ) ;

                        definicionX ="normal";
               }
            
            System.out.print(despejeXS + "\n");
            return despejeXS;
    }
    
    public String despejeY (){
        System.out.print( "\n Despeje de Y       ----> \t" );
        String despejeYS;
        
            if (ecuacion[1] == 0) { // x=0 y c=0
                despejeYS =variable[1] + " = indefinido" ;
                
                definicionY = "indefinido";
            }
            else
                if(ecuacion[0] == 0){
                    despejeYS = ( variable[1] + " = " + ( -ecuacion[2] )  + ( ecuacion[1] == 1 ? "" :"/" + ecuacion[1] )  );
                    
                    definicionY = "pFijo";
                }
                else {
                    despejeYS = (  variable[1] + " = " + ( (ecuacion[1] != 0 && ecuacion[1] != 1) ?"(" :"")  )
                            + (  ( -ecuacion[0] > 0 ) ?-ecuacion[0] + variable[0] :( -ecuacion[0] <0 ) ?-ecuacion[0] + variable[0] :""  )
                            + (  ( -ecuacion[2] > 0 ) ?" +" + (-ecuacion[2]) :( ( -ecuacion[2] <0 ) ?-ecuacion[2] :"" )  )
                            + (  ( ecuacion[1] != 0 && ecuacion[1] != 1) ?")/" + ecuacion[1] :"" ) ;
                    
                    definicionY = "normal";
                }
            
            System.out.print (despejeYS + "\n");
            return despejeYS;
        }
    
    public String getDefinicionX() {
        return definicionX;
    }

    public String getDefinicionY() {
        return definicionY;
    }
}


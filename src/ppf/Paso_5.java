package ppf;

public class Paso_5 {

    private int ecuacion[] = new int[3];
    private String variables[] = new String[3];
    
    Paso_5(int[] ecuacion, String[] variables) {
        this.ecuacion = ecuacion;
        this.variables = variables;
        
        System.out.println("\n\n 5)  ASINTOTAS:");
    }
    
    public void  asintotas(){
        System.out.printf("\n Asintotas Horizontales\t %s \n Asintotas Verticales\t %s\n",this.asintotaH(), this.asintotaV() );
    }
    public  String asintotaH(){
        return "Sin asint Horizontales";
    }
    
    public  String asintotaV(){
        return "Sin asint Verticales";
    }
    
}


package problema_fundamental;

public class Paso_5 {

    private int ecuacion[] = new int[3];
    private String variables[] = new String[3];
    

    Paso_5(int[] ecuacion, String[] variables) {
        this.ecuacion = ecuacion;
        this.variables = variables;
        
        System.out.println();        
        System.out.println("\n 5)  ASINTOTAS:");
    }
    
    public void asintotas(){
        System.out.printf("\n %s \n %s\n",this.asintotaH(), this.asintotaV() );
    }
    private String asintotaH(){
        return String.format("%-22s \t %s", "Asintotas Horizontales", "No tiene asintotas Horizontales");
    }
    
    private String asintotaV(){
        return String.format("%-22s \t %s", "Asintotas Verticales", "No tiene asintotas Verticales");
    }
}

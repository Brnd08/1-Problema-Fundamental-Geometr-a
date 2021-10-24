
package problema_fundamental;

public class Problema_Fundamental_Main {
    public  static void main(String[] args) {
        
        EntradaEcuacion ec = new EntradaEcuacion();        
        ec.pedirEcuacion();
        ec.simplificarEcuacion();
        ec.imprimirEcuacion();
        
        int [] ecuacion = ec.getEcuacion();
        String [] literal = ec.getLiteral();
        boolean esEcuacion = ec.isEsEcuacion();
        
                
        if(esEcuacion){
        
            Paso_1 ec1= new Paso_1(ecuacion, literal);
            ec1.despejeX();      
            String definicionX= ec1.getDefinicionX();
            ec1.despejeY();
            String definicionY= ec1.getDefinicionY();
            
            
            Paso_2 ec2 = new Paso_2 (ecuacion, literal);
            ec2.extencionX(definicionX);
            ec2.extencionY(definicionY);
            
            Paso_4 ec4 = new Paso_4 (ecuacion, literal);
            ec4.interseccionX(ecuacion, definicionX);
            ec4.interseccionY(ecuacion, definicionY);
            int pendiente = ec4.devolverPendiente(ecuacion);
            
            
        }   
        else 
            System.out.println("No se pueden realizar los pasos del problema geometrico");
        
            System.out.print("\033[0;1m" + "made by EQUIPO 1 \n");
    }    

}

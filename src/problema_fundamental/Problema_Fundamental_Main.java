package problema_fundamental;

public class Problema_Fundamental_Main {
    public  static void main(String[] args) {
        
        /*
         * Entrada Ecuacion
        */
        EntradaEcuacion ec = new EntradaEcuacion();        
        ec.pedirEcuacion();
        ec.simplificarEcuacion();
        
        /*
         * Strings Entrada Ecuacion
        */
        String ecuacionS =ec.imprimirEcuacion();
        int [] ecuacion = ec.getEcuacion();
        String [] literal = ec.getLiteral();
        boolean esEcuacion = ec.isEsEcuacion();
        
        float pendiente;
        
        /*
         * Strings Paso1 
        */
        String despejeX = "no se ejecuto el if";
        String despejeY = "no se ejecuto el if";
        
        /*
         * Strings Paso2
        */
        String extencionX = "no se ejecuto el if";
        String extencionY = "no se ejecuto el if";
        
        /*
         * Strings Paso3
        */
        String simetrias [];
        
        /*
         * Strings Paso4
        */
        String interseccionX = "no se ejecuto el if";
        String interseccionY = "no se ejecuto el if";
        
        /*
         * Strings Paso5
        */
        String asintotaV = "no se ejecut el if";
        String asintotaH = "no se ejecut el if";
        
        
                
        if( esEcuacion ){

                Paso_1 ec1= new Paso_1(ecuacion, literal);
                despejeX = ec1.despejeX(); //String listo
                String definicionX= ec1.getDefinicionX(); 
                despejeY = ec1.despejeY(); //String listo
                String definicionY= ec1.getDefinicionY();


                Paso_2 ec2 = new Paso_2 (ecuacion, literal);
                extencionX = ec2.extencionX(definicionX); //string listo
                extencionY = ec2.extencionY(definicionY); //String listo


                Paso_3 ec3 = new Paso_3(ecuacion, literal);
                simetrias = ec3.simetrias();//String[] listo
                pendiente = ec3.getPendiente();


                Paso_4 ec4 = new Paso_4 (ecuacion, literal, definicionX, definicionY);
                interseccionX = ec4.interseccionX(); //String listo
                interseccionY = ec4.interseccionY();//String listo


                Paso_5 ec5 = new Paso_5(ecuacion, literal);
                asintotaV =ec5.asintotaV(); //String listo
                asintotaH =ec5.asintotaH();//String listo
                ec5.asintotas();

        }   
        else 
            System.out.println("No se pueden realizar los pasos del problema geometrico");
        
            System.out.print("\033[0;1m made by EQUIPO 1 \n");

    }

}

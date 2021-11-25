package LoginYserializacion;

public class mainUsers {
    
    public static void main(String[] args) {
        
        String expresion = " aX + bY + c = 0 ";
        String [] 
                  Despejes = new String[] { " X = (-bY -c)/a", " Y = (-aX -c)/b"}
                , intervalos = new String[] { " intervaloX ", " intervaloY"}
                , simetria = new String[] { " simetriaX", " simetriaY", " simetriaO"}
                , interceptos = new String[] { " interceptoY", " interceptoY"}
                , asintotas = new String[] { " asintotasH", " asintotasV"};

        String username = "brdn",
                pass = "abc123";


        Ecuaciones ecuacion1 = new Ecuaciones(expresion, Despejes, intervalos, simetria, interceptos, asintotas);
        System.out.println( ecuacion1.toString() );
        
        Users usuario1 = new Users (username, pass);
        usuario1.agregarEcuacion(ecuacion1);
        System.out.println(usuario1.toString());
        
        ArrayUsuarios usuariosLista = new ArrayUsuarios();
        usuariosLista.agregarUsuario(usuario1);
        System.out.println("\n" + usuariosLista.toString());
        
        Serializar.GUARDAR_USUARIOS( usuariosLista.getListaUsuarios() );
        
        ArrayUsuarios usuariosListaRecuperado = new ArrayUsuarios();
        usuariosListaRecuperado.setListaUsuarios( Serializar.RECUPERAR_USUARIOS() );
        
        System.out.println( usuariosListaRecuperado.getListaUsuarios().toString() );
        
    }
    
}

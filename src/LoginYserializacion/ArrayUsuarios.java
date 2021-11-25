package LoginYserializacion;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayUsuarios implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public ArrayList <Users> listaUsuarios = new ArrayList<>();
    
    
    public void agregarUsuario (Users newUser){
        listaUsuarios.add(newUser);
        System.out.println( newUser.toString() );
    }
    
    public Users buscarUsuario (String username){
        
        for (Users user : listaUsuarios) {
            if ( user.getNombre().equals(username))
                return user;
        }
        
        return null;
    }
    
    public ArrayList <Users> getListaUsuarios (){
        
        return (ArrayList <Users>) listaUsuarios.clone();
        
    }
    
    public void setListaUsuarios ( ArrayList <Users> nuevaListaUsuarios){
        
        for (Users user : listaUsuarios) 
            System.out.println( user.toString());
        
       this.listaUsuarios = (ArrayList <Users>) nuevaListaUsuarios.clone();
       
        System.out.println();
        
        for (Users user : listaUsuarios) 
            System.out.println( user.toString());
        
    }

    @Override
    public String toString() {
        String representacion = "\n\nLista Usuarios\n";
        
        for (Users Usuario : listaUsuarios) {
            representacion += "usuario1 -> " + Usuario.toString()
            + Usuario.regresarListaEcuaciones().get(0).toString();
        }
        
        return representacion;
    }
    
}

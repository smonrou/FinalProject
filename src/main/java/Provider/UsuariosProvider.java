package Provider;

import DataClass.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsuariosProvider {
    private static final List<Usuario> userList = new ArrayList<>();
    
    public static void addUsuario(Usuario user){
        userList.add(user);
    }
    
    public static Usuario getUserByID(Usuario users){
        Usuario result = new Usuario();
        for(Usuario user: userList){
            if(users.getId() == user.getId()){
                result = user;
            }
        }
        return result;
    }
    
    public static Usuario getUser(){
        return userList.get(0);
    }
}

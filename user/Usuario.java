package user;

//Template para criação dos users do sistema
public class Usuario {

    //atributos encapsulados
    private String username;
    private String password;

    //construtor 
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    //getter
    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    //autenticação do usuario
    public static void userAuth(Usuario usuario,String inputUserName, String inputPassword){
        if (inputUserName.equals(usuario.getUserName()) && inputPassword.equals(usuario.getPassword())) {
            System.out.println("------ ------ ------ ------ ------ ------ ");
            System.out.println("\t<< Login realizado com sucesso! >>");
            System.out.println("------ ------ ------ ------ ------ ------ ");             
        } else {
            System.out.println("\tCredenciais invalidas. System exit.");
            System.exit(0);
        }
    }

    

}

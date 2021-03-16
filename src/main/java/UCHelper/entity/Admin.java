/*
 * Amirul Imran bin Ahmad Azam RSF2S1G1
 */
package admin;

/**
 *
 * @author muhamadalarif
 */
public class Admin extends User{
    public Admin(String username, String password, boolean something){
        super(username, password, something);
    }
    
    @Override
    public boolean login(){
        final boolean isAuthenticated = super.login();
        final boolean isAuthorized = isAlllowedToDoThis();
        return isAuthenticated && isAuthorized;
    }
    
    private boolean isAllowedToDoThis(){}
    
    @Override
    public Menu getMenu() {
        //Return Admin menu
    }
    
}

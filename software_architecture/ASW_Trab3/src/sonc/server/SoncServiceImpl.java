package sonc.server;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sonc.client.SoncService;
import sonc.game.Manager;
import sonc.shared.Movie;
import sonc.shared.SoncException;


/**
 * The server-side implementation of the RPC service.
 */
public class SoncServiceImpl extends RemoteServiceServlet implements SoncService {

	private static final long serialVersionUID = 1L;
	private static Manager manager = getManager();
	
	private static Manager getManager() {
		try {
	        return manager = Manager.getInstance();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	/**
	 * Init Server.
	 */
	/*
	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            manager = Manager.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    */
	
	/*
	 A servlet poderá ter um bloco estático (executado no carregamento da classe) para inicializar as configurações estáticas. 
	 O bloco estático é definido ao mesmo nível dos campos em métodos, e será desta forma
	static {
		try {
			manager = Manager.getInstance();
		} catch (SoncException e) {
			e.printStackTrace();
		}
		// Já está predefinido nas respetivas classes, mas podem atribuir por aqui outros valores
		//Manager.setPlayersFile(...);
	    //World.setWidth(...);
	  	//World.setHeight(...);
	}
	*/
	
	public boolean authenticate(String nick, String password) {
		return manager.authenticate(nick, password);
	}

	public boolean register(String userId, String password) throws SoncException {
		//if(manager == null) return true;
		//else return false;
		return manager.register(userId, password);
	}

	public boolean updatePassword(String nick, String oldPassword, String newPassword) throws SoncException {
		return manager.updatePassword(nick, oldPassword, newPassword);
	}

	public void buildShip(String nick, String password, String code) throws SoncException {
		manager.buildShip(nick, password, code);
	}
	
	public String getCurrentCode(String nick, String password) throws SoncException {
		return manager.getCurrentCode(nick, password);
	}
	
	//public Movie battle(List<String> nicks) throws SoncException {}
}

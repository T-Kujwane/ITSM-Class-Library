package za.ac.tut.model.bean;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;
import za.ac.tut.model.User;

@Remote
public interface UserService {

    boolean validateUsername(String username) throws ClassNotFoundException, SQLException;

    boolean validatePassword(String password) throws ClassNotFoundException, SQLException;

    public boolean createUser(User user) throws ClassNotFoundException, SQLException;

    public User authenticateUser(String username, String password) throws ClassNotFoundException, SQLException;

    public List<User> getUserByType(String type) throws ClassNotFoundException, SQLException;

    public User getUserByID(int userID) throws ClassNotFoundException, SQLException;

    public String getUserEmail(int userID) throws ClassNotFoundException, SQLException;

    public User getUserByEmail(String email) throws ClassNotFoundException, SQLException;

    public User getUserByFullName(String fullname) throws ClassNotFoundException, SQLException;

    boolean deleteUser(int userID) throws SQLException, ClassNotFoundException;

    boolean updateUser(int userID, String username, String fullname, String email, int roleID) throws ClassNotFoundException, SQLException;

}


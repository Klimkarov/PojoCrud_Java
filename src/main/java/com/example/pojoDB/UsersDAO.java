package com.example.pojoDB;

import java.util.Set;

public interface UsersDAO {
	
	User getUser(Integer id);
	
    Set<User> getAllUsers();
    
    User getUserByUserNameAndPassword(String user, String pass);
    
    boolean insertUser(User user);
    
    String batchInsertUser(Set<User> users);
    
    boolean updateUser(User user);
    
    boolean deleteUser(Integer id);

}

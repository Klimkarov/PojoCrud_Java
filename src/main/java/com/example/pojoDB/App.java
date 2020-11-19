package com.example.pojoDB;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	UsersDAO dao = new UsersDAOImpl();
    	
    	User user = dao.getUser(1);
    	
//    	System.out.println(user.getName());
//    	System.out.println(user.getEmail());
//    	
//    	
//    	Set<User> users = dao.getAllUsers();
//    	System.out.println(users.size());
//    	
//    	
//    	User usr = dao.getUserByUserNameAndPassword("Dimitar", "password");
//    	
//    	System.out.println(usr.getEmail());
    	
    	
    	Set<User> users = new HashSet<User>();
    	
    	User user1 = new User(4, "Ana", "ana@gmail.com", "MK", "pass");
    	User user2 = new User(5, "Ana", "ana@gmail.com", "MK", "pass");
    	User user3 = new User(6, "Ana", "ana@gmail.com", "MK", "pass");
    	
    	users.add(user1);
    	users.add(user2);
    	users.add(user3);
    	
    	System.out.println(dao.batchInsertUser(users));
    	
    	
    }
}

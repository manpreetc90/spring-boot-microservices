package com.mannu.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;



@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int usersCount=3;
	
	static{
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}
	
	//public List findAll()
	public List findAll(){
		return users;
	}
	
	//public User save(User user)
	public User save(User user){
		if(user.getId()==null){
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	//public User findOne(int id)
	public User findOne(int id){
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id){
		
		Iterator<User> itr=users.iterator();
		while(itr.hasNext())
		{
			User user = itr.next();
			if(user.getId()==id)
			{
				itr.remove();
				return user;
			}
		}
	
		return null;
	}

}

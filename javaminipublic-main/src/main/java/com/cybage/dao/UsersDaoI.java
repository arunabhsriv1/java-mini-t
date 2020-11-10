package com.cybage.dao;

import com.cybage.pojos.Users;

public interface UsersDaoI {
	//validate user
	Users authenticateUser(String email,String pwd) throws Exception;


}

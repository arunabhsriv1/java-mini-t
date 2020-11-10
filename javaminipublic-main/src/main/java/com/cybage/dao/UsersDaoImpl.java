package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.Users;

public class UsersDaoImpl implements UsersDaoI {
	// data members
		private Connection cn;
		private PreparedStatement pst1;

		public UsersDaoImpl() throws Exception {

			// get cn from DB utils
			cn = DbUtil.getConnection();
			// pst1
			pst1 = cn.prepareStatement("select * from Users where email=? and password=?");
			System.out.println("user dao created");
		}
		//clean up
		public void cleanUp() throws Exception
		{
			if(pst1 != null)
				pst1.close();
			if (cn != null)
				cn.close();
			System.out.println("user dao cleaned up");
		}
		
		@Override
		public Users authenticateUser(String email, String pwd) throws Exception {
			// set IN params
			pst1.setString(1, email);
			pst1.setString(2, pwd);
			try(ResultSet rst=pst1.executeQuery())
			{
				if(rst.next())
					return new Users(rst.getInt(1),rst.getString(2),pwd,rst.getString(4),rst.getString(5),rst.getString(6), rst.getString(7));
			}
			return null;
		}


	
}

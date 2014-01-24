package com.soat.happyref.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.soat.happyref.beans.User;

/**
 * @author formation
 *
 */
public class UserDAOImp implements UserDAO{

	private static String SelectUser="SELECT * FROM user WHERE mail=?";
	private static String InsertUser="INSERT INTO user(mail, nom, prenom, password) values(?,?,?,?)";	
	@Override
	public User getUserById(String mail) {
		User user=null;
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/happyreHibernatefDS"); 
			
			if (ds != null){
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(SelectUser);
				//exécution de la requête
			    st.setString(1, mail);
			    ResultSet rs = st.executeQuery();
			    //récupération des données
			    while(rs.next()){
					user = new User(rs.getString("mail"), rs.getString("nom"), rs.getString("prenom"), rs.getString("password"));
			    }
			    
			    rs.close();
			    st.close();
			    conn.close();

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public void insertUser(String mail, String nom, String prenom,
			String password) {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/happyreHibernatefDS"); 
			
			if (ds != null){
				Connection conn = ds.getConnection();
				PreparedStatement st = conn.prepareStatement(InsertUser);
				//exécution de la requête
			    st.setString(1, mail);
			    st.setString(2, nom);
			    st.setString(3, prenom);
			    st.setString(4, password);
			    st.executeUpdate();
			    st.close();
			    conn.close();

			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
}

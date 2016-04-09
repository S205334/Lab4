package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class DictionaryDAO {
	
	private List<String> lang;


	public DictionaryDAO() {}
	
	
	public void loadDictionary() {
		
		lang = new LinkedList<String>();
		
		try {
			Connection conn = DBConnect.getConnection();
			
			Statement st = conn.createStatement();
			
			String sql = "select nome from parola";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next() ) {
				// Aggiungere word alla struttura dati
				lang.add(res.getString("nome").toLowerCase());
			}
			
			res.close();
			conn.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public boolean spellCheckText(String input ) {
		
		try {
			Connection conn = DBConnect.getConnection();
			
			Statement st = conn.createStatement();
				
			String sql = "SELECT nome FROM parola WHERE nome = \""+input+"\"";
				
			ResultSet res = st.executeQuery(sql);
				
			if (res.next()) {
				res.close();
				conn.close();
				return true;
			} else {
				res.close();
				conn.close();
				return false;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	

}

package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.DictionaryDAO;

public class AnagrammiModel {
	
	private DictionaryDAO dao;
	
	public List<String> permuta(String parola) {
		
		List<String> p = new ArrayList<String>();
		
		permuta_ric(0, parola, "",  p);
		
		return p;
	}
	
	public void permuta_ric(int step, String parola, String part , List<String> p) {
		
		if(step == parola.length()) {
			p.add(part);
		} else {
			for (int pos = 0; pos < parola.length(); pos++) {
				
				if (part.indexOf(parola.charAt(pos)) == -1) {
					// add
					part +=(parola.charAt(pos));
					// try
					permuta_ric(step + 1, parola, part, p);
					// restore
					part = part.substring(0, part.length() - 1);
				}
			}
		}
	}
	
	public boolean spellCheckText(String input ) {
		return dao.spellCheckText(input);
	}
	
	public void loadDictionary() {
		dao = new DictionaryDAO();
		dao.loadDictionary();
	}
}

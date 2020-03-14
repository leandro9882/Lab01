package it.polito.tdp.parole.model;

import java.util.*;

public class Parolearray {
		String parola;
		ArrayList<String> parole;
	public Parolearray() {
		parole=new ArrayList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

}



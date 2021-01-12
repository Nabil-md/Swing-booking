package project.sqljava;

import java.time.LocalDate;

public class Activite {
	
	public int id;
    public String nom;
    public LocalDate date;
    
	Activite (int id, String nom, LocalDate date) {
		this.id = id;
		this.nom = nom;
		this.date = date;
    }


	public static void main(String[] args) {
		new Activite(1,"test",LocalDate.of(2020, 01, 01));
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

}

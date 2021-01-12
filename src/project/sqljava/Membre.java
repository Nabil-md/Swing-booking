package project.sqljava;

public class Membre extends Personne {
	
	public int numero;
	public String adresse;
	public String email;
	public String cin;
	public String membership;
	
	
	public Membre(String nom, String prenom, String sexe, int age, int num, String address, String email, String cin, String membership) {
		super(nom, prenom, sexe, age);
		this.numero = num;
		this.adresse = address;
		this.email = email;
		this.cin = cin;
		this.membership = membership;
	}
	
	public String getMembership() {
		return this.membership;
	}
	
	public void changerAdhesion(String newMembership) {
		this.membership = newMembership;
	}
	
	public void annulerAdhesion () {
		this.membership = "canceled";
	}
	
	

	public static void main(String[] args) {
		new Membre("test5", "test5", "test5", 20, 50, "test5", "test5", "test5", "test5");

	}

}

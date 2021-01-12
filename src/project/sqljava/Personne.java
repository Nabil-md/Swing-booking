package project.sqljava;

public class Personne {
	
	public String nom;
    public String prenom;
    public String sexe;
    public int age;
	
	public Personne(String nom, String prenom, String sexe, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getSexe() {
		return this.sexe;
	}
	
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		new Personne("nabil", "mhammdi", "male", 23);

	}

}

package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String titre;
   private int quantite;
public Livre() {
	super();
	// TODO Auto-generated constructor stub
}
public Livre(Integer id, String titre, int quantite) {
	super();
	this.id = id;
	this.titre = titre;
	this.quantite = quantite;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
   
}

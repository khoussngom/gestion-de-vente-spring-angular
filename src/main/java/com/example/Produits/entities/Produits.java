package com.example.Produits.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Produits {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPoduit;
	private String nomProduit;
	private Double prixProduit;
	private Date dateCreation;
	
	
	@ManyToOne
	private Categorie categorie;
	
	






	public Produits(String nomProduit, Double prixProduit, Date dateCreation) {
		super();
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.dateCreation = dateCreation;
	}
	
	
	public Produits() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getIdPoduit() {
		return idPoduit;
	}
	public void setIdPoduit(Long idPoduit) {
		this.idPoduit = idPoduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Produits [idPoduit=" + idPoduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
				+ ", dateCreation=" + dateCreation + "]";
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}

package com.example.Produits.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Produits.entities.Categorie;
import com.example.Produits.entities.Produits;

public interface produitRepositery extends JpaRepository<Produits, Long> {
	
	List<Produits> findByNomProduit(String nom);
	List<Produits> findByNomProduitContains(String nom);
	
	/*@Query("select p from Produits p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produits> findByNomPrix (String nom, Double prix);*/
	
	
	@Query("select p from Produits p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produits> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Produits p where p.categorie = ?1")
	List<Produits> findByCategorie (Categorie categorie);
	
	List<Produits> findByCategorieIdCat(Long id);


	List<Produits> findByOrderByNomProduitAsc();
}

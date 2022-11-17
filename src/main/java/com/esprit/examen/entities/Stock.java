package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStock;
	private String libelleStock;
	private Integer qte;
	private Integer qteMin;
	@OneToMany(mappedBy = "stock")
	@JsonIgnore
	private Set<Produit> produits;
	
	public Stock(String libelleStock, Integer qte, Integer qteMin) {
		super();
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
	}
	
	public Stock(Long id, String libelleStock, Integer qte, Integer qteMin) {
		super();
		this.idStock = id;
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
	}
	
	public Stock() {
	}

	

}
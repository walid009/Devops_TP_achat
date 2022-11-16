	package com.esprit.examen.controllers;

import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.ISecteurActiviteService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.Setter;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivite
	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivite() {
		List<SecteurActivite> list = secteurActiviteService.retrieveAllSecteurActivite();
		return list;
	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-secteurActivite/8
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/add-secteurActivite
	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurActivite addSecteurActivite(@RequestBody SecteurActiviteCategorieAchrefModel secteurActiviteCategorieAchrefModel) {
		SecteurActivite sec = new SecteurActivite();
		sec.setCodeSecteurActivite(secteurActiviteCategorieAchrefModel.getCodeSecteurActivite());
		sec.setLibelleSecteurActivite(secteurActiviteCategorieAchrefModel.getLibelleSecteurActivite());
		secteurActiviteService.addSecteurActivite(sec);
		return secteurActiviteService.addSecteurActivite(sec);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/remove-secteurActivite/{secteurActivite-id}
	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/modify-secteurActivite
	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurActivite modifySecteurActivite(@RequestBody  SecteurActiviteCategorieAchrefModel secteurActiviteCategorieAchrefModel) {
		return secteurActiviteService.updateSecteurActivite(new SecteurActivite(secteurActiviteCategorieAchrefModel.getIdSecteurActivite(),
				secteurActiviteCategorieAchrefModel.getCodeSecteurActivite(), secteurActiviteCategorieAchrefModel.getLibelleSecteurActivite(), secteurActiviteCategorieAchrefModel.getFournisseurs()));
	}

	
}


@Getter
@Setter
class SecteurActiviteCategorieAchrefModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	@ManyToMany(mappedBy="secteurActivites")
	@JsonIgnore
	private Set<Fournisseur> fournisseurs;
}

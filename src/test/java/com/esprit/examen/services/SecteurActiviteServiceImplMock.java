package com.esprit.examen.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplMock {

	@Autowired
	SecteurActiviteServiceImpl secteurActiviteServiceImpl;
	@MockBean
	SecteurActiviteRepository secteurActiviteRepository;

	@Test
	@Order(1)
	public void saveSecteurActiviteTest() {
		SecteurActivite sec = new SecteurActivite("sec1", "categorie 1");
		Mockito.when(secteurActiviteRepository.save(sec)).thenReturn(sec);
		assertEquals(sec, secteurActiviteServiceImpl.addSecteurActivite(sec));
		log.info("Secteur Activity ajouter avec success");
	}
	
	@Test
	@Order(2)
	public void updateSecteurActiviteTest() {
		SecteurActivite sec = new SecteurActivite("sec2", "categorie 2");
		Mockito.when(secteurActiviteRepository.save(sec)).thenReturn(sec);
		assertEquals(sec, secteurActiviteServiceImpl.addSecteurActivite(sec));
		log.info("secteurActivite ajouter avec success");
		sec.setCodeSecteurActivite("sec5");
		sec.setLibelleSecteurActivite("categorie 5");
		Mockito.when(secteurActiviteRepository.save(sec)).thenReturn(sec);
		assertEquals(sec, secteurActiviteServiceImpl.updateSecteurActivite(sec));
		log.info("secteurActivite mdofier avec success");
	}
	
	@Test
	@Order(3)
	public void getAllSecteurActiviteTest() {
		Mockito.when(secteurActiviteRepository.findAll()).thenReturn(Stream
				.of(new SecteurActivite("sec2", "categorie 2"), new SecteurActivite("sec3", "categorie 3")).collect(Collectors.toList()));
		assertEquals(2, secteurActiviteServiceImpl.retrieveAllSecteurActivite().size());
		List<SecteurActivite> listSecteurActivite = secteurActiviteServiceImpl.retrieveAllSecteurActivite();
		log.info("==>size:"+listSecteurActivite.size());
		for(int i=0;i<listSecteurActivite.size();i++){
			log.info("==>"+listSecteurActivite.get(i).getLibelleSecteurActivite());
		}
	}

	@Test
	@Order(4)
	public void deleteSecteurActiviteTest() {
		SecteurActivite sec = new SecteurActivite("sec4", "categorie 4");
		assertNotNull(sec.getCodeSecteurActivite());
		assertNotNull(sec.getLibelleSecteurActivite());
		secteurActiviteServiceImpl.deleteSecteurActivite(sec.getIdSecteurActivite());
		verify(secteurActiviteRepository, times(1)).deleteById(sec.getIdSecteurActivite());
		log.info("secteurActivite supprimer avec success");
	}
	
	@Test
	@Order(5)
	public void deleteAllSecteurActiviteTest() {
		Mockito.when(secteurActiviteRepository.findAll()).thenReturn(Stream
				.of(new SecteurActivite("sec2", "categorie 2"), new SecteurActivite("sec3", "categorie 3")).collect(Collectors.toList()));
		assertEquals(2, secteurActiviteServiceImpl.retrieveAllSecteurActivite().size());
		List<SecteurActivite> listSecteurActivite = secteurActiviteServiceImpl.retrieveAllSecteurActivite();
		log.info("==>size:"+listSecteurActivite.size());
		for(int i=0;i<listSecteurActivite.size();i++){
			secteurActiviteServiceImpl.deleteSecteurActivite(listSecteurActivite.get(i).getIdSecteurActivite());;
			log.info("==> secteurActivite "+listSecteurActivite.get(i).getLibelleSecteurActivite()+" deleted successfulyy ");
		}
	}
}
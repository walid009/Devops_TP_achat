package com.esprit.examen.services;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {

	@Autowired
	IFactureService factureService;
	
	@Test
	public void testAddOperateur() throws ParseException {
		Facture ft = new Facture();
		ft.setMontantFacture(20);
		ft.setMontantRemise(2);
		ft.setArchivee(false);
	
		
		factureService.addFacture(ft);
		log.info("facture ajouter avec success");
	}
	
	@Test
	public void testRetriveFacture() throws ParseException {
		Facture ft = new Facture();
		ft.setMontantFacture(20);
		ft.setMontantRemise(2);
		ft.setArchivee(false);
	
		
		factureService.addFacture(ft);
		log.info("facture ajouter avec success");
		Facture ft1 = factureService.retrieveFacture(ft.getIdFacture());
		
		log.info("facture Retrive avec success");
	}
	
	
	@Test
	public void testDeleteFacture() throws ParseException {
		Facture ft = new Facture();
		ft.setMontantFacture(20);
		ft.setMontantRemise(2);
		ft.setArchivee(false);
	
		
		factureService.addFacture(ft);
		log.info("facture ajouter avec success");
		factureService.cancelFacture(ft.getIdFacture());
		log.info("cancel Facture avec success");
	}
	
	
	@Test
	public void testRetrieveAllFacture() throws ParseException {
		List<Facture> listFactures = factureService.retrieveAllFactures();
		log.info("Nombre Factures: " + listFactures.size()+" \n");
		for(int i=0;i<listFactures.size();i++){
			log.info(""+listFactures.get(i).getMontantFacture());
		}
	}
	
	
}
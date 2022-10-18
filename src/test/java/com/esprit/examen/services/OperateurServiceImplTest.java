package com.esprit.examen.services;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {

	@Autowired
	IOperateurService operateurService;
	
	@Test
	public void testAddOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("wajdi");
		op.setPrenom("brahem");
		op.setPassword("1234");
		
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
	}
	
	@Test
	public void testModifierOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("wajdi");
		op.setPrenom("brahem");
		op.setPassword("1234");
		
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
		
		op.setNom("med wajdi");
		op.setPrenom("BRAHEM");
		op.setPassword("123456789");
		operateurService.updateOperateur(op);
		log.info("operateur modifier avec success");
	}
	
	
	@Test
	public void testDeleteOperateur() throws ParseException {
		Operateur op = new Operateur();
		op.setNom("wajdi");
		op.setPrenom("brahem");
		op.setPassword("1234");
		
		operateurService.addOperateur(op);
		log.info("operateur ajouter avec success");
		operateurService.deleteOperateur(op.getIdOperateur());
		log.info("operateur supprimer avec success");
	}
	
	
	@Test
	public void testRetrieveAllOperateur() throws ParseException {
		List<Operateur> listOperateurs = operateurService.retrieveAllOperateurs();
		log.info("Nombre operateurs: " + listOperateurs.size()+" \n");
		for(int i=0;i<listOperateurs.size();i++){
			log.info(""+listOperateurs.get(i).getNom());
		}
	}
	
	
}

package com.esprit.examen.services;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)
 class FactureServiceImpTest {
    @Mock //Definition d'un mock
    FactureRepository fact;
    @InjectMocks
    FactureServiceImpl facts;

    Facture f = Facture.builder().montantFacture(100000).montantRemise(500).build();
    //List<Facture> list=new ArrayList<Facture>(){
      //  {
        //    add(Facture.builder().dateCreationFacture(new Date("11-09-2022")).dateDerniereModificationFacture(new Date("11-09-2022")).montantFacture(500).montantRemise(50).build());
          //  add(Facture.builder().dateCreationFacture(new Date("11-09-2022")).dateDerniereModificationFacture(new Date("11-09-2022")).montantFacture(600).montantRemise(60).build());
        //}
   // };

    @Test
	 void addFacture() {
		Facture o_add = new Facture();
		o_add.setMontantFacture(200);
		
		Mockito.when(fact.save(ArgumentMatchers.any(Facture.class))).thenReturn(o_add);
		
		Facture o_added = facts.addFacture(o_add);
		assertEquals(o_add.getMontantFacture(),o_added.getMontantFacture());
		verify(fact).save(o_add);
	}
    @Test
	 void retrieveFacture () {
	
		List<Facture> Factures = new ArrayList<>();
		Factures.add(new Facture());

        Mockito.when(fact.findAll()).thenReturn(Factures);
        
        List<Facture> expected = facts.retrieveAllFactures();
        log.info("get ==> " + String.valueOf(Factures));
        assertEquals(expected, Factures);
      

        verify(fact).findAll();
        }
    

	@Test
	 void deleteFacture() {
		Facture o_delete = new Facture();
		o_delete.setIdFacture(1L);

		when(fact.findById(o_delete.getIdFacture())).thenReturn(Optional.of(o_delete));
		facts.deleteFacture(o_delete.getIdFacture());
		verify(fact).deleteById(o_delete.getIdFacture());
	}
	@Test
	 void updateFacture_ifFound() {
		Facture o_edit = new Facture();
		o_edit.setIdFacture(3L);

		Facture new_o_edit = new Facture();

		when(fact.findById(o_edit.getIdFacture())).thenReturn(Optional.of(o_edit));
		o_edit = facts.updateFacture(new_o_edit);
		
		verify(fact).save(o_edit);
	}
	@Test
 void retrieveFactureById() {

		Mockito.when(fact.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Facture facture = facts.retrieveFacture((long) 4);
		assertNotNull(facture);
		log.info("get ==> " + facture.toString());

		verify(fact).findById(Mockito.anyLong());
	}
    
    

    };


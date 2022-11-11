package com.esprit.examen.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {
	
	@Mock
	FactureRepository factureRepository;
	
	@InjectMocks
	FactureServiceImpl factureService;
	
	private Facture facture1 = new Facture(48L, 210L, true);
	private Facture facture2 = new Facture(2L, 480L, false);
	@Test
	public void ajoutFactureTest() {
		when(factureRepository.save(facture1)).thenReturn(facture1);
		assertNotNull(facture1);
		Facture persistee = factureService.addFacture(facture1);
		assertEquals(facture1, persistee);
	}
	
	@Test
	public void retrieveAllFacturesTest() {
		when(factureRepository.findAll()).thenReturn(Stream.of(facture1, facture2).collect(Collectors.toList()));
		assertEquals(2, factureService.retrieveAllFactures().size());
	}
	
	@Test
	public void retrieveFactureTest() {
		when(factureRepository.findById(facture1.getIdFacture())).thenReturn(Optional.of(facture1));
		assertEquals(facture1, factureService.retrieveFacture(facture1.getIdFacture()));
	}
	
}
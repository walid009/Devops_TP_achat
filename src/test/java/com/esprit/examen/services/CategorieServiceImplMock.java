package com.esprit.examen.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.services.CategorieProduitServiceImpl;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



//@Slf4j
@ExtendWith(MockitoExtension.class)
public class CategorieServiceImplMock {
	
	@InjectMocks
    CategorieProduitServiceImpl  categorieProduitServiceImpl ;

    @Mock
    CategorieProduitRepository categorieProduitRepository;


    @Test
    public void addProduitTest(){
    	CategorieProduit cat = new CategorieProduit("cat1", "categorie 1");
        when(categorieProduitRepository.save(cat)).thenReturn(cat);
        assertEquals(cat, categorieProduitServiceImpl.addCategorieProduit(cat));
    }
	/*@Test
	@Order(1)
	public void saveCategorieTest() {
		CategorieProduit cat = new CategorieProduit("cat1", "categorie 1");
		Mockito.when(categorieProduitRepository.save(cat)).thenReturn(cat);
		assertEquals(cat, categorieProduitServiceImpl.addCategorieProduit(cat));
		log.info("categorie ajouter avec success");
	}
	
	@Test
	@Order(2)
	public void updateCategorieTest() {
		CategorieProduit cat = new CategorieProduit("cat2", "categorie 2");
		Mockito.when(categorieProduitRepository.save(cat)).thenReturn(cat);
		assertEquals(cat, categorieProduitServiceImpl.addCategorieProduit(cat));
		log.info("categorie ajouter avec success");
		cat.setCodeCategorie("CAT5");
		cat.setLibelleCategorie("categorie 5");
		Mockito.when(categorieProduitRepository.save(cat)).thenReturn(cat);
		assertEquals(cat, categorieProduitServiceImpl.updateCategorieProduit(cat));
		log.info("categorie mdofier avec success");
	}
	
	@Test
	@Order(3)
	public void getAllCategorieTest() {
		Mockito.when(categorieProduitRepository.findAll()).thenReturn(Stream
				.of(new CategorieProduit("cat2", "categorie 2"), new CategorieProduit("cat2", "categorie 3")).collect(Collectors.toList()));
		assertEquals(2, categorieProduitServiceImpl.retrieveAllCategorieProduits().size());
		List<CategorieProduit> listCategorie = categorieProduitServiceImpl.retrieveAllCategorieProduits();
		log.info("==>size:"+listCategorie.size());
		for(int i=0;i<listCategorie.size();i++){
			log.info("==>"+listCategorie.get(i).getLibelleCategorie());
		}
	}*/

	/*@Test
	//@Order(4)
    public void deleteCategorieTest(){
		CategorieProduit cat = new CategorieProduit("cat4", "categorie 4");
		//assertNotNull(cat.getCodeCategorie());
		//assertNotNull(cat.getLibelleCategorie());
		categorieProduitServiceImpl.deleteCategorieProduit(cat.getIdCategorieProduit());
        verify(categorieProduitRepository, times(1)).deleteById(cat.getIdCategorieProduit());
        //log.info("categorie supprimer avec success");
    }*/
	
	/*@Test
	@Order(5)
	public void deleteAllCategorierTest() {
		Mockito.when(categorieProduitRepository.findAll()).thenReturn(Stream
				.of(new CategorieProduit("cat2", "categorie 2"), new CategorieProduit("cat2", "categorie 3")).collect(Collectors.toList()));
		assertEquals(2, categorieProduitServiceImpl.retrieveAllCategorieProduits().size());
		List<CategorieProduit> listCategorie = categorieProduitServiceImpl.retrieveAllCategorieProduits();
		log.info("==>size:"+listCategorie.size());
		for(int i=0;i<listCategorie.size();i++){
			categorieProduitServiceImpl.deleteCategorieProduit(listCategorie.get(i).getIdCategorieProduit());;
			log.info("==> categorie "+listCategorie.get(i).getLibelleCategorie()+" deleted successfulyy ");
		}
	}*/
}

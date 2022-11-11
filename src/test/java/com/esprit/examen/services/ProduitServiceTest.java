package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;




@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {
    /* test git* */
    @Autowired
    IProduitService ps;

    @Autowired
    IStockService ss;

    @MockBean
    private ProduitRepository pr;

    @MockBean
    private StockRepository SR;


    Produit p1=new Produit(1L,"p1","OMEN",4500,new Date(),new Date(),null,null,null);
    Produit p2=new Produit(1L,"p2","MACBOOK",4000,new Date(),new Date(),null,null,null);
    Stock S=new Stock(1L,"S1",100,3,null);

    //Reruperer tout les produits
    @Test
    public void retrieveAllProduitsTest() {
        when(pr.findAll()).thenReturn(Stream
                .of(p1,p2)
                .collect(Collectors.toList()));
        assertEquals(2,ps.retrieveAllProduits().size());
        System.out.println("Retrieved All Products With success");
    }

    //Ajouter un produit
    @Test
    public void addProduitTest() {
        when(pr.save(p1)).thenReturn(p1);
        assertNotNull(p1);
        assertEquals(p1, ps.addProduit(p1));
        System.out.println("Added Product With success");
    }

    //Suppression d'un produit
    @Test
    public void DeleteProduitTest() {
        pr.save(p1);
        ps.deleteProduit(p1.getIdProduit());
        verify(pr, times(1)).deleteById(p1.getIdProduit());
        System.out.println("Deleted Product With success");

    }

    //Recuperation d'un produit
    @Test
    public void retrieveProduitTest() {
        when(pr.findById(p1.getIdProduit())).thenReturn(Optional.of(p1));
        assertEquals(p1, ps.retrieveProduit(p1.getIdProduit()));
        System.out.println("Retrieved Product With success");
    }
}

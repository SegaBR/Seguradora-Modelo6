/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirCarro {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCarro() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Seguradora-Modelo6PU");
        em = emf.createEntityManager();        
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Carro obj = new Carro();
        obj.setPlaca("1234567");
        obj.setRenavam("1234567891");
        obj.setModelo("sedan");
        obj.setFabricante("Honda");
        obj.setAnoFabricacao(1999);
        obj.setAnoModelo(1999);
        Pessoa pe= new Pessoa();
        pe.setCpf("025.732.510-71");
        pe.setEmail("christofersega@gmail.com");
        pe.setNome("Christofer");
        pe.setRg("1234567890");
        pe.setTelefone("(54)98110-04");
        obj.setPessoa(pe);
        
        
        em.getTransaction().begin();
        em.persist(pe);
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}

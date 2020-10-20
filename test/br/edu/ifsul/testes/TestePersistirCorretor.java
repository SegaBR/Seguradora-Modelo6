/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Corretor;
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
public class TestePersistirCorretor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCorretor() {
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
        Corretor cor = new Corretor();
        cor.setCpf("025.732.510-71");
        cor.setEmail("christofersega@gmail.com");
        cor.setNome("Christofer");
        cor.setRg("1234567890");
        cor.setTelefone("(54)98110-04");
        cor.setNomeUsuario("Christofer25");
        cor.setPercentualComissao(2.5);
        cor.setSenha("senha123");
        
        
        em.getTransaction().begin();
        em.persist(cor);
        em.getTransaction().commit();        
    }
    
}

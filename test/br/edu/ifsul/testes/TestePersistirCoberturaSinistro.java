/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Sinistro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Seguro;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kakaz
 */
public class TestePersistirCoberturaSinistro {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCoberturaSinistro() {
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
        em.getTransaction().begin();
        
        Seguro obj=new Seguro();
        Calendar d = Calendar.getInstance(); 
        
        obj=em.find(Seguro.class, 3);
        
        Cobertura cob=new Cobertura();
        cob.setDescricao("danos naturais");
        cob.setValor(100.0);
        cob.setSeguro(obj);
        em.persist(cob);
        
        obj.getCobertura().add(cob);
        
        cob=new Cobertura();
        cob.setDescricao("roubos");
        cob.setValor(100.0);
        cob.setSeguro(obj);
        em.persist(cob);
        
        obj.getCobertura().add(cob);
        
        Sinistro sin=new Sinistro();
        sin.setDescricao("carro caiu do penhasco e veio um robo e quebro ele todinho");
        d.set(2020, 10, 21);
        sin.setData(d);
        sin.setCidade("Passo Fundo");
        sin.setEstado("Rio Grande do Sul");
        sin.setSeguro(obj);
        em.persist(sin);
        
        obj.getSinistro().add(sin);
        
        sin=new Sinistro();
        sin.setDescricao("capotei o corsa");
        d.set(2020, 10, 21);
        sin.setData(d);
        sin.setCidade("Passo Fundo");
        sin.setEstado("Rio Grande do Sul");
        sin.setSeguro(obj);
        em.persist(sin);
        
        obj.getSinistro().add(sin);
        
        em.merge(obj);
        em.getTransaction().commit();        
    }
}

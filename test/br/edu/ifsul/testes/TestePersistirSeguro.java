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
public class TestePersistirSeguro {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirSeguro() {
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
        
        Seguro obj = new Seguro();
        
        Calendar d = Calendar.getInstance(); 
        d.set(2020, 10, 21);
        obj.setData(d);
        
        d.set(2020, 10, 21);
        obj.setInicioVigencia(d);
        
        d.set(2021, 10, 21);
        obj.setFimVigencia(d);
        
        obj.setValorTotal(200.0);
        obj.setValorFipe(12000.0);
        
        Corretor cor = new Corretor();
        cor.setCpf("549.149.430-50");
        cor.setEmail("corretor@gmail.com");
        cor.setNome("Corretor seguro");
        cor.setRg("1234567890");
        cor.setTelefone("(54)98110-04");
        cor.setNomeUsuario("Christofer25");
        cor.setPercentualComissao(2.5);
        cor.setSenha("senha123");
        
        em.persist(cor);
        
        obj.setCorretor(cor);
        
        obj.setCarro(em.find(Carro.class, 18));
        
        em.persist(obj);
        /*obj=em.find(Seguro.class, 1);
        
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
        
        em.merge(obj); */
        em.getTransaction().commit();        
    }
}

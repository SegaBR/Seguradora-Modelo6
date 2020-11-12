/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author kakaz
 */
public class UtilRelatorios {
    public static List<Seguro> listaSeguros(){
        List<Seguro> lista= new ArrayList<>();
        
        Carro obj = new Carro();
        obj.setPlaca("1234567");
        obj.setRenavam("1234567891");
        obj.setModelo("sedan");
        obj.setFabricante("Honda");
        obj.setAnoFabricacao(1999);
        obj.setAnoModelo(1999);
        
        Pessoa pe= new Pessoa();
        pe.setCpf("899.725.820-60");
        pe.setEmail("teste@gmail.com");
        pe.setNome("teste");
        pe.setRg("1234567890");
        pe.setTelefone("(54)98110-04");
        obj.setPessoa(pe);
        
        Acessorios ac=new Acessorios();
        ac.setDescricao("Direção hidraulica");
        obj.getAcessoriosCarro().add(ac);
     
        Acessorios ace=new Acessorios();
        ace.setDescricao("ABS");
        obj.getAcessoriosCarro().add(ace);
        
        Seguro seg = new Seguro();
        Calendar d = Calendar.getInstance(); 
        d.set(2020, 10, 9);
        seg.setData(d);
        d.set(2020, 10, 10);
        seg.setInicioVigencia(d);
        d.set(2021, 10, 11);
        seg.setFimVigencia(d);
        seg.setValorTotal(200.0);
        seg.setValorFipe(12000.0);
        
        Corretor cor = new Corretor();
        cor.setCpf("549.149.430-50");
        cor.setEmail("corretor@gmail.com");
        cor.setNome("Corretor seguro");
        cor.setRg("1234567890");
        cor.setTelefone("(54)98110-04");
        cor.setNomeUsuario("Christofer25");
        cor.setPercentualComissao(2.5);
        cor.setSenha("senha123");
        
        seg.setCorretor(cor);
        seg.setCarro(obj);
        
        lista.add(seg);
        
        seg = new Seguro();
        d.set(2020, 10, 21);
        seg.setData(d);
        d.set(2020, 10, 21);
        seg.setInicioVigencia(d);
        d.set(2021, 10, 21);
        seg.setFimVigencia(d);
        seg.setValorTotal(200.0);
        seg.setValorFipe(12000.0);
        seg.setCorretor(cor);
        seg.setCarro(obj);
        
        lista.add(seg);
        
        return lista;
    }
    
    public static List<Seguro> listaSegurosSub(){
        List<Seguro> lista= new ArrayList<>();
        
        Carro obj = new Carro();
        obj.setPlaca("1234567");
        obj.setRenavam("1234567891");
        obj.setModelo("sedan");
        obj.setFabricante("Honda");
        obj.setAnoFabricacao(1999);
        obj.setAnoModelo(1999);
        
        Pessoa pe= new Pessoa();
        pe.setCpf("899.725.820-60");
        pe.setEmail("teste@gmail.com");
        pe.setNome("teste");
        pe.setRg("1234567890");
        pe.setTelefone("(54)98110-04");
        obj.setPessoa(pe);
        
        Acessorios ac=new Acessorios();
        ac.setDescricao("Direção hidraulica");
        obj.getAcessoriosCarro().add(ac);
     
        Acessorios ace=new Acessorios();
        ace.setDescricao("ABS");
        obj.getAcessoriosCarro().add(ace);
        
        Seguro seg = new Seguro();
        Calendar d = Calendar.getInstance(); 
        d.set(2020, 10, 9);
        seg.setData(d);
        d.set(2020, 10, 10);
        seg.setInicioVigencia(d);
        d.set(2021, 10, 11);
        seg.setFimVigencia(d);
        seg.setValorTotal(200.0);
        seg.setValorFipe(12000.0);
        
        Corretor cor = new Corretor();
        cor.setCpf("549.149.430-50");
        cor.setEmail("corretor@gmail.com");
        cor.setNome("Corretor seguro");
        cor.setRg("1234567890");
        cor.setTelefone("(54)98110-04");
        cor.setNomeUsuario("Christofer25");
        cor.setPercentualComissao(2.5);
        cor.setSenha("senha123");
        
        seg.setCorretor(cor);
        seg.setCarro(obj);
        
        lista.add(seg);
        
        seg = new Seguro();
        d.set(2020, 10, 21);
        seg.setData(d);
        d.set(2020, 10, 21);
        seg.setInicioVigencia(d);
        d.set(2021, 10, 21);
        seg.setFimVigencia(d);
        seg.setValorTotal(200.0);
        seg.setValorFipe(12000.0);
        seg.setCorretor(cor);
        seg.setCarro(obj);
        
        //-----
        
        Cobertura cob=new Cobertura();
        cob.setDescricao("danos naturais");
        cob.setValor(100.0);
        cob.setSeguro(seg);
        seg.getCobertura().add(cob);
        
        cob=new Cobertura();
        cob.setDescricao("roubos");
        cob.setValor(100.0);
        cob.setSeguro(seg);
        seg.getCobertura().add(cob);
        
        Sinistro sin=new Sinistro();
        sin.setDescricao("carro caiu do penhasco e veio um robo e quebro ele todinho");
        d.set(2020, 10, 21);
        sin.setData(d);
        sin.setCidade("Passo Fundo");
        sin.setEstado("Rio Grande do Sul");
        sin.setSeguro(seg);
        seg.getSinistro().add(sin);
        
        sin=new Sinistro();
        sin.setDescricao("capotei o corsa");
        d.set(2020, 10, 21);
        sin.setData(d);
        sin.setCidade("Passo Fundo");
        sin.setEstado("Rio Grande do Sul");
        sin.setSeguro(seg);
        seg.getSinistro().add(sin);
         
        lista.add(seg);
        
        return lista;
    }
    
    
}

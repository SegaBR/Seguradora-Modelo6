/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kakaz
 */
@Entity
@Table(name = "seguro")
public class Seguro implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)     
    private Integer id;
    
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "O inicio vigencia deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicioVigencia", nullable = false)
    private Calendar inicioVigencia;
    
    @NotNull(message = "O fim vigencia deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "fimVigencia", nullable = false)
    private Calendar fimVigencia;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    
    @NotNull(message = "O valor fipe deve ser informado")
    @Column(name = "valorFipe", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorFipe;
    
    @NotNull(message = "O corretor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "corretor", referencedColumnName = "id", nullable = false)
    private Corretor corretor;  
    
    @NotNull(message = "O carro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    private Carro carro; 
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sinistro> sinistro = new ArrayList<>();
    
    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cobertura> cobertura = new ArrayList<>();
    
    public Seguro() {
        valorTotal=0.0;
        valorFipe=0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Sinistro> getSinistro() {
        return sinistro;
    }

    public void setSinistro(List<Sinistro> sinistro) {
        this.sinistro = sinistro;
    }

    public List<Cobertura> getCobertura() {
        return cobertura;
    }

    public void setCobertura(List<Cobertura> cobertura) {
        this.cobertura = cobertura;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

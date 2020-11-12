/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author kakaz
 */
@Entity
@Table(name="acessorios")
public class Acessorios {
    @Id
    @SequenceGenerator(name = "seq_acessorios", sequenceName = "seq_acessorios_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorios",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max=50,message="A descrição não pode ter mais que {max} caracteres")
    @NotBlank(message="A descrição não pode ser em branco")
    @Column(name="descricao", length=50, nullable =false)
    private String descricao;
    
    //@ManyToMany(fetch=FetchType.LAZY)
    //@JoinTable(name="acessorios_carro", 
    //       joinColumns =@JoinColumn(name="acessorios", referencedColumnName="id", nullable=false), 
    //    inverseJoinColumns= @JoinColumn(name="carro", referencedColumnName="id", nullable=false))
    //private Set<Carro> Carroacessorios = new HashSet<>();
    
    public Acessorios(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   // public Set<Carro> getCarroacessorios() {
    //    return Carroacessorios;
   // }

   // public void setCarroacessorios(Set<Carro> Carroacessorios) {
    //    this.Carroacessorios = Carroacessorios;
   // }
    
}

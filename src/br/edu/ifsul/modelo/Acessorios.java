/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    
}

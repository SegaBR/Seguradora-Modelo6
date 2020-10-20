/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author kakaz
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A placa deve ser informada")
    @Length(max = 7, message = "A placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;
       
    @NotBlank(message = "A renavam deve ser informada")
    @Length(max = 11, message = "A renavam não pode ter mais que {max} caracteres")
    @Column(name = "renavam", nullable = false, length = 11)
    private String renavam;
    
    @NotBlank(message = "A modelo deve ser informada")
    @Length(max = 20, message = "A modelo não pode ter mais que {max} caracteres")
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    
    @NotBlank(message = "A fabricante deve ser informada")
    @Length(max = 50, message = "A fabricante não pode ter mais que {max} caracteres")
    @Column(name = "fabricante", nullable = false, length = 50)
    private String fabricante;
    
    @NotNull(message = "O ano de fabricação deve ser informado")
    @Column(name = "anoFabricacao", nullable = false)
    private Integer anoFabricacao;
      
    @NotNull(message = "O ano do modelo deve ser informado")
    @Column(name = "anoModelo", nullable = false)
    private Integer anoModelo;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;  
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

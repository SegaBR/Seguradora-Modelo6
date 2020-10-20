package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author kakaz
 */
@Entity
@Table(name="corretor")
public class Corretor extends Pessoa implements Serializable {
   
    @NotNull(message="O percentualComissao não pode ser nulo")
    @Column(name = "percentualComissao", precision = 2, nullable=false)
    private double percentualComissao;
    
    @Length(max=20,message="O nome de usuário não pode ter mais que {max} caracteres")
    @NotBlank(message="O nome do usuário não pode ser em branco")
    @Column(name="nomeUsuario", length=20, nullable =false)
    private String nomeUsuario;
    
    @Length(max=10,message="A senha não pode ter mais que {max} caracteres")
    @NotBlank(message="A senha não pode ser em branco")
    @Column(name="senha", length=10,nullable =false)
    private String senha;

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}

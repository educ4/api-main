package br.com.elostartup.api.Professor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/***
 * Entidade Professor com 5 atributos
 * Esta classe está recebendo os dados do DTO DadosCadastroProfessor
 */
@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cfep")
public class Professor {

    @Id
    private String cfep;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String email;
    private String senha;

    /***
     * Criação de construtor Professor para receber dados vindo da entidade e passar para o ProfessorRepository
     * @param dados
     */
    public Professor(DadosCadastroProfessor dados) {
        this.cfep = dados.cfep();
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoProfessor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
    }
}

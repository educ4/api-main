package br.com.elostartup.api.Aluno;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

/***
 * Classe Aluno com 5 Atributos
 * Esta classe recebe os dados do DTO DadosCadastroAluno
 */
@Table(name="alunos")
@Entity(name="Alunos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Aluno {

    @Id
    private String cpf;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String email;
    private String senha;


    /***
     * Criação de construtor Aluno para receber dados vindo da entidade e passar para o AlunoRepository
     *
     */
    public Aluno(DadosCadastroAluno dados) {
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.email = dados.email();
        this.senha = dados.senha();

    }
            /***
     * Criação de construtor atualizarInformacoes para atualizar dados vindo do DTO dados atualizacaoAluno e fazer a atualização de dados
     *
     */

    public void atualizarInformacoes(@Valid DadosAtualizacaoAluno dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }


    }
}

package br.com.elostartup.api.Aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Criação DTO Aluno (Data Transfer Object Protocol)
 * DTO cria e recebe informações, com classes e campos que queremos devolver da API
 * Esta classe envia dados para a entidade Aluno
 */

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @CPF
        @NotBlank
        String cpf,
        @NotNull
        Sexo sexo,
        @NotNull
        @Email
        String email,
        @NotBlank
        String senha) {
}

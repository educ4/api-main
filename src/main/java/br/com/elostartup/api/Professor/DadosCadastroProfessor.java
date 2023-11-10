package br.com.elostartup.api.Professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Criação DTO Professor (Data Transfer Object Protocol)
 * DTO cria e recebe informações, com classes e campos que queremos devolver da API
 * Esta classe envia dados para a entidade Professor
 */
public record DadosCadastroProfessor(
        @NotBlank
        String nome,
        
        @Pattern(regexp = "^BRA-\\d{6}$")
        @NotBlank
        String cfep,

        @NotNull
        Sexo sexo,

        @NotNull
        @Email
        String email,

        @NotBlank
        String senha) {
}

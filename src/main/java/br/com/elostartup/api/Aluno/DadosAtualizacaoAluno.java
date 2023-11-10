package br.com.elostartup.api.Aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

    @NotNull
    String cpf, 

    String nome, 
    
    String senha) {

} 
    


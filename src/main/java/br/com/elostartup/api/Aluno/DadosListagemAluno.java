package br.com.elostartup.api.Aluno;

public record DadosListagemAluno(String nome, String senha, String cpf, String email, Sexo sexo) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getNome(), aluno.getSenha(), aluno.getCpf(), aluno.getEmail(), aluno.getSexo());
    }
}

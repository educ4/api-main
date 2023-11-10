package br.com.elostartup.api.Aluno;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Classe Aluno controladora, todos os processos de modelo de negocio como persistências de dados estão percorrendo tudo por aqui!*/

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    /***
     * Atributo AlunoRepository, carregamento de interface
     * AutoWired mêcanismo de Injeção de dependências
     */

    @Autowired
    private AlunoRepository alunoRepository;

    /***
     * Criado um metodo cadastro para receber dados do DTO, usando Interface alunoRepository para salvar os dados na entidade Aluno;
     * Criado um novo objeto Aluno, dentro do metodo e passado um parametro dados do DTO, foi criado um construtor dentro da entidade para passar os dados.
     *
     */

    /***
     * Colocada a anotação @Transactional nos metodos que precisam de transação ex.: nos métodos para salvar, editar e excluir.
     *
     */

    /***
     * Valid spring integra com bean validarion e executa as validação em cima do DTO DadosCadastroAluno
     *
     */


    @PostMapping("/cadastro")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados){
        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping("/listar")
    public List<DadosListagemAluno> listagem(){
        return alunoRepository.findAll().stream().map(DadosListagemAluno::new).toList();
    }

    @PutMapping("/editar")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = alunoRepository.getReferenceById(dados.cpf());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public void excluir(@PathVariable String cpf){
        alunoRepository.deleteById(cpf);
    }
}

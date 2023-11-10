package br.com.elostartup.api.Professor;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/*Classe Professor controladora, todos os processos de modelo de negocio como persistências de dados estão percorrendo tudo por aqui!*/
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    /***
     * Atributo ProfessorRepository, carregamento de interface
     * @AutoWired mêcanismo de Injeção de dependências
     */
    @Autowired
    private ProfessorRepository professorRepository;

    /***
     * Criado um metodo cadastro para receber dados do DTO, usando Interface alunoRepository para salvar os dados na entidade Professor;
     * Criado um novo objeto Professor, dentro do metodo e passado um parametro dados do DTO, foi criado um construtor dentro da entidade para passar os dados.
     * @param dados
     */

    /***
     * Colocada a anotação @Transactional nos metodos que precisam de transação ex.: nos métodos para salvar, editar e excluir.
     * @param dados
     */

    /***
     * @Valid spring integra com bean validarion e executa as validação em cima do DTO DadosCadastroProfessor
     * @param dados
     */
    @PostMapping("/cadastro")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProfessor dados){
        professorRepository.save(new Professor(dados));
    }

    @GetMapping("/listar")
    public List<DadosListagemProfessor> listagem(){
        return professorRepository.findAll().stream().map(DadosListagemProfessor::new).toList();
    }

    @PutMapping("/editar")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados){
        var professor = professorRepository.getReferenceById(dados.cfep());
        professor.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{cfep}")
    @Transactional
    public void excluir(@PathVariable String cfep){
        professorRepository.deleteById(cfep);
    }

}

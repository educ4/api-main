package br.com.elostartup.api.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * Interface Repository onde faz todas as persistências dos dados
 */
public interface AlunoRepository extends JpaRepository<Aluno, String> {
}

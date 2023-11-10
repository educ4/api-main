package br.com.elostartup.api.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * Interface Repository onde faz todas as persistências dos dados
 */
public interface ProfessorRepository extends JpaRepository<Professor, String> {
}

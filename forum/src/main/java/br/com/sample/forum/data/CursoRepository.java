package br.com.sample.forum.data;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sample.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}

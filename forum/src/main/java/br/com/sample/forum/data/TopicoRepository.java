package br.com.sample.forum.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sample.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}

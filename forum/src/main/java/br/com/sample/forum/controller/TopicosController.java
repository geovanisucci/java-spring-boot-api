package br.com.sample.forum.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sample.forum.commands.CreateTopicoCommand;
import br.com.sample.forum.commands.UpdateTopicoCommand;
import br.com.sample.forum.data.CursoRepository;
import br.com.sample.forum.data.TopicoRepository;
import br.com.sample.forum.dto.TopicoDTO;
import br.com.sample.forum.modelo.Curso;
import br.com.sample.forum.modelo.Topico;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	// @RequestMapping(name = "/topicos/", method = RequestMethod.GET)
	@GetMapping
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TopicoDTO>> lista(String nomeCurso) {

		List<Topico> topicos;
		if (nomeCurso == null) {
			topicos = topicoRepository.findAll();
		} else {
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		}

		return new ResponseEntity<List<TopicoDTO>>(TopicoDTO.converter(topicos), HttpStatus.OK);
	}

	@PostMapping
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid CreateTopicoCommand command,
			UriComponentsBuilder uriBuilder) {

		Topico topico = command.converter(cursoRepository);

		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicoDTO> detalhar(@PathVariable Long id) {

		Optional<Topico> topico = topicoRepository.findById(id);

		if (!topico.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		TopicoDTO dto = new TopicoDTO(topico.get());

		return ResponseEntity.ok(dto);
	}

	@PutMapping("/{id}")
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateTopicoCommand command)
			throws Exception {

		Topico topico = command.atualizar(id, topicoRepository);

		// throw new Exception("Exception message");

		if (topico == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();

	}

	@DeleteMapping("/{id}")
	@Transactional(rollbackOn = Exception.class)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Topico> topico = topicoRepository.findById(id);

		if (!topico.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		topicoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}

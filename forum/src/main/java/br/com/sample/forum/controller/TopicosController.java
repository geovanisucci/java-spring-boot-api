package br.com.sample.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.forum.data.TopicoRepository;
import br.com.sample.forum.dto.TopicoDTO;
import br.com.sample.forum.modelo.Curso;
import br.com.sample.forum.modelo.Topico;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;

	// @RequestMapping(name = "/topicos/", method = RequestMethod.GET)
	@RequestMapping("/topicos")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TopicoDTO>> lista(String nomeCurso) {
		
		List<Topico> topicos;
		if(nomeCurso == null) {
			topicos = topicoRepository.findAll();
		}
		else {
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		}
		
		return new ResponseEntity<List<TopicoDTO>>(TopicoDTO.converter(topicos), HttpStatus.OK);
	}
	/*
	@RequestMapping("/topicos")
	public ResponseEntity<List<TopicoDTO>> listaPorNome(String nomeCurso) {
		List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
		return new ResponseEntity<List<TopicoDTO>>(TopicoDTO.converter(topicos), HttpStatus.OK);
	}*/

}

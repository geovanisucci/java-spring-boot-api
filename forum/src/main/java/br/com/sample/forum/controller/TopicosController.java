package br.com.sample.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sample.forum.dto.TopicoDTO;
import br.com.sample.forum.modelo.Curso;
import br.com.sample.forum.modelo.Topico;

@RestController
public class TopicosController {

	// @RequestMapping(name = "/topicos/", method = RequestMethod.GET)
	@RequestMapping("/topicos")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TopicoDTO>> lista() {

		Topico topico = new Topico("Dúvida", "Dúvida com o Spring", new Curso("Spring  Boot", "Programação"));
		return new ResponseEntity<List<TopicoDTO>>(TopicoDTO.converter(Arrays.asList(topico, topico, topico)), HttpStatus.OK);
	}

}

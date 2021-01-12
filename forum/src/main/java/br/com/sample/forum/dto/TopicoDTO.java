package br.com.sample.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.sample.forum.modelo.Topico;

public class TopicoDTO {

	public TopicoDTO(Topico topico) {

		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();

	}

	public UUID getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	private UUID id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	public static List<TopicoDTO> converter(List<Topico> topicos) {

		return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());

	}

}

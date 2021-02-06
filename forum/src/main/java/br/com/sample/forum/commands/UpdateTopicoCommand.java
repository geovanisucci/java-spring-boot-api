package br.com.sample.forum.commands;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.sample.forum.data.TopicoRepository;
import br.com.sample.forum.modelo.Topico;

public class UpdateTopicoCommand {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String titulo;
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		//Topico topico = topicoRepository.getOne(id);
		Optional<Topico> topico = topicoRepository.findById(id);
		
		if(!topico.isPresent()) {
			return null;
		}
		
		topico.get().setTitulo(this.titulo);
		topico.get().setMensagem(this.mensagem);
		
		return topico.get();
	}

}

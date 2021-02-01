package br.com.sample.forum.commands;

import br.com.sample.forum.data.CursoRepository;
import br.com.sample.forum.modelo.Curso;
import br.com.sample.forum.modelo.Topico;

public class CreateTopicoCommand {
	
	private String titulo;
	private String mensagem;
	private String nomeCurso;
	
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
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico converter(CursoRepository cursoRepository) {
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		return new Topico(titulo, mensagem, curso);
	}


}

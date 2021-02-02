package br.com.sample.forum.config.validacao;

public class ErroCommandDTO {
	
	private String campo;
	private String erro;
	public ErroCommandDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
	
	
}

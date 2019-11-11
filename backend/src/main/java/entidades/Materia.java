package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String descricao;
	
	/*
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private ArrayList<Nota> notas;
*/
	private float media;
	private int tipoMedia;
	// tipo 1- m�dia aritm�tica
	// tipo 2- m�dia ponderada
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/*
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	*/
	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public int getTipoMedia() {
		return tipoMedia;
	}
	public void setTipoMedia(int tipoMedia) {
		this.tipoMedia = tipoMedia;
	}
	
	public void calculaMedia() {
		if(this.tipoMedia == 1) {
		
		}
	}
	
	
	
}

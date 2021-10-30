/**
 * Feito por:
 * Ana Beatriz ---------- Ht191054x
 * Priscila Alves ------- Ht1910299
 * Vitória Santos ------- Ht191085x
 * 
 * Última modificação:
 * 05/08/2020
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	
	private String nome;
	private String genero;
	private String plataforma;
	private String status;
	private int avaliacao;
	private int id;

	
	//Constructor
	public Filme(String nome, String genero, String plataforma, String status, int avaliacao) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.plataforma = plataforma;
		this.status = status;
		this.avaliacao = avaliacao;
		
	}
	
	//getter and setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	



}

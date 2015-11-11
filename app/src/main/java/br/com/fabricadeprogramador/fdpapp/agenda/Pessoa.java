package br.com.fabricadeprogramador.fdpapp.agenda;

import java.io.Serializable;

/**
 * Created by Virmerson on 11/10/15.
 */
public class Pessoa implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private int imagem;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, int imagem) {
        this.nome=nome;
        this.imagem= imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}

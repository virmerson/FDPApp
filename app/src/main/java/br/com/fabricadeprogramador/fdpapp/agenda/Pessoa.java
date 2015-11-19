package br.com.fabricadeprogramador.fdpapp.agenda;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Virmerson on 11/10/15.
 */
public class Pessoa implements Serializable {

    private Long id;
    private String nome;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String email;
    private String telefone;
    private int imagem;
    public Bitmap img;
    public Pessoa(String nome, Bitmap imagem) {
        this.nome = nome;
        this.img = imagem;
    }


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

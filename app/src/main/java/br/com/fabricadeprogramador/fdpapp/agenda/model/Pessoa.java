package br.com.fabricadeprogramador.fdpapp.agenda.model;

import android.graphics.Bitmap;

import java.io.Serializable;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by Virmerson on 11/10/15.
 */
@Table("tbpessoa")
public class Pessoa extends Model implements Serializable {

    @Key
    @AutoIncrement
    @Column("id")
    private long id;

    @Column("nome")
    private String nome;


    @Column("email")
    private String email;

    @Column("telefone")
    private String telefone;


    private int imagem;

    public Bitmap img;
    public Pessoa(String nome, Bitmap imagem) {
        this.nome = nome;
        this.img = imagem;
    }

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
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

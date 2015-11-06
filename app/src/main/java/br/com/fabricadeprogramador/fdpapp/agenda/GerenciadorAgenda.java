package br.com.fabricadeprogramador.fdpapp.agenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 11/5/15.
 */
public class GerenciadorAgenda {

   private static List<String> nomes = new ArrayList<>();

    public static void adicionar(String nome) {
        nomes.add(nome);
    }
    public static List<String> getNomes(){
        return nomes;
    }
}

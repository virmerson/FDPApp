package br.com.fabricadeprogramador.fdpapp.agenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virmerson on 11/5/15.
 */
public class GerenciadorAgenda {

    private static List<Pessoa> pessoaList = new ArrayList<>();

    public static void adicionar(Pessoa pessoa) {
        pessoaList.add(pessoa);
    }

    public static List<Pessoa> getPessoaList() {
        return pessoaList;
    }
}

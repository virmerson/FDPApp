package br.com.fabricadeprogramador.fdpapp.agenda.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fabricadeprogramador.fdpapp.R;
import br.com.fabricadeprogramador.fdpapp.agenda.model.Pessoa;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Virmerson on 11/10/15.
 */
public class PessoaListAdapter extends ArrayAdapter<Pessoa> {


    public PessoaListAdapter(Context context, List<Pessoa> pessoaList) {
        super(context, R.layout.item_pessoa_lista , pessoaList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if(convertView==null){
            convertView = View.inflate(getContext(), R.layout.item_pessoa_lista,null);

            holder = new ViewHolder();

            ButterKnife.bind(holder, convertView);
            //Vinculando o holder contentView
            convertView.setTag(holder);

        }else {
            //Reaproveitando Holder
            holder = (ViewHolder)convertView.getTag();
        }


        Pessoa pessoa = getItem(position);
        if (pessoa!=null) {
            holder.id.setText(String.valueOf(pessoa.getId()));
            holder.nome.setText(pessoa.getNome());
            holder.imagem.setImageResource(pessoa.getImagem());
        }


        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.pessoa_imagem)
        ImageView imagem;

        @Bind(R.id.pessoa_id)
        TextView id;

        @Bind(R.id.pessoa_nome)
         TextView nome;
    }
}

package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Virmerson on 11/17/15.
 */
public class BancoDeDados extends SQLiteOpenHelper {

    private final String NOME_BANCO= "pessoasdb";
    private final int VERSAO_BANCO =2;


    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tbpessoa ( id integer primary key, nomemae text, nome text, email text, telefone text )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql ="drop table if exists tbpessoa";
        db.execSQL(sql);

        onCreate(db);

    }
    public void salvar (Pessoa pessoa){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("email", pessoa.getEmail());
        values.put("telefone", pessoa.getTelefone());

        db.insert("tbpessoa",null, values);

        db.close();

    }
}

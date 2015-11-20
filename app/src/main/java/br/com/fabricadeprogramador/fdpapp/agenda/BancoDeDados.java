package br.com.fabricadeprogramador.fdpapp.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Virmerson on 11/17/15.
 */
public class BancoDeDados extends SQLiteOpenHelper {

    private static  final String NOME_BANCO= "pessoasdb";
    private static final int VERSAO_BANCO =1;


    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tbpessoa ( id integer primary key,  nome text, email text, telefone text )";
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

        if (pessoa.getId()==null) {
            db.insert("tbpessoa", null, values);
        }else {
            //update tbpessoa set nome='jao', email ='jao@htcursos.com', telefone= '(67)3387-2941' where id=10
            db.update("tbpessoa", values, "id = ?", new String[]{pessoa.getId().toString()});
        }
        db.close();

    }

    public List<Pessoa> buscarTodos(){

        List<Pessoa> lista =  new ArrayList<>();
        //Preencher

        String sql = "select * from tbpessoa";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst()){


            do{
               //Pega do cursor e coloca em objeto Pessoa
                Pessoa pessoa = new Pessoa();
                pessoa.setId(cursor.getLong(0));
                pessoa.setNome(cursor.getString(1));
                pessoa.setEmail(cursor.getString(2));
                pessoa.setTelefone(cursor.getString(3));
                //Coloca na Lista

                lista.add(pessoa);

            }while (cursor.moveToNext());

        }

        return lista;
    }





}

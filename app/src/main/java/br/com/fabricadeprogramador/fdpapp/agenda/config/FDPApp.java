package br.com.fabricadeprogramador.fdpapp.agenda.config;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by Virmerson on 12/1/15.
 */
public class FDPApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //Criar contexto do Sprinks

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new Migration() {
            @Override
            protected void doMigration(SQLiteDatabase db) {
                //O que fazer? Criar a tabela

                String sql = "create table tbpessoa ( id integer primary key,  nome text, email text, telefone text )";
                db.execSQL(sql);
            }
        });



    }
}

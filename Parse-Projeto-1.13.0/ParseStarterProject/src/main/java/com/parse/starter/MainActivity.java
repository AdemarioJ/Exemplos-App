/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends Activity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ParseObject pontuacao = new ParseObject("Pontuacao");
    pontuacao.put("nome", "Jamilton");
    pontuacao.put("pontos", 100);
    pontuacao.put("nome", "Maria");
    pontuacao.put("pontos", 100);
    pontuacao.put("nome", "Marcos");
    pontuacao.put("pontos", 100);
    pontuacao.put("nome", "Leticia");
    pontuacao.put("pontos", 100);
    pontuacao.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null){ // Não temos erros pois o objeto está nulo
          Log.i("SalvarPontos", "Dados salvos com sucesso!");
        }else {
          Log.i("SalvarPontos", "Erro ao salvar os dados!");
        }
      }
    });
    /*
    ParseQuery<ParseObject> consulta = ParseQuery.getQuery("Pontuacao");
    consulta.getInBackground("xnwHOjOY7e", new GetCallback<ParseObject>() {
              @Override
              public void done(ParseObject object, ParseException e) {

                if (e == null){
                  object.put("postos", 500);
                  object.saveInBackground();

                }else {
                  Log.i("ConsultaObjeto","Erro ao consultar objeto");
                }
              }
            }

    );
  */

    ParseQuery<ParseObject> filtro = ParseQuery.getQuery("Pontuacao");

    // Aplicando filtro na listagem de objetos
    //filtro.whereGreaterThan("pontos", 800);
    //filtro.whereGreaterThanOrEqualTo("pontos", 800);
    //filtro.whereLessThan("pontos", 500);
    //filtro.whereGreaterThanOrEqualTo("pontos", 500);
    //filtro.whereEndsWith("nome", "ia");
    //filtro.whereStartsWith("nome", "Ja");
    //filtro.addAscendingOrder("pontos");
    //filtro.addDescendingOrder("pontos");
    filtro.setLimit(1);


    //Listar dados
    filtro.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {

        if (e == null){ // Efetuada a listagem sem erros

          for ( ParseObject object:objects ){

            Log.i("Listar dados","Objeto - Nome: " + object.get("nome")+ "pontos:"+object.get("pontos"));
          }
          //Log.i("ConsultaObjeto","Sucesso ao listar objeto" + objects.size());

        }else { // Erro ao listar
          Log.i("Listar dados","Erro ao listar objeto" + e.getMessage());
        }
      }
    });
  }
}

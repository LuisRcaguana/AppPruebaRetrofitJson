package com.example.luiscaguana.apppruebaretrofitjson;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.luiscaguana.apppruebaretrofitjson.RetrofitUtisl.ApiPokemon;
import com.example.luiscaguana.apppruebaretrofitjson.RetrofitUtisl.RetrofitClean;
import com.example.luiscaguana.apppruebaretrofitjson.model.Pokemon;
import com.example.luiscaguana.apppruebaretrofitjson.model.Resultado;

public class MainActivity extends AppCompatActivity {

    TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resul = findViewById(R.id.tvReul);

        consumirE();


    }

    private void consumirE() {

        Retrofit r = RetrofitClean.getClient(ApiPokemon.BASE_URL);
        ApiPokemon ars = r.create(ApiPokemon.class);
        Call<Resultado> call = ars.obtenerPokemon();


        call.enqueue(new Callback<Resultado>() {



            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                if (!response.isSuccessful()) {
                    Log.i("onResponse", "error" + response.code());
                } else {
                    Resultado r = (Resultado) response.body();
                    String resultado = "";
                    for (Pokemon poke : r.getResults()) {
                        resultado += poke.toString() + "\n";

                    }
                    resul.setText(resultado);

                }
            }


            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

                Log.i("onFailure", "error" + t.getMessage());


            }
        });
    }

}



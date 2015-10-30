package com.miw.bg0094.dasm1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.miw.bg0094.dasm1.models.APIResponse;
import com.miw.bg0094.dasm1.models.Show;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ListActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private MoviedbService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRetrofit();
        refreshShowsList();

        // shows_list
    }



    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MoviedbService.class);



    }

    public void refreshShowsList() {
        Call<Show> result = service.listShows("3");

        result.enqueue(new Callback<Show>() {
            @Override
            public void onResponse(Response<Show> response, Retrofit retrofit) {
                Show show = response.body();
                List<APIResponse> showsList = show.getResults();
                for (int i = 0; i < showsList.size(); i++) {
                    Log.d("------", showsList.get(i).getName());
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("------", t.getMessage());
            }
        });




    }

}

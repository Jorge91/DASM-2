package com.miw.bg0094.dasm1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.miw.bg0094.dasm1.models.Show;
import com.miw.bg0094.dasm1.models.APIShowsList;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ListActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private MoviedbService service;
    private LinearLayout shows_list;
    List<Show> actualShows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Displayed shows on device
        actualShows = new ArrayList<Show>();

        // shows_list
        shows_list = (LinearLayout) findViewById(R.id.shows_list);

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
        // Restart actualShows
        actualShows.clear();

        Random generator = new Random();
        int randomPage = generator.nextInt(1000) + 1;

        Call<APIShowsList> result = service.listShows(randomPage);

        result.enqueue(new Callback<APIShowsList>() {
            @Override
            public void onResponse(Response<APIShowsList> response, Retrofit retrofit) {
                APIShowsList APIShowsList = response.body();
                List<Show> showsList = APIShowsList.getResults();

                actualShows.addAll(showsList);
                paintList();
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("------", t.getMessage());
            }
        });
    }

    public void paintList() {

        shows_list.removeAllViews();


        for (int i = 0; i < actualShows.size(); i++) {
            TextView tv = new TextView(getApplicationContext());
            tv.setText(actualShows.get(i).getName());
            tv.setTextSize(25);
            shows_list.addView(tv);
        }
    }

    public void refreshList(View v) {
        refreshShowsList();
    }

}

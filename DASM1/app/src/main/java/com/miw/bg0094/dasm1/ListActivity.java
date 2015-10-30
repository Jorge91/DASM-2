package com.miw.bg0094.dasm1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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
    List<Show> actualShows;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Displayed shows on device
        actualShows = new ArrayList<Show>();

        //ListView
        listView = (ListView) findViewById(R.id.listView);

        initRetrofit();
        refreshShowsList();

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

        ArrayAdapter<Show> adaptador = new ArrayAdapter<Show>(this, android.R.layout.simple_list_item_1, actualShows);
              listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = listView.getItemAtPosition(position).toString();

                Log.d("..................", option.toString());
                /*
                Intent intent = new Intent(MainActivity.this, MuestraElementoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPTION", option);
                bundle.putInt("POSITION", position);
                intent.putExtras(bundle);
                startActivity(intent);
                */
            }
        });


    }

    public void refreshList(View v) {
        refreshShowsList();
    }

}

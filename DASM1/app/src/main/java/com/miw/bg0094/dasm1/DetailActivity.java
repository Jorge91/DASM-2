package com.miw.bg0094.dasm1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.miw.bg0094.dasm1.models.APIShowsList;
import com.miw.bg0094.dasm1.models.Session;
import com.miw.bg0094.dasm1.models.Show;
import com.squareup.picasso.Picasso;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class DetailActivity extends AppCompatActivity {

    private Show show;
    private Session session;
    private MoviedbService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSession();

        ((TextView) findViewById(R.id.show_title)).setText(this.getIntent().getExtras().getString("name"));

        show = new Show(this.getIntent().getExtras().getInt("id"), this.getIntent().getExtras().getString("name"));

        String description = this.getIntent().getExtras().getString("description");
        if ("".equals(description)) description = "No description available...";

        ((TextView) findViewById(R.id.description)).setText(description);
        ((TextView) findViewById(R.id.year_text)).setText(this.getIntent().getExtras().getString("firstAirDate"));

        Log.d("-----------", this.getIntent().getExtras().getString("posterPath"));
        String posterPath = this.getIntent().getExtras().getString("posterPath");
        if (!"".equals(posterPath)) Picasso.with(this).load("http://image.tmdb.org/t/p/w300" + posterPath).into((ImageView) findViewById(R.id.imageView));



    }

    public void getSession() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MoviedbService.class);

        Call<Session> result = service.getSession();

        result.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Response<Session> response, Retrofit retrofit) {
                session = response.body();
                Log.d("--------", session.toString());

            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("------", t.getMessage());
            }
        });
    }


    public void rateShow(View v) {
        float rating = ((RatingBar) findViewById(R.id.ratingBar)).getRating() * 2;
        Log.d("------------", Float.toString(rating));




    }
}

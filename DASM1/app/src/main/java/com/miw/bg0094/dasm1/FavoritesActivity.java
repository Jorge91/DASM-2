package com.miw.bg0094.dasm1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miw.bg0094.dasm1.models.Show;
import com.miw.bg0094.dasm1.models.SimpleShow;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        listView = (ListView) findViewById(R.id.favListView);

        SQLiteHelper db = new SQLiteHelper(this);

        ArrayAdapter<SimpleShow> adaptador = new ArrayAdapter<SimpleShow>(this, android.R.layout.simple_list_item_1, db.getAllShows());
        listView.setAdapter(adaptador);
    }
}

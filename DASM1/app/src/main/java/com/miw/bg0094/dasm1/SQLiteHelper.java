package com.miw.bg0094.dasm1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.miw.bg0094.dasm1.models.SimpleShow;

import java.util.LinkedList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ShowsDB";
    private static final String TABLE_SHOWS = "shows";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME};

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SHOW_TABLE = "CREATE TABLE shows ( " +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT )";

        db.execSQL(CREATE_SHOW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS shows");
        this.onCreate(db);
    }

    public void addShow(SimpleShow show){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, show.get_name());
        values.put(KEY_ID, show.get_id());

        try {
            db.insert(TABLE_SHOWS,
                    null,
                    values);
        } catch (Exception e) {
            Log.d("Existing id: ", show.get_name());
        }
        db.close();
    }

    public List<SimpleShow> getAllShows() {
        List<SimpleShow> shows = new LinkedList<SimpleShow>();

        String query = "SELECT  * FROM " + TABLE_SHOWS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        SimpleShow show = null;
        if (cursor.moveToFirst()) {
            do {
                show = new SimpleShow();
                show.set_id(Integer.parseInt(cursor.getString(0)));
                show.set_name(cursor.getString(1));

                shows.add(show);
            } while (cursor.moveToNext());
        }
        return shows;
    }

}
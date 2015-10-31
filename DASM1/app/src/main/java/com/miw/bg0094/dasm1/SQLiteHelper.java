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

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ShowsDB";

    // Books table name
    private static final String TABLE_SHOWS = "shows";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    private static final String[] COLUMNS = {KEY_ID,KEY_NAME};

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_SHOW_TABLE = "CREATE TABLE shows ( " +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT )";

        db.execSQL(CREATE_SHOW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS shows");

        // create fresh books table
        this.onCreate(db);
    }

    public void addShow(SimpleShow show){
        //for logging
        Log.d("addBook", show.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, show.get_name()); // get title
        values.put(KEY_ID, show.get_id()); // get author

        // 3. insert
        try {
            db.insert(TABLE_SHOWS, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values
        } catch (Exception e) {
            Log.d("Existing id: ", show.get_name());
        } 

        // 4. close
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

        Log.d("-o-o-o-o-o-o-o-o-o-o", shows.toString());

        return shows;
    }

}
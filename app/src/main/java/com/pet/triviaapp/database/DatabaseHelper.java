package com.pet.triviaapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import com.pet.triviaapp.R;

public class DatabaseHelper  extends SQLiteOpenHelper {

    static final String DB_NAME = "TRIVIA.DB";
    static final int DB_VERSION = 1;
    Context context;

    public DatabaseHelper(Context con) {
        super(con, DB_NAME, null, DB_VERSION);
        this.context=con;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTriviaCreateTable = context.getResources().getString(R.string.sql_create_table_my_vehicles);
        db.execSQL(sqlTriviaCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIntoTriviaTable(String name, String date,StringBuffer alldata) {
        SQLiteDatabase db = this.getWritableDatabase();
        String strSQL = context.getResources().getString(R.string.sql_insert_table_trivia);
        SQLiteStatement stmt = db.compileStatement(strSQL);
        if (name != null) {
            stmt.bindString(1, name);
            stmt.bindString(2, date);
            stmt.bindString(3, String.valueOf(alldata));
            stmt.execute();
            stmt.close();
        } else {
            Toast.makeText(context, "No Vehicle present", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getTriviaList() {
        Cursor result = null;
        SQLiteDatabase db = this.getReadableDatabase();
        String strSQL = context.getResources().getString(R.string.sql_select_table_trivia);
        result = db.rawQuery(strSQL, null);
        return result;
    }
}

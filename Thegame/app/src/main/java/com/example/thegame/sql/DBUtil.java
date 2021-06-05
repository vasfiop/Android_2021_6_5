package com.example.thegame.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBUtil {
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PASS = "password";
    public static final String DB_NAME = "users.db";
    public static final String DB_TABLE = "users";
    public static final int DB_VERSION = 1;

    private final Context context;
    private SQLiteDatabase db;
    private DBOpenHelper dbOpenHelper;

    public DBUtil(Context context) {
        this.context = context;
    }

    //    增加
    public long insert(Users users) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, users.name);
        contentValues.put(KEY_PASS, users.password);

        return db.insert(DB_TABLE, null, contentValues);
    }

    //    打开数据库
    public void open() {
        dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        db = dbOpenHelper.getWritableDatabase();

    }

    //关闭数据库释放资源
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    //    查找
    public Users[] select(String name, String password) {
        Cursor cursor = db.query(DB_TABLE, new String[]{KEY_ID, KEY_NAME, KEY_PASS,}, KEY_NAME + "=\"" + name + "\" and " + KEY_PASS + "=\"" + password + "\"",
                null, null, null, null);
        return toUsers(cursor);
    }

    private class DBOpenHelper extends SQLiteOpenHelper {
        //        创建表
        private static final String TABLE_CREATE =
                "create table " + DB_TABLE
                        + " (" + KEY_ID + " integer primary key autoincrement, "
                        + KEY_NAME + " text not null, "
                        + KEY_PASS + " text not null)";

        public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }

    private Users[] toUsers(Cursor cursor) {
        int resultcount = cursor.getCount();
        if (resultcount == 0 || !cursor.moveToFirst())
            return null;
        Users[] users = new Users[resultcount];
        for (int i = 0; i < resultcount; i++) {
            users[i] = new Users();
            users[i].id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            users[i].name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            users[i].password = cursor.getString(cursor.getColumnIndex(KEY_PASS));

            cursor.moveToNext();
        }

        return users;
    }
}

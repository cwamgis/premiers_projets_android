package dataaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Niveau utilisation
 * Created by prof on 17/03/15.
 */
public class DataSource {

    private final DBHelper helper;
    private SQLiteDatabase db;

    public DataSource(Context context)
    {
        helper = new DBHelper(context);
    }

    public SQLiteDatabase getDB()
    {
        if (db == null)open();

        return db;
    }

    public void open()
    {
        db = helper.getWritableDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public FishDAO newFishDAO()
    {
        return new FishDAO(this);
    }
}

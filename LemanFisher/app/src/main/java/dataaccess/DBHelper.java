package dataaccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Niveau modele
 * Created by prof on 17/03/15.
 */
public class DBHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "fish.db";
    public static final int DB_VERSION = 4;

    public DBHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);

    }

    // Context = activity à partir de laquelle on va acceder a la bd
    public static String getQueryCreate()
    {
        return "CREATE TABLE Fish("
            +"id integer(50) PRIMARY KEY,"
            +"name varchar(50) NOT NULL,"
            +"idFamily integer(50) NOT NULL);";
    }

    public static String getQueryDrop()
    {
        return "DROP TABLE IF EXISTS Fish;";
    }

    /**
     * Contrat a la creation de la base
     * */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(getQueryCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL(getQueryDrop() );
        db.execSQL(getQueryCreate() );
    }
}

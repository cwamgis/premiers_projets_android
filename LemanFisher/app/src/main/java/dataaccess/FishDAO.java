package dataaccess;

/**
 * Obj <=> Relational Database</=>
 * */

import android.content.ContentValues;
import android.database.Cursor;

import businessmodel.Famille;
import businessmodel.Fish;

/**
 * Created by prof on 17/03/15.
 */
public class FishDAO {
    public static final String COL_ID = "idFish";
    public static final String TABLE_NAME = "fish";
    public static final String COL_NAME   = "name";
    public static final String COL_FAMILY   = "idFamily";

    private final DataSource ds;

    public FishDAO(DataSource unDS)
    {
        ds = unDS;
    }


    public synchronized Fish create(Fish aFish)
    {
        ContentValues values = new ContentValues();
        values.put(COL_NAME,aFish.getNom());
        values.put(COL_FAMILY,aFish.getFamille().getId());

        // insert query
        int id = (int) ds.getDB().insert(TABLE_NAME,null,values);

        aFish.setId(id);

        return aFish;
    }




    public Fish read(Fish aFish)
    {
        // columns
        String[] allColumns = new String[]{COL_ID,COL_NAME,COL_FAMILY};

        // clause
        String clause = COL_ID + " = ?";
        String[] clauseArgs = new String[]{String.valueOf(aFish.getId())};

        // select query
        Cursor cursor = ds.getDB().query(TABLE_NAME,allColumns,"ID = ?",clauseArgs,null,null,null);

        // read cursor
        cursor.moveToFirst();
        aFish.setNom(cursor.getString(0));
        aFish.setFamille(new Famille(Integer.parseInt(cursor.getString(1)),"test recup famille"));

        cursor.close();
        return aFish;
    }

    public synchronized void delete(Fish aFish)
    {
        // where clause
        String clause = COL_ID + " = ?";
        String[] clauseArgs = new String[]{String.valueOf(aFish.getId())};

        ds.getDB().delete(TABLE_NAME, clause, clauseArgs);
    }

    public synchronized Fish update(Fish aFish)
    {
        //create associative array
        ContentValues values = new ContentValues();
        values.put(COL_NAME,aFish.getNom());
        values.put(COL_FAMILY,aFish.getFamille().getId());

        // where clause
        String clause = COL_ID + " = ?";
        String[] clauseArgs = new String[]{String.valueOf(aFish.getId())};

        ds.getDB().update(TABLE_NAME, values, clause, clauseArgs);

        return aFish;
    }
}

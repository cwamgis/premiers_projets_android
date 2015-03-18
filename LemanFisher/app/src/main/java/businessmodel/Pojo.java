package businessmodel;

/**
 * Created by prof on 17/03/15.
 */
public abstract class Pojo {

    private int id;

    public Pojo(int unId)
    {
        id = unId;
    }

    public void setId(int unId)
    {
        this.id = unId;
    }

    public int getId()
    {
        return id;
    }
}

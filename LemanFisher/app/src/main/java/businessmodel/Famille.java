package businessmodel;

/**
 * Created by prof on 17/03/15.
 */
public class Famille extends Pojo
{
    private String nom;

    public Famille(int unId,String unNomDeFamille)
    {
        super(unId);
        nom = unNomDeFamille;
    }

    public void setNom(String unNom)
    {
        nom = unNom;
    }

    public String getNom()
    {
        return nom;
    }
}

package businessmodel;

/**
 * Created by prof on 17/03/15.
 */
public class Fish extends Pojo{
    private String nom;
    private Famille famille;

    public Fish(int unId,String unNom,Famille uneFamille)
    {
        super(unId);
        setNom(unNom);
        setFamille(uneFamille);
    }

    public void setNom(String unNom)
    {
        this.nom = unNom;
    }

    public void setFamille(Famille uneF)
    {
        this.famille = uneF;
    }

    public String getNom()
    {
        return nom;

    }

    public Famille getFamille()
    {
        return famille;
    }

    @Override
    public String toString()
    {
        return "Poisson "+nom;

    }

}

package projet_java.crapet;


import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Image;


/** Carte du jeux de crapet 
 * Cette classe permet de créer une carte du jeux de crapet.
 * @author Justine BONDU
*  @version 1 du 09/11/2023
*/

public class Carte
{
    private static  int 				num = 0;
	private static  String[]			typeSigne = {"Coeur", "Pique", "Trêfle", "Carreau", "Enseigne"};
    private static  String[]			tabCoul = {"Rouge", "Noir"};
    private static  String[]			tabRole = {"Valet", "Cavalier", "Reine", "Roi"};
	private  		int 				ident;
    private  		int 				numCarte;
    private  		String             	coul;
    private  		String             	signe;
     private  		String             	role;

	private  		int 				posX; 
	private  		int 				posY;
	private	 		Image				image;

    public Carte()
    {
		this.ident = this.num;
		this.num = this.num + 1;

        if ( this.ident < 28 )
        {
            this.coul=tabCoul[0];
            if ( this.ident < 14 )
            {
                this.signe=typeSigne[0];
            }
            if ( this.ident > 13 )
            {
                this.signe=typeSigne[3];
            }


        }
        else if ( this.ident > 27 && this.ident < 56 )
        {
            this.coul=tabCoul[1];
            if ( this.ident < 42 )
            {
                this.signe=typeSigne[1];
            }
            if ( this.ident > 41 )
            {
                this.signe=typeSigne[2];
            }

        }
        else if ( this.ident > 55 && this.ident < 77 )
        {
            this.signe=typeSigne[4];
            this.coul="";

        }
        
        if ( !attNumC() )
        {
            attRole();
        }

		//setImage();
    }

	public void 			resetNUM	() 		{ this.num = 0; 		}
	public int				getIdent	() 		{ return this.ident;	}
    public String			getCouleur	() 		{ return this.coul; 	}
    public void 			setPosX		(int x) { this.posX = x; 		}
    public void 			setPosY		(int y) { this.posY = y; 		}
    public int  			getPosX		() 		{ return this.posX; 	}
    public int  			getPosY		()		{ return this.posY; 	}
	public Image			getImage	()		{ return this.image;	}

    public boolean attNumC()
    {
        if ( this.ident < 10 )  { this.numCarte = this.ident + 1; return true; }
        if ( this.ident > 13 && this.ident < 24 )  { this.numCarte = this.ident-13; return true; }
        if ( this.ident > 27 && this.ident < 38 )  { this.numCarte = this.ident-27; return true; }
        if ( this.ident > 41 && this.ident < 52 )  { this.numCarte = this.ident-41; return true; }
        if ( this.ident > 55 )  { this.numCarte = this.ident-55; return true; }
        return false;
    }

    public boolean attRole()
    {
        if ( this.ident > 9 && this.ident < 24 )  { this.role = tabRole[this.ident-10]; return true; }
        if ( this.ident > 23 && this.ident < 28 )  { this.role = tabRole[this.ident-24]; return true; }
        if ( this.ident > 37 && this.ident < 42 )  { this.role = tabRole[this.ident-38]; return true; }
        if ( this.ident > 51 && this.ident < 56 )  { this.role = tabRole[this.ident-52]; return true; }
        return false;
    }
/* 
	public void setImage()
	{
		try 
		{
			this.image = ( ImageIO.read( new File("./cartes/" + this.signe + "_" + this.coul + "_" + this.numCarte + ".png") ) ).getScaledInstance( 70, 90, Image.SCALE_DEFAULT);
		} catch (Exception ex) { System.out.println("Exception lors du chargement de l'image"); }
	}
*/
    public String toString() 
    {
        String s;
        if ( this.numCarte == 0 )
        {
            s = this.role;
        }
        else {s = "" + this.numCarte;}

        return "[" + this.ident + "] " + this.signe + ":" + this.coul + ":" + s + '\n'; 
    } 

    public static void main(String[] argv)
	{
		Carte        cart1, cart2, cart3, CarTempo;
		//cart1 = new Carte();

        for (int index = 0; index < 77; index++) 
        {
            CarTempo = new Carte();
            System.out.print(CarTempo);
        }

		System.out.println ();
		

	}

}
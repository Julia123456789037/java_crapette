package projet_java.crapet.java_crapette;

import java.util.ArrayList;
import java.util.Collections;


/** Paquet de carte du jeux de crapet 
 * Cette classe permet de créer un paquet avec toutes les cartes du jeux de crapet.
 * @author Justine BONDU
*  @version 1 du 09/11/2023
*/


public class PaquetCrapette
{
	private ArrayList<CarteCrapette>    paquet;
	private boolean 			scenario;	


	public PaquetCrapette(int num)
	{
		this.paquet	= new ArrayList<CarteCrapette>();
		
		if ( num == 0 )
		{
			this.initPioche();
			this.scenario = false;
		}
			
			
		if ( num == 1 )
		{
			this.paquet.clear();
			this.paquet	= new ArrayList<CarteCrapette>();
			this.scenario = false;
		}

		if ( num == 50 )
		{
			this.paquet.clear();
			this.paquet	= new ArrayList<CarteCrapette>();
			this.scenario = true;
		}

		if ( num == 5 )
		{
			this.initPioche();
			this.echangeCarte(0, 3);
			this.echangeCarte(1, 4);
			this.scenario = true;
		}
		
		if ( num == 6 ) //POUR SCENARIO 1
		{
			this.initPioche();
			this.echangeCarte(0, 2); 
			this.echangeCarte(1, 3); 
			this.echangeCarte(2, 3); 
			this.echangeCarte(3, 4); 
			this.scenario = true;
		}

		if ( num == 7 )
		{
			this.initPioche();
			this.scenario = false;
		}
		
	}


    public PaquetCrapette(PaquetCrapette aSectionner)
	{
		
		
	}

    public PaquetCrapette(PaquetCrapette aCompleter, ArrayList<CarteCrapette> sans)
	{
		
		
	}



	public void initPioche()
	{
		new CarteCrapette().resetNUM();
		this.paquet.clear();
		this.paquet	= new ArrayList<CarteCrapette>();

		for ( int cpt=0; cpt < 77; cpt++ ) { this.addCarteCrapette(new CarteCrapette()); }	
			
	}

	public void melangerEnJeux() 
	{ 
		if ( this.taille() != 0 )
		{
			ArrayList<CarteCrapette>    paqueTempo;
			paqueTempo	= new ArrayList<CarteCrapette>();
			int cptdeb, cptfin; 
			for ( cptdeb = 0, cptfin = this.paquet.size()-1; cptdeb < (this.paquet.size())/2; cptdeb++ ) 
			{
				paqueTempo.add( this.paquet.get( cptdeb ) );
				paqueTempo.add( this.paquet.get( cptfin ) ); 
				cptfin--;
			}
			paqueTempo.add( this.paquet.get( cptdeb ) );
			copierPaquet(paqueTempo, this.paquet);
		}
	}

	public void melanger() 
	{ 
		if ( this.taille() != 0 )
			Collections.shuffle(this.paquet); 		
	}

	public CarteCrapette piocher()
	{
		if ( ! this.scenario )
			this.melanger();

		if ( this.taille() == 0 )
			return null;
		return this.paquet.remove(0);
	}

	public void copierPaquet(ArrayList<CarteCrapette> paquetACopier, ArrayList<CarteCrapette> PaquetMettreCopie )
	{
		PaquetMettreCopie.clear();
		for (int i = 0; i < paquetACopier.size(); i++) 
		{
			PaquetMettreCopie.add(paquetACopier.get(i));
			//paquetACopier.remove(0);
		}
	}



	public ArrayList<CarteCrapette>	getPaquet()				{	return this.paquet;							}
	public CarteCrapette			getCarteCrapette(int indice)	{	return this.paquet.get(indice);				}
	public CarteCrapette			getLast()				{	return this.paquet.get(this.taille()-1);	}
	public boolean			getScenario()			{	return this.scenario;	}
	public void				addCarteCrapette(CarteCrapette carte)	{	this.paquet.add(carte);						}
	public int				taille()				{	return this.paquet.size();					}



	public void init2()
	{
		this.echangeCarte(0, 1);
		this.echangeCarte(1, 2);
		this.echangeCarte(2, 3);
	}


	public void echangeCarte(int ind1, int ind2)
	{
		CarteCrapette c1, c2;

		if ( ind1 < ind2 )
		{
			c2 = this.paquet.remove(ind2);
			c1 = this.paquet.remove(ind1);
			this.paquet.add(ind1, c2);
			this.paquet.add(ind2, c1);
		}
		else 
		{
			c1 = this.paquet.remove(ind1);
			c2 = this.paquet.remove(ind2);
			this.paquet.add(ind1, c2);
			this.paquet.add(ind2, c1);
		}
	}


	public String toString() 
	{
		String s;
		s= "" + this.paquet;
		return "" + this.paquet; 
	} 


    public static void main(String[] argv)
	{
		PaquetCrapette        PaTempo;


        PaTempo = new PaquetCrapette(0);
        System.out.print(PaTempo);
		System.out.println ();
		PaTempo.melangerEnJeux();
		System.out.println ();
		System.out.println ("-------------------------------------------------------");
		System.out.println ();
		System.out.print(PaTempo);
		System.out.println ("-------------------------------------------------------");
		//System.out.print(PaTempo);
		System.out.println ();
		

	}
}
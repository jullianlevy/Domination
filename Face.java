
public class Face {
	
	
	public int nbCouronnes;
	public String typeface;
	
	public 	Face(int nbCouronnes, String typeface){
		this.nbCouronnes = nbCouronnes;
		this.typeface = typeface;
	}
	
	public String gettypeface(){
		return this.typeface;
	}
	
	public Integer getNbCouronnes(){
		return this.nbCouronnes;
	}

}

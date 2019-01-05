import java.util.ArrayList;

public class Rois {

	public static ArrayList<Rois> listrois= new ArrayList<Rois>();
	private Couleur colorRoi;
	private int nbr;
	
	public Rois(Couleur colorRoi,int nbr) {
		this.colorRoi=colorRoi;
		this.nbr=nbr;
		
		
	}
	
	
	
	
	public Couleur getColorRoi() {
		return colorRoi;
	}
	public void setColorRoi(Couleur colorRoi) {
		this.colorRoi = colorRoi;
	}




	public int getNbr() {
		return nbr;
	}




	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	
	
	
	
	



}

import java.util.ArrayList;

public class Rois {

	public static ArrayList<Rois> listrois= new ArrayList<Rois>();
	private Couleur colorRoi;
	
	public Rois(Couleur colorRoi) {
		this.colorRoi=colorRoi;
		
		
	}
	public void addrois() {
		Rois.listrois.add(new Rois(this.colorRoi));
	}
	
	
	
	public Couleur getColorRoi() {
		return colorRoi;
	}
	public void setColorRoi(Couleur colorRoi) {
		this.colorRoi = colorRoi;
	}
	
	
	
	
	



}

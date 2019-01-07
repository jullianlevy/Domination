public class Case {
	private TypeTerrain Terrain;
	private int posX;
	private int posY;
	private int nbCouronne;
	
	public Case(int posX,int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
		Terrain=TypeTerrain.VIDE;
	}

	public TypeTerrain getTerrain() {
		return Terrain;
	}

	public void setTerrain(TypeTerrain terrain) {
		Terrain = terrain;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNbCouronne() {
		return nbCouronne;
	}

	public void setNbCouronne(int nbCouronne) {
		this.nbCouronne = nbCouronne;
	}

}

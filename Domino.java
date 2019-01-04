import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Domino {
	
		private int numDomino;
		Face facegauche;
		Face facedroite;
		ArrayList<Domino> listdomino= new ArrayList<Domino>();
		
		
		
		
		
		public Domino(int numDomino, Face facegauche, Face facedroite) {
			
			this.numDomino=numDomino;
			this.facedroite=facedroite;
			this.facegauche=facegauche;
		
		}
		
		private static void creationliste() throws FileNotFoundException, IOException {
			
			 String line = "";
		       
		        try (BufferedReader br = new BufferedReader(new FileReader("dominos.csv"))) {
		        	
		        	br.readLine();

		            while ((line = br.readLine()) != null) {

		                
		                String[] values = line.split(",");
		                
		                int nbCouronne1 = Integer.valueOf(values[0]);
		                String type1 = String.valueOf(values[1]);
		                int nbCouronne2 = Integer.valueOf(values[2]);
		                String type2 = String.valueOf(values[3]);
		                int numeroDomino = Integer.valueOf(values[4]);
		                
		                Face facegauche = new Face(nbCouronne1, type1);
		                Face facedroite = new Face(nbCouronne2, type2);
		                
		                Domino domino = new Domino(numeroDomino,facegauche, facedroite);
		            }
		            
		        }
		                
		            }
		
	
			

		public int getNumDomino() {
			return numDomino;
		}
		public void setNumDomino(int numDomino) {
			this.numDomino = numDomino;
		}
		
		public Face getFaceGauche() {
			return this.facegauche;
		}
		
		public Face getFaceDroite() {
			return this.facedroite;
		}
		
		public String getTypeFaceGauche() {
			return this.facegauche.gettypeface();
		}
		
		public String getTypeFaceDroite() {
			return this.facedroite.gettypeface();
		}
		
		public int getNbCouronneFaceGauche() {
			return this.facegauche.getNbCouronnes();
		}
		
		public int getNbcCouronneDroite() {
			return this.facedroite.getNbCouronnes();
		}
		
		
		

		
 
		
		
			
			 
		    
			
			
		
					
					 
					 
		
			
		
					
					 
					 
	
		




	




		
			
		
	}



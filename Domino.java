import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Domino {
	

	
		
			private int numDomino;
			Face facegauche;
			Face facedroite;

			
			
			
			
			
			public Domino(int numDomino, Face facegauche, Face facedroite) {
				
				this.numDomino=numDomino;
				this.facedroite=facedroite;
				this.facegauche=facegauche;
			
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	int nbrjoueurs;
		public static void  main (String[] args) throws IOException {
	
			
			
			
			
			
			
	
				System.out.println("----- Choisir le nombre de joueurs-----");
				System.out.print(
						"1.      2 joueurs \n2.      3 joueurs \n3.      4 joueurs   \n Mon Choix : ");
				Scanner sc = new Scanner(System.in);
				int choix = sc.nextInt();
				

				switch (choix) {
				case 2:
					Scanner scan = new Scanner(System.in);
					System.out.println("vous etes 2 joueurs");
					System.out.println(" Veuillez entrer le prénom du joueur1 ? : ");
					String nomJoueur1= scan.nextLine();
					
					System.out.println(" Veuillez entrer le prénom du joueur2 ? : ");
					String nomJoueur2= scan.nextLine();
					
					System.out.println("Maintenant vous devez chosir vos rois");
					
					
					
					
					
					
					
					
					


					
					
					
					break;
				case 3:
					
				Scanner scann = new Scanner(System.in);
				// code pour 3 joueurs donc on demande leurs noms et on distribue les rois
				
				System.out.println(" Veuillez entrer le prénom du joueur 1 ? : ");
				String nomJoueur3=scann.nextLine();
				;
				
				
				String nomJoueur4=scann.nextLine();
				System.out.println(" Veuillez entrer le prénom du joueur 2 ? : ");
				
				
				String nomJoueur5=scann.nextLine();
				System.out.println(" Veuillez entrer le prénom du joueur 1 ? : ");
			
				
				
				
				
				
				
			
				
				
				
					
					
					
					break;
				case 4:
					
					Scanner scanne= new Scanner(System.in);
					System.out.println(" Veuillez entrer le prénom du joueur 1 ? : ");
					String nomJoueur6=scanne.nextLine();
					
				
					
					
					System.out.println(" Veuillez entrer le prénom du joueur 2 ? : ");
					String nomJoueur7=scanne.nextLine();
				
					
					break;
				}
				
					
					
				
				}
				
			
			

				
			
		
	
		
			
	
		
		
				
				
			
		
	
		












		
		            {
		            for(int i=0;i<listdomino.size();i++) {
		            	
		            	System.out.println("le domino "+listdomino.get(i).getNumDomino()+" contient  "+listdomino.get(i).facedroite.getNbCouronnes()+" couronnes pour la face droite"+" et "+listdomino.get(i).facegauche.getNbCouronnes()+" pour la face gauche");
		            	System.out.println();
		            }
		            
		        
		            
		             
			
		}












			
		











	
		
		
	}






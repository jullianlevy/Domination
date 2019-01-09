import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



import java.util.Random;
import java.util.Collections;

public class Deroulement {
	ArrayList<String> couleur=new ArrayList<String>();
	ArrayList<Joueurs> listjoueurs=new ArrayList<Joueurs>();
	int nbrjoueurs;
	ArrayList<Domino> listdomino= new ArrayList<Domino>();
	ArrayList<Rois> listrois= new ArrayList<Rois>();

	public Deroulement() throws FileNotFoundException, IOException {
		System.out.println("--------------------------------------");
		System.out.println("BIENVENUE DOMIN'ATION");
		System.out.println("--------------------------------------");
		System.out.println("");
		
	
		creationJoueur();
		creationliste();
		ChoisirRois();
		
	}
	
	
	public void NombreDomino() {
		Random rand=new Random();
		if(nbrjoueurs==2) {
			for(int i=0;i<24;i++) {
				int nbAleatoire = rand.nextInt(listdomino.size());
				
				listdomino.remove(nbAleatoire);
				}
			for(int i=0;i<listdomino.size();i++) {
				System.out.println("domino est "+listdomino.get(i).getNumDomino());
			}
		}
		if(nbrjoueurs==3) {
			for(int i=0;i<12;i++) {
				int nbAleatoire = rand.nextInt(listdomino.size());
				listdomino.remove(nbAleatoire);
					}
			for(int i=0;i<listdomino.size();i++) {
				System.out.println("domino est "+listdomino.get(i).getNumDomino());
		}
		}
		System.out.println("--------------------------------------");
		
}
	
	public void Melangerdom() {
		System.out.println("Les "+listdomino.size()+" dominos sont mélangés");
		Collections.shuffle(listdomino);
		for(int i=0;i<listdomino.size();i++) {
			System.out.println("domino est "+listdomino.get(i).getNumDomino());
		}
		
		
	}
	
	public void creationliste() throws FileNotFoundException, IOException {
		
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
	            
	                listdomino.add(domino);
	            }
	                
	                	
	        }
	}
	
	public void showdomino() {
		
		for(int i=0;i<listdomino.size();i++) {
			System.out.println("domino est "+listdomino.get(i).getNumDomino());
		}
	}
	
	public void creationJoueur() {
		NombreJoueurs();
		
		NomJoueur();
		
	}
	
	public void NombreJoueurs() {
		Scanner nbjoueur=new Scanner(System.in);
		System.out.println("Tout d'abord il vous faut indiquer ci dessous le nombre de joueur compris entre 2 et 4 joueurs:  ");
		while(!nbjoueur.hasNext("[2-4]")) {
			System.out.println("-----------Attention, veuillez resaisir le nombre de joueurs---------");
		nbjoueur.next();
		}
		nbrjoueurs=nbjoueur.nextInt();
		
		
	}



	public void NomJoueur() {
		System.out.println("Rentrez le noms des participants");
		Scanner scan= new Scanner(System.in);
		int i=1;
		for(i=1;i<nbrjoueurs+1;i++) {
			System.out.println("pseudo du joueur"+i+" : ");
			Joueurs joueur =new Joueurs(scan.nextLine());
			listjoueurs.add(joueur);
			
			
		}
	}
	public void ChoisirRois() {
		Rois bleu=new Rois(Couleur.BLEU,1);
		Rois jaune=new Rois(Couleur.JAUNE,2);
		Rois rouge=new Rois(Couleur.ROUGE,3);
		Rois vert=new Rois(Couleur.VERT,4);
		listrois.add(vert);
		listrois.add(jaune);
		listrois.add(rouge);
		listrois.add(bleu);
		
		
		if(nbrjoueurs==2) {
			System.out.println("Vous etes "+nbrjoueurs+" ainsi vous devez choisir 2 rois chacun");
			for(Joueurs joueurtest:listjoueurs) {
				Scanner rois=new Scanner(System.in);
				
				System.out.println(joueurtest.getName());
				System.out.println("Chossissez parmi ces rois ");
				
				for(Rois roi:listrois) {
					System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
					
					}while(!rois.hasNext("[1-4]")) {
					
					System.out.println("Cette couleur n'est pas disponible");
					rois.next();
					
					}
					int reponse=rois.nextInt();
					if(reponse==bleu.getNbr()) {
						joueurtest.listrois.add(bleu);
						listrois.remove(bleu);
					}
					if(reponse==rouge.getNbr()) {
						joueurtest.listrois.add(rouge);
						listrois.remove(rouge);
					}if(reponse==jaune.getNbr()) {
						joueurtest.listrois.add(jaune);
						listrois.remove(jaune);
					}if(reponse==vert.getNbr()) {
						joueurtest.listrois.add(vert);
						listrois.remove(vert);
					}
			}for(Joueurs joueurtest:listjoueurs) {
				Scanner rois=new Scanner(System.in);
				
				System.out.println(joueurtest.getName());
				System.out.println("Chossissez parmi ces rois ");
				
				for(Rois roi:listrois) {
					System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
					
					}while(!rois.hasNext("[1-4]")) {
					
					System.out.println("Cette couleur n'est pas disponible");
					rois.next();
					
					}
					int reponse=rois.nextInt();
					if(reponse==bleu.getNbr()) {
						joueurtest.listrois.add(bleu);
						listrois.remove(bleu);
					}
					if(reponse==rouge.getNbr()) {
						joueurtest.listrois.add(rouge);
						listrois.remove(rouge);
					}if(reponse==jaune.getNbr()) {
						joueurtest.listrois.add(jaune);
						listrois.remove(jaune);
					}if(reponse==vert.getNbr()) {
						joueurtest.listrois.add(vert);
						listrois.remove(vert);
					}		
			}
				
				
			}
					if(nbrjoueurs==3||nbrjoueurs==4) {
						System.out.println("Vous etes "+nbrjoueurs+" ainsi vous devez choisir 1 roi chacun");
						for(Joueurs joueurtest:listjoueurs) {
							Scanner rois=new Scanner(System.in);
							System.out.println(joueurtest.getName());
							System.out.println("Chossissez parmi ces rois ");
							for(Rois roi:listrois) {
								System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
								
								}while(!rois.hasNext("[1-4]")) {
								
								System.out.println("Cette couleur n'est pas disponible");
								rois.next();
								
								}
								int reponse=rois.nextInt();
								if(reponse==bleu.getNbr()) {
									joueurtest.listrois.add(bleu);
									listrois.remove(bleu);
								}
								if(reponse==rouge.getNbr()) {
									joueurtest.listrois.add(rouge);
									listrois.remove(rouge);
								}if(reponse==jaune.getNbr()) {
									joueurtest.listrois.add(jaune);
									listrois.remove(jaune);
								}if(reponse==vert.getNbr()) {
									joueurtest.listrois.add(vert);
									listrois.remove(vert);
								}
						}
		}
		}
		
	
	
	
	
	
			
			
		
			
		

		
		
		
	}
	


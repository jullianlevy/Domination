import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Collections;

public class Deroulement {
	static ArrayList<String> couleur=new ArrayList<String>();

	
	
	
	public static void NombreDomino() {
		Random rand=new Random();
		if(Joueurs.nbrjoueurs==2) {
			for(int i=0;i<24;i++) {
				int nbAleatoire = rand.nextInt(Domino.listdomino.size());
				
				Domino.listdomino.remove(nbAleatoire);
				}
			for(int i=0;i<Domino.listdomino.size();i++) {
				System.out.println("domino est "+Domino.listdomino.get(i).getNumDomino());
			}
		}
		if(Joueurs.nbrjoueurs==3) {
			for(int i=0;i<12;i++) {
				int nbAleatoire = rand.nextInt(Domino.listdomino.size());
				Domino.listdomino.remove(nbAleatoire);
					}
			for(int i=0;i<Domino.listdomino.size();i++) {
				System.out.println("domino est "+Domino.listdomino.get(i).getNumDomino());
		}
		}
		System.out.println("--------------------------------------");
		
}
	
	public static void Melangerdom() {
		System.out.println("Les "+Domino.listdomino.size()+" dominos sont mélangés");
		Collections.shuffle(Domino.listdomino);
		for(int i=0;i<Domino.listdomino.size();i++) {
			System.out.println("domino est "+Domino.listdomino.get(i).getNumDomino());
		}
		
		
	}
	
	public static void showdomino() {
		
		for(int i=0;i<Domino.listdomino.size();i++) {
			System.out.println("domino est "+Domino.listdomino.get(i).getNumDomino());
		}
	}
	
	public static void creationJoueur() {
		int a=NombreJoueurs();
		if(a==2) {
			System.out.println("Rentrez le nom du Joueur 1");
			Scanner scan1=new Scanner(System.in);
			Joueurs joueur1=new Joueurs();
			joueur1.setName(scan1.nextLine());
			System.out.println("Rentrez le nom du Joueur 2");
			Scanner scan2=new Scanner(System.in);
			Joueurs joueur2=new Joueurs();
			joueur2.setName(scan2.nextLine());
			Joueurs.getListjoueurs().add(joueur1);
			System.out.println(joueur1.getName());
			Joueurs.getListjoueurs().add(joueur2);
			System.out.println(joueur2.getName());
			}
		if(a==3) {
			System.out.println("Rentrez le nom du Joueur 1");
			Scanner scan1=new Scanner(System.in);
			Joueurs joueur1=new Joueurs();
			joueur1.setName(scan1.nextLine());
			System.out.println("Rentrez le nom du Joueur 2");
			Scanner scan2=new Scanner(System.in);
			Joueurs joueur2=new Joueurs();
			joueur2.setName(scan2.nextLine());
			System.out.println("Rentrez le nom du Joueur ");
			Scanner scan3=new Scanner(System.in);
			Joueurs joueur3=new Joueurs();
			joueur3.setName(scan3.nextLine());
			Joueurs.getListjoueurs().add(joueur1);
			Joueurs.getListjoueurs().add(joueur2);
			Joueurs.getListjoueurs().add(joueur3);
			
		}
		if(a==4) {
			System.out.println("Rentrez le nom du Joueur 1");
			Scanner scan1=new Scanner(System.in);
			Joueurs joueur1=new Joueurs();
			joueur1.setName(scan1.nextLine());
			System.out.println("Rentrez le nom du Joueur 2");
			Scanner scan2=new Scanner(System.in);
			Joueurs joueur2=new Joueurs();
			joueur2.setName(scan2.nextLine());
			System.out.println("Rentrez le nom du Joueur 3");
			Scanner scan3=new Scanner(System.in);
			Joueurs joueur3=new Joueurs();
			joueur3.setName(scan3.nextLine());
			System.out.println("Rentrez le nom du Joueur 4 ");
			Scanner scan4=new Scanner(System.in);
			Joueurs joueur4=new Joueurs();
			joueur4.setName(scan4.nextLine());
			Joueurs.getListjoueurs().add(joueur1);
			Joueurs.getListjoueurs().add(joueur2);
			Joueurs.getListjoueurs().add(joueur3);
			Joueurs.getListjoueurs().add(joueur4);
			
		}
		
		
	}
	
	public static int NombreJoueurs() {
		Scanner nbjoueur=new Scanner(System.in);
		System.out.println("Indiquer le nombre de joueur: ? ");
		while(!nbjoueur.hasNext("[2-4]")) {
			System.out.println("Entrer un nombre entre 2 et 4");
		nbjoueur.next();
		}
		Joueurs.nbrjoueurs=nbjoueur.nextInt();
		return Joueurs.nbrjoueurs;
		
		
	}



	public static void NomJoueur() {
		System.out.println("Rentrez le noms des participants");
		Scanner scan= new Scanner(System.in);
		int i=1;
		for(i=1;i<Joueurs.nbrjoueurs+1;i++) {
			System.out.println("pseudo du joueur"+i+" : ");
			Joueurs.name=scan.nextLine();
			
			
			
		}
	}
	public static void ChoisirRois() {
		Rois bleu=new Rois(Couleur.BLEU,1);
		Rois jaune=new Rois(Couleur.JAUNE,2);
		Rois rouge=new Rois(Couleur.ROUGE,3);
		Rois vert=new Rois(Couleur.VERT,4);
		Rois.listrois.add(vert);
		Rois.listrois.add(jaune);
		Rois.listrois.add(rouge);
		Rois.listrois.add(bleu);
		
		
		if(Joueurs.nbrjoueurs==2) {
			System.out.println("Vous etes "+Joueurs.nbrjoueurs+" ainsi vous devez choisir 2 rois chacun");
			for(Joueurs joueurtest:Joueurs.getListjoueurs()) {
				Scanner rois=new Scanner(System.in);
				
				System.out.println(joueurtest.getName());
				System.out.println("Chossissez parmi ces rois ");
				
				for(Rois roi:Rois.listrois) {
					System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
					
					}while(!rois.hasNext("[1-4]")) {
					
					System.out.println("Cette couleur n'est pas disponible");
					rois.next();
					
					}
					int reponse=rois.nextInt();
					if(reponse==bleu.getNbr()) {
						joueurtest.listrois.add(bleu);
						Rois.listrois.remove(bleu);
					}
					if(reponse==rouge.getNbr()) {
						joueurtest.listrois.add(rouge);
						Rois.listrois.remove(rouge);
					}if(reponse==jaune.getNbr()) {
						joueurtest.listrois.add(jaune);
						Rois.listrois.remove(jaune);
					}if(reponse==vert.getNbr()) {
						joueurtest.listrois.add(vert);
						Rois.listrois.remove(vert);
					}
			}for(Joueurs joueurtest:Joueurs.getListjoueurs()) {
				Scanner rois=new Scanner(System.in);
				
				System.out.println(joueurtest.getName());
				System.out.println("Chossissez parmi ces rois ");
				
				for(Rois roi:Rois.listrois) {
					System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
					
					}while(!rois.hasNext("[1-4]")) {
					
					System.out.println("Cette couleur n'est pas disponible");
					rois.next();
					
					}
					int reponse=rois.nextInt();
					if(reponse==bleu.getNbr()) {
						joueurtest.listrois.add(bleu);
						Rois.listrois.remove(bleu);
					}
					if(reponse==rouge.getNbr()) {
						joueurtest.listrois.add(rouge);
						Rois.listrois.remove(rouge);
					}if(reponse==jaune.getNbr()) {
						joueurtest.listrois.add(jaune);
						Rois.listrois.remove(jaune);
					}if(reponse==vert.getNbr()) {
						joueurtest.listrois.add(vert);
						Rois.listrois.remove(vert);
					}		
			}
				
				
			}
					if(Joueurs.nbrjoueurs==3||Joueurs.nbrjoueurs==4) {
						System.out.println("Vous etes "+Joueurs.nbrjoueurs+" ainsi vous devez choisir 1 roi chacun");
						for(Joueurs joueurtest:Joueurs.getListjoueurs()) {
							Scanner rois=new Scanner(System.in);
							
							System.out.println("Chossissez parmi ces rois ");
							for(Rois roi:Rois.listrois) {
								System.out.println(roi.getColorRoi()+"  : TAPER "+roi.getNbr());
								
								}while(!rois.hasNext("[1-4]")) {
								
								System.out.println("Cette couleur n'est pas disponible");
								rois.next();
								
								}
								int reponse=rois.nextInt();
								if(reponse==bleu.getNbr()) {
									joueurtest.listrois.add(bleu);
									Rois.listrois.remove(bleu);
								}
								if(reponse==rouge.getNbr()) {
									joueurtest.listrois.add(rouge);
									Rois.listrois.remove(rouge);
								}if(reponse==jaune.getNbr()) {
									joueurtest.listrois.add(jaune);
									Rois.listrois.remove(jaune);
								}if(reponse==vert.getNbr()) {
									joueurtest.listrois.add(vert);
									Rois.listrois.remove(vert);
								}
						}
		}
		}
		
	
	
	
	
	
			
			
		
			
		

		
		
		
	}




	


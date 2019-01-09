import java.util.ArrayList;

import java.util.Scanner;

public class Joueurs {

	public String name;
	static int nbrjoueurs;
	private int score;
	private int id;

	ArrayList<Rois> listrois = new ArrayList<Rois>();
	ArrayList<Domino> dominojoueurs = new ArrayList<Domino>();

	Espace plateau;

	public Joueurs(String name, int id) {
		this.name = name;
		this.id = id;

	}

	public void NombreJoueurs() {
		Scanner nbjoueur = new Scanner(System.in);
		System.out.println("Indiquer le nombre de joueur: ? ");
		while (!nbjoueur.hasNext("[2-4]")) {
			System.out.println("Entrer un nombre entre 2 et 4");
			nbjoueur.next();
		}
		nbrjoueurs = nbjoueur.nextInt();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

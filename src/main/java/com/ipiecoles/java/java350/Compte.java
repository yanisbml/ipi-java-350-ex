package com.ipiecoles.java.java350;

import java.util.*;
import java.io.*;

public class Compte implements Serializable {
    private String typeCpte;
    protected double valeurCourante;
    private String numeroCompte;
    private LigneComptable[] ligne;
    public static final int NB_LIGNE = 10;
    private int nbLigneReel;

    public Compte() {
        Scanner lectureClavier = new Scanner(System.in);
        typeCpte = controleType();
        System.out.print("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        valeurCourante = controleValinit();
        ligne = new LigneComptable[NB_LIGNE];
        nbLigneReel = -1;
    }

    public Compte(String type) {
        Scanner lectureClavier = new Scanner(System.in);
        if (type.equalsIgnoreCase("Epargne")) {
            typeCpte = type;
            System.out.print("Numéro du compte : ");
            numeroCompte = lectureClavier.next();
            valeurCourante = controleValinit();
            ligne = new LigneComptable[NB_LIGNE];
            nbLigneReel = -1;
        }
    }

    public LigneComptable quelleLigne(int n) {
        return ligne[n];
    }



    private String controleType() {
        Scanner lectureClavier = new Scanner(System.in);
        char tmpc;
        String tmpS = "";
        do {
            System.out.print("Type du compte [Types possibles :");
            System.out.print("C(ourant), J(oint)] : ");
            tmpc = lectureClavier.next().charAt(0);
        } while (tmpc != 'C' && tmpc != 'J');
        switch (tmpc) {
            case 'C':
                tmpS = "Courant";
                break;
            case 'J':
                tmpS = "Joint";
                break;
        }
        return tmpS;
    }

    private double controleValinit() {
        Scanner lectureClavier = new Scanner(System.in);
        double tmp, tmpval;
        do {
            System.out.print("Valeur initiale du compte : ");
            tmpval = lectureClavier.nextDouble();
        } while (tmpval <= 0);
        return tmpval;
    }

    public void creerLigne() {
        nbLigneReel++;
        if (nbLigneReel < NB_LIGNE)
            ligne[nbLigneReel] = new LigneComptable();
        else {
            nbLigneReel--;
            decalerLesLignes();
            ligne[nbLigneReel] = new LigneComptable();
        }
        valeurCourante = valeurCourante + ligne[nbLigneReel].getValeur();
    }

    private void decalerLesLignes() {
        for (int i = 1; i < NB_LIGNE; i++)
            ligne[i - 1] = ligne[i];
    }

    public void afficherCompte() {
        System.out.print("Le compte n° : " + numeroCompte);
        System.out.println(" est un compte " + typeCpte);
        if (nbLigneReel >= 0) {
            for (int i = 0; i <= nbLigneReel; i++) ligne[i].afficherLigne();
        }
        System.out.println("Valeur courante : " + valeurCourante);
        if (valeurCourante < 0) System.out.println("Attention compte débiteur ... !!!");
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }
}
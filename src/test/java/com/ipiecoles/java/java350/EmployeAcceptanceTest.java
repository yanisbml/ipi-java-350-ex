package com.ipiecoles.java.java350;

import com.thoughtworks.gauge.Step;

public class EmployeAcceptanceTest {
     @Step("J'embauche une personne appelée <prenom> <nom> diplômée d'un <diplome> en tant que <poste> avec un taux d'activité de <txActivite>")
    public void embauche(String prenom, String nom, String diplome, String poste, String txActivite){
         System.out.print(prenom);
         System.out.print(nom);
         System.out.print(diplome);
         System.out.print(poste);
         System.out.print(txActivite);
     }
}

package com.ipiecoles.java.java350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void testGetNombreAnneeAncienneteDateEmbaucheNow() {
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now());

        //When
        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0,(int)nbAnneeAnciennete);
    }

    @Test
    void testGetNombreAnneeAncienneteDateEmbaucheNMinus2() {
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2L));

        //When
        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(2,(int)nbAnneeAnciennete);
    }

    @Test
    void testGetNombreAnneeAncienneteDateEmbaucheNPlus2() {
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(2L));

        //When
        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0,(int)nbAnneeAnciennete);
    }

    @Test
    void testGetNombreAnneeAncienneteDateEmbaucheNull() {
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When
        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0,(int)nbAnneeAnciennete);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 2, 0.5, 600.0",
    })
    public void testGetPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertEquals(primeAnnuelle, prime);
    }

}
package Perez.Cordero;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

class FitxersTest {


    @Test
    void escriuFitxerText_Test() {

        Fitxers f=new Fitxers("persones.csv");
        String text="4343434";

        f.escriuFitxerText(text,false);
    }

    @Test
    void escriuPersonaFitxerText_Test(){

        Fitxers f=new Fitxers("persones.csv");


        String nom= JOptionPane.showInputDialog("Dona'm el teu nom");
        String cognom= JOptionPane.showInputDialog("Dona'm el teu cognom");
        int edat= Integer.parseInt(JOptionPane.showInputDialog("Dona'm la teva edat"));
        double sou= Double.parseDouble(JOptionPane.showInputDialog("Dona'm el teu sou"));

        String text=nom+";"+cognom+";"+edat+";"+sou;
        f.escriuFitxerText(text,true);

    }

    @Test
    void retornaContingutFitxer_Test() {
        Fitxers f=new Fitxers("persones.csv");
        String contingut=f.retornaContingutFitxer();
        System.out.println(contingut);
    }

    @Test
    void retornaContingutFitxerLlista_Test() {

        Fitxers f=new Fitxers("persones.csv");
        List<String> lContingut=f.retornaContingutFitxerLlista();

//        for (int i = 0; i < lContingut.size(); i++) {
//            System.out.println(lContingut.get(i));
//        }

        for(String persona:lContingut){
            System.out.println(persona);
        }

    }
}
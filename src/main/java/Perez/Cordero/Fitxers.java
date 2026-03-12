package Perez.Cordero;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Llibreria de fitxer Ruben y David
/**
 * Classe per la gestió de Fitxers. Tractarem fitxer binaris, de text, etc.
 */
public class Fitxers {

    //<editor-fold desc="PROPIETATS">
    private String nomFitxer;
    //</editor-fold>

    //<editor-fold desc="VARIABLES GLOBALS">

    //</editor-fold>

    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Constructor de Fitxers
     * @param nomFitxer encapsulem el nom del fitxer
     */
    public Fitxers(String nomFitxer) {
        this.nomFitxer = nomFitxer;
    }

    //</editor-fold>

    //<editor-fold desc="GETTERS">

    public String getNomFitxer() {
        return nomFitxer;
    }

    //</editor-fold>

    //<editor-fold desc="MÈTODES">

    /**
     * Escriu un text pla a un fitxer de text
     * @param text text a escriure al fitxer
     * @param afegir Si afegir=true afegirem el "text" al fitxer.
     *               Si és fals sobreescrivim el "text" en el fitxer
     *               eliminant el text anterior
     */
    public void escriuFitxerText(String text,
                                 boolean afegir) {

        try (
                FileWriter out = new FileWriter(nomFitxer, afegir))   // true → afegim al fitxer
        {
            out.write(text + "\n"); // escrivim al fitxer
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Retorna el contingut del fitxer en una variable String
     * @deprecated Està deprecat perquè hi ha un mètode millor
     * @return Variable String amb el contingut del fitxer
     */
    @Deprecated
    public String retornaContingutFitxer() {
        String linia = ""; // per recollir la línia

        try (
                FileReader in = new FileReader(nomFitxer)) {
            Scanner input = new Scanner(in);
            while (input.hasNextLine()) { // Mentre hi hagen línies a l'arxiu ...
                linia = linia + input.nextLine()+"\n"; // Agafa una línia
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linia;
    }


    /**
     * Retorna el contingut del fitxer en una llista.
     * Cada posició de la llista serà una línia
     * @return Llista d'String amb el contingut del fitxer
     */
    public List<String> retornaContingutFitxerLlista(){
        List<String> llista=new ArrayList<>(); // per recollir la línia

        try (
                FileReader in = new FileReader(nomFitxer)) {
            Scanner input = new Scanner(in);
            while (input.hasNextLine()) { // Mentre hi hagen línies a l'arxiu ...
                llista.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return llista;
    }
//

}


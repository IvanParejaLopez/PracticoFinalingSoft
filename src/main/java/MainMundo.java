import alturas.Mundo;
import alturas.Pais;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo mundo = new Mundo();
        mundo.cargar("data/alturas.txt");

        /*
        for (String nombre : mundo.getNombrePaises()) {
            System.out.println(nombre);
        }
         */

        /*
        for (Pais pais : mundo.getPaisesDelContinente("Europe")) {
            System.out.println(pais);
        }
         */

        /*
        for (String continente : mundo.getContinentes()) {
            System.out.println(continente);
        }
         */

        /*
        for (String continente : mundo.getContinentesOrd()) {
            System.out.println(continente);
        }
         */

        // System.out.println(mundo.todosMayores(1.65));

        // System.out.println(mundo.algunPaisMayorDe(1.70));

        /*
        for (Pais pais : mundo.getPaisesOrdDelContinente("Europe")) {
            System.out.println(pais);
        }
        */

        /*
        for (Pais pais : mundo.getPaisesOrdLNA()) {
            System.out.println(pais);
        }
         */


        // System.out.println(mundo.masBajoDelContinente("Europe"));

        // System.out.println(mundo.paisDeMayorAltura());

        /*
        for(Double altura: mundo.conjuntoOrdDAlturasDelContinente("Europe")) {
            System.out.println(altura);
        }
         */


        /* *****************
         * MAP
         * *****************/
        /*
        for (Map.Entry<String, Integer> par : mundo.numPaisesPorContinente().entrySet())
            System.out.println(par.getKey() + ": " + par.getValue());
         */
        /*
        for (Map.Entry<String, List<Pais>> par : mundo.paisesPorContinente().entrySet() ) {
            System.out.println(par.getKey());
            for (Pais pais :  par.getValue()) {
                System.out.println("\t"+ pais);
            }
        }
         */
        /*
        Map<String, Set<Double>> map =  mundo.alturasPorContinente();
        for (String continente : map.keySet()) {
            System.out.println(continente+ " " + map.get(continente));
        }
         */
        /*
        Map<String,Set<String>> map = mundo.paisesOrdPorContinenteOrd();
        for(Map.Entry<String,Set<String>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        */
        /*
        Map<Double,List<Pais>> map = mundo.listaPaisesPorAlturaOrdD();
        for(Map.Entry<Double,List<Pais>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
         */
        /*
        Map<Double,Set<String>> map = mundo.conjuntoNombreOrdDPorAlturaOrd();
        for(Map.Entry<Double,Set<String>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
         */

        /*
        Map<String,Set<Pais>> map = mundo.conjuntoPaisOrdLNAPorContinenteOrdD();
        for(Map.Entry<String,Set<Pais>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
         */
        /*
        Map<String, Map<Integer, Set<Pais>>> map = mundo.paisesPorContinenteyLN();
        for (Map.Entry<String, Map<Integer, Set<Pais>>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<Integer, Set<Pais>> entry2 : entry.getValue().entrySet())
                System.out.println("\t" + entry2.getKey() + " - " + entry2.getValue());
        }
         */
    }
}

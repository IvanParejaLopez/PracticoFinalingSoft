package alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.security.Key;
import java.util.*;

public class Mundo {
    private List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<>();
    }
    public List<Pais> getPaises(){
        return paises;
    }

    /**
     *
     * @return
     */
    public List<String> getNombrePaises(){
        List<String> sol = new ArrayList<>();
        for (Pais pais : paises){
            sol.add(pais.getNombre());
        }
        return sol;
    }

    /**
     *
     * @param fich
     * @throws IOException
     */
    public void cargar(String fich) throws IOException {
        try {
            File file = new File(fich);
            try (Scanner scanner = new Scanner(file)){
                while (scanner.hasNextLine()){
                    try (Scanner sc = new Scanner(scanner.nextLine())){
                        sc.useDelimiter("[,]");
                        String nombrePais = sc.next();
                        String continente = sc.next();
                        double altura = Double.parseDouble(sc.next());

                        paises.add(new Pais(nombrePais, continente, altura));
                    }catch (Exception e){
                        //no hacer nada
                    }
                }
            }
        }catch (IOException e){
            throw new IOException(e);
        }catch (Exception e){
            //no hacer nada
        }
    }

    /**
     *
     * @param map
     * @param <K>
     * @param <V>
     */
    public static <K,V> void presentaEnConsola(Map<K,V> map){
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
    }
    public Map<String, Integer> numeroDePaisesPorContinente(){
        SortedMap<String, Integer> solucion = new TreeMap<>();
        for (Pais pais : paises){
            if (!solucion.containsKey(pais.getContinente())){
                solucion.put(pais.getContinente(), 1);
            }else {
                solucion.put(pais.getContinente(), solucion.get(pais.getContinente())+1);
            }
        }
        return solucion;
    }

    /**
     *
     * @return
     */
    public Map<Double, List<Pais>> paisesPorAltura() {
        SortedMap<Double, List<Pais>> solucion = new TreeMap<>();
        for (Pais pais : paises) {
            // Obtener la altura del país
            double altura = pais.getAltura();
            altura = Math.floor(altura * 10) / 10.0;

            // Obtener la lista de países correspondiente a esa altura
            List<Pais> listaPaises = solucion.get(altura);

            // Si la lista es null, significa que no hay entrada para esa altura todavía
            if (listaPaises == null) {
                // Crear una nueva lista y agregar el país
                listaPaises = new ArrayList<>();
                listaPaises.add(pais);
                // Colocar la nueva lista en el mapa
                solucion.put(altura, listaPaises);
            } else {
                // Si la lista ya existe, simplemente agregar el país a la lista existente
                listaPaises.add(pais);
            }
        }
        return solucion;
    }

    public Map<String, TreeSet<Pais>> paisesPorContinente(){
        SortedMap<String, TreeSet<Pais>> sol = new TreeMap<>();
        for (Pais pais : paises){
            TreeSet<Pais> p = sol.getOrDefault(pais.getContinente(), new TreeSet<>(Comparator.comparing(Pais::getNombre)));
            p.add(pais);
            sol.put(pais.getContinente(), p);
        }
        return sol;
    }

    public Set<Pais> paisesOrdenadosPorAltura(){
        Set<Pais> sol = new TreeSet<>(Comparator.comparing(Pais:: getAltura).thenComparing(Pais::getNombre)); //dijo que con landas, ns si esto cuenta
        sol.addAll(paises);
        return sol;
    }
    public Map<String, TreeSet<Pais>> paisesPorContinenteAltura(){
        SortedMap<String, TreeSet<Pais>> sol = new TreeMap<>();
        for (Pais pais : paises){
            TreeSet<Pais> lis = sol.getOrDefault(pais.getContinente(),
                    new TreeSet<>(Comparator.comparing(Pais::getAltura)));
            lis.add(pais);
            sol.put(pais.getContinente(), lis);
        }
        return sol;
    }
    public Map<String, TreeSet<Pais>> paisesPorContinenteAlturaDec(){
        SortedMap<String, TreeSet<Pais>> sol = new TreeMap<>();
        for (Pais pais : paises){
            TreeSet<Pais> lis = sol.getOrDefault(pais.getContinente(),
                    new TreeSet<>(Comparator.comparing(Pais::getAltura).reversed()));
            lis.add(pais);
            sol.put(pais.getContinente(), lis);
        }
        return sol;
    }
    public Map<Character, TreeSet<Pais>> paisesPorInicial(){
        SortedMap<Character, TreeSet<Pais>> sol = new TreeMap<>();
        for (Pais pais : paises){
            TreeSet<Pais> lis = sol.getOrDefault(pais.getNombre().toUpperCase().charAt(0),
                    new TreeSet<>(Comparator.comparing(Pais::getNombre)));
            lis.add(pais);
            sol.put(pais.getNombre().toUpperCase().charAt(0), lis);
        }
        return sol;
    }
    public Map<String, Double> mediaPorContinente(){
        SortedMap<String,Double> sol = new TreeMap<>();
        Map<String, TreeSet<Pais>> lista = paisesPorContinente();
        for (Map.Entry<String, TreeSet<Pais>> l : lista.entrySet()){
            double media = 0;
            int cantidad = 0;
            for (Pais valor : l.getValue()){
                media += valor.getAltura();
                ++cantidad;
            }
            sol.put(l.getKey(), media/cantidad);
        }
        return sol;
    }
    public List<String> continentesConMasPaises(){ //correspondencia o conjunto
        Map<String, Integer> lista = numeroDePaisesPorContinente();
        List<String> sol = new ArrayList<>();
        int mayNum = -1;
        String pais = null;
        for (Map.Entry<String, Integer> l : lista.entrySet()){
            if (l.getValue() > mayNum){
                mayNum = l.getValue();
                pais = l.getKey();
            }
        }
        sol.add(pais);
        return sol;
    }
}

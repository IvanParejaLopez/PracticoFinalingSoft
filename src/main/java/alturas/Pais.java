package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private String continente;
    private double altura;

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    /**
     * Constructor
     * @param nom
     * @param con
     * @param al
     */
    public Pais(String nom, String con, double al){
        nombre = nom;
        continente = con;
        altura = al;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Pais o) {
        return this.nombre.compareTo(o.nombre);//ns si hace falta reverse
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + "," + continente + "," + altura + ")";
    }
}

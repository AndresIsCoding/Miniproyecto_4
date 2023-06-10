import java.util.ArrayList;

public class Nodo {
    int valor;
    ArrayList<String> datos;

    Nodo izquierdo;
    Nodo derecho;
    public Nodo(int valor,ArrayList<String> datos) {
        this.datos = datos;
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
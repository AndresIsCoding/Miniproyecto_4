import java.util.ArrayList;

public class Nodo
{
    int valor;
    Object datos;
    Nodo izquierdo;
    Nodo derecho;
    Nodo padre;
    public Nodo(int valor,Object datos)
    {
        this.datos = datos;
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
    }
}
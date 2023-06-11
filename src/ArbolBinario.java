import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArbolBinario
{
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor,Object datos)
    {
        raiz = insertarRecursivo(raiz, valor,datos);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor, Object datos)
    {
        if (nodo == null)
        {
            nodo = new Nodo(valor,datos);
            return nodo;
        }

        if (valor < nodo.valor)
        {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor,datos);
        } else if (valor > nodo.valor)
        {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor,datos);
        }

        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo nodo, int valor)
    {
        if (nodo == null)
        {
            return false;
        }

        if (valor == nodo.valor)
        {
            return true;
        } else if (valor < nodo.valor)
        {
            return buscarRecursivo(nodo.izquierdo, valor);
        } else {
            return buscarRecursivo(nodo.derecho, valor);
        }
    }

    public void editar(int valorAntiguo, int valorNuevo) {
        raiz = editarRecursivo(raiz, valorAntiguo, valorNuevo);
    }

    private Nodo editarRecursivo(Nodo nodo, int valorAntiguo, int valorNuevo)
    {
        if (nodo == null)
        {
            return null;
        }

        if (valorAntiguo == nodo.valor)
        {
            nodo.valor = valorNuevo;
        } else if (valorAntiguo < nodo.valor)
        {
            nodo.izquierdo = editarRecursivo(nodo.izquierdo, valorAntiguo, valorNuevo);
        } else {
            nodo.derecho = editarRecursivo(nodo.derecho, valorAntiguo, valorNuevo);
        }

        return nodo;
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor)
    {
        if (nodo == null)
        {
            return null;
        }

        if (valor < nodo.valor)
        {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Caso 1: Nodo sin hijos
            if (nodo.izquierdo == null && nodo.derecho == null)
            {
                nodo = null;
            }
            // Caso 2: Nodo con un hijo
            else if (nodo.izquierdo == null) {
                nodo = nodo.derecho;
            } else if (nodo.derecho == null) {
                nodo = nodo.izquierdo;
            }
            // Caso 3: Nodo con dos hijos
            else {
                Nodo sucesor = encontrarSucesor(nodo.derecho);
                nodo.valor = sucesor.valor;
                nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.valor);
            }
        }

        return nodo;
    }
    public Nodo getNodo(int valor) {
        return getNodoRecursivo(raiz, valor);
    }

    private Nodo getNodoRecursivo(Nodo nodo, int valor)
    {
        if (nodo == null)
        {
            return null;
        }

        if (valor == nodo.valor)
        {
            return nodo;
        } else if (valor < nodo.valor)
        {
            return getNodoRecursivo(nodo.izquierdo, valor);
        } else {
            return getNodoRecursivo(nodo.derecho, valor);
        }
    }

    private Nodo encontrarSucesor(Nodo nodo)
    {
        while (nodo.izquierdo != null)
        {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public void imprimirEnOrden() {
        imprimirEnOrdenRecursivo(raiz);
    }

    private void imprimirEnOrdenRecursivo(Nodo nodo)
    {
        if (nodo != null)
        {
            imprimirEnOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            imprimirEnOrdenRecursivo(nodo.derecho);
        }
    }

    public int tamaño() {
        return tamañoRecursivo(raiz);
    }

    private int tamañoRecursivo(Nodo nodo)
    {
        if (nodo == null)
        {
            return 0;
        }

        int tamañoIzquierdo = tamañoRecursivo(nodo.izquierdo);
        int tamañoDerecho = tamañoRecursivo(nodo.derecho);

        return tamañoIzquierdo + tamañoDerecho + 1;
    }

    public boolean estaVacio() {
        return raiz == null;
    }
}

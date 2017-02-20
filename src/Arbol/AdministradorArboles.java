package Arbol;

import java.util.ArrayList;

public class AdministradorArboles {

   

    ArrayList<Integer> valores = new ArrayList<>();
    ArrayList<Integer> terminales = new ArrayList<>();
    
    public NodoArbol raiz;
    
    public void AdministradorArboles(){
    
    NodoArbol raiz= new NodoArbol();
    }
    
     public boolean esVacio(){
        return (raiz == null);
    }

//    public void imprimirArbolInOrden(NodoArbol arbol) {
//
//        if (arbol != null) {
//            valores.add(raiz.IdInfo);
//            imprimirArbolInOrden(raiz.izquierdo);
//            System.out.println(arbol.IdInfo + "->-> " + arbol.PosicionArchivo);
//            imprimirArbolInOrden(raiz.derecho);
//
//        }
//
//    }
    public void inOrder(){
        if (!esVacio()) {
            raiz.izquierdo.inOrder();
            System.out.print( raiz.IdInfo + "->-> "+raiz.PosicionArchivo+"\n");
            raiz.derecho.inOrder();
        }
    }

//    public void imprimirArbolPreOrden(NodoArbol arbol) {
//
//        if (arbol != null) {
//            System.out.println(arbol.IdInfo);
//            imprimirArbolPreOrden(arbol.izquierdo);
//            imprimirArbolPreOrden(arbol.derecho);
//
//        }
//
//    }

//    public void imprimirArbolPostOrden(NodoArbol arbol) {
//
//        if (arbol != null) {
//
//            imprimirArbolPreOrden(arbol.izquierdo);
//            imprimirArbolPreOrden(arbol.derecho);
//            System.out.println(arbol.IdInfo);
//
//        }
//
//    }

    public void insertarNodo(Integer ValorId, Long Posicion) {

        if (esVacio()) {
            
            NodoArbol arbolito = new NodoArbol();
            arbolito.IdInfo = ValorId;
            arbolito.PosicionArchivo = Posicion;
            arbolito.derecho= new AdministradorArboles();
            arbolito.izquierdo= new AdministradorArboles();
            raiz=arbolito;
            
        } else {
            if (ValorId < raiz.IdInfo) {
                (raiz.izquierdo).insertarNodo( ValorId, Posicion);
            } else if (ValorId > raiz.IdInfo) {
                (raiz.derecho).insertarNodo( ValorId, Posicion);
            }

        }
        
    }

    public long buscar(int a){
        
        NodoArbol arbolito = null;
        
        if (!esVacio()) {
            if (a == raiz.IdInfo) {
            return raiz.PosicionArchivo;
            }
            else {
                if (a < raiz.IdInfo) {
                    raiz.PosicionArchivo = raiz.izquierdo.buscar(a);
                }
                else {
                    raiz.PosicionArchivo = raiz.derecho.buscar(a);
                }
            }
        }
        return raiz.PosicionArchivo;
    }

//    public NodoArbol borrarNodo(NodoArbol arbolito, int valor) {
//        NodoArbol arbolitoo = new NodoArbol();
////        imprimirArbolInOrden(arbolito);
//        for (int i = 0; i < valores.size(); i++) {
//            if (valor == valores.get(i)) {
//                valores.remove(i);
//            }
//
//        }
//        for(int p = 0; p < valores.size(); p++){ //Cargar segundo array sin el cero
//                    if(valores.get(p).equals(0)){
//                        System.out.println("Cero");
//                    }else{
//                       terminales.add(valores.get(p)); 
//                    }
//                }
//        for (int q = 0; q < terminales.size(); q++) { //Cargar Segundo Arbol
//                    Integer x = terminales.get(q);
//                    insertarNodo(arbolitoo, x);
//                }
//        return arbolitoo;
//    }
    public void Recorrer() {
        for (int i = 0; i < valores.size(); i++) {
            System.out.println(valores.get(i));
        }
    }

//    public NodoArbol voltearArbol(NodoArbol a) {
//
//        NodoArbol c = new NodoArbol();
//
//        if (a != null) {
//            c = a.derecho;
//            a.derecho = a.izquierdo;
//            a.izquierdo = c;
//
//            voltearArbol(a.derecho);
//            voltearArbol(a.izquierdo);
//        }
//
//        return a;
//    }

}

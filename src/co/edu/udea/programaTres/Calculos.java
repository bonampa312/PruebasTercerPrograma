/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.programaTres;

/**
 *
 * @author DAVID, RAFAEL, SANTIAGO
 */
public class Calculos {
    
    private double vs, small, medium, large, vl;
    private double avg, variance, stndDeviate;
    
    public ListaLigada calcularDatos(ListaLigada x, ListaLigada y){
        
        ListaLigada coeficiente = ListaLigada.dividirValores(x,y);
        double cantidadDatos;
        cantidadDatos = coeficiente.getCantidadNodos();
        double sumatoriaLista = sumarLnsLista(coeficiente);
        
        avg = sumatoriaLista/cantidadDatos;
        variance = sumarLnsLista(coeficiente,avg,2)/(cantidadDatos-1);
        stndDeviate = Math.sqrt(variance);
        
        vs = Math.exp(avg-2*stndDeviate);
        small = Math.exp(avg-stndDeviate);
        medium = Math.exp(avg);
        large = Math.exp(avg+stndDeviate);
        vl = Math.exp(avg+2*stndDeviate);
        
        return coeficiente;
    }
    
    public static double roundDouble(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    static double sumarLnsLista(ListaLigada coeficiente) {
        Nodo pivote = coeficiente.getPrimero();
        double suma=0;
        double lnDato;
        while(null!=pivote){
            lnDato = Math.log1p(pivote.getDato());
            lnDato = Calculos.roundDouble(lnDato, 4);
            System.out.println("Lognat "+pivote.getDato());
            suma = suma + lnDato;
            pivote = pivote.getSiguiente();
        }
        return suma;
    }

    static double sumarLnsLista(ListaLigada coeficiente, double avg, double i) {
        Nodo pivote = coeficiente.getPrimero();
        double suma = 0;
        double dato;
        while(pivote!=null){
            double termino = Math.log1p(pivote.getDato())-avg;
            termino = Calculos.roundDouble(termino, 4);
            dato = Math.pow(termino, i);
            dato = Calculos.roundDouble(dato, 4);
            System.out.println("Lognat "+dato);
            suma = suma + dato;
            pivote = pivote.getSiguiente();
        }
        return suma;
    }
    
    public double getVs() {
        return vs;
    }

    public double getSmall() {
        return small;
    }

    public double getMedium() {
        return medium;
    }

    public double getLarge() {
        return large;
    }

    public double getVl() {
        return vl;
    }
    
    
    
}

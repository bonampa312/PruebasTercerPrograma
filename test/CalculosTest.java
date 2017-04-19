/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.udea.programaTres.Calculos;
import co.edu.udea.programaTres.GestionDatos;
import co.edu.udea.programaTres.ListaLigada;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ELVIS
 */
public class CalculosTest {
    GestionDatos obtenerDatos = new GestionDatos();
    ListaLigada x, y;
    
    
    public CalculosTest() {
    }
    
    @Test
    public void dividirValoresTest() throws IOException{
        ListaLigada resultado;
        x = obtenerDatos.leerDatos("/");
        y = null;
        resultado = ListaLigada.dividirValores(x,y);
        assertNotNull(resultado);
    }
    
    @Test
    public void sumarLnsListaTest(){
        x = ListaLigada.dividirValores(x,y);
        double promedio = Calculos.calcularMedia(x);
        Double result = Calculos.sumarLnsLista(x, promedio, 2);
        assertTrue(result!=0);
    }
}

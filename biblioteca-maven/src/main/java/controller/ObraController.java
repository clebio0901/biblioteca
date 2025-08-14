package controller;

import java.util.ArrayList;
import model.Obra;


	public class ObraController {
    private ArrayList<Obra> obras;

    public ObraController() {
        obras = new ArrayList<Obra>();
    }

    public void cadastrarObra(Obra novaObra) {
        obras.add(novaObra);
        System.out.println("Obra cadastrada com sucesso!");
    }

    public void listarObras() {
        for (Obra obra : obras) {
            System.out.println(obra.getTitulo() + " (" + obra.getClass().getSimpleName() + ")");
        }
    }
    
    
}
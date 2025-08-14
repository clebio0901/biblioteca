package controller;

import model.Obra;
import java.util.ArrayList;
import java.util.List;

public class ObraController {
    private List<Obra> obras;

    public ObraController() {
        obras = new ArrayList<>();
    }

    public void adicionarObra(Obra obra) {
        obras.add(obra);
    }

    public Obra buscarPorCodigo(String codigo) {
        for (Obra obra : obras) {
            if (obra.getCodigo().equalsIgnoreCase(codigo)) {
                return obra;
            }
        }
        return null;
    }

    public void listarObras() {
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra cadastrada.");
            return;
        }
        for (Obra obra : obras) {
            System.out.println(obra);
        }
    }

    public List<Obra> getObras() {
        return obras;
    }
}

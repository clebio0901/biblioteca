package controller;

import model.Emprestimo;
import model.Obra;
import model.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;

    public EmprestimoController() {
        emprestimos = new ArrayList<>();
    }

    public void realizarEmprestimo(Obra obra, Usuario usuario) {
        obra.setEmprestada(true);
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataPrevista = dataEmprestimo.plusDays(7); 
        Emprestimo emp = new Emprestimo(obra, usuario, dataEmprestimo, dataPrevista);
        emprestimos.add(emp);
    }

    public void registrarDevolucao(String codigoObra) {
        for (Emprestimo emp : emprestimos) {
            if (emp.getObra().getCodigo().equalsIgnoreCase(codigoObra) && emp.getDataPrevistaDevolucao() == null) {
                emp.setDataDevolucao(LocalDate.now());
                emp.getObra().setEmprestada(false);

                long diasAtraso = ChronoUnit.DAYS.between(emp.getDataPrevistaDevolucao(), emp.getDataPrevistaDevolucao());
                if (diasAtraso > 0) {
                    double multa = diasAtraso * 2.0; 
                    System.out.printf("Devolução com atraso de %d dias. Multa: R$ %.2f%n", diasAtraso, multa);
                } else {
                    System.out.println("Devolução realizada no prazo.");
                }
                return;
            }
        }
        System.out.println("Empréstimo não encontrado ou já devolvido.");
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

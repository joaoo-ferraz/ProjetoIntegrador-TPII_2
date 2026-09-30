package siga;

import java.util.ArrayList;
import java.util.List;
public class AlunoDAOMemoria implements AlunoDAO {

    private final List<Aluno> armazem = new ArrayList<>();

    @Override
    public void inserir(Aluno aluno) {
            if (buscarPorMatricula(aluno.getMatricula()) != null) {
                throw new IllegalStateException("Aluno com matrícula " + aluno.getMatricula() + " já existe.");
            }
        armazem.add(aluno);
    }

    @Override
    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno aluno : armazem) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;   
    }

    @Override
    public List<Aluno> listarTodos() {
        // DESLIZE 1: devolve a própria coleção interna, sem cópia defensiva.
        return armazem;
    }

    @Override
    public void atualizar(Aluno aluno) {
        for (int i = 0; i < armazem.size(); i++) {
            if (armazem.get(i).getMatricula().equals(aluno.getMatricula())) {
                armazem.set(i, aluno);
                return;
            }
        }
        throw new IllegalStateException("Aluno com matrícula " + aluno.getMatricula() + " não encontrado.");
    }

    @Override
    public void remover(String matricula) {
        // DESLIZE 2: não verifica se existia; falha em silêncio.
        Aluno encontrado = buscarPorMatricula(matricula);
        armazem.remove(encontrado);   // remove(null) simplesmente não faz nada
    }
}

import java.util.List;

public class ManipulaAluno {
    public ManipulaAluno() {
    }

    public Aluno cadastro(Aluno aluno, List<Aluno> alunos) {
        alunos.add(aluno);
        return aluno;
    }

    public void listarTudo(List<Aluno> alunos) {
        for (Aluno a: alunos) {
            System.out.println(a.toString());
        }
    }

    public void modificarNota(int matricula, double novaNota, List<Aluno> alunos) {
        boolean alunoEncontrado = false;

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                aluno.setNota(novaNota);  // Atualiza a nota do aluno
                alunoEncontrado = true;
                System.out.println("Nota do aluno modificada com sucesso.");
                System.out.println(aluno.toString());
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Número de matrícula inválido.");
        }
    }


    public double calcularMediaNotas(List<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return 0.0; // Retorna 0 se não houver alunos na lista
        }

        double somaNotas = 0.0;
        for (Aluno aluno : alunos) {
            somaNotas += aluno.getNota();
        }

        return somaNotas / alunos.size(); // Retorna a média das notas
    }
}

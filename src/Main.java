import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ManipulaAluno manipulaAlunos = new ManipulaAluno();

        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        int matricula;
        String nome;
        double nota;
        int maxId = 1;

        while (true) {
            menu(); //EXIBE OPÇÕES DO MENU

            int opcao = Integer.parseInt(sc.nextLine());   //COLETA OPÇÃO DIGITADA PELO USUÁRIO E O
                                                          // Integer.parseInt PEGA TUDO E CONVERTE PRA INTEIRO

            switch(opcao) {

                case 0:
                    sc.close();
                    System.out.println("SISTEMA ENCERRADO");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("--- Cadastro de alunos ---");
                    System.out.print("Nome completo do aluno: ");
                    nome = sc.nextLine();
                    System.out.print("Nota: ");
                    nota = sc.nextDouble();
                    sc.nextLine();

                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida. A nota deve estar entre 0 e 10.");
                    } else {
                        Aluno a = new Aluno(maxId, nome, nota);
                        manipulaAlunos.cadastro(a, alunos);
                        maxId++;
                        System.out.println("Aluno adicionado.\n");
                        System.out.println(a.toString());
                    }
                    break;
                case 2:
                    System.out.println("--- Informações de alunos ---");
                    if (alunos.isEmpty()) {
                        System.out.println("NÃO HÁ ALUNOS CADASTRADOS.\n");
                    } else {
                        System.out.println("ALUNOS");
                        manipulaAlunos.listarTudo(alunos);
                    }
                    break;
                case 3:
                    System.out.println("--- Modificar nota ---");
                    System.out.print("Digite a matrícula do aluno: ");
                    int alunoModificar = Integer.parseInt(sc.nextLine());
                    Aluno alunoEncontrado = null;

                    // Procura o aluno na lista pelo número de matrícula
                    for (Aluno a : alunos) {
                        if (a.getMatricula() == alunoModificar) {
                            alunoEncontrado = a;
                            break;
                        }
                    }

                    if (alunoEncontrado == null) {
                        System.out.println("Número de matrícula inválido. O aluno não foi encontrado.");
                    } else {
                        System.out.print("Nova nota: ");
                        double novaNota = sc.nextDouble();
                        sc.nextLine();

                        if (novaNota < 0 || novaNota > 10) {
                            System.out.println("Nota inválida. A nota deve estar entre 0 e 10.");
                        } else {
                            // Atualiza a nota do aluno encontrado
                            alunoEncontrado.setNota(novaNota);
                            System.out.println("Nota modificada com sucesso.");
                            System.out.println(alunoEncontrado.toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println("--- Média de notas ---");
                    double mediaNotas = manipulaAlunos.calcularMediaNotas(alunos);
                    System.out.println("A média de notas entre os alunos é: " + mediaNotas + "\n");
                    break;
            }
        }
    }
    public static void menu() {
        System.out.println("=== MENU ===");
        System.out.println("1 - Cadastro de alunos");
        System.out.println("2 - Informações de alunos");
        System.out.println("3 - Modificar nota");
        System.out.println("4 - Média de notas");
        System.out.println("0 - Sair");
    }
}

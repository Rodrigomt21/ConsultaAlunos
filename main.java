import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de notas e faltas.");
        System.out.print("Usuário: ");
        String username = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        if (login.login(username, password)) {
            System.out.println("Login bem-sucedido!");

            int alunoId = login.getAlunoId(username);
            if (alunoId != -1) {
                consulta.getNotasEFaltas(alunoId);
            } else {
                System.out.println("Erro ao buscar o ID do aluno.");
            }

        } else {
            System.out.println("Login inválido!");
        }

        scanner.close();
    }
}

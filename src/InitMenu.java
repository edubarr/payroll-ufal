import java.util.Scanner;

public class InitMenu {
    Scanner input = new Scanner(System.in);

    public void run() {
        System.out.println("\n##########################################");
        System.out.println("##### Folha de pagamento v0.1 Alpha #####");
        System.out.println("##########################################\n");
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("0 - DEV: Debug");
            System.out.println("1 - Adicionar empregado");
            System.out.println("2 - Remover empregado");
            System.out.println("3 - Lançar cartão de ponto");
            System.out.println("4 - Lançar resultado de venda");
            System.out.println("5 - Lançar taxa de serviço");
            System.out.println("6 - Alterar dados de empregado");
            System.out.println("7 - Rodar folha de pagamento (Hoje)");
            System.out.println("8 - Alterar agenda de pagamento");
            System.out.println("9 - Criar agenda de pagamento");
            System.out.println("10 - Desfazer/Refazer alteração");
            System.out.println("11 - Sair do sistema\n");

            int selection = input.nextInt();

            switch (selection) {
                case 0:
                    System.out.println("Selecionada opção 0 - Debug - em implementação\n");
                    break;
                case 1:
                    System.out.println("Selecionada opção 1 - Adicionar empregado - em implementação\n");
                    break;
                case 2:
                    System.out.println("Selecionada opção 2 - Remover empregado - em implementação\n");
                    break;
                case 3:
                    System.out.println("Selecionada opção 3 - Lançar cartão de ponto - em implementação\n");
                    break;
                case 4:
                    System.out.println("Selecionada opção 4 - Lançar resultado de venda - em implementação\n");
                    break;
                case 5:
                    System.out.println("Selecionada opção 5 - Lançar taxa de serviço - em implementação\n");
                    break;
                case 6:
                    System.out.println("Selecionada opção 6 - Alterar dados de empregado - em implementação\n");
                    break;
                case 7:
                    System.out.println("Selecionada opção 7 - Rodar folha de pagamento - em implementação\n");
                    break;
                case 8:
                    System.out.println("Selecionada opção 8 - Alterar agenda de pagamento - em implementação\n");
                    break;
                case 9:
                    System.out.println("Selecionada opção 9 - Criar agenda de pagamento - em implementação\n");
                    break;
                case 10:
                    System.out.println("Selecionada opção 10 - Desfazer/Refazer alterações - em implementação\n");
                    break;
                case 11:
                    System.out.println("Saindo do sistema, até logo...\n");
                    break;
                default:
                    System.out.println("Opção inválida, favor selecionar uma das opções disponíveis:\n");
                    break;
            }
        }
    }
}
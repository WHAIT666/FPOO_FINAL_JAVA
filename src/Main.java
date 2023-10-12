import java.util.Scanner;

public class Main {
    private static Ginasio ginasio = new Ginasio();

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Escolhe a tua opção : ");
    }

    public static Sucursal criarSucursal(Scanner scanner) {
        scanner.nextLine();
        System.out.println("nome\n");
        String nome = scanner.nextLine();
        System.out.println("id\n");
        int id = scanner.nextInt();
        Sucursal sucursal = new Sucursal(id, nome);
        System.out.println(sucursal);
        return sucursal;
    }

    public static void criarCliente(Scanner scanner) {
        System.out.print("Id da sucursal\n");
        int id = scanner.nextInt();
        Sucursal sucursalDoCliente = ginasio.encontrarSucursal(id);
        scanner.nextLine();
        System.out.println("nome\n");
        String nome = scanner.nextLine();
        System.out.println("dataNascimento\n");
        String dataNascimento = scanner.nextLine();
        System.out.println("morada\n");
        String morada = scanner.nextLine();
        System.out.println("nif\n");
        String nif = scanner.nextLine();
        System.out.println("Duração contrato");
        System.out.println("1- diário");
        System.out.println("2- trimestral");
        System.out.println("3- semestral");
        System.out.println("4- anual");
        int opcaoDuracao = scanner.nextInt();
        DuracaoContrato duracaoContrato = switch (opcaoDuracao) {
            case 1 -> DuracaoContrato.diario;
            case 2 -> DuracaoContrato.trimestral;
            case 3 -> DuracaoContrato.semestral;
            case 4 -> DuracaoContrato.anual;
            default -> null;
        };
        System.out.println("Tipo de acesso");
        System.out.println("1- básico");
        System.out.println("2- completo");
        int opcaoAcesso = scanner.nextInt();
        Acesso acesso = null;
        switch (opcaoAcesso) {
            case 1:
                acesso = Acesso.basico;
                break;
            case 2:
                acesso = Acesso.completo;
                break;

        }
        System.out.println("Tipo de cliente");
        System.out.println("1- Cliente Normal");
        System.out.println("2- Cliente VIP");
        int opcaoCliente = scanner.nextInt();
        TipoCliente tipoCliente = switch (opcaoCliente) {
            case 1 -> TipoCliente.normal;
            case 2 -> TipoCliente.vip;
            default -> null;
        };
        Contrato contrato = new Contrato(nif, duracaoContrato, tipoCliente, acesso);
        Cliente cliente = new Cliente(nif, morada, nome, dataNascimento, contrato);
        System.out.println(cliente);

        sucursalDoCliente.adicionarCliente(cliente);
    }


    public static void main(String[] args) {
        String[] primeiroMenu = {"1- Criar sucursal",
                "2- Criar cliente",
                "3- Entrar Cliente",
                "4- Número total de clientes",
                "5- Número total de colaboradores",
                "6- Percentagem de clientes ativos",
                "7- Top 5 sucursais por clientes ativos",
                "8 - Exit",
        };
        String[] menuCliente = {"1- Alterar Tipo de Contrato",
                "2- Pesquisar Cliente",
                "3- Adicionar sessão",
                "4- Remover sessão",
                "5- Obter estado da inscrição",
                "6- Imprimir todas as sessões",
                "7- Imprimir ficha de cliente",
                "8- Exit",
        };


        Scanner scanner = new Scanner(System.in);
        int option = 1;

        // Testes
        Sucursal testeS = new Sucursal(1, "Sobrado");
        Sucursal testeS2 = new Sucursal(2, "Valongo");
        Cliente testeC = new Cliente("123", "rua cenas", "Pedro", "03/01/2004",
                new Contrato("123", DuracaoContrato.semestral, TipoCliente.vip, Acesso.basico));
        Cliente testeC2 = new Cliente("456", "rua outra", "Ricardo", "03/04/2002",
                new Contrato("456", DuracaoContrato.diario, TipoCliente.vip, Acesso.completo));
        Cliente testeC3 = new Cliente("987", "rua do inicio", "Paulo", "03/04/1999", null);
        Cliente testeC4 = new Cliente("654", "rua das peras", "Joaquim", "11/09/1999",
                new Contrato("654", DuracaoContrato.anual, TipoCliente.normal, Acesso.completo));
        Sessao testeSessao = new Sessao("01/01/2023", 60, "17h00");
        Sessao testeSessao2 = new Sessao("05/01/2023", 60, "12h00");
        Colaborador testeColab = new Colaborador("789", "rua do fim", "Albertino", "10/10/1905");

        ginasio.getSucursais().add(testeS);
        ginasio.getSucursais().add(testeS2);

        testeS.adicionarCliente(testeC);
        testeS2.adicionarCliente(testeC3);
        testeS2.adicionarCliente(testeC2);
        testeS2.adicionarCliente(testeC4);

        testeS.adicionarColaborador(testeColab);

        testeC.adicionarSessao(testeSessao);
        testeC2.adicionarSessao(testeSessao2);

        Sucursal sucursal = null;
        Cliente clienteSelecionado = null;
        while (option != 8) {
            printMenu(primeiroMenu);

            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    Sucursal novaSucursal = criarSucursal(scanner);
                    ginasio.adicionarSucursal(novaSucursal);
                }
                case 2 -> criarCliente(scanner);
                case 3 -> {
                    System.out.print("Id da sucursal\n");
                    int id = scanner.nextInt();
                    Sucursal sucursalSelecionada = ginasio.encontrarSucursal(id);
                    if (sucursalSelecionada != null) {
                        System.out.println("Selecionada sucursal:\n");
                        System.out.println(sucursalSelecionada);
                        scanner.nextLine();
                        System.out.print("NIF do cliente\n");
                        String nif = scanner.nextLine();
                        Cliente cliente = sucursalSelecionada.encontrarCliente(nif);

                        if (cliente != null) {
                            clienteSelecionado = cliente;
                            System.out.println("Selecionado cliente:\n");
                            System.out.println(cliente);

                            printMenu(menuCliente);
                            int optionCliente = scanner.nextInt();
                            switch (optionCliente) {
                                case 1 -> {
                                    System.out.println("Nova duração contrato");
                                    System.out.println("1- diário");
                                    System.out.println("2- trimestral");
                                    System.out.println("3- semestral");
                                    System.out.println("4- anual");
                                    int duracao = scanner.nextInt();
                                    DuracaoContrato duracaoContrato = switch (duracao) {
                                        case 1 -> DuracaoContrato.diario;
                                        case 2 -> DuracaoContrato.trimestral;
                                        case 3 -> DuracaoContrato.semestral;
                                        case 4 -> DuracaoContrato.anual;
                                        default -> null;
                                    };
                                    clienteSelecionado.mudarDuracaoContrato(duracaoContrato);
                                    System.out.println(clienteSelecionado.getContrato());
                                }
                                case 2 -> {
                                    scanner.nextLine();
                                    System.out.print("NIF do cliente\n");
                                    String nifProcurar = scanner.nextLine();
                                    Cliente clienteEncontrado = sucursalSelecionada.encontrarCliente(nifProcurar);
                                    if (clienteEncontrado != null) {
                                        System.out.println(clienteEncontrado);
                                    } else {
                                        System.out.println("Cliente não existe");
                                    }
                                }
                                case 3 -> {
                                    if (clienteSelecionado.getContrato().getTipoCliente().equals(TipoCliente.vip)) {
                                        scanner.nextLine();
                                        System.out.println("Data\n");
                                        String data = scanner.nextLine();
                                        System.out.println("Hora de Inicio");
                                        String horaInicio = scanner.nextLine();
                                        System.out.println("Duração\n");
                                        int duracaoSessao = scanner.nextInt();
                                        Sessao sessao = new Sessao(data, duracaoSessao, horaInicio);

                                        clienteSelecionado.adicionarSessao(sessao);
                                        System.out.println(sessao);
                                    } else {
                                        System.out.println("Você não é um cliente VIP");
                                    }
                                }
                                case 4 -> {
                                    if (clienteSelecionado.getContrato().getTipoCliente().equals(TipoCliente.vip)) {
                                        scanner.nextLine();
                                        System.out.println("Data\n");
                                        String data = scanner.nextLine();
                                        System.out.println("Hora de Inicio");
                                        String horaInicio = scanner.nextLine();

                                        boolean foiRemovido = clienteSelecionado.removerSessao(data, horaInicio);
                                        if (foiRemovido) {
                                            System.out.println("Sessao removida");
                                        } else {
                                            System.out.println("Não existe essa sessão");
                                        }

                                    } else {
                                        System.out.println("Você não é um cliente VIP");
                                    }
                                }
                                case 5 -> System.out.println(clienteSelecionado.getContrato());
                                case 6 -> System.out.println(clienteSelecionado.getSessoes());
                                case 7 -> System.out.println(clienteSelecionado);
                            }
                        } else {
                            System.out.println("Cliente não existe");
                        }
                    } else {
                        System.out.println("Sucursal não existe");
                    }
                }
                case 4 -> {
                    for (int i = 0; i < ginasio.getSucursais().size(); i++) {
                        Sucursal sucursalAtual = ginasio.getSucursais().get(i);
                        System.out.println(sucursalAtual);
                        System.out.println("Clientes: " + sucursalAtual.getClientes().size());
                    }
                }
                case 5 -> {
                    for (int i = 0; i < ginasio.getSucursais().size(); i++) {
                        Sucursal sucursalAtual = ginasio.getSucursais().get(i);
                        System.out.println(sucursalAtual);
                        System.out.println("Colaboradores: " + sucursalAtual.getColaboradores().size());
                    }
                }
                case 6 -> {
                    for (int i = 0; i < ginasio.getSucursais().size(); i++) {
                        Sucursal sucursalAtual = ginasio.getSucursais().get(i);
                        System.out.println(sucursalAtual);
                        System.out.println("Clientes Ativos: " + sucursalAtual.percentagemClientesAtivos() + "%");
                    }
                }
                case 7 -> {
                    ginasio.getSucursais().sort((s1, s2) -> {
                        int s1Ativos = s1.numeroTotalClientesAtivos();
                        int s2Ativos = s2.numeroTotalClientesAtivos();

                        return s2Ativos - s1Ativos;
                    });
                    for (int i = 0; i < ginasio.getSucursais().size(); i++) {
                        Sucursal sucursalAtual = ginasio.getSucursais().get(i);
                        System.out.println(i + 1 + "º " + sucursalAtual + " clientes ativos " + sucursalAtual.numeroTotalClientesAtivos());
                    }
                }
            }
        }
    }
}

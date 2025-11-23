import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Seja bem-vindo ao QUIZ ACADÊMICO!");

        String nome = "";

        // ===== Validação do nome =====
        while (true) {
            System.out.print("Insira o seu nome: ");
            nome = input.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("⚠️ O nome não pode estar vazio. Tente novamente!");
                continue;
            }

            // Corrigido: aceita letras e espaços (sem //)
            if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                System.out.println("⚠️ O nome deve conter apenas letras. Tente novamente!");
                continue;
            }

            break; // Sai do while se tudo estiver ok
        }

        // ===== Validação da idade =====
        int idade = 0;
        boolean idadeValida = false;

        while (!idadeValida) {
            System.out.print("Insira a sua idade: ");
            try {
                idade = Integer.parseInt(input.nextLine());
                if (idade <= 0) {
                    System.out.println("⚠️ Idade inválida! Digite um número positivo.");
                } else {
                    idadeValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Digite apenas números inteiros.");
            }
        }

        // ===== Seleção de escolaridade =====
        System.out.println("\nQual a sua escolaridade:");
        System.out.println("1 - Fundamental");
        System.out.println("2 - Ensino Médio");
        System.out.println("3 - Ensino Superior");
        System.out.println("Pela escolaridade, você será inserido em níveis diferentes de dificuldade do nosso quiz.");

        int opcao = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Escolha uma opção (1, 2 ou 3): ");

            if (input.hasNextInt()) {
                opcao = input.nextInt();
                input.nextLine(); // limpa o buffer

                if (opcao >= 1 && opcao <= 3) {
                    entradaValida = true;
                } else {
                    System.out.println("⚠️ Opção inválida! Digite 1, 2 ou 3.");
                }
            } else {
                System.out.println("⚠️ Entrada inválida! Digite apenas números.");
                input.nextLine(); // limpa texto incorreto
            }
        }

        // ===== Chama o quiz conforme a opção =====
        switch (opcao) {
            case 1:
                System.out.println("\n🎯 Você foi inserido na dificuldade BÁSICA.");
                quizBasico(input);
                break;
            case 2:
                System.out.println("\n🎯 Você foi inserido na dificuldade INTERMEDIÁRIA.");
                quizInter(input);
                break;
            case 3:
                System.out.println("\n🚀 Você foi inserido na dificuldade AVANÇADA.");
                quizAvancado(input);
                break;
        }

        System.out.println("\nObrigado, " + nome + ", por ter participado do nosso Quiz. Volte sempre!");
        input.close();
    }

    // ===== MÉTODO PARA RANDOMIZAR PERGUNTAS =====
    public static String[][] randomizarPerguntas(String[][] perguntas) {
        // Converte o array para List para poder usar Collections.shuffle
        List<String[]> listaPerguntas = Arrays.asList(perguntas);

        // Embaralha a lista
        Collections.shuffle(listaPerguntas);

        // Converte de volta para array
        return listaPerguntas.toArray(new String[0][0]);
    }

    // ===== QUIZ BÁSICO =====
    public static void quizBasico(Scanner input) {
        int pontuacao = 0;
        System.out.println("🎯 Vamos começar o quiz básico!");
        System.out.println("Responda com o número da alternativa (1, 2 ou 3).");

        String[][] perguntas = {
                {"Qual é o maior planeta do sistema solar?", "Terra", "Júpiter", "Saturno", "2"},
                {"Quem descobriu o Brasil em 1500?", "Pedro Álvares Cabral", "Dom Pedro", "Cristóvão Colombo", "1"},
                {"Qual é o resultado de 5 + 3?", "8", "9", "10", "1"},
                {"Qual animal é conhecido como 'Rei da Selva'?", "Leão", "Elefante", "Tigre", "1"},
                {"Qual planeta é conhecido como 'Planeta Vermelho'?", "Vênus", "Marte", "Júpiter", "2"},
                {"Qual é a cor do céu em um dia claro?", "Azul", "Verde", "Vermelho", "1"},
                {"Quantos continentes existem no mundo?", "5", "7", "6", "2"},
                {"Qual é a água no estado sólido?", "Gelo", "Vapor", "Chuva", "1"},
                {"Quem pintou a Mona Lisa?", "Van Gogh", "Da Vinci", "Picasso", "2"},
                {"Qual o nome do personagem que usa uma capa vermelha e voa?", "Batman", "Superman", "Homem-Aranha", "2"}
        };

        // Randomiza as perguntas antes de começar o quiz
        String[][] perguntasRandomizadas = randomizarPerguntas(perguntas);

        for (int i = 0; i < perguntasRandomizadas.length; i++) {
            fazerPergunta(input, perguntasRandomizadas[i], i + 1);
            if (respostaCorreta(input, perguntasRandomizadas[i])) {
                pontuacao++;
            }
        }

        System.out.println("\n🏁 Você acertou " + pontuacao + " de " + perguntasRandomizadas.length + " perguntas.");
    }

    // ===== QUIZ INTERMEDIÁRIO =====
    public static void quizInter(Scanner input) {
        int pontuacao = 0;
        System.out.println("🎯 Vamos começar o quiz intermediário!");
        System.out.println("Responda com o número da alternativa (1, 2 ou 3).");

        String[][] perguntas = {
                {"Qual é a área de um triângulo com base 8 cm e altura 5 cm?", "20 cm²", "40 cm²", "13 cm²", "1"},
                {"Qual unidade é usada para medir a intensidade da corrente elétrica?", "Volt (V)", "Ampere (A)", "Ohm (Ω)", "2"},
                {"Qual elemento químico tem símbolo 'Na'?", "Sódio", "Nitrogênio", "Níquel", "1"},
                {"Qual é a função dos glóbulos vermelhos no sangue?", "Combater infecções", "Coagular o sangue", "Transportar oxigênio", "3"},
                {"Qual foi a causa principal da Revolução Industrial?", "Descoberta da América", "Desenvolvimento das máquinas a vapor", "Revoltas camponesas", "2"},
                {"Qual é o maior bioma brasileiro?", "Mata Atlântica", "Cerrado", "Amazônia", "3"},
                {"Na frase 'Ela falou com a professora', o verbo está no tempo:", "Presente", "Pretérito perfeito", "Futuro", "2"},
                {"Quem foi o autor da obra 'A República'?", "Sócrates", "Platão", "Aristóteles", "2"},
                {"Qual conceito está ligado a normas e valores compartilhados?", "Cultura", "Poder", "Tecnologia", "1"},
                {"Qual é o plural de 'child'?", "Childs", "Childes", "Children", "3"}
        };

        // Randomiza as perguntas antes de começar o quiz
        String[][] perguntasRandomizadas = randomizarPerguntas(perguntas);

        for (int i = 0; i < perguntasRandomizadas.length; i++) {
            fazerPergunta(input, perguntasRandomizadas[i], i + 1);
            if (respostaCorreta(input, perguntasRandomizadas[i])) {
                pontuacao++;
            }
        }

        System.out.println("\n🏁 Você acertou " + pontuacao + " de " + perguntasRandomizadas.length + " perguntas.");
    }

    // ===== QUIZ AVANÇADO =====
    public static void quizAvancado(Scanner input) {
        int pontuacao = 0;
        System.out.println("🚀 Vamos começar o quiz avançado!");
        System.out.println("Responda com o número da alternativa (1, 2 ou 3).");

        String[][] perguntas = {
                {"Qual é o elemento químico mais eletronegativo?", "Oxigênio", "Cloro", "Flúor", "3"},
                {"Qual presidente brasileiro era conhecido como 'Jango'?", "João Goulart", "Jacinto Anjos", "Jânio Quadros", "1"},
                {"De quem é a frase 'Penso, logo existo'?", "Sócrates", "René Descartes", "Platão", "2"},
                {"Um dos principais autores do Barroco no Brasil:", "Gregório de Matos", "Miguel de Cervantes", "Dante Alighieri", "1"},
                {"Qual contém classes de palavras?", "Consoantes", "Sintaxe", "Preposição", "3"},
                {"Quem descobriu a pasteurização?", "Marie Curie", "Charles Darwin", "Louis Pasteur", "3"},
                {"Em que século ocorreu a peste bubônica?", "XIV", "XII", "XI", "1"},
                {"Quantos graus têm ângulos complementares?", "90", "45", "180", "1"},
                {"Primeiro presidente do Brasil:", "1890, Floriano Peixoto", "1889, Hermes da Fonseca", "1891, Deodoro da Fonseca", "3"},
                {"O que completou 30 anos em 2019?", "Queda da Bastilha", "Queda do Muro de Berlim", "Grande Depressão", "2"}
        };

        // Randomiza as perguntas antes de começar o quiz
        String[][] perguntasRandomizadas = randomizarPerguntas(perguntas);

        for (int i = 0; i < perguntasRandomizadas.length; i++) {
            fazerPergunta(input, perguntasRandomizadas[i], i + 1);
            if (respostaCorreta(input, perguntasRandomizadas[i])) {
                pontuacao++;
            }
        }

        System.out.println("\n🏁 Você acertou " + pontuacao + " de " + perguntasRandomizadas.length + " perguntas.");
    }

    // ===== MÉTODOS AUXILIARES =====
    public static void fazerPergunta(Scanner input, String[] pergunta, int numero) {
        System.out.println("\n" + numero + ") " + pergunta[0]);
        System.out.println("1) " + pergunta[1]);
        System.out.println("2) " + pergunta[2]);
        System.out.println("3) " + pergunta[3]);
    }

    public static boolean respostaCorreta(Scanner input, String[] pergunta) {
        while (true) {
            System.out.print("Resposta: ");
            String entrada = input.nextLine();

            if (entrada.matches("[1-3]")) {
                if (entrada.equals(pergunta[4])) {
                    System.out.println("✅ Correto!");
                    return true;
                } else {
                    System.out.println("❌ Errado! A resposta certa é: " + pergunta[Integer.parseInt(pergunta[4])]);
                    return false;
                }
            } else {
                System.out.println("⚠️ Digite apenas 1, 2 ou 3.");
            }
        }
    }
}
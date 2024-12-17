import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to the game of Rock-Paper-Scissors!");
        System.out.println("Enter 'Rock', 'Scissors' or 'Paper'. To exit, enter 'Exit'.");

        while (true) {
            // Ввод пользователя
            System.out.print("Your choice: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("exit")) {
                System.out.println("Thanks for playing!");
                System.out.println("Your score: " + playerScore + ", Computer Score: " + computerScore);
                break;
            }

            // Проверка корректности ввода
            if (!playerChoice.equals("rock") && !playerChoice.equals("scissors") && !playerChoice.equals("paper")) {
                System.out.println("Incorrect entry! Try again.");
                continue;
            }

            // Выбор компьютера
            int computerRandom = random.nextInt(3); // 0, 1 или 2
            String computerChoice = "";
            switch (computerRandom) {
                case 0:
                    computerChoice = "rock";
                    break;
                case 1:
                    computerChoice = "scissors";
                    break;
                case 2:
                    computerChoice = "paper";
                    break;
            }

            System.out.println("The computer chose: " + computerChoice);

            // Определение победителя
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
                playerScore++;
            } else {
                System.out.println("The computer has won!");
                computerScore++;
            }

            // Показ текущего счёта
            System.out.println("Score: You " + playerScore + " - Computer " + computerScore);
            System.out.println("------------------------------------");
        }

        scanner.close();
    }
}

// test
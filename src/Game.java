import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    HashMap<Player, Combination> game = new HashMap<>();
    int numGame = 1;

    /**
     * Выбираем сколько игроков будет играть
     * даем им реальные имена
     */
    void playerInitialization() {
        System.out.println("Сколько будет игроков");
        int numPlayer = 0;
        try {
            numPlayer = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное число игроков");
        }
        System.out.println("Введите их имена");
        for (int i = 0; i < numPlayer; i++) {
            String name = scanner.next();
            Player newPlayer = new Player(name);
            game.put(newPlayer, new Combination());
        }
    }

    /**
     * Метод проверки победителя
     * Победителя в камень-ножницы-бумага можно выявить только тогда, когда игроки показали 2 типа комбинаций
     * если игроки показади 3 типа комбинации, то необходима переигровка
     */
    void checkWinner() {
        int quantityRock = 0;
        int quantityPaper = 0;
        int quantityScissors = 0;

        //Локальная таблица для удаления проигравших
        HashMap<Player, Combination> localGame = (HashMap<Player, Combination>) game.clone();

        for (Map.Entry<Player, Combination> winner : game.entrySet()) { // Вывод какой игрок что показал
            System.out.println("" + winner.getKey() + winner.getValue());
        }
        System.out.println("------------------------------------------");
        for (Player player : game.keySet()) { // Проверяем сколько комбинаций было показано игроками
            game.get(player).randomCombination();
            String localResult = game.get(player).getHandVariant();
            if (localResult.equals("Камень")) {
                quantityRock++;
            } else if (localResult.equals("Ножницы")) {
                quantityScissors++;
            } else if (localResult.equals("Бумагу")) {
                quantityPaper++;
            }
        }

        /**
         * Далее проверяем на условие что все игроки показали 1 тип комбинации или все показали разное
         * если не выполняется, то победитель возможен.
         */
        if ((quantityPaper == game.size() || quantityRock == game.size() || quantityScissors == game.size())
                || (quantityPaper > 0 && quantityRock > 0 && quantityScissors > 0)) {
        } else {
            if (quantityPaper == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).getHandVariant();
                    if (combination.equals("Ножницы")) {
                        localGame.remove(player);
                    }
                }
            } else if (quantityRock == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).getHandVariant();
                    if (combination.equals("Бумагу")) {
                        localGame.remove(player);
                    }
                }
            } else if (quantityScissors == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).getHandVariant();
                    if (combination.equals("Камень")) {
                        localGame.remove(player);
                    }
                }
            }
            game = localGame;
        }
        if (game.size() > 1) {
            System.out.println("Эта игра победителя не выявила");
            System.out.print("В игре остались: ");
            for (Player nextRoundPlayer : game.keySet()) {
                System.out.print(nextRoundPlayer.getName() + " ");
            }
            System.out.println(". Что же покажет попытка № " + numGame++);
            checkWinner();
        } else {
            for (Map.Entry<Player, Combination> winner : game.entrySet()) {
                System.out.println("Победил " + winner.getKey() + " который" + winner.getValue());
            }

        }
    }
}

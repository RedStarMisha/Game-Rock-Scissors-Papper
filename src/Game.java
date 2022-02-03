import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    HashMap<Player, Combination> game = new HashMap<>();

    void playerInitialization() {
        System.out.println("Сколько будет игроков");
        int numPlayer = 0;
        try {
            numPlayer = scanner.nextInt();
            //scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное число игроков");
        }
        System.out.println("Введите их имена");
        for (int i = 0; i < numPlayer; i++) {
            String name = scanner.next();
            Player newPlayer = new Player(name);
            game.put(newPlayer, new Combination());

            /*if (game.containsKey(newPlayer)) {
                System.out.println("Такое имя уже есть. Введите еще и фамилию чтобы мы могли отличать игроков ");
                name+=scanner.next();
                newPlayer = new Player(name);
            } else {
                game.put(newPlayer, new Combination());
            }*/
        }
    }

    /* HashMap<Player, Combination> play() {
         playerInitialization();
            if (nameExistOrNo) {
                 game.put(new Player(name), new Combination());
             }

         for (Player player : game.keySet()) {
             System.out.println("Имя игрока "+player.getName());
         }

         return game;
     }*/
    void checkWinner() {
        int quantityRock = 0;
        int quantityPaper = 0;
        int quantityScissors = 0;
        HashMap<Player, Combination> localGame = (HashMap<Player, Combination>) game.clone();
        for (Player player : game.keySet()) {
            String localResult = game.get(player).randomCombination();
            if (localResult.equals("Камень")) {
                quantityRock++;
            } else if (localResult.equals("Ножницы")) {
                quantityScissors++;
            } else if (localResult.equals("Бумага")) {
                quantityPaper++;
            }
        }
        if ((quantityPaper == game.size() || quantityRock == game.size() || quantityScissors == game.size())
                || (quantityPaper > 0 && quantityRock > 0 && quantityScissors > 0)) {
            System.out.println("Победителя нет");
        } else {
            if (quantityPaper == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).randomCombination();
                    if (combination.equals("Ножницы")) {
                        localGame.remove(player);
                    }
                }
            } else if (quantityRock == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).randomCombination();
                    if (combination.equals("Бумага")) {
                        localGame.remove(player);
                    }
                }
            } else if (quantityScissors ==0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).randomCombination();
                    if (combination.equals("Камень")) {
                        localGame.remove(player);
                    }
                }
            }
            game=localGame;
            if (game.size()>1) {
                checkWinner();
            } else {
                System.out.println("Победил "+game.keySet().);
            }
            System.out.println("Камень = " + quantityRock + "; Ножницы = " + quantityScissors + " Бумага = " + quantityPaper);
        }
    }

    /*ArrayList<String []> play () {
        int numPlayer=0;
        ArrayList <String []> game=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько будет игроков");
        try {
            numPlayer = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное число игроков");
        }
        System.out.println("Введите их имена");
        for (int i = 0; i < numPlayer; i++) {
            String name = scanner.next();
            game.add(new String[]{Player(name), new Combination().randomCombination()});
        }
        return game;
    }*/
/*
    void result(HashMap<Player, Combination> game) {
        int quantityRock = 0;
        int quantityPaper = 0;
        int quantityScissors = 0;
        for (Player player : game.keySet()) {
            String localResult = game.get(player).randomCombination();
            if (localResult.equals("Камень")) {
                quantityRock++;
            } else if (localResult.equals("Ножницы")) {
                quantityScissors++;
            } else if (localResult.equals("Бумага")) {
                quantityPaper++;
            }
        }
        if ((quantityPaper == game.size() || quantityRock == game.size() || quantityScissors == game.size()) || (quantityPaper > 0 && quantityRock > 0 && quantityScissors > 0)) {
            System.out.println("Камень = " + quantityRock + "; Ножницы = " + quantityScissors + " Бумага = " + quantityPaper);
            System.out.println("Победителя нет");
        } else {
            if (quantityPaper == 0) {
                for (Player player : game.keySet()) {
                    String combination = game.get(player).randomCombination();
                    if (combination.equals("Ножницы")) {
                        game.remove(player);
                    }
                }
            }
            System.out.println("Камень = " + quantityRock + "; Ножницы = " + quantityScissors + " Бумага = " + quantityPaper);
        }
    }*/

}

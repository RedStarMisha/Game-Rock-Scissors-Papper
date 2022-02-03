import java.util.Random;

public class Combination {
    private String handVariant;

    void randomCombination() {
        Random random = new Random();
        int variant = random.nextInt(3);
        switch (variant) {
            case 0:
                handVariant = "Камень";
                break;
            case 1:
                handVariant = "Ножницы";
                break;
            case 2:
                handVariant = "Бумагу";
                break;
        }
    }

    public String getHandVariant() {
        return handVariant;
    }

    @Override
    public String toString() {
        return " показал " +
                handVariant;
    }
}

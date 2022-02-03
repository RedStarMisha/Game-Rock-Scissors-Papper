import java.util.Random;

public class Combination {

    String randomCombination () {
        Random random=new Random();
        int variant = random.nextInt(3);
        String handVariant=null;
        switch (variant){
            case 0:
                handVariant="Камень";
                break;
            case 1:
                handVariant="Ножницы";
                break;
            case 2:
                handVariant="Бумага";
                break;
        }
        return handVariant;
    }
}

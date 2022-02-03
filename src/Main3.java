import java.util.HashMap;

public class Main3 {
   /* int x;
    int y;

    Main3 (int x, int y) {
        this.x=x;
        this.y=y;
    }
    void area() {
        System.out.println(x*y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }*/
    HashMap <String,String> myHash=new HashMap<>();

    Main3 (String key, String value) {
        myHash.put(key, value);
    }

    public HashMap<String, String> getMyHash() {
        return myHash;
    }
}

import java.awt.*;

public class Tile {
    int value;
    public Tile(int value){
        this.value=value;
    }

    public Boolean is_empty(){
        if(this.value==0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void setValue(int num) {
        this.value=num;
    }

    public int getValue() {
        return this.value;
    }

    public Color getColor(int value) {
        switch (value) {
            case 2:
                return new Color(238, 228, 218);
            case 4:
                return new Color(237, 224, 200);
            case 8:
                return new Color(242, 177, 121);
            case 16:
                return new Color(245, 149, 99);
            case 32:
                return new Color(246, 124, 95);
            case 64:
                return new Color(246, 94, 59);
            case 128:
                return new Color(237, 207, 114);
            case 256:
                return new Color(237, 204, 97);
            case 512:
                return new Color(237, 200, 80);
            case 1024:
                return new Color(237, 197, 63);
            case 2048:
                return new Color(237, 194, 46);
            default:
                return new Color(150, 150, 150); // Default tile color
        }
    }
}

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
}

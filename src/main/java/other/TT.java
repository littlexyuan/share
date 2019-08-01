package other;

public class TT {

    private Compare compare;

    public TT(Compare compare){
        this.compare = compare;
    }

    public int max(int a, int b){
        return compare.compareTo(a,b);
    }

    public boolean bigger(int a, int b){
        return compare.compareTo(a,b)>0;
    }
}

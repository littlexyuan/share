package other;

public class TTA {
    private CompareA compare;

    public TTA(CompareA compare){
        this.compare = compare;
    }

    public void max(){
        compare.compare();
    }
}

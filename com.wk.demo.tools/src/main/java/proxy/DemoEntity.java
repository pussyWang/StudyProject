package proxy;

/**
 * PackageName proxy
 * Created by wangkang on 2017/12/20.
 */
public class DemoEntity implements DemoAnnotation {
    private String var;
    private int fie;

    private String toStr(){
        return var + "   " + fie;
    }


    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getFie() {
        return fie;
    }

    public void setFie(int fie) {
        this.fie = fie;
    }
}

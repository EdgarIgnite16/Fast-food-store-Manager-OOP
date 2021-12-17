import java.util.regex.Matcher;

public class Product {
    private String Ten;
    private String ChiTietSP;
    private int stt = 1;
    private static int count = 0;

    public Product() {
       this.Ten = null;
       this.ChiTietSP = null;
       this.stt = count++;
    }
}

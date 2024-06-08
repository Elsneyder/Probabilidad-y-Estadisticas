
public class Conditional {
    public Conditional() {}

    void getConditional(int[] marginalX, int[] marginalY, int[] joint) {
        int p = 0, r = 0, t = 0;
        System.out.println("Probability Conditional");
        for (int i = 0; i < marginalX.length; i++) {
            t++;
            System.out.println(t + ")" + joint[p] + "/" + marginalY[r]);
            t++;
            System.out.println(t + ")" + joint[p] + "/" + marginalX[r]);
            p++;
        }
        r++;
        t++;
        for (int i = 0; i < marginalX.length; i++) {
            System.out.println(t + ")" + joint[p] + "/" + marginalY[r]);
            t++;
            System.out.println(t + ")" + joint[p] + "/" + marginalX[r]);
            t++;
            p++;
        }
    }
}
import java.math.BigDecimal;
public class DataSet {

    BigDecimal[] x={BigDecimal.valueOf(108), BigDecimal.valueOf(115), BigDecimal.valueOf(106), BigDecimal.valueOf(97), BigDecimal.valueOf(95), BigDecimal.valueOf(91),
            BigDecimal.valueOf(97), BigDecimal.valueOf(83), BigDecimal.valueOf(83), BigDecimal.valueOf(78), BigDecimal.valueOf(54), BigDecimal.valueOf(67), BigDecimal.valueOf(56),
            BigDecimal.valueOf(53), BigDecimal.valueOf(61), BigDecimal.valueOf(115), BigDecimal.valueOf(81), BigDecimal.valueOf(78), BigDecimal.valueOf(30), BigDecimal.valueOf(45), BigDecimal.valueOf(99),
            BigDecimal.valueOf(32), BigDecimal.valueOf(25), BigDecimal.valueOf(28), BigDecimal.valueOf(90), BigDecimal.valueOf(89)};
    BigDecimal[][] y={{BigDecimal.valueOf(95)}, {BigDecimal.valueOf(96)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(97)}, {BigDecimal.valueOf(93)}, {BigDecimal.valueOf(94)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(93)},
            {BigDecimal.valueOf(92)}, {BigDecimal.valueOf(86)}, {BigDecimal.valueOf(73)}, {BigDecimal.valueOf(80)}, {BigDecimal.valueOf(65)}, {BigDecimal.valueOf(69)}, {BigDecimal.valueOf(77)}, {BigDecimal.valueOf(96)}, {BigDecimal.valueOf(87)},
            {BigDecimal.valueOf(89)}, {BigDecimal.valueOf(60)}, {BigDecimal.valueOf(63)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(61)}, {BigDecimal.valueOf(55)}, {BigDecimal.valueOf(56)}, {BigDecimal.valueOf(94)}, {BigDecimal.valueOf(93)}};

    BigDecimal[] x2 = {
            BigDecimal.valueOf(1),
            BigDecimal.valueOf(2),
            BigDecimal.valueOf(3),
            BigDecimal.valueOf(4),
            BigDecimal.valueOf(5),
            BigDecimal.valueOf(6),
            BigDecimal.valueOf(7),
            BigDecimal.valueOf(8),
            BigDecimal.valueOf(9),
            BigDecimal.valueOf(10)

    };

    BigDecimal[][] y2 = {
            {BigDecimal.valueOf(2)},
            {BigDecimal.valueOf(4)},
            {BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(8)},
            {BigDecimal.valueOf(10)},
            {BigDecimal.valueOf(12)},
            {BigDecimal.valueOf(14)},
            {BigDecimal.valueOf(16)},
            {BigDecimal.valueOf(18)},
            {BigDecimal.valueOf(20)},

    };

    BigDecimal[] x3 = {BigDecimal.valueOf(-3), BigDecimal.valueOf(-2), BigDecimal.valueOf(-1), BigDecimal.valueOf(0), BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)};
    BigDecimal[] x4 = {BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30), BigDecimal.valueOf(40), BigDecimal.valueOf(50), BigDecimal.valueOf(60), BigDecimal.valueOf(70), BigDecimal.valueOf(80), BigDecimal.valueOf(90), BigDecimal.valueOf(100)};
    BigDecimal[] x5 = {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN, BigDecimal.valueOf(100), BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), BigDecimal.valueOf(3000), BigDecimal.valueOf(4000), BigDecimal.valueOf(5000), BigDecimal.valueOf(6000)};

    // Crear matriz y1
    BigDecimal[][] y3 = {
            {BigDecimal.valueOf(7.5)},
            {BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(0.5)},
            {BigDecimal.valueOf(1)},
            {BigDecimal.valueOf(3)},
            {BigDecimal.valueOf(6)},
            {BigDecimal.valueOf(14)},

    };

    // Crear matriz y2
    BigDecimal[][] y4 = {
            {BigDecimal.valueOf(60)},
            {BigDecimal.valueOf(85)},
            {BigDecimal.valueOf(80)},
            {BigDecimal.valueOf(70)},
            {BigDecimal.valueOf(90)},
            {BigDecimal.valueOf(75)},
            {BigDecimal.valueOf(65)},
            {BigDecimal.valueOf(55)},
            {BigDecimal.valueOf(95)},
            {BigDecimal.valueOf(100)}
    };

    // Crear matriz y3
    BigDecimal[][] y5 = {
            {BigDecimal.valueOf(5)},
            {BigDecimal.valueOf(15)},
            {BigDecimal.valueOf(25)},
            {BigDecimal.valueOf(35)},
            {BigDecimal.valueOf(45)},
            {BigDecimal.valueOf(55)},
            {BigDecimal.valueOf(65)},
            {BigDecimal.valueOf(75)},
            {BigDecimal.valueOf(85)},
            {BigDecimal.valueOf(95)}
    };

    public DataSet(){

    }
    public DataSet(BigDecimal[] x, BigDecimal[][] y){
        this.y=y;
        this.x=x;


    }

    public BigDecimal[][] getY(int i) {

        /*BigDecimal[] array=new BigDecimal[y.length];
for (int i=0;i<y.length;i++)
    array[i]=y[i][0];

Arrays.sort(array);
        for (int i=0;i<y.length;i++)
            y[i][0]=array[i];*/

        switch (i){
            case 1:
                return y;

            case 2:
                return y2;

            case 3:
                return y3;

            case 4:
                return y4;

            case 5:
                return y5;

        }

        return null;

    }

    public BigDecimal[] getX(int i) {

        switch (i){
            case 1:
                return x;

            case 2:
                return x2;
            case 3:
                return x3;
            case 4:
                return x4;
            case 5:
                return x5;
        }


        // Arrays.sort(x);
        return null;

    }
}
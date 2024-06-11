import java.math.BigDecimal;

public class DataSet {
    BigDecimal[] x = {BigDecimal.valueOf(108), BigDecimal.valueOf(115), BigDecimal.valueOf(106), BigDecimal.valueOf(97), BigDecimal.valueOf(95), BigDecimal.valueOf(91),
            BigDecimal.valueOf(97), BigDecimal.valueOf(83), BigDecimal.valueOf(83), BigDecimal.valueOf(78), BigDecimal.valueOf(54), BigDecimal.valueOf(67), BigDecimal.valueOf(56),
            BigDecimal.valueOf(53), BigDecimal.valueOf(61), BigDecimal.valueOf(115), BigDecimal.valueOf(81), BigDecimal.valueOf(78), BigDecimal.valueOf(30), BigDecimal.valueOf(45), BigDecimal.valueOf(99),
            BigDecimal.valueOf(32), BigDecimal.valueOf(25), BigDecimal.valueOf(28), BigDecimal.valueOf(90), BigDecimal.valueOf(89)};
    BigDecimal[][] y = {{BigDecimal.valueOf(95)}, {BigDecimal.valueOf(96)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(97)}, {BigDecimal.valueOf(93)}, {BigDecimal.valueOf(94)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(93)},
            {BigDecimal.valueOf(92)}, {BigDecimal.valueOf(86)}, {BigDecimal.valueOf(73)}, {BigDecimal.valueOf(80)}, {BigDecimal.valueOf(65)}, {BigDecimal.valueOf(69)}, {BigDecimal.valueOf(77)}, {BigDecimal.valueOf(96)}, {BigDecimal.valueOf(87)},
            {BigDecimal.valueOf(89)}, {BigDecimal.valueOf(60)}, {BigDecimal.valueOf(63)}, {BigDecimal.valueOf(95)}, {BigDecimal.valueOf(61)}, {BigDecimal.valueOf(55)}, {BigDecimal.valueOf(56)}, {BigDecimal.valueOf(94)}, {BigDecimal.valueOf(93)}};

    public BigDecimal[][] getY(int i) {
        switch (i) {
            case 1:
                return y;
            default:
                return null;
        }
    }

    public BigDecimal[] getX(int i) {
        switch (i) {
            case 1:
                return x;
            default:
                return null;
        }
    }
}

import javax.swing.JOptionPane;

public class Solver {
    public static void main(String[] args) {
        // ax+b=0
        String strA = JOptionPane.showInputDialog("Enter a: ");
        String strB = JOptionPane.showInputDialog("Enter b: ");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        String result1;
        if (a==0) {
            if (b==0) result1 = "Infinite";
            else result1 = "No solution";
        } else {
            result1 = "Solution: x = " + -b / a;
        }
        JOptionPane.showMessageDialog(null, "Result: " + result1);
        //a11x1+a12x2=b1 a21x1+a22x2=b2
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("b1: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("b2: "));
        double D = a11*a22 -a12*a21;
        double D1 = b1*a22 - b2*a12;
        Double D2 = b2*a11 - b1*a21;
        String result2;
        if (D==0) {
            if (D1==0 && D2 == 0) 
                result2 = "Infinite";
            else result2 = "No solution";
        }   else {
            result2 = "x = " + D1/D + ", y = " +D2/D;
        }
        JOptionPane.showMessageDialog(null, "Result: " + result2);

        //ax^2 + bx + c = 0
        
        double a3 = Double.parseDouble(JOptionPane.showInputDialog("a: "));
        double b3 = Double.parseDouble(JOptionPane.showInputDialog("b: "));
        double c3 = Double.parseDouble(JOptionPane.showInputDialog("c: "));
        String result3;
        if (a3==0) {
            if (b3==0) {
                if (c3==0) result3 = "Infinite";
                else result3 = "No solution";
            }   else {
                result3 = "Solution: " + -c3/b3;
            }
        }   else {
            double delta = b3*b3 - 4*a3*c3;
            if (delta < 0) {
                result3 = "No solution";
            }   else if (delta == 0) {
                result3 = "Solution: x = " + -b3 / (2*a3);
            }   else {
                result3 = "Solution: x1= " + (-b3 + Math.sqrt(delta))/ (2*a3) + ", x2 = " + (-b3 - Math.sqrt(delta))/ (2*a3);
            }
        }

        JOptionPane.showMessageDialog(null, "Result "+ result3);
        System.exit(0);
    }
}
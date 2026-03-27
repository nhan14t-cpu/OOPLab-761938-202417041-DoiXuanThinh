import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {

        // ===== 1. Linear equation: ax + b = 0 =====
        String aStr = JOptionPane.showInputDialog("Linear: Enter a:");
        String bStr = JOptionPane.showInputDialog("Linear: Enter b:");

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        String result1;
        if (a == 0) {
            if (b == 0)
                result1 = "Infinite solutions";
            else
                result1 = "No solution";
        } else {
            double x = -b / a;
            result1 = "Solution: x = " + x;
        }

        JOptionPane.showMessageDialog(null, "Linear Equation:\n" + result1);


        // ===== 2. System of 2 linear equations =====
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("b1:"));

        double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

        double D  = a11 * a22 - a12 * a21;
        double Dx = b1 * a22 - a12 * b2;
        double Dy = a11 * b2 - b1 * a21;

        String result2;
        if (D == 0) {
            if (Dx == 0 && Dy == 0)
                result2 = "Infinite solutions";
            else
                result2 = "No solution";
        } else {
            double x = Dx / D;
            double y = Dy / D;
            result2 = "x = " + x + ", y = " + y;
        }

        JOptionPane.showMessageDialog(null, "Linear System:\n" + result2);


        // ===== 3. Quadratic equation: ax^2 + bx + c = 0 =====
        double qa = Double.parseDouble(JOptionPane.showInputDialog("Quadratic: Enter a:"));
        double qb = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double qc = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        String result3;

        if (qa == 0) {
            // trở thành bậc 1
            if (qb == 0) {
                if (qc == 0)
                    result3 = "Infinite solutions";
                else
                    result3 = "No solution";
            } else {
                double x = -qc / qb;
                result3 = "Linear solution: x = " + x;
            }
        } else {
            double delta = qb * qb - 4 * qa * qc;

            if (delta < 0) {
                result3 = "No real root";
            } else if (delta == 0) {
                double x = -qb / (2 * qa);
                result3 = "Double root: x = " + x;
            } else {
                double x1 = (-qb + Math.sqrt(delta)) / (2 * qa);
                double x2 = (-qb - Math.sqrt(delta)) / (2 * qa);
                result3 = "x1 = " + x1 + ", x2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, "Quadratic Equation:\n" + result3);
    }
}
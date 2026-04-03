import javax.swing.JOptionPane;
public class Calculator{
    public static void main(String[] args){
        String strNum1,strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ");
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number (Not 0): ");
        double num2 = Double.parseDouble(strNum2);
        double num1 = Double.parseDouble(strNum1);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        String result = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product + "\nQuotient: " + quotient;
        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Informe o salário do funcionário " + i);
            double rendaBruta = sc.nextDouble();

            double descontoINSS = DescontoINSS(rendaBruta);
            double descontoIR = DescontoIR(rendaBruta);

            double salarioLiquido = rendaBruta - descontoINSS - descontoIR;

            imprimirResultado(rendaBruta, descontoINSS, descontoIR, salarioLiquido);
        }
    }

    private static double DescontoINSS(double rendaBruta) {
        if (rendaBruta <= 1212.00) {
            return rendaBruta * 0.075;
        } else if (rendaBruta > 1212.01 && rendaBruta < 2427.35) {
            return rendaBruta * 0.09;
        } else if (rendaBruta > 2427.36 && rendaBruta < 3641.03) {
            return rendaBruta * 0.12;
        } else if (rendaBruta > 3641.04 && rendaBruta < 7087.22) {
            return rendaBruta * 0.14;
        } else {
            return rendaBruta * 0.14;
        }
    }

    private static double DescontoIR(double rendaBruta) {
        if (rendaBruta <= 1903.98) {
            return rendaBruta * 0.0;
        } else if (rendaBruta > 1903.99 && rendaBruta < 2826.65) {
            return rendaBruta * 0.075;
        } else if (rendaBruta > 2826.66 && rendaBruta < 3751.05) {
            return rendaBruta * 0.15;
        } else if (rendaBruta > 3751.06 && rendaBruta < 4664.68) {
            return rendaBruta * 0.225;
        } else {
            return rendaBruta * 0.275;
        }
    }

    private static void imprimirResultado(double rendaBruta, double descontoINSS, double descontoIR, double salarioLiquido) {
        System.out.printf("Salário Bruto - R$: %.2f", rendaBruta);
        System.out.println("");
        System.out.printf("Desconto de INSS - R$: %.2f", descontoINSS);
        System.out.println("");
        System.out.printf("Desconto de IR - R$: %.2f", descontoIR);
        System.out.println("");
        System.out.printf("Salário Líquido - R$: %.2f", salarioLiquido);
        System.out.println("");
        System.out.println("");
    }
}
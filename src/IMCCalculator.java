import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator {
    private JTextField txtAltura;
    private JTextField txtPeso;
    private JButton button1;
    private JLabel info;
    private JPanel calculadora;
    private JLabel labelAlt;
    private JLabel labelPeso;

    public static void main(String[] args) {

        JFrame tela = new JFrame("Calculadora de IMC");
        tela.setContentPane(new IMCCalculator().calculadora);
        tela.setSize(500, 500);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
    }

    double altura = 0;
    double peso = 0;
    double valor = 0;

    public IMCCalculator() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesoText = txtPeso.getText();
                String alturaText = txtAltura.getText();

                if (pesoText.isEmpty() || alturaText.isEmpty()) {
                    info.setText("Por favor, preencha todos os campos.");
                    return;
                }

                try {
                    // Convertendo os textos para números
                    peso = Double.parseDouble(pesoText);
                    altura = Double.parseDouble(alturaText);

                    // Verificando se os valores são positivos
                    if (peso <= 0 || altura <= 0) {
                        info.setText("Altura e peso devem ser maiores que zero.");
                    } else {
                        // Calculando o IMC
                        valor = peso / (altura * altura);
                        String categoria = calcularCategoriaIMC(valor);
                        info.setText(String.format("Seu IMC é: %.2f - %s", valor, categoria));
                    }
                } catch (NumberFormatException ex) {
                    // Caso os campos não contenham números válidos
                    info.setText("Por favor, insira números válidos.");
                }

            }
        });

    }
    public String calcularCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
}
}

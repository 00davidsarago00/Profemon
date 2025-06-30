import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class jogo implements ActionListener {
    public static void main(String[] args) {
        JFrame Principal = new JFrame("Jogo de Profemons");
        Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrincipalsetSize(800, 600);
        PrincipalsetLayout(new BorderLayout());
        
        JPanel gamePanel = new JPanel();
        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Jogo Iniciado!");
            }
        });

        gamePanel.setBackground(Color.GREEN);
        Principal.add(gamePanel, BorderLayout.CENTER);
       
        Principal.setVisible(true);


    }
}

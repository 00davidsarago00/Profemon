import javax.swing.*;
import java.awt.*;  


public class LH extends profemon {
    public LH() {
        this.nome = "Lh";
        this.tipo = "Matematico";
        this.ataque = 120;
        this.vida = 85;
        this.nivel = 1;
        this.defesa = 70;
        this.evolucao = 1;
        this.vidamaxima = 85;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente);
        
           
        this.velocidadedosataques[0] = 90; 
        this.velocidadedosataques[1] = 60; 
        this.velocidadedosataques[2] = 75;
        this.velocidadedosataques[3] = 30;

        this.poderdosataques[0] = 40;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 80;
        this.poderdosataques[3] = 140;

    }
    
    


}

    

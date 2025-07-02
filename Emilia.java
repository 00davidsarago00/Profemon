import javax.swing.*;
import java.awt.*;  


public class Emilia extends profemon {
    public Emilia() {
        this.nome = "Emilia";
        this.tipo = "Matematico";
        this.ataque = 60;
        this.vida = 130;
        this.nivel = 1;
        this.defesa = 115;
        this.evolucao = 1;
        this.vidamaxima = 130;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 80; 
        this.velocidadedosataques[1] = 50; 
        this.velocidadedosataques[2] = 65;
        this.velocidadedosataques[3] = 40;

        this.poderdosataques[0] = 50;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 40;
        this.poderdosataques[3] = 65;
    }
    
}

    

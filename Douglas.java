import javax.swing.*;
import java.awt.*;  


public class Douglas extends profemon {
    public Douglas() {
        this.nome = "Douglas";
        this.tipo = "Programador";
        this.ataque = 115;
        this.vida = 80;
        this.nivel = 1;
        this.defesa = 75;
        this.evolucao = 1;
        this.vidamaxima = 80;
        
        imagemfrente = new ImageIcon("Sprints/" + nome + nivel + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + nivel + "Back" + ".png");
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 85; 
        this.velocidadedosataques[1] = 60; 
        this.velocidadedosataques[2] = 70;
        this.velocidadedosataques[3] = 45;

        this.poderdosataques[0] = 75;
        this.poderdosataques[1] = 60;
        this.poderdosataques[2] = 90;
        this.poderdosataques[3] = 130;
    }
    
}

    

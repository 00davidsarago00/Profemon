import javax.swing.*;
import java.awt.*;  


public class Paiola extends profemon {
    public Paiola() {
        this.nome = "Paiola";
        this.tipo = "Programador";
        this.ataque = 110;
        this.vida = 80;
        this.nivel = 1;
        this.defesa = 70;
        this.evolucao = 1;
        this.vidamaxima = 110;
        
        this.imagemfrente = new ImageIcon("Sprints/" + nome + "1" + "Front" + ".png");
        this.imagemcostas = new ImageIcon("Sprints/" + nome + "1" + "Back" + ".png");
        this.imagemderrotado = new ImageIcon("Sprints/" + nome + "1" + "Back" + "BG.png");
        
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente);
        
           
        this.velocidadedosataques[0] = 90; 
        this.velocidadedosataques[1] = 70; 
        this.velocidadedosataques[2] = 80;
        this.velocidadedosataques[3] = 50;

        this.poderdosataques[0] = 40;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 70;
        this.poderdosataques[3] = 120; 
        
        this.nomedosataques[0] = "Compilação Rápida";
        this.nomedosataques[1] = "Ponteiro Nulo";
        this.nomedosataques[2] = "Alocação Dinâmica";
        this.nomedosataques[3] = "Garbage Collector";
    }
    
}

    

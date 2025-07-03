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
        
        imagemfrente = new ImageIcon("Sprints/" + nome + "1" + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + "1" + "Back" + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "1" + "Back" + "BG.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 80; 
        this.velocidadedosataques[1] = 50; 
        this.velocidadedosataques[2] = 65;
        this.velocidadedosataques[3] = 40;

        this.poderdosataques[0] = 50;
        this.poderdosataques[1] = 0;
        this.poderdosataques[2] = 40;
        this.poderdosataques[3] = 65;

        this.nomedosataques[0] = "Caixa de Vetores";
        this.nomedosataques[1] = "Plano Tangente";
        this.nomedosataques[2] = "Distância entre pontos";
        this.nomedosataques[3] = "Hipérbole Assimétrica";
    }
    
}

    

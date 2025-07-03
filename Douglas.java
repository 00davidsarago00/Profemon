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
        
        imagemfrente = new ImageIcon("Sprints/" + nome + "1" + "Front" + ".png");
        imagemcostas = new ImageIcon("Sprints/" + nome + "1" + "Back" + ".png");
        imagemderrotado = new ImageIcon("Sprints/" + nome + "1" + "Back" + "BG.png");
        imagemderrotado = new ImageIcon(imagemderrotado.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
        imagemfrente = new ImageIcon(imagemfrente.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        imagemcostas = new ImageIcon(imagemcostas.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        this.label = new JLabel(imagemfrente); 
        
           
        this.velocidadedosataques[0] = 85; 
        this.velocidadedosataques[1] = 60; 
        this.velocidadedosataques[2] = 70;
        this.velocidadedosataques[3] = 45;

        this.poderdosataques[0] = 75;
        this.poderdosataques[1] = 60;
        this.poderdosataques[2] = 90;
        this.poderdosataques[3] = 130;

        this.nomedosataques[0] = "Interpolação Linear";
        this.nomedosataques[1] = "Ajuste de Curva";
        this.nomedosataques[2] = "Método de Euler";
        this.nomedosataques[3] = "Convergência Explosiva";
    }
    
}

    

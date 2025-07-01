import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class inimigoPetista extends inimigos {
    public inimigoPetista() {
        this.nome = "Petista";
        this.tipo = "EntraçonoRU";
        this.velocidade = 13;
        this.vida = 13;
        this.ataque = 13;
        this.defesa = 13;
        this.imagem = new ImageIcon("Sprints/petista.png");
        this.label = new JLabel(imagem);
        this.velocidadedosataques[0] = 10; 
        this.velocidadedosataques[1] = 15; 
        this.velocidadedosataques[2] = 20;
        this.velocidadedosataques[3] = 25;
    }
}


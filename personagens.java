import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class personagens implements Runnable{ 
    // Atributos comuns a todos os personagens
    public String nome;
    public String tipo;

    public int vida;
    public int ataque;
    public int defesa;
    public int [] velocidadedosataques = new int[4];


    ImageIcon imagem;
    JLabel label;

    public void receberDano(int dano, personagens autor) {
        this.vida -= dano / this.defesa;
        if (this.vida <= 0) {
            this.derrotado();
        }
    }

}

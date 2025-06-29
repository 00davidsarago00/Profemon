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
    public int posicaoX;
    public int posicaoY;

    ImageIcon imagem;
    JLabel label;

    // Ações comuns a todos os personagens
    public abstract void receberDano(int dano);
    public abstract void derrotado();

    public synchronized void atacarnormal(String tipoALvo, personagens alvo){
        //ANIMAÇÃO DE ATAQUE//
        

        ImageIcon ataque = new ImageIcon("Sprints/" + nome + "ataque.png");
        JLabel labelAtaque = new JLabel(ataque);

        setPositionxy(labelAtaque, this.label.getX(), this.label.getY());
        while(labelAtaque.getX() != alvo.posicaoX || labelAtaque.getY() != alvo.posicaoY) {
            if(labelAtaque.getX() < alvo.posicaoX){
                labelAtaque.setLocation(labelAtaque.getX() - 1, labelAtaque.getY());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            else if(labelAtaque.getX() > alvo.posicaoX){
                labelAtaque.setLocation(labelAtaque.getX() + 1, labelAtaque.getY());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if(labelAtaque.getY() < alvo.posicaoY){
                labelAtaque.setLocation(labelAtaque.getX(), labelAtaque.getY() + 1);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            else if(labelAtaque.getY() > alvo.posicaoY){
                labelAtaque.setLocation(labelAtaque.getX(), labelAtaque.getY() - 1);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

        }
       

        if (alvo.vida <= 0) return;
        int dano = this.ataque;
        alvo.receberDano(dano, this);
    }

}
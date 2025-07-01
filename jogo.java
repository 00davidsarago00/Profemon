import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class jogo implements ActionListener {
    boolean comecou = false;
    boolean escolha = false;
    boolean confronto = false;
    
    

    //Profemons
    Paiola paiola = new Paiola();
    Andrea andrea = new Andrea();
    LH lh = new LH();

    profemon []equipe = new profemon[6];
    profemon []rejeitados = new profemon[6];
    inimigos []equipeinimigos = new inimigos[6];

    //Botões
    JButton paiolaButton = new JButton("Ver as caracteristicas de Paiola");
    JButton andreaButton = new JButton("Ver as caracteristicas de Andrea");
    JButton lhButton = new JButton("Ver as caracteristicas de LH");
    JButton startButton = new JButton("Iniciar Jogo");

    JButton escolhaButton = new JButton("Aperte aqui quando tomar sua decisão!");
    
    //Paineis
    JFrame Principal = new JFrame("Jogo de Profemons");
    JPanel gamePanel = new JPanel();
    JPanel profemonsPanel = new JPanel();

    //Batalha
    profemon prof;

    public jogo(){
        

        Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Principal.setSize(1925, 1000);
        Principal.setLayout(new BorderLayout());

        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        gamePanel.add(startButton, BorderLayout.CENTER);
        gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));
        
        startButton.addActionListener(this);

        Principal.add(gamePanel, BorderLayout.CENTER);
       
        Principal.setVisible(true);

        while (!comecou) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Início");
        }

        startButton.setVisible(false);
        gamePanel.remove(startButton);
        gamePanel.setLayout(new GridLayout(1, 1)); 
        JLabel gameLabel = new JLabel("Jogo Iniciado!", SwingConstants.CENTER);

        Principal.add(gamePanel, BorderLayout.CENTER);
        gameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gamePanel.add(gameLabel);
        
        gameLabel.setText("Seja bem vindo, jovem universitario! Ao mundo dos Profemons.");
        esperar(5000);
        gameLabel.setText("Aqui, esteja preparado para enfrentar os inimigos do conhecimento!");
        esperar(5000);
        gameLabel.setText("Prepare-se para a batalha, pois os inimigos estão chegando!");
        esperar(5000);
        gameLabel.setText("Para iniciarmos, escolha seu Profemon inicial!");
        esperar(5000);
        gamePanel.removeAll();
        gamePanel.setLayout(new BorderLayout());

        
        gameLabel.setText("Escolha seu Profemon inicial:\n\n");
        gamePanel.add(gameLabel, BorderLayout.NORTH);


        paiolaButton.addActionListener(this);
        andreaButton.addActionListener(this);
        lhButton.addActionListener(this);

        paiolaButton.setFont(new Font("Arial", Font.BOLD, 20));
        andreaButton.setFont(new Font("Arial", Font.BOLD, 20));
        lhButton.setFont(new Font("Arial", Font.BOLD, 20));

        profemonsPanel.setLayout(new GridLayout(2,3));

        profemonsPanel.add(paiola.label);
        profemonsPanel.add(andrea.label);
        profemonsPanel.add(lh.label);

        profemonsPanel.add(paiolaButton);
        profemonsPanel.add(andreaButton);
        profemonsPanel.add(lhButton);

        paiola.label.setVisible(true);
        andrea.label.setVisible(true);
        lh.label.setVisible(true);

        escolhaButton.setFont(new Font("Arial", Font.BOLD, 20));

        gamePanel.add(profemonsPanel, BorderLayout.CENTER);
        gamePanel.add(escolhaButton, BorderLayout.SOUTH);
        escolhaButton.addActionListener(this);
        
        gamePanel.revalidate();

        while (!escolha) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon");
        }
        escolha = false;
        paiolaButton.setText("Escolher Paiola!");
        andreaButton.setText("Escolher Andrea!");
        lhButton.setText("Escolher LH!");

        gamePanel.remove(escolhaButton);

        while(equipe[0] == null) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon");
        }
        gamePanel.removeAll();
        gamePanel.setLayout(new BorderLayout());
        
        
        Principal.setTitle("Jogo de Profemons - " + equipe[0].nome + " Escolhido");
        gameLabel.setText("Você escolheu " + equipe[0].nome + "! Preparem-se para a aventura!");
        gamePanel.add(gameLabel, BorderLayout.CENTER);
        gamePanel.add(equipe[0].label, BorderLayout.SOUTH);
        
        esperar(5000);

        gamePanel.remove(equipe[0].label);
        gamePanel.revalidate();

        gameLabel.setText("Espera, o que é isso? Um inimigo esta se aproximando!");

        gameLabel.setText("Prepare-se para a batalha! Use seu Profemon para enfrentar o inimigo!");
        gamePanel.add(gameLabel, BorderLayout.CENTER);

        equipeinimigos[0] = new inimigoPetista();
        do{
            confronto = batalha(equipe,equipeinimigos);
            Principal.add(gameLabel, BorderLayout.CENTER);
            if(!confronto){
                equipe[0].reviveu(equipe[0].vidamaxima);
                gameLabel.setText("Espera ai, ainda nao acabou, irei curar " + equipe[0].nome +"! Tente novamente");
                esperar(5000);
                gamePanel.add(gameLabel, BorderLayout.CENTER);
                
                //Quando tiver as imagens, ve se nao vale a pena colocar ele derrotado depois vivo
            }
            gamePanel.revalidate();
        }while(!confronto);

        gameLabel.setText("Parabens, voce venceu seu primeiro inimigo!");
        esperar(5000);
        gameLabel.setText("Agora, sua jornada se inicia de verdade.");
        esperar(5000);
        gameLabel.setText("Por favor, ajude-nos a defender a Unesp, dos universitarios.");
        esperar(5000);
        gameLabel.setText("Aqui, voce encontrara as mais bizarras criaturas, te desejo sorte e cuidado!");
        esperar(5000);



        //continuar aqui




    }
    
    public static void main(String[] args) {
       new jogo();
    }

    public profemon escolherProfemon(profemon[] equipe) {
            Principal.removeAll();
            Principal.setLayout(new GridLayout(2,1));
            JPanel equipePanel = new JPanel(new GridLayout(equipe.length, 1));
            JLabel equipeLabel = new JLabel("Escolha seu Profemon:");
            Principal.add(equipeLabel);
            equipeLabel.setFont(new Font("Arial", Font.BOLD, 20));

            for(int i=0; i<equipe.length; i++){
                profemon profe = equipe[i];
                JButton profButton = new JButton();
                if(profe.vida <= 0) {
                    profButton.setEnabled(false);
                    profButton.setIcon("Sprints/" + profe.nome + " " + profe.evolucao + " derrotado.png");

                }
                else{
                    profButton.setIcon(profe.imagem);
                    equipePanel.add(profe.profButton);
                    profButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            prof = profe;
                            Principal.setTitle("Jogo de Profemons - " + prof.nome + " Escolhido");
                            JOptionPane.showMessageDialog(Principal, "Você escolheu " + prof.nome + " para a batalha!");
                            prof.label.setVisible(true);
                            Principal.revalidate();
                            escolha = true;
                            return prof;
                        }
                    });
                    
                    
                }       
            }
            Principal.add(equipePanel);
            Principal.setTitle("Jogo de Profemons - Escolha seu Profemon para Batalha");
            while(!escolha){
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
            escolha = false;
            Principal.removeAll();
            return prof;


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            comecou = true;
        }
        else if(e.getSource() == paiolaButton && !escolha) {
            paiola.mostrarCaracteristicas();
        }  
        else if(e.getSource() == andreaButton && !escolha) {
            andrea.mostrarCaracteristicas();
        }  
        else if(e.getSource() == lhButton && !escolha) {
            lh.mostrarCaracteristicas();
        } 
        else if(e.getSource() == escolhaButton) {
            escolha = true;
        }
        else if(e.getSource() == paiolaButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Você escolheu Paiola!", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            paiola.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Paiola Escolhido");
            equipe[0] = paiola;
            rejeitados[0] = andrea;
            rejeitados[1] = lh;
        } else if(e.getSource() == andreaButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Você escolheu Andrea!", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            andrea.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Andrea Escolhida");
            equipe[0] = andrea;
            rejeitados[0] = paiola;
            rejeitados[1] = lh;
        } else if(e.getSource() == lhButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Você escolheu LH!", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            lh.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - LH Escolhido");
            equipe[0] = lh;
            rejeitados[0] = paiola;
            rejeitados[1] = andrea;
        }
    }

    public Boolean batalha(profemon[] equipe, inimigos[] inimigue){
        Boolean vitoria = false;
        if(equipe.length == 1){
            prof = equipe[0];
        }
        else if(equipe.length > 1){
            prof = escolherProfemon(equipe);
            while(prof == null) {
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
        }
        int aux = equipe.legth;
        int aux2 = inimigue.length;
        inimigos inimigo = inimigue[aux2-1];
        while(aux > 0 && aux2 > 0){
            while(prof.vida > 0 && inimigo.vida > 0) {
                Principal.removeAll();
                Principal.setLayout(new GridLayout(2,1));

                JPanel imagens = new JPanel(new GridLayout(1, 2));
                imagens.add(prof.label);
                imagens.add(inimigo.label);
                Principal.add(imagens);

                Principal.setTitle("Batalha entre " + prof.nome + " e " + inimigo.nome);
                
                Jpanel batalhaPanel = new JPanel(new GridLayout(2, 1));

                JPanel infos = new JPanel(new GridLayout(1, 2));
                
                JLabel profLabel = new JLabel(prof.nome + " (Vida: " + prof.vida + ")");
                JLabel inimigoLabel = new JLabel(inimigo.nome + " (Vida: " + inimigo.vida + ")");
                profLabel.setFont(new Font("Arial", Font.BOLD, 20));
                inimigoLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
                
                infos.add(profLabel);
                infos.add(inimigoLabel);

                batalhaPanel.add(infos);

                JButton ataque1Button = new JButton("Ataque 1");
                JButton ataque2Button = new JButton("Ataque 2");
                JButton ataque3Button = new JButton("Ataque 3");
                JButton ataque4Button = new JButton("Ataque 4");

                ataque1Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque2Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque3Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque4Button.setFont(new Font("Arial", Font.BOLD, 20));
                JPanel acoesPanel = new JPanel(new GridLayout(2, 2));

                acoesPanel.add(ataque1Button);
                acoesPanel.add(ataque2Button);
                acoesPanel.add(ataque3Button);
                acoesPanel.add(ataque4Button);

                batalhaPanel.add(acoesPanel);

                int indice;

                ataque1Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dano = prof.ataque1();
                        indice = 0;
                    }
                });
                ataque2Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dano = prof.ataque2();
                        indice = 1;
                    }
                });
                ataque3Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dano = prof.ataque3();
                        indice = 2;
                    }
                });
                ataque4Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int dano = prof.ataque4();
                        indice = 3;
                    }
                });

                Principal.add(batalhaPanel);
                Principal.revalidate();

                while(indice < 0 || indice > 3) {
                    esperar(100);
                    Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Ataque");
                }
                int dano = 0;
                int indiceinimigo = (int) (Math.random() * 4);

                if(velocidadedosataques[indice] > inimigo.velocidadedosataques[indiceinimigo]) {
                    dano = prof.ataque1();
                    inimigo.receberDano(dano, prof);
                    if(inimigo.vida > 0) {
                        dano = inimigo.ataque1();
                        prof.receberDano(dano, inimigo);
                    }
                } else {
                    dano = inimigo.ataque1();
                    prof.receberDano(dano, inimigo);
                    if(prof.vida > 0) {
                        dano = prof.ataque1();
                        inimigo.receberDano(dano, prof);
                    }
                }
                
            }
            if(prof.vida <= 0) {
                Principal.revalidate();
                prof.label.setVisible(false);
                aux--;
                if(aux > 0) {
                    prof = escolherProfemon(equipe);
                    while(prof == null) {
                        esperar(100);
                        Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
                    }
                }
            } else if(inimigo.vida <= 0) {
                Principal.revalidate();
                esperar(5000);
                inimigo.label.setVisible(false);
                aux2--;
                if(aux2 > 0) {
                    inimigo = inimigue[aux2-1];
                } else {
                    vitoria = true;
                    break;
                }
            }
        }
        Principal.setTitle("Jogo de Profemons - Batalha Finalizada");
        Principal.removeAll();
        Principal.setLayout(new BorderLayout());

        JLabel mensagemfinal = new JLabel("Batalha Finalizada!");
        esperar(5000);

        if(vitoria) mensagemfinal.setText("Você venceu a batalha!");  
        else mensagemfinal.setText("Você foi derrotado!");
            
        
        mensagemfinal.setFont(new Font("Arial", Font.BOLD, 30));
        Principal.add(mensagemfinal, BorderLayout.CENTER);
        Principal.revalidate();
        esperar(5000);
        
        return vitoria;
    }

    void esperar(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jogo implements ActionListener{
    boolean comecou = false;
    boolean escolha = false;
    boolean confronto = false;
    boolean acabou = false;
    
    
    //Profemons
    Paiola paiola = new Paiola();
    Andrea andrea = new Andrea();
    LH lh = new LH();
    Matheus matheus = new Matheus();
    Emilia emilia = new Emilia();
    Douglas douglas = new Douglas();

    profemon []equipe = new profemon[6];
    profemon []rejeitados = new profemon[6];
    inimigos []equipeinimigos = new inimigos[6];

    public int indice = 0;
    public int quantiadedeprofemons = 0;
    public int quantiadedeinimigos = 0;

    //inimigos
    InimigoPetista inimigopetista = new InimigoPetista();

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
        Principal.setSize(1200, 720);
        Principal.setLayout(new BorderLayout());

        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        gamePanel.add(startButton, BorderLayout.CENTER);
        gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
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
        
        paiolaButton.setText("Escolher Paiola!");
        andreaButton.setText("Escolher Andrea!");
        lhButton.setText("Escolher LH!");

        gamePanel.remove(escolhaButton);

        while(equipe[0] == null) {
            esperar(5000);
            Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon");
        }
        escolha = false;
        gamePanel.removeAll();
        gamePanel.setLayout(new GridLayout(2,1));
        
        Principal.revalidate();
        Principal.setTitle("Jogo de Profemons - " + equipe[0].nome + " Escolhido");
        gameLabel.setText("Você escolheu " + equipe[0].nome + "! Preparem-se para a aventura!");
        gamePanel.add(gameLabel);
        gamePanel.add(equipe[0].label);
        
        esperar(5000);

        gamePanel.removeAll();
        gamePanel.revalidate();

        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(gameLabel);
    
        
        gameLabel.setText("Espera, o que é isso? Um inimigo esta se aproximando!");
        esperar(5000);
        
        equipeinimigos[0] = inimigopetista;
        quantiadedeinimigos = 1;
        gameLabel.setText("Prepare-se para a batalha! Use seu Profemon para enfrentar o inimigo!");
        esperar(5000);
        
        
        Principal.revalidate();
        gamePanel.removeAll();
        gamePanel.revalidate();

        do{
            confronto = batalha(equipe,equipeinimigos);
            while(!acabou) {};
            gamePanel.removeAll();
            gamePanel.add(gameLabel, BorderLayout.CENTER);
            if(!confronto){
                equipe[0].reviveu(equipe[0].vidamaxima);   
                gameLabel.setText("Espera ai, ainda nao acabou, irei curar " + equipe[0].nome +"! Tente novamente");
                esperar(5000);
                //Quando tiver as imagens, ve se nao vale a pena colocar ele derrotado depois vivo
            }
            gamePanel.revalidate();
        }while(!confronto);

        gamePanel.removeAll();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(gameLabel, BorderLayout.CENTER);
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
            gamePanel.removeAll();
            gamePanel.setLayout(new GridLayout(2,1));
            JPanel equipePanel = new JPanel(new GridLayout(equipe.length, 1));
            JLabel equipeLabel = new JLabel("Escolha seu Profemon:");
            gamePanel.add(equipeLabel);
            equipeLabel.setFont(new Font("Arial", Font.BOLD, 20));

            for(int i=0; i<quantiadedeprofemons; i++){
                profemon profe = equipe[i];
                JButton profButton = new JButton();
                if(profe.vida <= 0) {
                    profButton.setEnabled(false);
                    ImageIcon profImagederrotado = new ImageIcon("Sprints/" + profe.nome + profe.evolucao + " derrotado.png");
                    profImagederrotado = new ImageIcon(profImagederrotado.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH));
                    profButton.setIcon(profImagederrotado);
                }
                else{
                    profButton.setIcon(profe.imagem);
                    equipePanel.add(profButton);
                    profButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            profemon prof = profe;
                            Principal.setTitle("Jogo de Profemons - " + prof.nome + " Escolhido");
                            JOptionPane.showMessageDialog(Principal, "Você escolheu " + prof.nome + " para a batalha!");
                            prof.label.setVisible(true);
                            gamePanel.revalidate();
                            escolha = true;

                        }
                    });
                    
                    
                }       
            }
            gamePanel.add(equipePanel);
            Principal.setTitle("Jogo de Profemons - Escolha seu Profemon para Batalha");
            while(!escolha){
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
            escolha = false;
            
            
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
            quantiadedeprofemons = 1;
            
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
            quantiadedeprofemons = 1;
            
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
            quantiadedeprofemons = 1;
            
        }
    }

    public Boolean batalha(profemon[] equipe, inimigos[] inimigue){
        Boolean vitoria = false;
        
        double modificardordetipoprof = 1;
        double modificadordetipoinimigo = 1;
        
        if(quantiadedeprofemons == 1){
            prof = equipe[0];
        }
        else if(quantiadedeprofemons > 1){
            prof = escolherProfemon(equipe);
            while(prof == null) {
                esperar(100);
                Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Profemon para Batalha");
            }
        }
        int aux = quantiadedeprofemons;
        int aux2 = quantiadedeinimigos;
        int contador = 0;
        inimigos inimigo = inimigue[0];

        JLabel profLabel = new JLabel(prof.nome + " (Vida: " + prof.vida + ")");
        JLabel inimigoLabel = new JLabel(inimigo.nome + " (Vida: " + inimigo.vida + ")");
        
        Principal.add(gamePanel);

        while(aux > 0 && aux2 > 0){
            while(prof.vida > 0 && inimigo.vida > 0) {
                indice = -1;
                gamePanel.removeAll();
                gamePanel.setLayout(new GridLayout(2,1));

                JPanel imagens = new JPanel(new GridLayout(1, 2));
                imagens.add(prof.label);
                imagens.add(inimigo.label);

                JPanel infos = new JPanel(new GridLayout(1, 2));
                

                profLabel.setFont(new Font("Arial", Font.BOLD, 20));
                inimigoLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
                
                infos.add(profLabel);
                infos.add(inimigoLabel);

                JPanel acoesPanel = new JPanel(new GridLayout(2, 2));
                JButton ataque1Button = new JButton("Ataque 1");
                JButton ataque2Button = new JButton("Ataque 2");
                JButton ataque3Button = new JButton("Ataque 3");
                JButton ataque4Button = new JButton("Ataque 4");

                ataque1Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque2Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque3Button.setFont(new Font("Arial", Font.BOLD, 20));
                ataque4Button.setFont(new Font("Arial", Font.BOLD, 20));
            
                ataque1Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 0;
                    }
                });
                ataque2Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 1;
                    }
                });
                ataque3Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 2;
                    }
                });
                ataque4Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        indice = 3;
                    }
                });

                acoesPanel.add(ataque1Button);
                acoesPanel.add(ataque2Button);
                acoesPanel.add(ataque3Button);
                acoesPanel.add(ataque4Button);

                JPanel inferior = new JPanel(new BorderLayout());
                inferior.add(infos, BorderLayout.NORTH);
                inferior.add(acoesPanel, BorderLayout.CENTER);
                
                gamePanel.add(imagens);
                gamePanel.add(inferior);

                gamePanel.revalidate();
                gamePanel.repaint(); 
                
                gamePanel.setVisible(true);
                
                Principal.setVisible(true);
                Principal.revalidate();
                Principal.repaint();

                //System.out.println("Chegou aqui");

                while(indice < 0 || indice > 3) {
                    Principal.setTitle("Jogo de Profemons - Aguardando Escolha do Ataque");
                }

                modificardordetipoprof = 1;
                modificadordetipoinimigo = 1;

                if(prof.tipo.equals("Programador") && inimigo.tipo.equals("Matematico")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(inimigo.tipo.equals("Programador") && prof.tipo.equals("Matematico")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }
                else if(prof.tipo.equals("Engenheiro") && inimigo.tipo.equals("Matematico")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }
                else if(inimigo.tipo.equals("Matematica") && prof.tipo.equals("Engenheiro")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(prof.tipo.equals("Engenheiro") && inimigo.tipo.equals("Programador")){
                    modificardordetipoprof = 1.5;
                    modificadordetipoinimigo = 0.75;
                }
                else if(inimigo.tipo.equals("Programador") && prof.tipo.equals("Engenheiro")){
                    modificardordetipoprof = 0.75;
                    modificadordetipoinimigo = 1.5;
                }


                
                int indiceinimigo = (int) (Math.random() * 4);

                double danoprof = (double)(prof.ataque*prof.poderdosataques[indice] / inimigo.defesa)*modificardordetipoprof;
                double danoini =  (double)(inimigo.ataque*inimigo.poderdosataques[indiceinimigo] / prof.defesa)*modificadordetipoinimigo;

                if(prof.velocidadedosataques[indice] > inimigo.velocidadedosataques[indiceinimigo]) {
                    inimigo.receberDano((int)Math.floor(danoprof), prof);
                    if(inimigo.vida > 0) {
                        prof.receberDano((int)Math.ceil(danoini), inimigo);
                    }
                } else {
                    prof.receberDano((int)Math.ceil(danoini), inimigo);
                    if(prof.vida > 0) {
                        inimigo.receberDano((int)Math.floor(danoprof), prof);
                    }
                }
                
            }
            profLabel.setText(prof.nome + " (Vida: " + prof.vida + ")");
            inimigoLabel.setText(inimigo.nome + " (Vida: " + inimigo.vida + ")");

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
                    inimigo = inimigue[contador++];
                } else {
                    vitoria = true;
                    break;
                }
            }
        }

        Principal.setTitle("Jogo de Profemons - Batalha Finalizada");
        
        

        JLabel mensagemfinal = new JLabel("Batalha Finalizada!");
        gamePanel.removeAll();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(mensagemfinal);
        mensagemfinal.setFont(new Font("Arial", Font.BOLD, 30));
        esperar(5000);

        if(vitoria) mensagemfinal.setText("Você venceu a batalha!");  
        else mensagemfinal.setText("Você foi derrotado!");
            
        esperar(5000);
        acabou = true;
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

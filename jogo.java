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

    volatile int indice = -1;
    public int quantiadedeprofemons = 0;
    public int quantiadedeinimigos = 0;

    //inimigos
    Fluflu fluflu = new Fluflu();

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

    //backgorunds

    ImageIcon Biblioteca = new ImageIcon("Backgrounds/Bibilioteca_BG.png");
    ImageIcon LEPEC = new ImageIcon("Backgrounds/LEPEC_BG.png");
    ImageIcon Portaria = new ImageIcon("Backgrounds/Portaria_BG.png");
    ImageIcon PrimeiroDeMaio = new ImageIcon("Backgrounds/PrimeiroDeMaio_BG.png");
    ImageIcon RU = new ImageIcon("Backgrounds/RU_BG.png");


    //Batalha
    profemon prof;

    public jogo(){
        Portaria = new ImageIcon(Portaria.getImage().getScaledInstance(1200, 720, Image.SCALE_SMOOTH));
        Principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Principal.setSize(1200, 720);
        Principal.setLayout(new BorderLayout());

        JLabel fundoLabel = new JLabel(Portaria);
        fundoLabel.setBounds(0, 0, 1200, 720);

        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.addActionListener(this);
        startButton.setBounds(500, 500, 200, 50); // x, y, largura, altura

        fundoLabel.add(startButton);

        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(fundoLabel, BorderLayout.CENTER);
        
        Principal.add(gamePanel, BorderLayout.CENTER);
        Principal.setVisible(true);

        while (!comecou) {
            esperar(100);
            Principal.setTitle("Jogo de Profemons - Aguardando Início");
        }

        startButton.setVisible(false);
        fundoLabel.remove(startButton);
        JLabel gameLabel = new JLabel("Jogo Iniciado!", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameLabel.setOpaque(true);
        gameLabel.setBackground(Color.WHITE);
        
        gameLabel.setBounds(40, 335, 1000, 50);
        fundoLabel.add(gameLabel);

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
        
        paiolaButton.setIcon(paiola.imagemfrente);
        andreaButton.setIcon(andrea.imagemfrente);
        lhButton.setIcon(lh.imagemfrente);


        profemonsPanel.setLayout(new GridLayout(1,3));

        profemonsPanel.add(paiolaButton);
        profemonsPanel.add(andreaButton);
        profemonsPanel.add(lhButton);

        gamePanel.add(profemonsPanel, BorderLayout.CENTER);

        escolhaButton.setFont(new Font("Arial", Font.BOLD, 20));

        
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
            esperar(100);
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
        
        equipeinimigos[0] = fluflu;
        quantiadedeinimigos = 1;
        gameLabel.setText("Prepare-se para a batalha! Use seu Profemon para enfrentar o inimigo!");
        esperar(5000);
        
        
        Principal.revalidate();
        gamePanel.removeAll();
        gamePanel.revalidate();

        do{
            confronto = batalha(equipe,equipeinimigos);
            //while(!acabou) {};
            gamePanel.removeAll();
            gamePanel.add(gameLabel, BorderLayout.CENTER);
            if(!confronto){   
                gameLabel.setText("Espera ai, ainda nao acabou, irei curar " + equipe[0].nome +"! Tente novamente");
                equipe[0].reviveu(equipe[0].vidamaxima);
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
        acabou = false;




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
                    profButton.setIcon(profe.imagemfrente);
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
            JLabel escolhaLabel = new JLabel("Ótimo, você escolheu o Paiola! Tenho certeza que terão uma gloriosa jornada", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            paiola.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Paiola Escolhido"); 
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);

            equipe[0] = paiola;
            rejeitados[0] = andrea;
            rejeitados[1] = lh;
            quantiadedeprofemons = 1;
            
        } else if(e.getSource() == andreaButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Então, você escolheu a Andrea! Ótima escolha.", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            andrea.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Andrea Escolhida");
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);
            equipe[0] = andrea;
            rejeitados[0] = paiola;
            rejeitados[1] = lh;
            quantiadedeprofemons = 1;
            
        } else if(e.getSource() == lhButton && escolha) {
            gamePanel.removeAll();
            gamePanel.setLayout(new BorderLayout());
            JLabel escolhaLabel = new JLabel("Maravilha você escolheu o Lh! Muito bem.", SwingConstants.CENTER);
            escolhaLabel.setFont(new Font("Arial", Font.BOLD, 30));
            gamePanel.add(escolhaLabel, BorderLayout.CENTER);
            lh.label.setVisible(true);
            Principal.setTitle("Jogo de Profemons - Lh Escolhido");
            gamePanel.revalidate();
            gamePanel.repaint();
            esperar(5000);
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
            prof.imagemcostas = new ImageIcon(prof.imagemcostas.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH));
            prof.label = new JLabel(prof.imagemcostas);  
            while(prof.vida > 0 && inimigo.vida > 0) {
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
                JButton ataque1Button = new JButton(prof.nomedosataques[0]);
                JButton ataque2Button = new JButton(prof.nomedosataques[1]);
                JButton ataque3Button = new JButton(prof.nomedosataques[2]);
                JButton ataque4Button = new JButton(prof.nomedosataques[3]);

                

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
                Principal.setTitle("Atacando");
                esperar(2000);
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
                else if(inimigo.tipo.equals("Matematico") && prof.tipo.equals("Engenheiro")){
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

                double danoprof = (double)(prof.ataque*prof.poderdosataques[indice] / (inimigo.defesa))*modificardordetipoprof;
                double danoini =  (double)(inimigo.ataque*inimigo.poderdosataques[indiceinimigo] / (prof.defesa))*modificadordetipoinimigo;

                if(prof.velocidadedosataques[indice] > inimigo.velocidadedosataques[indiceinimigo]) {
                    inimigo.receberDano((int)Math.floor(danoprof), prof);
                    if(inimigo.vida > 0) {
                        prof.receberDano((int)Math.ceil(danoini), inimigo);
                    }
                } 
                else {
                    prof.receberDano((int)Math.ceil(danoini), inimigo);
                    if(prof.vida > 0) {
                        inimigo.receberDano((int)Math.floor(danoprof), prof);
                    }
                    
                }
                indice = -1;
                profLabel.setText(prof.nome + " (Vida: " + prof.vida + ")");
                inimigoLabel.setText(inimigo.nome + " (Vida: " + inimigo.vida + ")");
            }
            
           
            gamePanel.revalidate();
            gamePanel.repaint();
            
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
                    contador++;
                    inimigo = inimigue[contador];
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

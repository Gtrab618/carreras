/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gt618
 */
public class Proceso extends Thread {

    private SoundEffect soundCar1 = new SoundEffect("src/sound/carrosound.wav");
    private SoundEffect soundCar2 = new SoundEffect("src/sound/carsound2.wav");
    private SoundEffect soundCar3 = new SoundEffect("src/sound/carsound3.wav");
    private SoundEffect soundCar4 = new SoundEffect("src/sound/inicio.wav");
    static int V1, V2, V3;
    static String R1, R2, R3;
    static boolean banderaGeneral = true;
    private int P1, P2, P3, Meta;
    //instancio pista jframe
    private Pista miPista;

    public Proceso(String name, Pista pista) {
        super(name);
        this.miPista = pista;
    }

    @Override
    public void run() {
        //Asigan la velocidad correspondiente sin que se repitan

        asignarVelocidad();

        switch (getName()) {
            case "carro1":
                moverCarro(1);
                break;

            case "carro2":
                moverCarro(2);
                break;
            case "carro3":
                moverCarro(3);
                break;
            case "manager":
                //desactivar fondo estatico
                try {
                    sleep(7500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
                miPista.getLbl_pista_fondoEstatico().setVisible(false);
                
                //despues de media carrera activar cilo para ver ganador y ulmito para aumentar velocidad
                try {
                    sleep(31400);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }

            verUltimoCarro();
            verGanador();
            break;

        }
    }

    private void moverCarro(int i) {
        //sonido de conteo y esperar
        soundCar4.PlaySound();
        try {
            sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        //Movimiento de los diferentes carros 
        switch (i) {
            case 1:
                //sonido de arranque
                soundCar1.PlaySound();
                //asignar animacion correspodiente
                miPista.getLbl_carro1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));
                //espera y arrancar carro
                arrancar();
                //Sirve para cabmiar el lbl
                R1 = "/graficos/car1.gif";
                while (banderaGeneral) {
                    miPista.getLbl_carro1().setIcon(new javax.swing.ImageIcon(getClass().getResource(R1)));
                    miPista.getLbl_carro1().setLocation(miPista.getLbl_carro1().getLocation().x + V1, miPista.getLbl_carro1().getLocation().y);
                    //hillo de espera
                    esperarHilo();

                }
                if (!banderaGeneral) {
                    soundCar1.stopSounds();
                }

            case 2:

                soundCar2.PlaySound();
                miPista.getLbl_carro2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                arrancar();
                R2 = "/graficos/car2.gif";
                while (banderaGeneral) {
                    miPista.getLbl_carro2().setIcon(new javax.swing.ImageIcon(getClass().getResource(R2)));
                    miPista.getLbl_carro2().setLocation(miPista.getLbl_carro2().getLocation().x + V2, miPista.getLbl_carro2().getLocation().y);

                    esperarHilo();

                }
                if (!banderaGeneral) {
                    soundCar2.stopSounds();
                }

            case 3:

                soundCar3.PlaySound();
                miPista.getLbl_carro3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                arrancar();
                R3 = "/graficos/car3.gif";
                while (banderaGeneral) {
                    miPista.getLbl_carro3().setIcon(new javax.swing.ImageIcon(getClass().getResource(R3)));
                    miPista.getLbl_carro3().setLocation(miPista.getLbl_carro3().getLocation().x + V3, miPista.getLbl_carro3().getLocation().y);

                    esperarHilo();

                }
                if (!banderaGeneral) {
                    soundCar3.stopSounds();
                }

        }
    }

    public void asignarVelocidad() {
        do {
            V1 = (int) (Math.random() * 5 + 4);
            V2 = (int) (Math.random() * 5 + 4);
            V3 = (int) (Math.random() * 5 + 4);
        } while (V1 == V2 || V3 == V2 || V3 == V1);
    }

    private void verGanador() {
        boolean bandera = true;
        Meta = miPista.getLbl_meta().getLocation().x + 40;
        // System.out.println(Meta);
        do {
            P1 = miPista.getLbl_carro1().getLocation().x;
            P2 = miPista.getLbl_carro2().getLocation().x;
            P3 = miPista.getLbl_carro3().getLocation().x;

            if (P1 >= Meta || P2 >= Meta || P3 >= Meta) {

                Podio elPodio = new Podio();

                if (P1 > P2 && P1 > P3) {

                    //System.out.println("gana el 1");
                    elPodio.getLbl_primer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));

                    if (P2 > P3) {
                        //System.out.println("segundo carro2");
                        elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                        elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                    } else {
                        //System.out.println("segundo carro3");
                        elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                        elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                    }

                } else {

                    if (P2 > P1 && P2 > P3) {
                        //System.out.println("gana el 2");
                        elPodio.getLbl_primer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                        if (P3 > P1) {
                            // System.out.println("segundo carro3");
                            elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                            elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));
                        } else {
                            //System.out.println("segundo carro1");
                            elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));
                            elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                        }
                    } else {
                        //System.out.println("gana el 3");
                        elPodio.getLbl_primer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car3A.gif")));
                        if (P2 > P1) {
                            //System.out.println("segundo carro2");
                            elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                            elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));
                        } else {
                            //System.out.println("segundo carro1");
                            elPodio.getLbl_segun().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car1A.gif")));
                            elPodio.getLbl_tercer().setIcon(new javax.swing.ImageIcon(getClass().getResource("/graficos/car2A.gif")));
                        }
                    }
                }
                bandera = false;
                banderaGeneral = false;
                elPodio.getSoundPodio().loopMusic();
                elPodio.setVisible(true);
                miPista.dispose();
            }
            esperarHilo();

        } while (bandera);

    }

    private void verUltimoCarro() {
        System.out.println(V1 + "-1-" + V2 + "-2-" + V3);

        //ve la ultima posicion delvehiculo para darle velocidad extra
        while (true) {
            P1 = miPista.getLbl_carro1().getLocation().x;
            P2 = miPista.getLbl_carro2().getLocation().x;
            P3 = miPista.getLbl_carro3().getLocation().x;

            if (P1 < P2 && P1 < P3) {

                V1 = V1 + (int) (Math.random() * 10 + 1);
                R1 = "/graficos/car1A.gif";
            } else {
                if (P2 < P1 && P2 < P3) {
                    V2 = V2 + (int) (Math.random() * 10 + 1);
                    R2 = "/graficos/car2A.gif";
                } else {
                    V3 = V3 + (int) (Math.random() * 10 + 1);
                    R3 = "/graficos/car3A.gif";
                }
            }
            System.out.println("aumento de velocidad");
            System.out.println(V1 + "-1-" + V2 + "-2-" + V3);
            break;
        }
    }

    private void esperarHilo() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void arrancar() {
        try {
            sleep(3500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

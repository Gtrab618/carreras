package vista;

/**
 *
 * @author gt618
 */
public class Carrera {

    public static void main(String[] args) {
        Pista pista = new Pista();
        pista.setVisible(true);

        Proceso hilo1 = new Proceso("carro1", pista);
        Proceso hilo2 = new Proceso("carro2", pista);
        Proceso hilo3 = new Proceso("carro3", pista);
        Proceso hilo4 = new Proceso("manager", pista);

        pista.getBtn_inicio().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                hilo1.start();
                hilo2.start();
                hilo3.start();
                hilo4.start();
            }
        });

    }

}

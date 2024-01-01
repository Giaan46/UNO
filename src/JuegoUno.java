import java.util.ArrayList;

public class JuegoUno {
    private int ronda;
    private BarajaUno  baraja;
    private int turno;
    private Jugador[] jugadores;
    private int puntosLimite;


    public JuegoUno(Jugador[] jugadores, int puntosLimite) {
        this.jugadores = jugadores;
        this.puntosLimite = puntosLimite;
        this.ronda = 1;
        this.turnoInicial();
        this.repartirCartas();

    }
    public void turnoInicial(){
        this.turno = Metodos.generarNumeroEnteroAleatorio(0, this.jugadores.length - 1 );

    }
    public void repartirCartas(){
        this.baraja = new BarajaUno();
        for(Jugador j: this.jugadores){
            j.setCartas(this.baraja.darCartas(7, false));

        }
    }
    public int getRonda(){
        return this.ronda;

    }
    public Jugador jugadorActual(){
        return this.jugadores[this.turno];

    }
    public void mostrarTurnoActual(){
        System.out.println("Es el turno del jugador: " + this.jugadorActual().getNombre() );

    }
    public void mostrarCartasJugadorActual(){
        this.jugadorActual().mostratMano();

    }
    public int numCartasJugadorActual(){
        return this.jugadorActual().numCartas();

    }
    public void mostrarSentidoActual(){
        if(this.baraja.isSentido()){
            System.out.println("El sentido actual es la de las agujas del reloj!");

        }else{
            System.out.println("El sentido actual es el contrario a las agujas del reloj! ");

        }
    }
    public void cambioTurno(){
        if(this.baraja.isSentido() && turno == this.jugadores.length - 1 ){
            turno = 0;
        }else if (this.baraja.isSentido() && turno ==0){
            this.turno = this.jugadores.length -1;

        }else{
            if(this.baraja.isSentido()){

            }else{
                turno--;
            }
        }
    }

    public Jugador ganadorPartida(){

        Jugador j = null;
        for(int i = 0; i < this.jugadores.length; i++){
            if(this.jugadores[i].sinCartas()){
            j = this.jugadores[i];

        }
    }

   return j;

    }
    public Jugador ganadorJuego(){
        Jugador j = null;
        int mayorPuntuacion = 0;
        for(int i=0; i < this.jugadores.length; i++){
            if(this.jugadores[i].getPuntos() >= mayorPuntuacion){
                mayorPuntuacion = this.jugadores[i].getPuntos();
                j = this.jugadores[i];
            }
        }
        return j;
    }
    public boolean finJuego(){
        return this.ganadorJuego()get.Puntos() >= this.puntosLimite;

    }
    public boolean finPartida(){
        return this.ganadorPartida() != null;

    }
    public int calcularPuntos(){
        int puntos = 0;
        for(int i = 0; i < this.jugadores.length; i++){
            puntos += this.jugadores[i].puntosMano();

        }
        return puntos;

    }
    public void siguienteRonda(){
        this.ronda++;
        int puntos = this.calcularPuntos();

        Jugador ganador = this.ganadorPartida();
        ganador.aumentarPuntos(puntos);
        System.out.println("Ha ganado : " + ganador.getNombre() + " "+ puntos + "puntos");

        this.repartirCartas();


    }
    public void ranking(){
        ArrayList<Jugador> jugadoresClon = new ArrayList<>();

        for(Jugador j : jugadores) {
            jugadoresClon.add(j);

        }
        Collection.sort(jugadoresClon);

        for(Jugador j : jugadoresClon) {
            System.out.println(j);

    }
}

    private class BarajaUno {
    }

    private class Jugador {
    }

    private static class Metodos {
        public static int generarNumeroEnteroAleatorio(int i, int i1) {
        }
    }


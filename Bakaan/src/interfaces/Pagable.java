package interfaces;

/**
 *
 * @author Jdguarnizos (También como El_Sanster)
 */
public interface Pagable {
    //Métodos para las clases de tipo transacción
    //Por ahora de tipo void hasta que requiera algún dato de regreso.
    void procesarPago();
    void generarRecibo();
}

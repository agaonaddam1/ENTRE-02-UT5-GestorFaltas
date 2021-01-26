/**
 * Un objeto de esta clase guarda la información de un estudiante
 *
 */
public class Estudiante {
    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;

    /**
     *  
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
        String[] datos = new String[4];
        datos = lineaDatos.split(SEPARADOR); 
        for (int i = 0; i < datos.length; i++){
            datos[i] = datos[i].trim();
        }
        apellidos = datos[1].toUpperCase();
        faltasNoJustificadas = Integer.parseInt(datos[2]);
        faltasJustificadas = Integer.parseInt(datos[3]);
        String[] nombreS = datos[0].split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nombreS.length; i++){
            if (i != nombreS.length - 1){
                sb.append(nombreS[i].toUpperCase().charAt(0));
                sb.append(".");
            }
            else{
                sb.append(" " + nombreS[i].toUpperCase().charAt(0));
                sb.append(nombreS[i].substring(1));
            }
        }
        nombre = sb.toString();
    }

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el nº de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%-25s %-25s \n", "Apellidos y Nombre:"
                , this.apellidos + "," + this.nombre));
        sb.append(String.format("%-25s %-25d \n", "Faltas No Justificadas:", faltasNoJustificadas));
        sb.append(String.format("%-25s %-25d \n", "Faltas Justificadas:", faltasJustificadas));
        sb.append(String.format("%-25s ", "Apercibimientos:"));
        if (faltasNoJustificadas < 10){
            sb.append(String.format("%-25s", "Sin Apercibimientos"));
        }
        else if (faltasNoJustificadas >= 30){
            sb.append(String.format("%-25s", TipoApercibimiento.DIEZ.toString() + " " 
            + TipoApercibimiento.VEINTE.toString() + " " + TipoApercibimiento.TREINTA.toString()));
        }
        else if (faltasNoJustificadas >= 20){
            sb.append(String.format("%-25s", TipoApercibimiento.DIEZ.toString() + " " 
            + TipoApercibimiento.VEINTE.toString()));
        }
        else if (faltasNoJustificadas >= 10){
            sb.append(String.format("%-25s", TipoApercibimiento.DIEZ.toString()));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai  ,  Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}

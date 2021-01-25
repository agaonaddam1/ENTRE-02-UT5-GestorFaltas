
/**
 * tIPO ENUMERADO TipoApercibimiento 
 * 
 * @author  
 * @version  
 */
public enum TipoApercibimiento
{
    DIEZ(10),

    VEINTE(20),

    TREINTA(30);
    private int tipoApercibimiento;
    private TipoApercibimiento(int nivel)
    {
        this.tipoApercibimiento = tipoApercibimiento;
    }

    public int getValorTipo(){
        return tipoApercibimiento;
    }
}

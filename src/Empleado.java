import java.util.Objects;

public class Empleado {
    private double cedula;
    private String nombre;
    private double salario;
    private double aporteSeguroSocial;
    private double impuestoRenta;

    public Empleado(double cedula, String nombre, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salario = salario;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAporteSeguroSocial() {
        return aporteSeguroSocial;
    }

    public void setAporteSeguroSocial(double aporteSeguroSocial) {
        this.aporteSeguroSocial = aporteSeguroSocial;
    }

    public double getImpuestoRenta() {
        return impuestoRenta;
    }

    public void setImpuestoRenta(double impuestoRenta) {
        this.impuestoRenta = impuestoRenta;
    }

    @Override
    public String toString() {
        return "EMPLEADO = " + " CEDULA: " + String.format("%.0f", cedula) + ", NOMBRE: " + nombre + ", SALARIO: " + salario + "\n";
    }

    public String toString2() {
        double salarioFinal = salario-aporteSeguroSocial-impuestoRenta;
        return "EMPLEADO = " + " CEDULA: " + String.format("%.0f", cedula) + ", NOMBRE: " + nombre + ", SALARIO MENSUAL: " + String.format("%.2f",salario) + ", APORTE SEGURO SOCIAL: " + String.format("%.2f",aporteSeguroSocial) + ", IMPUESTO RENTA: " + String.format("%.2f",impuestoRenta) + ", SUELDO A RECIBIR: " + String.format("%.2f",salarioFinal) + "\n\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return cedula == empleado.cedula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

}

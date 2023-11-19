import java.util.HashSet;

public class RolDePagos {
    HashSet<Empleado> setEmpleados;

    public RolDePagos() {
        setEmpleados = new HashSet<Empleado>();
    }

    public HashSet<Empleado> getSetEmpleados() {
        return setEmpleados;
    }

    public void setSetEmpleados(HashSet<Empleado> setEmpleados) {
        this.setEmpleados = setEmpleados;
    }

    public boolean agregarEmpleado(Empleado dato) {
        if (setEmpleados.add(dato)) {
            return true;
        }
        return false;
    }

    public boolean modificarEmpleado(Empleado dato) {
        for (Empleado e : setEmpleados) {
            if (e.getCedula()== dato.getCedula()){
                e.setNombre(dato.getNombre());
                e.setSalario(dato.getSalario());
                return true;
            }
        }
        return false;
    }

    public void calcularSeguroSocial(){
        for (Empleado e : setEmpleados){
            e.setAporteSeguroSocial(e.getSalario()*0.0935);
        }
    }

    public void calcularImpuestoalaRenta(){
        double impuestoRentaAnual;
        for (Empleado e : setEmpleados){
            if((e.getSalario()*12) <= 5000){
                impuestoRentaAnual=0;
                e.setImpuestoRenta(impuestoRentaAnual);
            }
            if((e.getSalario()*12) > 5000 && (e.getSalario()*12) <= 10000){
                impuestoRentaAnual=((e.getSalario()*12)-5000)*0.1;
                e.setImpuestoRenta(impuestoRentaAnual/12);
            }
            if((e.getSalario()*12) > 10000 && (e.getSalario()*12) <= 18000){
                impuestoRentaAnual=((e.getSalario()*12)-10000)*0.2;
                e.setImpuestoRenta(impuestoRentaAnual/12);
            }
            if((e.getSalario()*12) > 18000){
                impuestoRentaAnual=((e.getSalario()*12)-18000)*0.3;
                e.setImpuestoRenta(impuestoRentaAnual/12);
            }
        }
    }

    public String generarInforme(){
        String resultado = "";
        for(Empleado e : setEmpleados){
            resultado += e.toString2() + "";
        }
        return resultado;
    }


}

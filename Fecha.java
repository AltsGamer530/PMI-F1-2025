public class Fecha {
    int dia,mes,ano;

    public Fecha() {}

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public void mostrarFecha(){
        System.out.println("Fecha: " + this.dia + "/" + this.mes + "/" + this.ano);
    }
    
    public int cantDias(Fecha f){
        int dias1 = 0, dias2 = 0, dias = 0;
        int[] numDias = {31,28,31,30,31,30,31,31,30,31,30,31};
        //año bisiesto
        if(this.ano % 4 == 0 && (this.ano %400 == 0 || this.ano % 100 != 0)) numDias[1] = 29;
        
        //dias desde el 1/1/1900 hasta el 1/1/año
        //floor(años/4) = cantidad de años bisiestos entre esas fechas
        dias1 = (this.ano - 1900) * (365 + 1/4);
        dias2 = (f.ano - 1900) * (365 + 1/4);
        //dias desde 1/1/año hasta 1/mes/año
        for(int i=0; i<this.mes; i++) dias1 += numDias[i];
        for(int i=0; i<f.mes; i++) dias2 += numDias[i];
        //dias desde 1/mes/año hasta dia/mes/año
        dias1 += this.dia;
        dias2 += f.dia;
        
        dias = Math.abs(dias1 - dias2);
        
        return dias;
    }
    
}

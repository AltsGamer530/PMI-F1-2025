

public class JavaApplication5 {
    public static void main(String[] args) {
        Fecha f = new Fecha(1,1,2001);
        Piloto p = new Piloto();
        p.setNombre("pedro");
        p.setApellido("sanchez");
        p.setFechaDeNacimiento(f);
        System.out.println("nombre: "+p.getNombre()+"\napellido: "+p.getApellido()+"\nnacio: "+ p.getFechaDeNacimiento()+"\n");
    
    }
    
}

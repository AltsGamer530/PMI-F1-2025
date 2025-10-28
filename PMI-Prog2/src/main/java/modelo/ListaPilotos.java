package modelo;
import java.util.ArrayList;
import java.util.Scanner;
        
/**
 *
 * @author arctan
 */
public class ListaPilotos {
    private ArrayList<Piloto> lista;
    private int cantPilotos;

    public ListaPilotos() {
        this.lista = new ArrayList<Piloto>();
    }

    public ArrayList<Piloto> getLista() {
        return lista;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        this.lista = listaPilotos;
    }

    public int getCantPilotos() {
        return cantPilotos;
    }

    public void setCantPilotos(int cantPilotos) {
        this.cantPilotos = cantPilotos;
    }
    
    public int localizarPiloto(int numeroAuto){
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getNumeroDeAuto() == numeroAuto) return i;
        }
        return -1;
    }
    
    public Piloto buscarPilotoPorNumero(int numeroAuto){
        for(Piloto p: lista)
            if(p.getNumeroDeAuto() == numeroAuto) return p;
        return null;
    }
    
    public boolean addPiloto(Piloto p){
        Piloto paux = buscarPilotoPorNumero(p.getNumeroDeAuto());
        if(paux == null){
            lista.add(p);
            return true;
        }
        return false;
    }
    
    public boolean eliminarPiloto(int numeroAuto){
        Piloto p = buscarPilotoPorNumero(numeroAuto);
        if(p != null){
            lista.remove(p);
            return true;
        }
        return false;
    }
    
    public ListaPilotos filtrarPilotosPorPuntaje(int puntos){
        ListaPilotos filtrados = new ListaPilotos();
        for(Piloto p : this.lista){
            if(p.getPuntos() >= puntos) filtrados.addPiloto(p);
        }
        return filtrados;
    }
    
    public Piloto pilotoConMasPenalizaciones(){
        Piloto p = new Piloto();
        int max = 0;
        for(Piloto paux : this.lista){
            if(paux.getPenalizaciones() > max) p = paux;
        }
        if(max == 0) return null;
        return p;
    }
    
    public int cantPilotosPorRol(String rol){
        int cont = 0;
        for(Piloto p : this.lista){
            if(p.getRol() == rol) cont++;
        }
        return cont;
    }
    
    public boolean modificarPiloto(int numeroAuto){
        Scanner sc = new Scanner(System.in);
        int i = this.localizarPiloto(numeroAuto);
        if(i >= 0){
        System.out.println("Piloto enocontrado: ");
        this.lista.get(i).mostrarDatosPi();

        System.out.println("Que desea modificar?: ");
        System.out.println("1.Numero de Auto");
        System.out.println("2.Rol");
        System.out.println("3.Puntos");
        System.out.println("4.Podios");
        System.out.println("5.Poles");
        System.out.println("6.Vueltas Rapidas");
        System.out.println("7.Penalizaciones");
        System.out.println("8.Abandonos(DNF)");
                    
        int opcion = sc.nextInt();
                    
        switch (opcion) {
            case 1:
                System.out.println("Nuevo numero de auto: ");
                    this.lista.get(i).setNumeroDeAuto(sc.nextInt());
                        break;
            case 2:
            System.out.println("Nuevo Rol: ");
                        this.lista.get(i).setRol(sc.nextLine());
                        break;
                        case 3:
                            System.out.println("Nuevos puntos: ");
                            this.lista.get(i).setPuntos(sc.nextInt());
                            break;
                        case 4:
                            System.out.println("Nuevo podio: ");
                            this.lista.get(i).setPodios(sc.nextInt());
                            break;
                        case 5:
                            System.out.println("Nuevo Pole: ");
                            this.lista.get(i).setPoles(sc.nextInt());
                            break;
                        case 6:
                            System.out.println("Vueltas Rapidas Actuales: ");
                            this.lista.get(i).setVueltasRapidas(sc.nextInt());
                            break;
                        case 7:
                            System.out.println("Nuevas Penalizaciones: ");
                            this.lista.get(i).setPenalizaciones(sc.nextInt());
                            break;
                        case 8:
                            System.out.println("Nuevos Abandonos");
                            this.lista.get(i).setAbandonos(sc.nextInt());
                            break;
                        default:
                            System.out.println("Opción inválida");
                            return false;
                }
            }
            System.out.println("No se encontró el piloto con ese número de auto");
            return false;
        }
    
}

class Estudiante{
    private int ci;
    private String nombre,paterno, materno;

    public Estudiante(int ci,String nombre, String paterno, String materno) {
        this.ci=ci;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }
    public int getCi(){
        return ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    public void mostrar(){
        System.out.println(ci+" "+nombre+" "+paterno+""+materno);
    }

}

class CSimpleE{
    private int max=100;
    private Estudiante v[]=new Estudiante[max+1];
    private int ini, fin;

    public CSimpleE(){
        ini=fin=0;
    }

    public boolean esVacia(){
        if(ini == 0 && fin ==0)
            return true;
        return false;
    }
    public boolean esLLena(){
        if(fin == max)
            return true;
        return false;
    }
    public int nroElementos(){
        return fin -ini;
    }
    public void adicionar(Estudiante x){
        if(esLLena()){
            System.out.println("Cola llena");
        }
        
        v[fin]=x;
        fin++;
    }


    public Estudiante eliminar(){
        if(esVacia()){
            System.out.println("cola vacia");
        }
        Estudiante ele=v[ini];
        ini++;
        if(ini==fin){
            ini=fin=0;
        }
        return ele;
    }

    public void mostrar(){
        CSimpleE aux = new CSimpleE();
        while(!esVacia()){
            Estudiante ele= eliminar();
            ele.mostrar();
            aux.adicionar(ele);
        }
        vaciar(aux);
    }

    public void vaciar(CSimpleE x) {
        Estudiante ele =  null;
        while(!x.esVacia()){
            ele = x.eliminar();
            adicionar(ele);
        }
    }

    public void llevar( String y){
        CSimpleE aux1 = new CSimpleE();
        CSimpleE aux2 = new CSimpleE();

        Estudiante ele = null;
        while(!esVacia()){
            ele = eliminar();
            if(ele.getPaterno().equals(y) || ele.getMaterno().equals(y)){
                aux1.adicionar(ele);
            }else{
                aux2.adicionar(ele);
            }
        }
        vaciar(aux1);
        vaciar(aux2);
        
    }
    public void mostrarEs( CSimpleP y){
    CSimpleE aux = new CSimpleE();
    CSimpleP aux2 = new CSimpleP();
    while(!esVacia()){
        Estudiante e = eliminar();
        e.mostrar();

        while(!y.esVacia()){
            Practica p = y.eliminar();
            if(e.getCi() == p.getCi()){
                p.mostrar();
            }
            aux2.adicionar(p);
        }
        y.vaciar(aux2);
        aux.adicionar(e);
    }
}
    public void mostrarCantidadPracticasPorEstudiante(CSimpleP practicas) {
        CSimpleE auxEst = new CSimpleE();
        while (!esVacia()) {
            Estudiante est = eliminar();
            int c = 0;
            CSimpleP auxPrac = new CSimpleP();
            while (!practicas.esVacia()) {
                Practica p = practicas.eliminar();
                if (p.getCi() == est.getCi()) {
                    c++;
                }
                auxPrac.adicionar(p);
            }
            practicas.vaciar(auxPrac);
            System.out.println(est.getNombre() + ": " + c + " practicas");
            auxEst.adicionar(est);
        }
        vaciar(auxEst);
    }
    public void llevarPracticasAdelante(int ci, CSimpleP practicas) {
        CSimpleE auxEst = new CSimpleE();
        CSimpleP auxPrac = new CSimpleP();
        CSimpleP practicasEst = new CSimpleP();

        while (!esVacia()) {
            Estudiante est = eliminar();
            if (est.getCi() == ci) {
                while (!practicas.esVacia()) {
                    Practica p = practicas.eliminar();
                    if (p.getCi() == ci) {
                        practicasEst.adicionar(p);
                    } else {
                        auxPrac.adicionar(p);
                    }
                }
                practicas.vaciar(auxPrac);
            }
            auxEst.adicionar(est);
        }

        while (!practicasEst.esVacia()) {
            practicas.adicionar(practicasEst.eliminar());
        }
        practicas.vaciar(auxPrac);
        vaciar(auxEst);
        System.out.println("Prácticas llevadas adelante para el estudiante con CI: " + ci);
        CSimpleP mostrarPracticas = new CSimpleP();
        int contador = 0;
        while (!practicas.esVacia()) {
            Practica p = practicas.eliminar();
            if (p.getCi() == ci) {
                //p.mostrar();
                contador++;
            }
            mostrarPracticas.adicionar(p);
        }
        practicas.vaciar(mostrarPracticas);
        if (contador == 0) {
            System.out.println("No hay prácticas para este estudiante.");
        }
    }




}

class Practica {
    private int ci;
    private String fechaPresentacion;
    private String tema;

    public Practica(int ci, String fechaPresentacion, String tema) {
        this.ci = ci;
        this.fechaPresentacion = fechaPresentacion;
        this.tema = tema;
    }

    public int getCi() {
        return ci;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public String getTema() {
        return tema;
    }

    public void mostrar() {
        System.out.println("CI: " + ci + ", Fecha: " + fechaPresentacion + ", Tema: " + tema);
    }
}

class CSimpleP {
    private int max = 100;
    private Practica v[] = new Practica[max + 1];
    private int ini, fin;

    public CSimpleP() {
        ini = fin = 0;
    }

    public boolean esVacia() {
        return ini == 0 && fin == 0;
    }

    public boolean esLLena() {
        return fin == max;
    }

    public int nroElementos() {
        return fin - ini;
    }

    public void adicionar(Practica x) {
        if (esLLena()) {
            System.out.println("Cola de practicas llena");
            return;
        }
        v[fin] = x;
        fin++;
    }

    public Practica eliminar() {
        if (esVacia()) {
            System.out.println("Cola de practicas vacia");
            return null;
        }
        Practica ele = v[ini];
        ini++;
        if (ini == fin) {
            ini = fin = 0;
        }
        return ele;
    }

    public void mostrar() {
        CSimpleP aux = new CSimpleP();
        while (!esVacia()) {
            Practica ele = eliminar();
            if (ele != null) {
                ele.mostrar();
                aux.adicionar(ele);
            }
        }
        vaciar(aux);
    }

    public void vaciar(CSimpleP x) {
        Practica ele = null;
        while (!x.esVacia()) {
            ele = x.eliminar();
            if (ele != null) {
                adicionar(ele);
            }
        }
    }

    public void contarPracticasPorTema(String tema) {
        int c = 0;
        CSimpleP aux = new CSimpleP();
        while (!esVacia()) {
            Practica ele = eliminar();
            if (ele.getTema().equals(tema)) {
                c++;
            }
            aux.adicionar(ele);
        }
        vaciar(aux);
        System.out.println(c);
    }
}

public class Cola1 {
    public static void main(String[] args) {
    //cola de estudiantes (nombre, ci, paterno, materno)
    //cola de las practicas (ci, fechapresentacion, tema)
    Estudiante c1 = new Estudiante(1,"Ana","Perez","Rios");
    Estudiante c2 = new Estudiante(2,"Pedro","Rodriguez","Rios");
    Estudiante c3 = new Estudiante(3,"Juan","Perez","Coyo");
    Estudiante c4 = new Estudiante(4,"Bryan","Coyo","Vargas");
    Estudiante c5 = new Estudiante(5,"Marcelo","Villalobos","Carrillo");
    CSimpleE co = new CSimpleE();
    
    co.adicionar(c1);
    co.adicionar(c2);
    co.adicionar(c3);
    co.adicionar(c4);
    co.adicionar(c5);
    co.mostrar();
    
    // System.out.println("--------------solucion 1--------------");
    // co.llevar("Rios");
    // co.mostrar();
    //crear una cola de practicas y mostrar
    CSimpleP cp = new CSimpleP();
    Practica p1 = new Practica(1, "03/09/2025","pilas");
    Practica p2 = new Practica(2, "05/09/2025","colas");
    Practica p3 = new Practica(3, "10/09/2025","listas");
    Practica p4 = new Practica(4, "15/09/2025","arboles");
    Practica p5 = new Practica(5, "21/09/2025","grafos");
    Practica p6 = new Practica(4, "25/09/2025","pilas");
    Practica p7 = new Practica(3, "26/09/2025","pilas");
    cp.adicionar(p1);
    cp.adicionar(p2);
    cp.adicionar(p3);
    cp.adicionar(p4);
    cp.adicionar(p5);
    cp.adicionar(p6);
    cp.adicionar(p7);
    cp.mostrar();
   

    System.out.println("--------------");
    co.mostrarCantidadPracticasPorEstudiante(cp);
    System.out.println("-----------------");
    co.adicionar(c1);
    co.adicionar(c2);
    co.adicionar(c3);
    co.adicionar(c4);
    co.adicionar(c5);
    co.llevarPracticasAdelante(4, cp);
    cp.mostrar();
    // System.out.println("---------------solucion 4-----------------");
    // cp.contarPracticasPorTema("pilas");
    // System.out.println("---------------solucion 5-----------------");
    // co.mostrarEs(cp);
    // System.out.println("---------------solucion 6-----------------");
   

    
    
    
    }





}

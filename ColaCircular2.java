class Artesania{
    private int nroPuesto, precio;
    private String nombre;

    public Artesania(int nroPuesto, int precio, String nombre) {
        this.nroPuesto = nroPuesto;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getNroPuesto() {
        return nroPuesto;
    }

    public void setNroPuesto(int nroPuesto) {
        this.nroPuesto = nroPuesto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.println(nroPuesto+" "+precio+" "+nombre);
    }



    
}


class CCircularA{
    public void llevarDesdePila(PilaA pila, int x) {
        int n = pila.nroElementos();
        PilaA aux = new PilaA();
        for (int i = 1; i <= n; i++) {
            Artesania a = pila.eliminar();
            if (a.getNroPuesto() == x) {
                adicionar(a);
            } else {
                aux.adicionar(a);
            }
        }
        pila.vaciar(aux);
    }
    private int max=100;
    private Artesania v[] = new Artesania[max+1];
    private int ini,fin;

    public CCircularA(){
        ini=0;
        fin=0;
    }

    public int nroElementos(){
        if(ini == 0 && fin ==0){
            return 0;
        }else if(fin > ini){
            return fin -ini;
        }else{
            return max-ini+fin;
        }
    }

    public boolean esVacia(){
        if(nroElementos() ==0)
            return true;
        return false;
    }

    public boolean esLlena(){
        if(nroElementos() == max)
            return true;
        return false;
    }
    public void adicionar(Artesania x){
        if(!esLlena()){
            if(fin == max){
                fin=1;
            }else{
                fin++;
            }
            v[fin]=x;
    }else{
        System.out.println("cola llena");
    }
}
    public Artesania eliminar(){
        Artesania ele = null;
        if(!esVacia()){
            
            ini++;
            ele = v[ini];
            if(ini==fin){
                ini =fin=0;
            }

        }else{
            System.out.println("cola vacia");
        }
        return ele;
    }

    public void mostrar(){
        CCircularA aux = new CCircularA();
        while(!esVacia()){
            Artesania ele = eliminar();
            
            ele.mostrar();
            aux.adicionar(ele);
        }
        vaciar(aux);
    }

    public void vaciar(CCircularA x){
        while(!x.esVacia())  {
            adicionar(x.eliminar());
        }
    }

    public  void llevar( CCircularA b, int x){
        int n = nroElementos();
        int m= b.nroElementos();
        for(int i=1; i<=n; i++){
            Artesania ax = eliminar();
            if(ax.getNroPuesto()==x){
                b.adicionar(ax);
            }else{
                adicionar(ax);
            }
        }
        int c=n-nroElementos();
        for(int j=1; j<=m; j++){
            Artesania bx = b.eliminar();
            if(bx.getNroPuesto() == x){
                adicionar(bx);
            }else{
                b.adicionar(bx);
            }
        }
        
        for(int i=1; i<=c; i++){
            b.adicionar(b.eliminar());
        }
    }

}

class PilaA{
    public void llevarDesdeCola(CCircularA cola, int x) {
        int n = cola.nroElementos();
        CCircularA aux = new CCircularA();
        for(int i=1; i<=n; i++){
            Artesania ele = cola.eliminar();
            if(ele.getNroPuesto() == x){
                adicionar(ele);
            }else{
                aux.adicionar(ele);
            }
        }
        cola.vaciar(aux);
    }
    private int max=100;
    private Artesania v [ ] = new Artesania[max+1];
    private int tope;

    public PilaA(){
        tope=0;
    }

    public boolean esLLena(){
        if(tope == max)
            return true;
        return false;
    }

    public boolean esVacia(){
        if(tope == 0)
            return true;
        return false;
    }

    public int nroElementos(){
        return tope;
    }

    public Artesania eliminar(){
        Artesania ele = null;
        if(esVacia()){
            System.out.println("pila vacia");
        }else{
            ele = v[tope];
            tope--;
        }
        return ele;
    }

    public void adicionar(Artesania x){
        if(esLLena()){
            System.out.println("pila llena");
        }else{
            tope++;
            v[tope]=x;
            
        }
    }

    public void vaciar(PilaA x){
        while(!x.esVacia()){
            adicionar(x.eliminar());
        }
    }
    public void mostrar(){
        PilaA aux = new PilaA();
        while(!esVacia()){
            Artesania ele = eliminar();
            ele.mostrar();
            aux.adicionar(ele);
        }
        vaciar(aux);
    }

}
















public class ColaCircular2 {
    public static void main(String[] args) {
        CCircularA A = new CCircularA();
        Artesania a1 = new Artesania(1, 10, "Pintura");
        Artesania a2 = new Artesania(2, 25, "lapicero");
        Artesania a3 = new Artesania(1, 55, "poncho");
        Artesania a4 = new Artesania(4,34, "portafolio");
        Artesania a5 = new Artesania(3, 30, "macetero");
        Artesania a6 = new Artesania(4, 20, "cuaderno");
        Artesania a7 = new Artesania(5, 15, "alcancia");

        A.adicionar(a1);
        A.adicionar(a2);
        A.adicionar(a3);
        A.adicionar(a4);
        A.adicionar(a5);
        A.adicionar(a6);
        A.adicionar(a7);
        System.out.println("**********Primera cola*****************");

        A.mostrar();
        CCircularA B = new CCircularA();
        Artesania b1 = new Artesania(1, 40, "vasija");
        Artesania b2 = new Artesania(2, 22, "tapiz");
        Artesania b3 = new Artesania(3, 18, "collar");
        Artesania b4 = new Artesania(4, 60, "escultura");
        Artesania b5 = new Artesania(2, 35, "cinturon");

        B.adicionar(b1);
        B.adicionar(b2);
        B.adicionar(b3);
        B.adicionar(b4);
        B.adicionar(b5);

        System.out.println("******************Segunda cola***************");

        B.mostrar();

        //1. llevar al final las artesanias del nroPuesto x de la cola 1 a la cola 2 y de la cola 2 a la cola 1
        System.out.println("solucion 1");
        A.llevar(B, 1);

        A.mostrar();
        B.mostrar();

        //2.Crear pila de artesanias y mostrar

        PilaA PA = new PilaA();
        Artesania p1 = new Artesania(2, 50, "retrato");
        Artesania p2 = new Artesania(3, 70, "escultura");
        Artesania p3 = new Artesania(4, 20, "jarron");
        Artesania p4 = new Artesania(5, 15, "pulsera");
        Artesania p5 = new Artesania(1, 80, "alfombra");

        PA.adicionar(p1);
        PA.adicionar(p2);
        PA.adicionar(p3);
        PA.adicionar(p4);
        PA.adicionar(p5);

        System.out.println("**********Pila de artesanias**********");
        PA.mostrar();
        //4.llevar al final las artesanias del puesto x al final de la pila en la cola, de la cola en la pila
        System.out.println("**************de la pila a la cola***********");

        A.llevarDesdePila(PA, 2);
        A.mostrar();
        PA.mostrar();

        System.out.println("************de la cola a la pila*****************");
        PA.llevarDesdeCola(A, 4);
        PA.mostrar();
        A.mostrar();
    }
}

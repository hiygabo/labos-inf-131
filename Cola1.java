class Estudiante{
    private int ci;
    private String nombre;
    private String paterno;
    private String materno;

    public Estudiante(){

    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
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

    public void leer(){
        System.out.println("Ingrese el nombre: ");
        nombre = Leer.dato();
        System.out.println("Ingrese el paterno: ");
        paterno = Leer.dato();
        System.out.println("Ingrese el materno: ");
        materno = Leer.dato();
    }
    public void mostrar(){
        System.out.println("Nombre: "+nombre+ " "+paterno+" "+" "+materno);
    }
}
class Cola{
    private int max;
    private Estudiante[] estudiantes = new Estudiante[max+1];
    private int inicio;
    private int fin;

    public Cola() {
        this.inicio =0;
        this.fin =0;
    }

    public boolean esVacia(){
        if (inicio ==0 && fin  ==0)
            return true;
        return false;
    }

    public boolean esLlena(){
        if(fin == max)
            return true;
        return false;
    }

    public void adicionar(Estudiante x){
        if(esLlena()){
            System.out.println("Cola llena");
        }
        fin = fin+1;
        estudiantes[fin]=x;

    }
    public Estudiante eliminar(){
        Estudiante ele = null;
        if(esVacia()){
            System.out.println("Cola vacia");
        }
        ele = estudiantes[inicio+1];
        if (inicio == fin){
            inicio = fin = 0;
        }
        return ele;
    }

    public void llenar(int n){
        for (int i=0; i<n; i++){
            Estudiante e = new Estudiante();
            e.leer();
            adicionar(e);
        }
    }
    public void mostrar(){
        Cola aux = new Cola();
        Estudiante ele = null;
        while(!esVacia()){
            ele = eliminar();
            ele.mostrar();
            aux.adicionar(ele);
        }
        vaciar(aux);
    }
    public int nroElementos(){
        return inicio-fin;
    }
    public void vaciar(Cola x){
        while(!x.esVacia()){
            Estudiante ele = x.eliminar();
            adicionar(ele);
        }
    }
    //Ejrcicios
    //1. LLevar al ultimo estudiante adelante
    public void llevarUltimoAdelante(){
        Cola aux = new Cola();
        while(nroElementos()>1){
            Estudiante ele = eliminar();
            aux.adicionar(ele);
        }
        Estudiante ultimo = eliminar();
        adicionar(ultimo);
        vaciar(aux);
        
    }
    //2. Llevar el penultimo estudiante adelante
    public void llevarPenultimoAdelante(){
        Cola aux = new Cola();
        while(nroElementos ()>2){
            Estudiante ele = eliminar();
            aux.adicionar(ele);
        }
        Estudiante penultimo = eliminar();
        adicionar(penultimo);
        eliminar();
    }
    //3. LLevar adelante a estudiantes con el apellido x
    public void llevarAdelanteConapX(String x){
        Cola aux = new Cola();
        Cola aux2 = new Cola();

        while(!esVacia()){
            Estudiante ele = eliminar();
            if(ele.getPaterno().equals(x) || ele.getMaterno().equals(x)){
                aux.adicionar(ele);
            }else{
                aux2.adicionar(ele);
            }
        }
        vaciar(aux);
        vaciar(aux2);
        }
    public void contarConNombrex(String x){
        int c=0;
        Cola aux = new Cola();
        Cola aux2 = new Cola();
        while(!esVacia()){
            Estudiante ele = eliminar();
            if(ele.getNombre().equals(x)){
                c++;
                aux.adicionar(ele);
            }else{
                aux2.adicionar(ele);
            }
            
        }
        vaciar(aux);
        vaciar(aux2);
        System.out.println("Estudiantes con el nombre "+ x +": "+c);
    }

    //4. Sean 2 colas intercambiar el primer estudiante de la cola A con el ultimo estudiante de la cola B, y el primer estudiante de la cola B con el ultimo estudiante de la cola A
    public void intercambiar(Cola x){
    // Verificar que ambas colas tengan al menos un elemento
    if (this.esVacia() || x.esVacia()) {
        System.out.println("Alguna cola está vacía, no se puede intercambiar.");
        return;
    }

    // --- Extraer primer y último de A ---
    Cola auxA = new Cola();
    Estudiante primeroA = this.eliminar(); // primer estudiante de A
    Estudiante ultimoA = null;
    while(!this.esVacia()){
        ultimoA = this.eliminar();
        if(!this.esVacia()) auxA.adicionar(ultimoA);
    }
    // ultimoA ahora es el último estudiante de A

    // --- Extraer primer y último de B ---
    Cola auxB = new Cola();
    Estudiante primeroB = x.eliminar(); // primer estudiante de B
    Estudiante ultimoB = null;
    while(!x.esVacia()){
        ultimoB = x.eliminar();
        if(!x.esVacia()) auxB.adicionar(ultimoB);
    }
    // ultimoB ahora es el último estudiante de B

    // --- Reconstruir A ---
    this.adicionar(ultimoB);         // El último de B pasa a ser el primero de A
    this.vaciar(auxA);               // Resto de elementos de A (excepto primero y último)
    this.adicionar(primeroB);        // El primero de B pasa a ser el último de A

    // --- Reconstruir B ---
    x.adicionar(ultimoA);            // El último de A pasa a ser el primero de B
    x.vaciar(auxB);                  // Resto de elementos de B (excepto primero y último)
    x.adicionar(primeroA);           // El primero de A pasa a ser el último de B
}



}

public class Cola1 {
    public static void main(String[] args) {
        
    }
}

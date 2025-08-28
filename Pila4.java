import java.util.Stack;
class Celular{
    private String marca;
    private String color;
    private String modelo;
    public Celular(String marca, String color, String modelo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void mostrar(){
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Color: "+color);
    }

    
}

class PilaC{
     private int max = 50;
    private int tope;
    private Celular c[]=new Celular[max+1];

    public PilaC(){
        tope=0;
    
    }

    public boolean esLlena(){
        if(tope==max)
            return true;
        return false;

    }
    public boolean esVacia(){
         if(tope==0)
            return true;
        return false;
    }

    public int nroElementos(){
        return tope;
    }

    public void llenar(Celular x){
        if(esLlena()){
            System.out.println("Pila llena");
            
        }
        else{
            
            tope++;
            c[tope]=x;
            
        }

    }

    public Celular eliminar(){
        Celular elem=null;
        if(esVacia()){
            System.out.println("Pila Vacia");
        }else{
             elem =c[tope];
            tope--;
        }
        return elem;
    }

    public  void mostrar(){
        PilaC aux = new PilaC();
        while(!esVacia()){
            Celular elem =eliminar();
            elem.mostrar();
            aux.llenar(elem);
        }
        vaciar(aux);
    }
    public void vaciar(PilaC x){
        while (!x.esVacia()) {
            llenar(x.eliminar());

        }
    }

    public static void colorX(PilaC a, String x){
        PilaC aux = new PilaC();
        while (!a.esVacia()) {
            Celular c = a.eliminar();
            if(c.getColor().equals(x))
                c.mostrar();
            aux.llenar(c);
            
        }
        a.vaciar(aux);
    }

    public void intercambiar(PilaC p2){
        if(this.esVacia() || p2.esVacia()){
            System.out.println("Alguna de las pilas esta vacia");
        }else{
            Celular aux1 = this.eliminar();
            Celular aux2 = p2.eliminar();
            this.llenar(aux2);
            p2.llenar(aux1);
        }
    }
}








public class Pila4 {
    public static void main(String[] args) {
        Celular c = new Celular("xiaomi", "azul", "x1");
        Celular c1 = new Celular("xiaomi", "rojo", "x2");
        Celular c2 = new Celular("xiaomi", "verde", "x3");
        Celular c3 = new Celular("xiaomi", "amarillo", "x4");
        Celular c4 = new Celular("xiaomi", "naranja", "x5");
        Celular c5 = new Celular("xiaomi", "negro", "x6");
        PilaC pc = new PilaC();
        PilaC pc2 = new PilaC();
        pc.llenar(c);
        pc.llenar(c1);
        pc.llenar(c2);
        pc.mostrar();
        pc2.llenar(c3);
        pc2.llenar(c4);
        pc2.llenar(c5);
        pc.colorX(pc, "azul");
        pc.intercambiar(pc2);
        pc.mostrar();
        System.out.println("--------------------");
        pc2.mostrar();

        Stack <Celular> s = new Stack<>();
        s.push(c1);
        s.push(c2);

        while(!s.empty()){
            Celular ent = s.pop();
            ent.mostrar();
        }
    }
}

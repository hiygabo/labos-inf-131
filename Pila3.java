class PilaN{
    private int max = 50;
    private int tope;
    private String v[]=new String[max+1];

    public PilaN(){
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

    public void llenar(String x){
        if(esLlena()){
            System.out.println("Pila llena");
            
        }
        else{
            
            tope++;
            v[tope]=x;
            
        }

    }

    public String eliminar(){
        String elem="";
        if(esVacia()){
            System.out.println("Pila Vacia");
        }else{
            elem=v[tope];
            tope--;
        }
        return elem;
    }

    public  void mostrar(){
        PilaN aux = new PilaN();
        while(!esVacia()){
            String elem =eliminar();
            System.out.println(elem);
            aux.llenar(elem);
        }
        vaciar(aux);
    }
    public void vaciar(PilaN x){
        while (!x.esVacia()) {
            llenar(x.eliminar());

        }
    }

    public static void letra (PilaN a, char x){
        PilaN aux = new PilaN();
        while (!a.esVacia()) {
            String nom = a.eliminar();
            if(nom.charAt(nom.length()-1)==x)
                System.out.println(nom);
            aux.llenar(nom);

        }
    }

    
}

public class Pila3{
    public static void main(String[] args) {
        PilaN p = new PilaN();
        p.llenar("juan");
        p.llenar("juan");
        p.llenar("juan1");
        p.mostrar();

    }
}
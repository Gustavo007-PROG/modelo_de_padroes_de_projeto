 

public class Janela {

 

    private static final Janela INSTANCE = new Janela();
    private static final String Teste= "Exemplo Singleton Privado";

    private static final String Singleton = "Exemplo Singleton Publico";

    private Janela() {

    }

    public static Janela getInstance() {
        return INSTANCE;
    }
    public static void Abir() {
        System.out.println("Abrir Janela!");
    }
    public static void Fechar() {
        System.out.println("Abrir Fechar");
    }
}


 

package exemplo;

 

public class Janela2 {
    private static Janela2 instancia;

    private Janela2() {

    }

    public static synchronized Janela2 getInstance() {
        if(instancia == null) {
            instancia = new Janela2();
        }
        return instancia;
    }

 

}

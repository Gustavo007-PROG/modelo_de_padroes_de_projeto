package button;

// Declaração da interface Button
public interface Button {
    void paint(); // Método abstrato que será implementado nas classes concretas
}


package button;

// Implementação da classe concreta MacOSButton que implementa a interface Button
public class MacOSButton implements Button{
    public void paint() { // Implementação do método paint() da interface Button
        System.out.println("You have created MacOSButton."); // Mensagem a ser exibida
    }
}


package button;

// Implementação da classe concreta WindowsButton que implementa a interface Button
public class WindowsButton implements Button{
    public void paint() { // Implementação do método paint() da interface Button
        System.out.println("You have created WindowsButton."); // Mensagem a ser exibida
    }
}


package checkbox;

// Declaração da interface Checkbox
public interface Checkbox {
    void paint(); // Método abstrato que será implementado nas classes concretas
}


package checkbox;

// Implementação da classe concreta MacOSCheckbox que implementa a interface Checkbox
public class MacOSCheckbox implements Checkbox{
    public void paint() { // Implementação do método paint() da interface Checkbox
        System.out.println("You have created MacOSCheckbox"); // Mensagem a ser exibida
    }
}


package checkbox;

// Implementação da classe concreta WindowsCheckbox que implementa a interface Checkbox
public class WindowsCheckbox implements Checkbox{
    public void paint() { // Implementação do método paint() da interface Checkbox
        System.out.println("You have created WindowsCheckbox"); // Mensagem a ser exibida
    }
}

package factories;

import button.Button;

// Declaração da interface GUIFactory
public interface GUIFactory {
    Button createButton(); // Método abstrato que retorna um objeto Button
    Checkbox createCheckbox(); // Método abstrato que retorna um objeto Checkbox
}


package factories;

import button.Button;

// Implementação da fábrica MacOSFactory que implementa a interface GUIFactory
public class MacOSFactory implements GUIFactory{
    public Button createButton() { // Implementação do método createButton() da interface GUIFactory
        return new MacOSButton(); // Retorna um novo objeto MacOSButton
    }

    public Checkbox createCheckbox() { // Implementação do método createCheckbox() da interface GUIFactory
        return new MacOSCheckbox(); // Retorna um novo objeto MacOSCheckbox
    }
}




package factories;

import button.Button;

// Implementação da fábrica WindowsFactory que implementa a interface GUIFactory
public class WindowsFactory implements GUIFactory{
    public Button createButton() { // Implementação do método createButton() da interface GUIFactory
        return new WindowsButton(); // Retorna um novo objeto WindowsButton
    }

    public Checkbox createCheckbox() { // Implementação do método createCheckbox() da interface GUIFactory
        return new WindowsCheckbox(); // Retorna um novo objeto WindowsCheckbox
    }
}



package app;

import button.Button;

// Implementação da classe Application
public class Application {
    private Button button; // Atributo privado do tipo Button
    private Checkbox checkbox; // Atributo privado do tipo Checkbox

    public Application(GUIFactory factory) { // Construtor que recebe uma fábrica como parâmetro
        button = factory.createButton(); // Cria um novo botão usando a fábrica
        checkbox = factory.createCheckbox(); // Cria uma nova checkbox usando a fábrica
    }

    public void paint() { // Método que executa a ação de pintar na interface do usuário
        button.paint(); // Chama o método paint() do bot
    }

    package app;

// import da interface Button do pacote button
import button.Button;
// import da interface GUIFactory do pacote factories
import factories.GUIFactory;

// definição da classe Application
public class Application {
    // atributos privados da classe
    private Button button;
    private Checkbox checkbox;

    // construtor que recebe uma fábrica de GUI
    public Application(GUIFactory factory) {
        // criação do botão a partir da fábrica
        button = factory.createButton();
        // criação do checkbox a partir da fábrica
        checkbox = factory.createCheckbox();
    }

    // método para pintar a interface gráfica
    public void paint() {
        // chama o método paint do botão criado
        button.paint();
        // chama o método paint do checkbox criado
        checkbox.paint();
    }
}


package app;

// definição da classe Demo
public class Demo {
    // método estático para configurar a aplicação
    private static Application configureApplication() {
        // declaração das variáveis locais
        Application app;
        GUIFactory factory;
        // obtenção do nome do sistema operacional
        String osName = System.getProperty("os.name").toLowerCase();
        // criação da fábrica de acordo com o sistema operacional
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }

        // criação da aplicação com a fábrica escolhida
        app = new Application(factory);
        return app;
    }

    // método main
    public static void main(String[] args) {
        // configura a aplicação
        Application app = configureApplication();
        // pinta a interface gráfica
        app.paint();
    }
}

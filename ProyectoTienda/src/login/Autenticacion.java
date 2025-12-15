package login;

public class Autenticacion {
    public static boolean verifica(String usuario, String clave) {
        boolean sw = false;

        if (usuario.equalsIgnoreCase("Algoritmia") && clave.equalsIgnoreCase("12345")) {
            sw = true;
        } else {
            sw = false;
        }

        return sw;
    }
}
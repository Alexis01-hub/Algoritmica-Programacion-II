package TP3.ej3.actividad;

public class CaesarCipherDemo {
    public static void main(String[] args) {
        // Crear un cifrador con desplazamiento de 3
        CaesarCipher cipher = new CaesarCipher(3);
        
        String original = "Hola Mundo Ñandú 2023"; // Texto con mayúsculas, minúsculas y números.
        System.out.println("Texto original:    " + original);
        
        // Encriptar el texto
        String encrypted = cipher.encrypt(original);
        System.out.println("Texto encriptado:  " + encrypted);
        
        // Desencriptar el texto
        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Texto desencriptado: " + decrypted);
        
        // Verificar que el desencriptado coincide con el original
        System.out.println("¿Coinciden original y desencriptado? " + 
                          original.equals(decrypted));
    }
}
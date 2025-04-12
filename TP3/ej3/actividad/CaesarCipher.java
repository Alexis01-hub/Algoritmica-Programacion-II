package TP3.ej3.actividad;

/**
 * La clase CaesarCipher implementa el cifrado y descifrado de texto
 * utilizando el algoritmo de cifrado César. Este algoritmo desplaza
 * los caracteres de un texto según un número fijo de posiciones.
 * 
 * Soporta el alfabeto español (incluyendo la letra 'ñ'), dígitos numéricos
 * y letras mayúsculas.
 */
public class CaesarCipher {
    private final int shift; // Número de posiciones para el desplazamiento.
    private final String alphabet = "abcdefghijklmnñopqrstuvwxyz"; // Alfabeto español en minúsculas.
    private final String uppercaseAlphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; // Alfabeto español en mayúsculas.
    private final String digits = "0123456789"; // Dígitos numéricos.
    private final String allCharacters; // Combina alfabeto, mayúsculas y dígitos.

    /**
     * Constructor de la clase CaesarCipher.
     * 
     * @param shift Número de posiciones para el desplazamiento en el cifrado.
     */
    public CaesarCipher(int shift) {
        this.shift = shift % 64; // Asegura que el desplazamiento esté dentro del rango.
        this.allCharacters = alphabet + uppercaseAlphabet + digits; // Combina alfabeto, mayúsculas y dígitos.
    }

    /**
     * Cifra un texto dado utilizando el cifrado César.
     * 
     * @param plaintext El texto en claro que se desea cifrar.
     * @return El texto cifrado.
     */
    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder(); // Almacena el texto cifrado.
        
        for (char c : plaintext.toCharArray()) { // Itera sobre cada carácter del texto en claro.
            if (allCharacters.indexOf(c) != -1) { // Verifica si el carácter pertenece al conjunto soportado.
                int originalPos = allCharacters.indexOf(c); // Obtiene la posición original del carácter.
                int newPos = (originalPos + shift) % allCharacters.length(); // Calcula la nueva posición con el desplazamiento.
                ciphertext.append(allCharacters.charAt(newPos)); // Añade el carácter cifrado al resultado.
            } else {
                ciphertext.append(c); // Añade el carácter sin cambios si no está soportado.
            }
        }
        
        return ciphertext.toString(); // Devuelve el texto cifrado.
    }

    /**
     * Descifra un texto cifrado utilizando el cifrado César.
     * 
     * @param ciphertext El texto cifrado que se desea descifrar.
     * @return El texto en claro.
     */
    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder(); // Almacena el texto descifrado.
        
        for (char c : ciphertext.toCharArray()) { // Itera sobre cada carácter del texto cifrado.
            if (allCharacters.indexOf(c) != -1) { // Verifica si el carácter pertenece al conjunto soportado.
                int originalPos = allCharacters.indexOf(c); // Obtiene la posición original del carácter.
                int newPos = (originalPos - shift) % allCharacters.length(); // Calcula la nueva posición invirtiendo el desplazamiento.
                if (newPos < 0) { // Ajusta la posición si es negativa.
                    newPos += allCharacters.length();
                }
                plaintext.append(allCharacters.charAt(newPos)); // Añade el carácter descifrado al resultado.
            } else {
                plaintext.append(c); // Añade el carácter sin cambios si no está soportado.
            }
        }
        
        return plaintext.toString(); // Devuelve el texto descifrado.
    }
}






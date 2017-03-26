/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author ferchs
 */
public class Criptografia {
    
    private static final String ALGO = "AES";
    
    private static final byte[] keyValue = new byte[] { 'W', 'e', 'b', '$', '0', 'f', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    
    public static String cifrar(String data){
        try{
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(data.getBytes());
            String valorEncriptado = new BASE64Encoder().encode(encVal);
            return valorEncriptado;
            }
            catch(Exception e){
            return null;
            }
    }
    
    public static String descifar(String data){
         try{
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
            byte[] decValue = c.doFinal(decordedValue);
            String decryptedValue = new String(decValue);
            return decryptedValue;
            }
            catch(Exception e){
            return null;
            }
    }
    
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}

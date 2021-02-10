/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 * 
 * Se http://www.braingle.com/brainteasers/codes/keyword.php for andre cripers.
 */
public interface CipherInterface {
    

    char[] ALPHABETH = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F'
            , 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M'
            , 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T'
            , 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};
    
    String encrypt(String original);
    String decrypt(String encrypted);
    
//    boolean writeToFile(String message, String fileName); 
//    String readFromFile(String fileName);
    
}

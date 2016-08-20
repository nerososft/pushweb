package org.twtpush.util.Random;


/**
 * Created by nero on 16-8-19.
 */
public class RandomString {

    private final String seeds="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+~";

    public String getRandomString(long length){
        String randomString="";
        for(int i = 0; i< length; i++){
            int randomPos =(int)(Math.random() * seeds.length());
            randomString+=seeds.substring(randomPos,randomPos+1);
        }
        return randomString;
    }
}

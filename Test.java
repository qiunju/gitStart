

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.base.Preconditions;

import sun.misc.BASE64Decoder;

/**
 * 
 */
public class Test {
    
    private static SecureRandom random = new SecureRandom();
    
    public static void main(String[] args) {
///////////////////////////////////////////////////////////////////////////////////
//        Calendar cal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        cal.set(Calendar.YEAR, 9999);
//        cal.set(Calendar.MONTH, Calendar.DECEMBER);
//        cal.set(Calendar.DATE, 31);
//        cal.set(Calendar.HOUR_OF_DAY, 23);
//        cal.set(Calendar.MINUTE, 59);
//        cal.set(Calendar.SECOND, 59);
//        cal.set(Calendar.MILLISECOND, 999);
//        
//        System.out.println(new java.sql.Timestamp(cal.getTimeInMillis()));

///////////////////////////////////////////////////////////////////////////////////
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        
//        System.out.println(StringUtils.join(list, ","));

///////////////////////////////////////////////////////////////////////////////////
//        List<String> baseSkus = new ArrayList<>(4);
//        baseSkus.add("stg-search-api-user01");
//        baseSkus.add("dev-search-api-user01");
//        baseSkus.add("63do%VTod");
//        
//        for (int i = 0; i < baseSkus.size(); i++) {
//            System.out.println(StringEncrypter.encrypt(baseSkus.get(i)));
//        }

///////////////////////////////////////////////////////////////////////////////////
      //  int i = randInt(5, 10);
      //  System.out.println(i);

///////////////////////////////////////////////////////////////////////////////////
//        // method 1: given CharArray and length, using charAt
//        System.out.println(RandomString(5));
//      
//        // method 2: using ASCII reverting to String
//        System.out.println(RandomString2(5));
//      
//        // method 3: using SecureRandom, expensive
//        System.out.println(nextSessionId());
//        
//        // method 4: using RandomStringUtils
//        System.out.println(RandomStringUtils.random(5, 0, 62, true, true, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()));

///////////////////////////////////////////////////////////////////////////////////
        
    }

 // ========================= generating random random AlphaNumeric ===========================
//    public static String RandomString(int length) {
//        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuffer buf = new StringBuffer();
//
//        for (int i = 0; i < length; i++) {
//            int num = (int) (Math.random() * str.length());
//            buf.append(str.charAt(num));
//        }
//
//        return buf.toString();
//    }
//    
//    public static String RandomString2(int length) {
//        Random random = new Random();
//        StringBuffer sf = new StringBuffer();
//        for (int i = 0; i < length; i++) {
//            int number = random.nextInt(3);
//            long result = 0;
//
//            switch (number) {
//                case 0:
//                    result = Math.round(Math.random() * 25 + 65);
//                    sf.append(String.valueOf((char) result));
//                    break;
//                case 1:
//                    result = Math.round(Math.random() * 25 + 97);
//                    sf.append(String.valueOf((char) result));
//                    break;
//                case 2:
//                    sf.append(String.valueOf(new Random().nextInt(10)));
//                    break;
//
//            }
//        }
//
//        return sf.toString();
//    }
//    
//    public static String nextSessionId() {
//        return new BigInteger(25, random).toString(32);
//    }

// ========================= generating random integers in a specific range ===========================
//    public static int randInt(int min, int max) {
//        
//        Random rand = new Random();
//        int randomNum = rand.nextInt((max - min) + 1) + min;
//     
//        return randomNum;
//    }

// =========================== for threadlocal not available both in producer and consumer ====================
    
//    static final Map<String,String> test = new HashMap<>();
//    static final ThreadLocal<Map<String,String>> productErrors = new ThreadLocal<Map<String,String>>(){
//
//        @Override
//        protected Map<String,String> initialValue(){
//            return test;
//        }
//
//    };
//
//    public static void main(String[] argus) {
//
//        final ExecutorService executor = Executors.newFixedThreadPool(2);
//        final BlockingQueue<Future<Void>> queue = new LinkedBlockingDeque<Future<Void>>(10); 
////        final CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor);
//        final CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor, queue);
//        final AtomicInteger incRef = new AtomicInteger(0);
//        final int numOfRun = 2;
//        try {
//            for (int i = 0; i < numOfRun; i++) {
//                completionService.submit(new Callable<Void>() {
//                    public Void call() throws Exception {
//                        final String key = "key_" + incRef.incrementAndGet();
//                        final String value = "value_" + Thread.currentThread().getName();
//                        productErrors.get().put(key, value);
//                        System.out.println(productErrors.get());
//                        return null;
//                    }
//                });
//            }
//
//
//            for (int i = 0; i < numOfRun; i++) {
//                try {
//                    completionService.take().get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            System.out.println(productErrors.get());
//
//        } finally {
//            executor.shutdownNow();
//        }
//
//    }
}

class StringEncrypter {

    
    private static final String ENCRYPTION_KEY="d41dc86d-806f-40f1-8d11-2d7494853c4b";
    private static SecretKey desKey;

    public static String encrypt(String value)
    {
            Preconditions.checkNotNull(value, "Value cannot be null");

            try {
                    Cipher ecipher = Cipher.getInstance("DES");
                    ecipher.init(Cipher.ENCRYPT_MODE, desKey);
                    byte[] valueBytes = value.getBytes();

                    // Encrypt
                    byte[] encryptedBytes = ecipher.doFinal(valueBytes);

                    // Encode bytes to base64 to get a string
                    sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
                    return base64Encoder.encode(encryptedBytes);
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
                    throw new IllegalStateException("Unable to encrypt", e);
            }
    }

    public static String decrypt(String value) {
            Preconditions.checkNotNull(value, "Value cannot be null");

            try {

                    // Decode string from base64 to get a byte[]
                    BASE64Decoder base64Decoder = new BASE64Decoder();
                    final byte[] bytes = base64Decoder.decodeBuffer(value);

                    Cipher ecipher = Cipher.getInstance("DES");
                    ecipher.init(Cipher.DECRYPT_MODE, desKey);

                    // Decrypt
                    byte[] decryptedBytes = ecipher.doFinal(bytes);

                    return new String(decryptedBytes);
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | IOException e) {
                    throw new IllegalStateException("Unable to decrypt", e);
            }
    }

    static {
            try {
                    DESKeySpec dks = new DESKeySpec(ENCRYPTION_KEY.getBytes());
                    SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
                    desKey = skf.generateSecret(dks);
            } catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException e) {
                    throw new IllegalStateException("Unable to initialize crypto key", e);
            }
    }



}

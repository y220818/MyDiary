package com.ace.blue;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import junit.framework.Assert;

public class TestKK {

	@Test
	public void givenPassword_whenHashing_thenVerifying() 
	  throws NoSuchAlgorithmException {
	    String hash = "35454B055CC325EA1AF2126E27707052";
	    String password = "ILoveJava";
	        
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter
	      .printHexBinary(digest).toUpperCase();
	        
	    System.out.println(myHash);
	    System.out.println(myHash.equals(hash));
	}
}

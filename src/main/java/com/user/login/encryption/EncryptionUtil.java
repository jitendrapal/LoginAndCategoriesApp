package com.user.login.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptionUtil {
	private static StandardPBEStringEncryptor encryptor = null;

	static {
		encryptor = new StandardPBEStringEncryptor();
		encryptor.setProvider(new BouncyCastleProvider());
		encryptor.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
		encryptor.setPassword("sogeti");
	}

	/**
	 * This method returns decrypted password.
	 * 
	 * @param encryptedMessage Encrypted password is sent for decryption.
	 * @return String The decrypted password
	 */
	public static String decrypt(String encryptedMessage) {
		return encryptor.decrypt(encryptedMessage);
	}

}

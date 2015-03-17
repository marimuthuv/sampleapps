<?php

/**
 * OAuth OAuthSignatureMethod_RSA_SHA1_impl signature implementation 
 * 
 */


require_once dirname(__FILE__).'/OAuth.php';

class OAuthSignatureMethod_RSA_SHA1_impl extends OAuthSignatureMethod_RSA_SHA1
{
	public function name() 
	{
		return 'RSA-SHA1';
	}
	
	/**
	 * Fetch the public CERT key for the signature
	 * 
	 * @param OAuthRequest request
	 * @return string public key
	 */
	protected function fetch_public_cert ( &$request )
	{
		throw OAuthException("OAuthSignatureMethod_RSA_SHA1::fetch_public_cert not implemented");
	}
	
	
	/**
	 * Fetch the private CERT key for the signature
	 * 
	 * @param OAuthRequest request
	 * @return string private key
	 */
	protected function fetch_private_cert (&$request )
	{

			$passphrase = 'replace-this-withp12-cert-password';
    	    $pkcs12 = file_get_contents( "replace-this-with-pl2-filename" );	
			$certs = array();
    		if (!openssl_pkcs12_read($pkcs12, $certs, $passphrase)) {
      			throw new OAuthException("Unable to parse the p12 file.  " .
          		"Is this a .p12 file?  Is the password correct?  OpenSSL error: ".openssl_error_string());
    		}

    		if (!array_key_exists("pkey", $certs) || !$certs["pkey"]) {
      			throw new OAuthException("No private key found in p12 file.");
    		}
    		$privateKey = openssl_pkey_get_private($certs["pkey"]);
    		if (!$privateKey) {
      			throw new OAuthException("Unable to load private key in ");
		}	
		return $privateKey;
	}
}


?>

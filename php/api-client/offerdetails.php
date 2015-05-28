<?php
require_once 'config.php';

$offer_id = $_GET['offer_id'];
$url = $detail_url . $offer_id;

$request = OAuthRequest::from_consumer_and_token($consumer, NULL, 'GET', $url, NULL);
$request->sign_request(new OAuthSignatureMethod_RSA_SHA1_impl(), $consumer, NULL);

$curl = curl_init($url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($curl, CURLOPT_FAILONERROR, false);
curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($curl, CURLOPT_HTTPHEADER, array($request->to_header()));

Header('Content-type: text/xml');
echo $response = curl_exec($curl);

?>


<?php
require_once 'config.php';

$data = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><OfferSearchCriteria><Tag>GOATMAY2015</Tag></OfferSearchCriteria>';
$dataHash = base64_encode(sha1($data, TRUE)); 

$request = OAuthRequest::from_consumer_and_token($consumer, NULL, 'POST', $search_url, array('oauth_body_hash' => $dataHash));
$request->sign_request(new OAuthSignatureMethod_RSA_SHA1_impl(), $consumer, NULL);
$header = array_merge(array($request->to_header()),array("Content-Type: application/xml"));

$ch = curl_init($search_url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

Header('Content-type: text/xml');
echo $response = curl_exec($ch);
?>

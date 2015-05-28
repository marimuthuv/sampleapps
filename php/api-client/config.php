<?php
require_once 'OAuth.php';
require_once 'OAuthRsaSha1.php';

$consumer_key     = 'your consumer key';
$consumer_secret  = 'your .p12 password';
//for Prod : base_url = https://api.mastercard.com/eop/offer/v1/
//for Sand box : base_url = https://sandbox.api.mastercard.com/eop/offer/v1/
$base_url         = 'https://sandbox.api.mastercard.com/eop/offer/v1/';
$search_url       = $base_url . "search";
$detail_url       = $base_url . "detail/";
$consumer         = new OAuthConsumer($consumer_key,$consumer_secret);

?>
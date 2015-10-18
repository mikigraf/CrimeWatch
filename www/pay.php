<?php
require_once('braintree-php-3.5.0/lib/Braintree.php');

Braintree_Configuration::environment('sandbox');

Braintree_Configuration::merchantId('wzgwhjx9djykmyty');
Braintree_Configuration::publicKey('m2g7bhw99gbydrqh');
Braintree_Configuration::privateKey('300db931c84fcaf9c3e0a17edc7b16cb');

$result = Braintree_Transaction::sale([
  'amount'		=> '10.00',
  'paymentMethodNonce'	=> $_POST['payment_method_nonce']
]);

if($result->success) echo 'Erfolg :) Betrag: '.$result->transaction->amount.' '. $result->transaction->currencyIsoCode.'.';
else echo 'Fehler :(.';

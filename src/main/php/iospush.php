<?php

// Put your device token here (without spaces):
//$deviceToken = '078dc8ec049a50601f4ba77ad090ef75f612edd2c4c578c0ac2ff2eb49b113af';
$deviceToken = '1c299256427d2c7d787fe4dc3932e125bf6522ded0dc071b9db5304c0392e401';

// Put your private key's passphrase here:
$passphrase = '123456789';

// Put your alert message here:
$message['title'] = 'this is a title';
$message['body'] = '!!!this is a body!!!!';
//$message['action-loc-key'] = "greeting";
	//$message['action-local-key'] = null;
////////////////////////////////////////////////////////////////////////////////

$ctx = stream_context_create();
stream_context_set_option($ctx, 'ssl', 'local_cert', 'ck.pem');
stream_context_set_option($ctx, 'ssl', 'passphrase', $passphrase);

// Open a connection to the APNS server
$fp = stream_socket_client(
	'ssl://gateway.sandbox.push.apple.com:2195', $err,
	$errstr, 60, STREAM_CLIENT_CONNECT|STREAM_CLIENT_PERSISTENT, $ctx);

if (!$fp)
	exit("Failed to connect: $err $errstr" . PHP_EOL);

echo 'Connected to APNS' . PHP_EOL;

// Create the payload body
$body['aps'] = array(
	'alert' => $message,
	'sound' => 'default',
	'category' => "Invite"
);

$body['info'] = array(
	'string' => 'best try'
);


// Encode the payload as JSON
$payload = json_encode($body);

// Build the binary notification
$msg = chr(0) . pack('n', 32) . pack('H*', $deviceToken) . pack('n', strlen($payload)) . $payload;

// Send it to the server
$result = fwrite($fp, $msg, strlen($msg));

if (!$result)
	echo 'Message not delivered' . PHP_EOL;
else
	echo 'Message successfully delivered' . PHP_EOL;

// Close the connection to the server
fclose($fp);

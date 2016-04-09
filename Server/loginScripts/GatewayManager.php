<?php
	class GatewayManager {
		$table;

		private const $credential_mismatch_message = "Credentials do not match, please try again.";
		private const $connection_failed_message = "Connection went wrong, please try again.";
		private const $unexpected_error_message = "An unexpected error occured, please try again."

		function __construct() {
			$db = mysqli_connect("ericshiao.me", "ericineo_FABase","BaseBase1","ericineo_foodAround");
			$table = "userAuth";
		} 

		function __construct($type) {
			if ($type == "admin") {
				$db = mysqli_connect("ericshiao.me", "ericshiao_FABase","AdminAdmin1","ericineo_foodAround");
				$table = "adminAuth";
			}
		}

		function authenticate() {
			$success = false;
			$fail_message;
			if ($db) {
				if (checkCredentials($authencation_link)) {
					$session = session_start(oid);
					if ($session) {
						$success = true;
					} else { //fail to create a session
						$fail_message = $unexpected_error_message;
					}
				} else { //fail authentication
					$fail_message = $credential_mismatch_message;	
				}
			} else { //fail to connect to the DB
				$fail_message = $connection_failed_message;
			}

			if ($success) {
				echo "Login Successful";
			} else {
				echo json_encode($fail_message);
			}
			exit; 
		}

		private function checkCredentials($sql_link) {
			$ret = false;
			if (isset($_POST["test"])) {
        		$hash = hash("md5", $password);
        		$query = "SELECT * FROM $table WHERE username=$username AND password=$hash";
        		$result = $db_link -> mysqli_query($query);
        		if (mysql_num_rows($result) == 1) {
        			$ret = true;
        		} else {
        			$ret = false;
        		}
			}
			return $ret;
		}
	}
?>
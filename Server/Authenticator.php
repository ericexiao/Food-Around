<?php 
	//illegal access redirect barrier OR begin checking the credentials
	if (isset($_POST["username"]) && isset($_POST["password"])) {
		header("Location: ericshiao.me/foodAround/index.html");
	} else {
		$a = new Authenticator($_POST["username"], $_POST["password"]));
		$a -> authenticate();
	}

	class Authenticator {
		private $username;
		private $password;
		private $db_link;
		//Error messages for user interface in case of error
		private const $credential_mismatch_message = "Credentials do not match, please try again.";
		private const $connection_failed_message = "Connection went wrong, please try again.";
		private const $unexpected_error_message = "An unexpected error occured, please try again."

		public function __construct($postUser, $postPassword) {
			$username = $postUser;
			$password = $postPassword;
		}

		//wrapper function for authentication + returns message to the AJAX call. 
		public function authenticate() {
			$success = false;
			$fail_message;
			$db_link=mysqli_connect("ericshiao.me", "ericshiao_foodAround","","ericshiao_authOnly"); //TODO: use file extraction for username password 
			if (!$authencation_link) {
				$fail_message = $connection_failed_message;
			} else {
				if (!checkCredentials($authencation_link)) {
					$fail_message = $credential_mismatch_message;	
				} else {
					$session = session_start(oid);
					if (!$session) {
						$fail_message = $unexpected_error_message;
					} else {
						$success = true;
					}
				}
			}

			if ($success) {
				echo "Login Successful";
			} else {
				echo $fail_message;
			}
			exit; 
		}

		//function logs into the authentication table as a user with limited permissions and checks the admin user table. 
		private function checkCredentials($sql_link) {
			$ret = false;
			if (isset($_POST["test"])) {
        		$hash = hash("md5", $password);
        		$query = "SELECT * FROM adminAuth WHERE username=$username AND password=$hash";
        		$result = $db_link -> mysqli_query($query);
        		//$result = $run_query -> fetch_array();
        		if (mysql_num_rows($result) == 1) {
        			$ret = true;
        		} else if (mysql_num_rows($result) == 0) {

        		} else {
        			echo("ERROR");
        		}
			}
		}
	}
?> 

<?php
	session_unset();
	$match =  false;
	if (isset($_POST["user"]) and isset($_POST["password"])) {
		if ($_POST["user"] != null and $_POST["password"] != null) {
			$db = new mysqli('stardock.cs.virginia.edu', "cs4750es2py", "windshear1", 'cs4750es2py');
			$user = $_POST["user"]; 
			$password = $_POST["password"]; 
			$password = hash('md5', $password);
			$loginQuery = "select * from userLogin";
			$userResult = $db -> query($loginQuery);
			$userInfo = $userResult -> fetch_array();
			while ($userInfo) {
				if (($userInfo[1] == $user) and ($userInfo[2] == $password)) {
					$match = true;
					break;
				}
				$userInfo = $userResult -> fetch_array();
			}
			if($match == true) {
				session_start();
				$_SESSION["user"] = $user;
				$_SESSION["userID"] = $userInfo[0];
				//$accountQuery = "select type from login natural join accounts where username = '$user'";
				//$accountCheck = $db -> query($accountQuery);
				//$accountInfo = $accountCheck -> fetch_array();
				echo("success");
				exit();
			} else {
				echo("Incorrect username or password, please try again");
			}
		} 
		$db = null;
	} else { 
		header("Location: index.html");
	}
?>
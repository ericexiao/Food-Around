<?php
	require "BaseSQLManager.php"
	
	//class that manages the storing and retrieval of data into the MySQL database for admin purposes. 
	class SQLAdminManager extends BaseSQLManager {
		private final $password = " ";
		private $valid = false;
		function __construct($input) {
			if ($input === $password) {
				$valid = true;
			} else {
				$valid = false;
			}
		}

		//creates the query for creating a restaurant table in the database
		private function createRestarauntTableQuery($tableName) {

		}

		//creates the query for creating a menu table in the database
		private function createMenuTableQuery($tableName) {
			$query = ""
			$result = mysql_query($query);
		}

		//creates the query for inserting the line/menuItem into the table
		private function insertQuery($menuArray, $tableName) {

		}

		private function checkInformationSchema() {
			$query = "";
			$result = mysql_query($query);
			if 
		}

		//retrieves all data from a table. 
		function selectTableQuery() {

		}
?>
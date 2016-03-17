<?php
	require "BaseSQLManager.php"
	
	//class that manages the storing and retrieval of data into the MySQL database for admin purposes. 
	public class SQLAdminManager extends BaseSQLManager {
		private final $password = " ";
		private $valid = false;

		public function __construct() {

		}

		public function __construct($input) {
			if ($input === $password) {
				$valid = true;
			} else {
				$valid = false;
			}
		}

		public function createRestaurant($restaurantName, $menuArray, $infoArray) {
			$successArray = array(false, false, false);
			$infoTable = $this -> generateInfoTableName($restaurantName);
			$menuTable = $this -> generateMenuTableName($restaurantName);

			$successArray[1] = createtInfoTable($infoTable, $infoArray);
			$successArray[2] = createtMenuTable($menuTable, $menuArray);

			$successArray[0] = ($successArray[1] && $successArray[2]);
			return $successArray;
		}

		private function generateInfoTableName($restaurantName) {
			return $restaurantName + " Info";
		}

		private function generateMenuTableName($restaurantName) {
			return $restaurantName + " Menu";
		}

		//creates the query for creating a restaurant table in the database
		private function createInfoTable($tableName) {

		}

		//creates the query for creating a menu table in the database
		private function createtMenuTable($tableName) {
			$query = "";
			$result = mysql_query($query);
		}

		//inserts query for into the table
		private function insertInfoQuery($menuArray, $tableName) {

		}

		//creates the query for inserting the line/menuItem into the table
		private function insertMenuQuery($menuArray, $tableName) {

		}

		private function checkTableExistence() {
			$query = "";
			$result = mysql_query($query);
			if 
		}
?>
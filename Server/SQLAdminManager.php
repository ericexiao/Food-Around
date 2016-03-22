<?php
	require "BaseSQLManager.php"
	
	//class that manages the storing and retrieval of data into the MySQL database for admin purposes. 
	public class SQLAdminManager extends BaseSQLManager {
		private final $password = " ";
		private $valid = false;

		public function __construct() {
			$valid = true;
		}

		public function createRestaurant($restaurantName, $menuArray, $infoArray) {
			$successArray = array(false, false, false, false);
			$infoTable = $this -> generateInfoTableName($restaurantName);
			$menuTable = $this -> generateMenuTableName($restaurantName);

			$successArray[1] = insertMetadata($restaurantName, $infoTable, $menuTable)
			$successArray[2] = createtInfoTable($infoTable, $infoArray);
			$successArray[3] = createtMenuTable($menuTable, $menuArray);

			$successArray[0] = ($successArray[1] && $successArray[2] $successArray[3]);
			return $successArray;
		}

		private function generateInfoTableName($restaurantName) {
			return $restaurantName + " Info";
		}

		private function generateMenuTableName($restaurantName) {
			return $restaurantName + " Menu";
		}

		private function insertMetadata($restaurantName, $infoTable, $menuTable) {
			$query = "INSERT INTO '$metaDB' (Restaurant, InfoTable, MenuTable) VALUES ($restaurantName, $infoTable, $menuTable)";
			$result = mysqli_query($query);
			return $result; 
		}

		//creates the query for creating a restaurant table in the database
		private function createInfoTable($tableName) {
			$query = "CREATE TABLE IF NOT EXISTS '$tableName' (
					Name varchar(255) NOT NULL,
					Location varchar(255),
					Times varchar(255),
					Courses varchar(255),
					PRIMARY KEY (Name)
				)";
			$result = mysqli_query()
		}

		//creates the query for creating a menu table in the database
		private function createtMenuTable($tableName) {
			$query = "CREATE TABLE IF NOT EXISTS '$tableName' (
				ID int NOT NULL AUTO_INCREMENT,
				Name varchar(255) NOT NULL,
				Course varchar(255),
				Price varchar(255) NOT NULL,
				Eaten int NOT NULL,
				Rating int,
				PRIMARY KEY (ID)
			)";
			$result = mysqli_query($query);
			return $result;
		}

		//inserts query for into the table
		private function insertInfoArray($infoArray, $tableName) {//Name, Location, Time (Array as String), Courses (Array as String)
			$query = "INSERT INTO '$tableName' (Name, Location, Time, Courses) VALUES ($infoArray[0], $infoArray[1], $infoArray[2], $infoArray[3])";
			$result = mysqli_query($query);
			return $result;
		}

		//creates the query for inserting the line/menuItem into the table
		private function insertMenuArray($menuArray, $tableName) { //ID, Name, Course, Price, Eaten, Rating
			$query = "INSERT INTO '$tableName' (ID, Name, Course, Price, Eaten, Rating) VALUES (null, $menuArray[0], $menuArray[1], $menuArray[2], $menuArray[3], $menuArray[4])";
			$result = mysqli_query($query);
			return $result;
		}	
?>
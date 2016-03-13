<?php

	//class that manages the storing and retrieval of data into the MySQL database. 
	class FileConverter {
		//wrapper function for reading in a menu in the form of a file and inserting it into a SQL table from scratch
		function convertMenuFileToTable($filename, $tableName) {
			$path = "Menus";
			$filepath = $path . DIRECTORY_SEPARATOR . "$filename";
			$file = fopen($filepath, "r");
			
			if ($file) {
				echo("Converting $fileName into $tableName <br>");
				//create table

				while ($line = fgets($file)) {
					$menuItem =  split("::", $line);
					foreach ($menuItem as $menuDetail) {
						echo($menuDetail . "<br>");
					}
					//split, create query, execute query
					//$query = "INSERT INTO $tableName";
				} 
				fclose($file);
				return true;
			} else {
				return false;
			}
		}

		//creates the query for creating a table in the database
		private function createTable($tableName) {

		}

		//creates the query for inserting the line/menuItem into the table
		private function insertIntoTable($menuArray, $tableName) {

		}

		//retrieves all data from a table. 
		function selectTable() {

		}
?>
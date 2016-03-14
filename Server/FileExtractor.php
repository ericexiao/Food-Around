<?php
	//class that manages the storing and retrieval of data into the MySQL database. 
	class FileExtractor {
		function __construct() {

		}

		//return array of arrays of menu data
		function extractMenu($filename) {
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

		//return an array converted from the text file for insertion into SQL 
		function extractInfo() {
			$path = "Restaurants";
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
?>
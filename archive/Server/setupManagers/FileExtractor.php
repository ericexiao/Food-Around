<?php
	//class that manages the storing and retrieval of data into the MySQL database. 
	class FileExtractor {
		function __construct() {

		}

		//return array of arrays of menu data converted from a txt file. if something goes wrong, return array with error data.
		function extractMenu($filename) {
			$path = "Menus";
			$filepath = $path . DIRECTORY_SEPARATOR . "$filename";
			$file = fopen($filepath, "r");
			$dataArray = array();

			if ($file) {
				while ($line = fgets($file)) {
					$insert = array();
					$menuItem =  split("::", $line);
					foreach ($menuItem as $menuDetail) {
						echo($menuDetail . "<br>");
						$insert[] = $menuDetail;
					}
					$dataArray[] = $insert;
				} 
				fclose($file);
				return $dataArray;
			} else {
				return array("File Extraction", "Menus", $filename, $file);
			}
		}

		//return an array converted from the restaurant info in a txt file. If something goes wrong, return array with error data. 
		function extractInfo() {
			$path = "Restaurants";
			$filepath = $path . DIRECTORY_SEPARATOR . "$filename";
			$file = fopen($filepath, "r");
			$dataArray = array();

			if ($file) {
				while ($line = fgets($file)) {
					$insert = array();
					$restaurantInfo =  split("::", $line);
					foreach ($restaurantInfo as $restaurantDetail) {
						echo($menuDetail . "<br>");
						$insert[] = $restaurantDetail;
					}
					$dataArray[] = $insert;
				} 
				fclose($file);
				return $dataArray;
			} else {
				return array("File Extraction", "Restaurants", $filename, $file);
		}
?>
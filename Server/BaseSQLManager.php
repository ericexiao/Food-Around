<?php

	//class that manages the storing and retrieval of data into the MySQL database for admin purposes. 
	abstract class BaseSQLManager {
		private $db; 

		//retrieves all data from a table. 
		protected function selectTable($tableName) {

		}

		//update an entry in a table
		protected function updateRow($tableName, $columnName, $rowID, $info) {

		}
?>
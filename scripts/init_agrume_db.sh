#!/bin/bash

SQL_DIR="./src/main/resources/sql"

#define DB schema
cat $SQL_DIR/agrume_db_schema.sql | sudo docker exec -i agrume-mysql-db mysql -u root -padmin agrume_db
#insert db values
cat $SQL_DIR/agrume_db_values.sql | sudo docker exec -i agrume-mysql-db mysql -u root -padmin agrume_db

#test query
sudo docker exec -i agrume-mysql-db mysql -u root -padmin agrume_db -e "SELECT * FROM campus;"

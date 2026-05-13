#!/bin/bash
cd ~/Desktop/Smart_Inventory_System
mvn clean compile
cp -r src/main/resources/com/NexStock/images target/classes/com/NexStock/
cp src/main/resources/com/NexStock/view/createAccount.fxml target/classes/com/NexStock/view/
mvn javafx:run

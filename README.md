# Smart_Inventory_System

## Directory Structure

.
├── bills.txt
├── demo
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   │   └── main
│   │       ├── java
│   │       │   ├── module-info.java
│   │       │   └── src
│   │       │       └── demo
│   │       │           ├── HelloApplication.java
│   │       │           └── HelloController.java
│   │       └── resources
│   │           └── src
│   │               └── demo
│   │                   └── hello-view.fxml
│   └── target
│       ├── classes
│       │   ├── module-info.class
│       │   └── src
│       │       └── demo
│       │           ├── HelloApplication.class
│       │           ├── HelloController.class
│       │           └── hello-view.fxml
│       ├── demo-1.0-SNAPSHOT.jar
│       ├── generated-sources
│       │   └── annotations
│       ├── maven-archiver
│       │   └── pom.properties
│       └── maven-status
│           └── maven-compiler-plugin
│               └── compile
│                   └── default-compile
│                       ├── createdFiles.lst
│                       └── inputFiles.lst
├── out
│   └── production
│       └── Smart_Inventory_System
│           ├── com
│           │   └── NexStock
│           │       ├── controller
│           │       │   └── SceneNewController.class
│           │       ├── images
│           │       │   ├── at-sign.png
│           │       │   ├── ChatGPT Image May 12, 2026, 05_46_05 PM.png
│           │       │   ├── hide.png
│           │       │   ├── Logo.png
│           │       │   ├── mail.png
│           │       │   ├── search.png
│           │       │   └── user.png
│           │       ├── MainApp.class
│           │       ├── model
│           │       │   ├── Admin.class
│           │       │   ├── Customer.class
│           │       │   ├── DiscountStrategy.class
│           │       │   ├── InvoiceItem.class
│           │       │   ├── Product.class
│           │       │   ├── StockObserver.class
│           │       │   ├── Transaction.class
│           │       │   ├── User$role.class
│           │       │   └── User.class
│           │       ├── products
│           │       │   ├── Accessory.class
│           │       │   ├── Clothing.class
│           │       │   ├── Crockery.class
│           │       │   ├── Electronics.class
│           │       │   ├── Furniture.class
│           │       │   └── Grocery.class
│           │       ├── security
│           │       │   ├── Password_Generator.class
│           │       │   ├── Password_Hasher.class
│           │       │   └── passwrod_generator.class
│           │       └── view
│           │           └── createAccount.fxml
│           └── main
│               └── resources
│                   └── com
│                       └── NexStock
│                           ├── images
│                           │   ├── at-sign.png
│                           │   ├── ChatGPT Image May 12, 2026, 05_46_05 PM.png
│                           │   ├── hide.png
│                           │   ├── Logo.png
│                           │   ├── mail.png
│                           │   ├── search.png
│                           │   └── user.png
│                           └── view
│                               └── createAccount.fxml
├── pom.xml
├── Products.txt
├── README.md
├── run.sh
├── Smart_Inventory_System.iml
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── NexStock
│       │           ├── controller
│       │           │   ├── addProductcontroller.java
│       │           │   ├── addUser.java
│       │           │   ├── categorycontroller.java
│       │           │   ├── ChangePasswordController.java
│       │           │   ├── createAccount.java
│       │           │   ├── dashboardCashier.java
│       │           │   ├── dashboardcontroller.java
│       │           │   ├── LoginController.java
│       │           │   ├── ReportController.java
│       │           │   └── Sceneswitches.java
│       │           ├── FileHandler
│       │           │   └── fileIO.java
│       │           ├── MainApp.java
│       │           ├── model
│       │           │   ├── Admin.java
│       │           │   ├── Cashier.java
│       │           │   ├── Customer.java
│       │           │   ├── DiscountStrategy.java
│       │           │   ├── InvoiceItem.java
│       │           │   ├── Product.java
│       │           │   ├── StockObserver.java
│       │           │   ├── Transaction.java
│       │           │   └── User.java
│       │           ├── products
│       │           │   ├── Accessory.java
│       │           │   ├── Clothing.java
│       │           │   ├── Crockery.java
│       │           │   ├── Electronics.java
│       │           │   ├── Furniture.java
│       │           │   └── Grocery.java
│       │           ├── report
│       │           │   ├── ReportFormatter.java
│       │           │   └── ReportManager.java
│       │           └── security
│       │               ├── BruteForce_Detector.java
│       │               ├── Password_Generator.java
│       │               └── Password_Hasher.java
│       └── resources
│           └── com
│               └── NexStock
│                   ├── css
│                   ├── images
│                   │   ├── 2.png
│                   │   ├── at-sign.png
│                   │   ├── bill.jpeg
│                   │   ├── category.png
│                   │   ├── ChatGPT Image May 12, 2026, 05_46_05 PM.png
│                   │   ├── ChatGPT Image May 13, 2026, 06_38_20 PM.png
│                   │   ├── ChatGPT Image May 14, 2026, 07_19_41 PM.png
│                   │   ├── checklist.gif
│                   │   ├── graph.png
│                   │   ├── hide.png
│                   │   ├── history.jpeg
│                   │   ├── icons8-home-50.png
│                   │   ├── icons8-home.gif
│                   │   ├── icons8-logout-50.png
│                   │   ├── icons8-logout.gif
│                   │   ├── icons8-product-50.png
│                   │   ├── icons8-product.gif
│                   │   ├── increase.png
│                   │   ├── logo name.png
│                   │   ├── Logo.png
│                   │   ├── mail.png
│                   │   ├── menu.png
│                   │   ├── modern logo.png
│                   │   ├── postman.gif
│                   │   ├── product-catalog.png
│                   │   ├── product-description.png
│                   │   ├── sales.png
│                   │   ├── search.png
│                   │   ├── supplier.png
│                   │   ├── user.gif
│                   │   ├── user.png
│                   │   ├── WhatsApp Image 2026-05-18 at 10.50.50 PM (3).jpeg
│                   │   ├── WhatsApp Image 2026-05-18 at 10.50.50 PM (4).jpeg
│                   │   └── WhatsApp Image 2026-05-18 at 10.50.50 PM (5).jpeg
│                   └── view
│                       ├── addProduct.fxml
│                       ├── category.fxml
│                       ├── changePassword.fxml
│                       ├── createAccount.fxml
│                       ├── Dashboard_Cashier.fxml
│                       ├── Dashboard.fxml
│                       ├── login.fxml
│                       └── report.fxml
├── target
│   ├── classes
│   │   └── com
│   │       └── NexStock
│   │           ├── controller
│   │           ├── FileHandler
│   │           ├── images
│   │           │   ├── 2.png
│   │           │   ├── at-sign.png
│   │           │   ├── bill.jpeg
│   │           │   ├── category.png
│   │           │   ├── ChatGPT Image May 12, 2026, 05_46_05 PM.png
│   │           │   ├── ChatGPT Image May 13, 2026, 06_38_20 PM.png
│   │           │   ├── ChatGPT Image May 14, 2026, 07_19_41 PM.png
│   │           │   ├── checklist.gif
│   │           │   ├── graph.png
│   │           │   ├── hide.png
│   │           │   ├── history.jpeg
│   │           │   ├── icons8-home-50.png
│   │           │   ├── icons8-home.gif
│   │           │   ├── icons8-logout-50.png
│   │           │   ├── icons8-logout.gif
│   │           │   ├── icons8-product-50.png
│   │           │   ├── icons8-product.gif
│   │           │   ├── increase.png
│   │           │   ├── logo name.png
│   │           │   ├── Logo.png
│   │           │   ├── mail.png
│   │           │   ├── menu.png
│   │           │   ├── modern logo.png
│   │           │   ├── postman.gif
│   │           │   ├── product-catalog.png
│   │           │   ├── product-description.png
│   │           │   ├── sales.png
│   │           │   ├── search.png
│   │           │   ├── supplier.png
│   │           │   ├── user.gif
│   │           │   ├── user.png
│   │           │   ├── WhatsApp Image 2026-05-18 at 10.50.50 PM (3).jpeg
│   │           │   ├── WhatsApp Image 2026-05-18 at 10.50.50 PM (4).jpeg
│   │           │   └── WhatsApp Image 2026-05-18 at 10.50.50 PM (5).jpeg
│   │           ├── model
│   │           ├── products
│   │           ├── report
│   │           ├── security
│   │           └── view
│   │               ├── addProduct.fxml
│   │               ├── category.fxml
│   │               ├── changePassword.fxml
│   │               ├── createAccount.fxml
│   │               ├── Dashboard_Cashier.fxml
│   │               ├── Dashboard.fxml
│   │               ├── login.fxml
│   │               └── report.fxml
│   ├── generated-sources
│   │   └── annotations
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       └── compile
│   │           └── default-compile
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   └── test-classes
└── User.txt

---

Actively Learning Student
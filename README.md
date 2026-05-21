Smart_Inventory_System/
│
├── Dockerfile
├── .dockerignore
├── pom.xml
├── README.md
├── run.sh
│
├── data/
│   ├── Products.txt
│   ├── User.txt
│   └── bills.txt
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── NexStock/
│       │           ├── MainApp.java
│       │           │
│       │           ├── controller/
│       │           │   ├── LoginController.java
│       │           │   ├── DashboardController.java
│       │           │   ├── ReportController.java
│       │           │   ├── AddUserController.java
│       │           │   ├── AddProductController.java
│       │           │   └── ...
│       │           │
│       │           ├── model/
│       │           │   ├── User.java
│       │           │   ├── Product.java
│       │           │   ├── Transaction.java
│       │           │   ├── Admin.java
│       │           │   └── ...
│       │           │
│       │           ├── products/
│       │           │   ├── Electronics.java
│       │           │   ├── Grocery.java
│       │           │   ├── Furniture.java
│       │           │   └── ...
│       │           │
│       │           ├── security/
│       │           │   ├── Password_Hasher.java
│       │           │   ├── Password_Generator.java
│       │           │   └── BruteForce_Detector.java
│       │           │
│       │           ├── report/
│       │           │   ├── ReportManager.java
│       │           │   └── ReportFormatter.java
│       │           │
│       │           ├── FileHandler/
│       │           │   └── fileIO.java
│       │           │
│       │           └── util/
│       │               ├── SceneSwitcher.java
│       │               └── Validator.java
│       │
│       └── resources/
│           └── com/
│               └── NexStock/
│                   ├── view/
│                   │   ├── login.fxml
│                   │   ├── Dashboard.fxml
│                   │   ├── addProduct.fxml
│                   │   └── ...
│                   │
│                   ├── css/
│                   │   └── style.css
│                   │
│                   └── images/
│                       ├── Logo.png
│                       ├── user.png
│                       └── ...
│
├── target/
│
└── .gitignore

import java.util.ArrayList;

class Product implements Comparable<Product>{

 private final String productID;
 private String  pdname;
private String category;
private double unitPrice;
private int  stockQuantity;
private int reorderlevel;
private String supplierName;
ArrayList <StockObserver> Observer;
static int count=0;



    public Product( String pdname, String category, double unitPrice, int stockQuantity, int reorderlevel, String supplierName) {
      count++;
        
      
      
       if (pdname==null){
        System.out.println("Invalid");
       } else {
        this.pdname = pdname;
       }
    

    this.category = category;

    String prefix = "";

    if (this.category.equals("Electronics")) {
        prefix = "EL";
    } 
    else if (this.category.equals("Food")) {
        prefix = "FD";
    } 
    else if (this.category.equals("Accessories")) {
        prefix = "AC";
    }

    this.productID = prefix + "00" + count;


      
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.reorderlevel = reorderlevel;
        this.supplierName = supplierName;
        this.Observer =new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

   

    public String getPdname() {
        return pdname;
    }

    public String getProductID() {
        return productID;
    }

    public int getReorderlevel() {
        return reorderlevel;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    

void addObserver(StockObserver other){

      Observer.add(other);

}

void deductsales(int stocksaled){

     stockQuantity-=stocksaled;

  System.out.println("Remaining Stock:"+stockQuantity);
   if (stockQuantity<5){
       notifyObserver();
   }
  

}
void notifyObserver(){

  for(StockObserver watcher:Observer){
        watcher.Notify();
  }

}
   
   //equals Method
//    boolean equals(Product other){

//      if (other instanceof Product){

//        Product obj=(Product) other;
            
//         return  this.pdname.equals(other.pdname);


//      }
  
//    }

       public  int compareTo(Product other){
           int result=this.pdname.compareToIgnoreCase(other.pdname);
     
        if(result==0){
        return     ((Double)this.unitPrice).compareTo(other.unitPrice);
        }
     
      return result;
        }

   }
        


    







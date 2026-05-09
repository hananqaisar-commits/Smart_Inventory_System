class Customer{

private String customerID;
private String customerName;
private String phoneNo;
private int loyaltyPoints;
private double totalspents;
static int count=0;

    public Customer( String customerName, String phoneNo, int loyaltyPoints, double totalspents) {
       
       if(customerName==null || customerName.trim().isEmpty()){
              System.out.println("Invalid");
        }   else {
        this.customerName = customerName;
           } 
         
           this.customerID = CustomerID_Generator();
       
       if(phoneNo.length()>11){
        System.out.println("Invalid");
       }  else {    
        this.phoneNo = phoneNo;
       }
    
       if(loyaltyPoints<0){
              System.out.println("Invalid");
       }     else {
        this.loyaltyPoints = loyaltyPoints;
       }
     
        if (totalspents<=0){
            System.out.println("Invalid Amount");
        }   else {
        this.totalspents = totalspents;
        }      
    }

public  String CustomerID_Generator(){
       return    String.format("%-2s%03d","CU",++count);
}

void addpoints(double amount){
          if (amount<=0){
            System.out.println("Invalid Amount");
          }
             else {
          loyaltyPoints+=((int)(amount/20));
             }
}


  double redeempoint(){
       double DiscountedAmount=0;
    if (loyaltyPoints>=500){
         DiscountedAmount= totalspents-(loyaltyPoints*20);
              loyaltyPoints-=loyaltyPoints;     
   }    else {
        System.out.println("Low Loyalty Points");
   }
              
            return DiscountedAmount;
  }


}
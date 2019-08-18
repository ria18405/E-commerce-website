//import static Mercury.al_merchant;

//slots-- when unique item found
//linking merchant obj to item and customer obj



import java.util.*;
import java.io.*;

public class Mercury {

    public static void main(String [] args){
        
        ArrayList <item> al_merchant=new ArrayList <item>(); 
        ArrayList <item> al_customer=new ArrayList <item>();
//        ArrayList <item> al_merchant=new ArrayList <item>(); 

        Customer c_one=new Customer(1,"Harry potter", "C-315");
        Customer c_two= new Customer(2,"Ron weasley","C-405");
        Customer c_three= new Customer(3,"Hermoine Granger","C-415");
        Customer c_four= new Customer(4,"Dobby","C-010");
        Customer c_five= new Customer(5,"Dumbledore","C-110");

        
        Merchant m_one=new Merchant(1,"Voldemort","A-001");
        Merchant m_two=new Merchant(2,"Bellatrix","A-010");
        Merchant m_three=new Merchant(3,"Umbridge","A-150");
        Merchant m_four=new Merchant(4,"Malfoy","A-315");
        Merchant m_five=new Merchant(5,"Nagini","A-405");
        display_home_pg(al_merchant,al_customer,c_one,c_two,c_three,c_four,c_five,m_one,m_two,m_three,m_four,m_five);

    }
    public static void merchant_menu(String char_name,ArrayList <item> al_merchant,ArrayList <item> al_customer,Merchant m_req){
        Scanner Sc=new Scanner(System.in);
        System.out.println("Welcome " +char_name +"\n" + "Merchant Menu\n" + "1) Add item\n" + "2) Edit item\n" + "3) Search by category\n" + "4) Add offer\n" + "5) Rewards won\n" + "6) Exit");
            int choice_work=Sc.nextInt();
            if(choice_work==6){
                return;
            }
                
            if(choice_work==1){
                System.out.println("Enter item details\n" +"item name:");
                String name=Sc.next();
                System.out.println("Price");
                int price=Sc.nextInt();
                System.out.println("Quantity");
                int quantity=Sc.nextInt();
                System.out.println("Category");
                String cat=Sc.next();
             
                item ptr=new item(name,price,quantity,-1,cat,m_req.m_id);
                al_merchant.add(ptr);
                // ADDTOMERCHANT(name,price,quantity,cat);
                
            }
            else if(choice_work==2){
                System.out.println("choose item by code");
//                    DISPLAYALLITEMS();
                for(int i=0;i<al_merchant.size();i++){
                    System.out.println(al_merchant.get(i).item_id+" " +al_merchant.get(i).name+" " +al_merchant.get(i).price+" "+al_merchant.get(i).quantity+" " +al_merchant.get(i).offer+" "+ al_merchant.get(i).category+" ");
                }
                int n=Sc.nextInt();
                System.out.println("Enter edit details\n" + "item price:");
                int price=Sc.nextInt();
                System.out.println("item quantity");
                int quantity=Sc.nextInt();
//                    DISPLAY_UPDATED_DETAILS(n);
                al_merchant.get(n-1).price=price;
                al_merchant.get(n-1).quantity=quantity;
                for(int i=0;i<al_merchant.size();i++){
                    System.out.println(al_merchant.get(i).item_id+" " +al_merchant.get(i).name+" " +al_merchant.get(i).price+" "+al_merchant.get(i).quantity+" " +al_merchant.get(i).offer+" "+ al_merchant.get(i).category+" ");
                }
            }
            else if(choice_work==3){
//                Merchant abc=new Merchant();
                m_req.search(al_merchant,al_customer,char_name);
               
            }
            else if(choice_work ==4){
                System.out.println("Choose item by code");
                for(int i=0;i<al_merchant.size();i++){
                    System.out.println(al_merchant.get(i).item_id+" " +al_merchant.get(i).name+" " +al_merchant.get(i).price+" "+al_merchant.get(i).quantity+" " +al_merchant.get(i).offer+" "+ al_merchant.get(i).category+" ");
                }
                int n=Sc.nextInt();
                System.out.println("choose offer\n" + "1) buy one get one\n" + "2) 25% off");
                int nn=Sc.nextInt();
                al_merchant.get(n-1).offer=nn;
                if(nn==2){
                    //25% OFF 
                    al_merchant.get(n-1).price=(int)((al_merchant.get(n-1).price)*(0.75)); 
                }
                else if(nn==1){
//                      BUY 1 GET ONE FREE
                        if(al_merchant.get(n-1).quantity<2){
                            System.out.println("ERROR, THIS OFFER CODE CANNOT BE APPLIED ; UNAVAILABILITY OF REQUIRED STOCK");
                            al_merchant.get(n-1).offer=-1;
                        }
                }
                
            }
            else if(choice_work==5){
                //print reward
//                Merchant abc=new Merchant();
                m_req.Reward();
            }
            merchant_menu(char_name,al_merchant,al_customer,m_req);
    }
    public static void customer_menu(String char_name,ArrayList <item> al_merchant,ArrayList <item> al_customer,Customer c_req){
       System.out.println("Welcome "+char_name+"\n" + "Customer Menu\n" + "1) Search item\n" + "2) checkout cart\n" + "3) Reward won\n" + "4) print latest orders\n" + "5) Exit");
       Scanner Sc=new Scanner(System.in);
       int choice_work=Sc.nextInt();
            if(choice_work==5){
                return;
            }
            else if(choice_work==1){
//                Customer abc= new Customer();
                c_req.search(al_merchant,al_customer,char_name);
                }
            
                else if(choice_work==2){
                //checkout  //empty cart and buy all
//                for(int i=0;i<al_customer.size();i++){                   
//                     c_req.Buy(al_customer.get(i));}

                    c_req.Transaction(al_customer);
                    
            }
            else if(choice_work==3){
                //reward
                c_req.Reward();
            }
            else if(choice_work==4){
                //list recent orders
                ArrayList<item> printing = c_req.c_history;
                for(int i=0;i<printing.size();i++){
                    System.out.println("Bought item "+printing.get(i).name+" "+"quantity "+printing.get(i).quantity+" "+ "for Rs. "+printing.get(i).price+" "+"from "+printing.get(i).m_id + "Merchant");
                }
                
            }
            customer_menu(char_name,al_merchant,al_customer,c_req);

    }
    public static void display_home_pg(ArrayList <item> al_merchant,ArrayList <item> al_customer,Customer c_one, Customer c_two,Customer c_three, Customer c_four,Customer c_five, Merchant m_one, Merchant m_two, Merchant m_three, Merchant m_four, Merchant m_five){

        System.out.println("Welcome to Mercury");
        System.out.println("1. Enter as Merchant");
        System.out.println("2. Enter as Customer");
        System.out.println("3. See user details");
        System.out.println("4.Company account balance");
        System.out.println("5. Exit");
        String [] customers_name=new String []{"Harry potter","Ron weasley","Hermoine Granger","Dobby","Dumbledore"};
        String [] merchants_name=new String []{"Voldemort","Bellatrix","Umbridge","Malfoy","Nagini"};
        Scanner Sc=new Scanner(System.in);
        int num=Sc.nextInt();
        if(num==5){
        return;
        }
        else if(num==1){
            System.out.println("CHOOSE YOUR MERCHANT\n"+"1) Voldemort\n"+"2) Bellatrix\n"+"3) Umbridge\n"+"4) Malfoy\n"+"5) Nagini\n");

            int ch=Sc.nextInt();
            String char_name;
            if(ch==1){
                char_name="Voldemort";
                merchant_menu(char_name,al_merchant,al_customer,m_one);
            }
                
            
            else if(ch==2){
                char_name="Bellatrix";
             merchant_menu(char_name,al_merchant,al_customer,m_two);}
            else if(ch==3){
                char_name="Umbridge";
                merchant_menu(char_name,al_merchant,al_customer,m_three);}
            else if(ch==4){
                char_name="Malfoy";
                     merchant_menu(char_name,al_merchant,al_customer,m_four);}
            else{
                char_name="Nagini";
                 merchant_menu(char_name,al_merchant,al_customer,m_five);}

//            merchant_menu(char_name,al_merchant,al_customer);

        }
        else if(num==2){
            System.out.println("choose customer\n" + "1 Harry Potter\n" + "2 Ron Weasley\n" + "3 Hermoine Granger\n" + "4 Dobby\n" + "5 Dumbledore");
            int ch= Sc.nextInt();
            String char_name;
            if(ch==1){
                char_name="harry Potter";
               customer_menu(char_name,al_merchant,al_customer,c_one);}

            else if(ch==2){
                char_name="Ron Weasley";
                customer_menu(char_name,al_merchant,al_customer,c_two);}

            else if(ch==3){
                char_name="Hermoine Granger";
                customer_menu(char_name,al_merchant,al_customer,c_three);}

            else if(ch==4){
                char_name="Dobby";
               customer_menu(char_name,al_merchant,al_customer,c_four);}

            else{
                char_name="Dumbledore";
                customer_menu(char_name,al_merchant,al_customer,c_five);}

            
//            customer_menu(char_name,al_merchant,al_customer);
        }
        else if(num==3){
            System.out.println("Input M/C for seing Merchant/Customer's information and id");
            String user=Sc.next();
            int id= Sc.nextInt();
            if(user.equals("M")){
                System.out.println(merchants_name[id-1]+" ");
            }
            else{
                System.out.println(customers_name[id-1]+" ");
            }
        }
        else if(num==4){
            //accout balance of company
            System.out.println("Account balance of company "+Company.account_company);
        }
       display_home_pg(al_merchant,al_customer,c_one,c_two,c_three,c_four,c_five,m_one,m_two,m_three,m_four,m_five);
     }
}


interface user{
    public void Reward();
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer,String char_name);

}
class Customer implements user{
    public ArrayList <item> c_history=new ArrayList<item>();
    public int money_left;
    public int orders_total;
    public int orders_current;
    private String name;
    private String address;
    public int c_id;
//    private int counter=0;
    public int acc_main;
    public int acc_reward;
    public Customer(){
        
        orders_total=0;
        orders_current=0;
        money_left=100;
    }
    public Customer(int c_id, String name,String address){

        this.c_id=c_id;
        this.name=name;
        this.address=address;
        orders_total=0;
        orders_current=0;
        money_left=100;
    }
    @Override
    public void Reward(){
        if(orders_current>=5){
            acc_reward+=10;
            orders_current=orders_total-5;
        }
        System.out.println(acc_reward);
            
    }
    
    public void Transaction(ArrayList <item> al_customer){
         int amt=0;
        for(int i=0;i<al_customer.size();i++){
            amt+=al_customer.get(i).quantity*al_customer.get(i).price;
            if(c_history.size()<10){
                c_history.add(al_customer.get(i));
            }
            else {
                c_history.remove(c_history.get(0));
                c_history.add(al_customer.get(i));
            }
        }
        Company.account_company=(int)0.01*amt;
        this.acc_main-=(int)0.5*amt;
        
        if(amt<=this.acc_main){
         this.acc_main-=amt;
       }
        else{
            this.acc_main=0;
            this.acc_reward-=amt-this.acc_main;
        }
//        counter+=1;
        
        this.orders_current+=1;
        this.orders_total+=1;
    }
    public void Buy(item tobuy){
        int amt=tobuy.price*tobuy.quantity;
        
        if(tobuy.offer==1){
            tobuy.quantity=2*tobuy.quantity;
        }
        orders_current+=1;
        orders_total+=1;
//        c_history.add(tobuy);
           Company.account_company+=(int)0.01*amt;
           this.acc_main-=(int)0.5*amt;
//           tobuy.m_id;
           
        if(c_history.size()<10){
                c_history.add(tobuy);
            }
            else {
                c_history.remove(c_history.get(0));
                c_history.add(tobuy);
            }
        
    }
    @Override
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer,String char_name){
        Scanner Sc =new Scanner(System.in);
        System.out.println("choose category");
                
        ArrayList <String> category_uniq=new ArrayList<String>();
        int k;
        for(int i=0;i<al_merchant.size();i++){
           k=-1;
            for(int j=0;j<category_uniq.size();j++){
                if((al_merchant.get(i).category.equals(category_uniq.get(j)))){
                    k=0;
                }
                
            }
            if(k==-1){
                category_uniq.add(al_merchant.get(i).category);
            }
        }
        
        for(int q=0;q<category_uniq.size();q++){
            System.out.println(q+1+" "+ category_uniq.get(q));
        }
        int yourchoice=Sc.nextInt();
        
        for(int i=0;i<al_merchant.size();i++){
            if(al_merchant.get(i).category.equals(category_uniq.get(yourchoice-1)))
                  System.out.println(al_merchant.get(i).item_id+" " +al_merchant.get(i).name+" " +al_merchant.get(i).price+" "+al_merchant.get(i).quantity+" " +al_merchant.get(i).offer+" "+ al_merchant.get(i).category+" ");
        }
        System.out.println("Enter item code");
        int itemcode=Sc.nextInt();
        System.out.println("Enter item quantity");
        int itemquan=Sc.nextInt();
        
        System.out.println("Choose method of transaction \n"+ "1) Buy item\n" + "2) Add item to cart\n" + "3) Exit");
        int option=Sc.nextInt();
//        if(option==3){
//            Mercury.customer_menu(char_name,al_merchant,al_customer);       //remove it if in stack
//        }
        if(option==1) {
            //buy immediately
//            al_merchant.get(itemcode-1).m_id;
             if(itemquan<= al_merchant.get(itemcode-1).quantity){
                 int price=al_merchant.get(itemcode-1).price;
//                 System.out.println("price"+price);
                 
//                 Merchant abc=new Merchant();
//                 abc.buy_directly(price,itemquan);
//                    this.Transaction(al_customer);
            item ptr=new item(al_merchant.get(itemcode-1).name,al_merchant.get(itemcode-1).price,itemquan,al_merchant.get(itemcode-1).offer,al_merchant.get(itemcode-1).category,itemcode);

                    this.Buy(ptr);
                    al_merchant.get(itemcode-1).quantity-=ptr.quantity;
//                         TRANSACTION
             }
            
        }
        else if(option==2){
            //add to cart
           if(itemquan<= al_merchant.get(itemcode-1).quantity){
            item ptr=new item(al_merchant.get(itemcode-1).name,al_merchant.get(itemcode-1).price,itemquan,al_merchant.get(itemcode-1).offer,al_merchant.get(itemcode-1).category,itemcode);
            al_customer.add(ptr);
//              this.Transaction(al_customer);
                    if(ptr.offer==1){
                        //buy 1 get one
                        itemquan=2*itemquan;
                    }
                al_merchant.get(itemcode-1).quantity=al_merchant.get(itemcode-1).quantity-itemquan;
                if(al_merchant.get(itemcode-1).quantity<0){
                    System.out.println("INSUFFICIENT QUANTITY IN STOCK");
                }
                
            }
           else{
               System.out.println("NOT ENOUGH STOCK ; UNABLE TO ADD TO CART");
           }
        }

    }
    
    
}

class Merchant implements user {
    public int contri_total;
    public int contri_current;
    public int slots;
    private String name;
    private String address;
    public int m_id;
    public Merchant(){
        contri_total=0;
        contri_current=0;
        this.slots=10;
        
    }
    public Merchant(int m_id,String name,String address){
        this.name=name;
        this.address=address;
        this.m_id=m_id;
        contri_total=0;
        contri_current=0;
        this.slots=10;
    }
    /*
    public void Transaction(ArrayList<item> al_customer){
        int amt=0;
        for(int i=0;i<al_customer.size();i++){
            amt+=al_customer.get(i).quantity*al_customer.get(i).price;
        }
        
        contri_total+=(int)(amt*0.5);
//        contri_current=
        Company.account_company+=(int)0.01*amt;
    }
    public void buy_directly(int price, int quantity){
        int amt=price*quantity;
        contri_total+=(int)(amt*0.5);
        Company.account_company+=(int)0.01*amt;
    }
*/
    @Override
    public void Reward(){
        if(contri_total>=100){
            slots+=1;
        }
        System.out.println("extra slots are "+(slots-10));
    }
    @Override
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer,String char_name){
        System.out.println("choose category");
        Scanner Sc=new Scanner(System.in);
                
        ArrayList <String> category_uniq=new ArrayList<String>();
        int k;
        for(int i=0;i<al_merchant.size();i++){
           k=-1;
            for(int j=0;j<category_uniq.size();j++){
                if((al_merchant.get(i).category.equals(category_uniq.get(j)))){
                    k=0;
                }
            }
            if(k==-1){
                category_uniq.add(al_merchant.get(i).category);
            }
        }

        for(int q=0;q<category_uniq.size();q++){
            System.out.println(q+1+" "+ category_uniq.get(q));
        }
        int yourchoice=Sc.nextInt();

        for(int i=0;i<al_merchant.size();i++){
            if(al_merchant.get(i).category.equals(category_uniq.get(yourchoice-1)))
                  System.out.println(al_merchant.get(i).item_id+" " +al_merchant.get(i).name+" " +al_merchant.get(i).price+" "+al_merchant.get(i).quantity+" " +al_merchant.get(i).offer+" "+ al_merchant.get(i).category+" ");
        }
    }
    

}
class item{
    public final int item_id;
    public static int counter=0;
    public String name;
    public int price;
    public int quantity;
    public int offer;
    public String category;
    public int m_id;
    public item(String name,int price,int quantity,int offer,String category,int m_id){
        this.item_id=(++counter);
        this.category=category;
        this.name=name;
        this.offer=offer;
        this.price=price;
        this.quantity=quantity;
        this.m_id=m_id;
        
    }
    
}
class Company{
    public static int account_company;
    public Company(){
        account_company=0;
    }
}


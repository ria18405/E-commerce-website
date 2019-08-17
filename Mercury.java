//import static Mercury.al_merchant;
import java.util.*;
import java.io.*;

public class Mercury {

    public static void main(String [] args){
        
        ArrayList <item> al_merchant=new ArrayList <item>(); 
        ArrayList <item> al_customer=new ArrayList <item>();
        display_home_pg(al_merchant,al_customer);
//        ArrayList <item> al_merchant=new ArrayList <item>();  

    }
    public static void merchant_menu(String char_name,ArrayList <item> al_merchant,ArrayList <item> al_customer){
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
             
                item ptr=new item(name,price,quantity,-1,cat);
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
                Merchant abc=new Merchant();
                abc.search(al_merchant,al_customer);
               
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
                    al_merchant.get(n-1).price=(int)((al_merchant.get(n-1).price)*(0.75)); 
                }
                else if(nn==1){
//                      BUY 1 GET ONE FREE
                }
                
            }
            else if(choice_work==5){
                
            }
            merchant_menu(char_name,al_merchant,al_customer);
    }
    public static void customer_menu(String char_name,ArrayList <item> al_merchant,ArrayList <item> al_customer){
       System.out.println("Welcome "+char_name+"\n" + "Customer Menu\n" + "1) Search item\n" + "2) checkout cart\n" + "3) Reward won\n" + "4) print latest orders\n" + "5) Exit");
       Scanner Sc=new Scanner(System.in);
       int choice_work=Sc.nextInt();
            if(choice_work==5){
                return;
            }
            else if(choice_work==1){
                Customer abc= new Customer();
                abc.search(al_merchant,al_customer);
                }
            
                else if(choice_work==2){
                //checkout
                for(int i=0;i<al_customer.size();i++){
//                    al_customer.get(i).;
                }
            }
            else if(choice_work==3){
                
            }
            else if(choice_work==4){
                
            }
            customer_menu(char_name,al_merchant,al_customer);

    }
    public static void display_home_pg(ArrayList <item> al_merchant,ArrayList <item> al_customer){

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
            if(ch==1)
                char_name="Voldemort";
            else if(ch==2)
                char_name="Bellatrix";
            else if(ch==3)
                char_name="Umbridge";
            else if(ch==4)
                char_name="Malfoy";
            else
                char_name="Nagini";

            merchant_menu(char_name,al_merchant,al_customer);

        }
        else if(num==2){
            System.out.println("choose customer\n" + "1 Harry Potter\n" + "2 Ron Weasley\n" + "3 Hermoine Granger\n" + "4 Dobby\n" + "5 Dumbledore");
            int ch= Sc.nextInt();
            String char_name;
            if(ch==1)
                char_name="harry Potter";
            else if(ch==2)
                char_name="Ron Weasley";
            else if(ch==3)
                char_name="Hermoine Granger";
            else if(ch==4)
                char_name="Dobby";
            else
                char_name="Dumbledore";
            
            customer_menu(char_name,al_merchant,al_customer);
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
        }
       display_home_pg(al_merchant,al_customer);
     }
}


interface user{
    public void Reward();
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer);

}
class Customer implements user{
    public int money_left;
    public int orders_total;
    public int orders_current;
    private String name;
    private String address;
    private int c_id;
    public Customer(){
        orders_total=0;
        orders_current=0;
        money_left=100;
    }
    public Customer(int c_id,String name,String address){
        this.c_id=c_id;
        this.name=name;
        this.address=address;
        orders_total=0;
        orders_current=0;
        money_left=100;
    }
    @Override
    public void Reward(){
        
    }
    @Override
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer){
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
        if(option==3){
            customer_menu(char_name,al_merchant,al_customer);       //remove it if in stack
        }
        else if(option==1) {
            //buy immediately
             if(itemquan<= al_merchant.get(itemcode-1).quantity){
//                         TRANSACTION
             }
            
        }
        else{
            //add to cart
           if(itemquan<= al_merchant.get(itemcode-1).quantity){
            item ptr=new item(al_merchant.get(itemcode-1).name,al_merchant.get(itemcode-1).price,itemquan,al_merchant.get(itemcode-1).offer,al_merchant.get(itemcode-1).category);
            al_customer.add(ptr);
//                    TRANSACTION
        }
        }

    }
    
    
}

class Merchant implements user {
    public int contri_total;
    public int contri_current;
    private String name;
    private String address;
    private int m_id;
    public Merchant(){
        contri_total=0;
        contri_current=0;  
    }
    public Merchant(int m_id,String name,String address){
        this.name=name;
        this.address=address;
        this.m_id=m_id;
        contri_total=0;
        contri_current=0;
    }
    public void Transaction(){
        
    }
    @Override
    public void Reward(){
        
    }
    @Override
    public void search(ArrayList<item> al_merchant,ArrayList<item> al_customer){
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
    public int item_id=1;
    public String name;
    public int price;
    public int quantity;
    public int offer;
    public String category;
    public item(String name,int price,int quantity,int offer,String category){
        item_id+=1;
        this.category=category;
        this.name=name;
        this.offer=offer;
        this.price=price;
        this.quantity=quantity;
        
    }
    
}


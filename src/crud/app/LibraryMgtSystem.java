package crud.app;

import java.util.*; // this import scanner
import java.sql.*; // 
public class LibraryMgtSystem {
    public static void main(String[] args) {
        
        // creating local variables
        String db_Url= "jdbc:mysql://localhost:3306/mydb";
        String username= "root";
        String passwd= "root";
        String bookName= "";
        String authorName= "";
        int bookId= 0;
        // here we make the program loop endlessly
        while(true){
            System.out.println("Library Management System");
            System.out.println("===========================");
            System.out.println("1. REGISTER BOOK");
            System.out.println("2. UPDATE BOOK");
            System.out.println("3. DELETE BOOK");
            System.out.println("4. LIST OF BOOKS");
            System.out.println("5. SEARCH FOR BOOK BY ID");
            System.out.println("0. EXIT ");
            System.out.println("===========================");
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Choice: "); // it will print only without the next line 
            int choice = sc.nextInt();
            
            switch(choice){
                case 1: 
                    // surround with try and catch
                    try{
                        System.out.print("Enter Book Id: ");
                        bookId= sc.nextInt();
                        System.out.println("Emter Book Name: ");
                        bookName= sc.next();
                        System.out.println("Enter Author Name: ");
                        authorName= sc.next();
                        // register driver
                        //Class.forName("com.mysql.jdbc.Driver");
                        
                        // create connection
                         Connection con= DriverManager.getConnection(db_Url, username, passwd);   
                         // create statement
                         Statement st= con.createStatement();
                        // execute statement
                        String sql_query= "INSERT INTO book VALUES ("+bookId+",'"+bookName+"','"+authorName+"')";
                        int rowAffected= st.executeUpdate(sql_query);
                        con.close();
                        if(rowAffected>=1){
                             System.out.println("Data Saved Successfully");
                        }else{
                            System.out.println("Data Not Saved");
                        }
                        //close connection
                        System.out.println("Do you wish to continue use YES/NO");
                        String answer= sc.next();
                        if (answer.equalsIgnoreCase("YES")){
                            continue;
                        }else{
                            System.exit(0); // provide 0 if it was successfully if it 1 there are errors happened;
                        }
                    }catch(Exception ex){
                        ex.printStackTrace(); // know where there is the error
                    }
                    
                    break; // the break helps to go to next case
                case 2:
                    try {
                        // register driver
                        System.out.print("Enter Book Id: ");
                        bookId= sc.nextInt();
                        System.out.println("Enter Book Name: ");
                        bookName= sc.next();
                        System.out.println("Enter Author Name: ");
                        bookName= sc.next();
                        Connection con= DriverManager.getConnection(db_Url, username, passwd);
                        Statement st= con.createStatement();
                        String sql_query= "UPDATE book SET book_name='"+bookName+"',author_name='"+authorName+"' WHERE book_id='"+bookId+"'";
                        int rowAffected= st.executeUpdate(sql_query);
                        if(rowAffected>=1){
                            System.out.println("Book Updated Successfully!");
                        }else{
                            System.out.println("Not Updated");
                        }
                        con.close();
                        System.out.println("Do you wish to continue enter YES or NO");
                        String answer= sc.next();
                        if(answer.equalsIgnoreCase("YES")){
                            continue;
                        }else{
                            System.exit(0);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 3: 
                    System.out.println("Enter Book ID: ");
                    bookId= sc.nextInt();
                    try {
                        Connection con= DriverManager.getConnection(db_Url, username, passwd);
                        Statement st= con.createStatement();
                        String sql_query="DELETE FROM book WHERE book_id= '"+bookId+"'";
                        int rowAffected = st.executeUpdate(sql_query);
                        if(rowAffected >= 1){
                            System.out.println("Book Deleted");
                        }else{
                            System.out.println("Not Deleted");
                        }
                        con.close();
                        System.out.println("Do you wish to continue enter Yes or No");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("Yes")){
                            continue;
                        }else{
                            /**
                             * 0 successful terminated
                             * 1 unsuccessful terminated
                             * -1 unsuccessful terminated with exception
                             */
                            System.exit(0);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        Connection con= DriverManager.getConnection(db_Url, username, passwd);
                        Statement st = con.createStatement();
                        String sql_query= "SELECT * FROM book;";
                        ResultSet rs = st.executeQuery(sql_query);
                         
                        int counter = 0;
                        while(rs.next()){
                            counter++;
                            System.out.println("Books in the Store"+counter);
                            System.out.println("BookId: "+rs.getString(1));
                            System.out.println("BookName: "+rs.getString(2));
                            System.out.println("AuthorName: "+rs.getString(3));
                            System.out.println("---------------------------");
                        }
                        System.out.println("Do you wish to continue enter Yes or No");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("Yes")){
                            continue;
                        }else{
                            /**
                             * 0 successful terminated
                             * 1 unsuccessful terminated
                             * -1 unsuccessful terminated with exception
                             */
                            System.exit(0);
                        }
                        con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 5: 
                    break;
                case 0:
                    break;
                default:
                    
            }
        }
    }
}





















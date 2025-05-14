import java.util.*;
public class Main{
    static Scanner sc=new Scanner(System.in);
    static List<Book> books=new ArrayList<>();
    static List<Member> members=new ArrayList<>();
    static Member loggedIn=null;
    static final String adminUsername="admin";
    static final String adminPassword="Password";
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        books.add(new Book("MPMC", "ASHOK", "Educational"));
        books.add(new Book("ERTS", "PRABHU", "Educational"));

        while(true){
            System.out.println("Enter your role(Admin/User): ");
            String role=sc.next().toLowerCase();
            if(role.equals("admin")){
                loginAsAdmin();
            } else if (role.equals("user")) {
                loginAsUser();
            }
            else{
                System.out.println("Invalid role. Please Try again");
            }
        }
    }
    private static void loginAsAdmin(){
        System.out.print("Enter username: ");
        String username=sc.next();
        System.out.print("Enter password");
        String password=sc.next();
        if(username.equals(adminUsername)&&password.equals(adminPassword)){
            System.out.println("Logged in as admin");
            adminMenu();
        }
        else{
            System.out.println("Invalid admin credentials.");
        }
    }
    private static void loginAsUser(){
        /*System.out.print("Enter UserId: ");
        String UserId=sc.next();*/
        System.out.print("Enter username: ");
        String username=sc.next();
        loggedIn=findOrCreateMember(/*UserId,*/username);
        System.out.println("Logged in as User.");
        userMenu();
    }
    private static void adminMenu(){
        while (true){
            System.out.println("\n Library Management System");
            System.out.println("\n1. Add Book\n2. Update Book\n3. Remove Book\n4. Add Member\n5. Remove Member\n6. Display All Books\n7. Display All Members\n8. Exit");
            System.out.println("Enter your Choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1: addBook();break;
                case 2: updateBook();break;
                case 3: removeBook();break;
                case 4: addMember();break;
                case 5: removeMember();break;
                case 6: displayAllBooks();break;
                case 7: displayAllMembers();break;
                case 8: return;
                default: System.out.println("Invalid Choice");
            }
        }
    }
    private static void userMenu(){
        while(true){
            System.out.println("\n Library Management System");
            System.out.println("\n1. BorrowBook\n2. Return Book\n3. Display All Books\n4. Exit");
            System.out.print("Enter your Choice: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1: borrowBook(); break;
                case 2: returnBook(); break;
                case 3: displayAllBooks(); break;
                //case 4: displayAllMembers(); break;
                case 4: return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter book author: ");
        String author = sc.nextLine();
        System.out.print("Enter book genre: ");
        String genre = sc.nextLine();
        books.add(new Book(title, author, genre));
        System.out.println("Book added successfully.");
    }
    private static void updateBook(){
        System.out.print("Enter book title to update");
        String title=sc.nextLine();
        Book book=findBookByTitle(title);
        if(book!=null){
            System.out.println("Enter new Author");
            book.author=sc.next();
            System.out.println("enter new genre: ");
            book.genre=sc.nextLine();
            System.out.println("Updated Book Successfully! ");
        }
        else{
            System.out.println("Book not found! ");
        }
    }
    private static void removeBook(){
        System.out.print("Enter book title to remove: ");
        String title = sc.nextLine();
        Book book = findBookByTitle(title);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
    private static void addMember(){
       /* System.out.println("Enter Member UserID: ");
        String userId=sc.next();*/
        System.out.print("Enter Member UserName: ");
        String username=sc.nextLine();
        members.add(new Member(/*userId,*/username));
        System.out.println("Member added successfully.");
    }
    private static void removeMember(){
       /* System.out.println("Enter member ID: ");
        String userID=sc.next();*/
        System.out.println("Enter member name: ");
        String username=sc.next();
        members.remove(new Member(/*userID,*/username));
        System.out.println("Member removed successfully.");
    }
    private static void displayAllBooks(){
        if(books.isEmpty()){
            System.out.println("No books is Available! ");
        }
        else{
            System.out.println("List of Books: ");
            for(Book book:books){
                System.out.printf("Title: "+book.title+"\nAuthor: "+book.author+"\nGenre: "+book.genre);
            }
        }
    }
    private static void displayAllMembers(){
        if(members.isEmpty()){
            System.out.println("No memebers exist");
        }else{
            System.out.println("\nList of Members:");
            for (Member member : members) {
                System.out.println(/*"UserID: "+member.userId+*/"\nUsername: " + member.username + ", Borrowed Books: " + member.borrowedBooks.size());
            }
        }
    }
    private static void borrowBook(){
        System.out.print("Enter book title to borrow: ");
        String title=sc.next();
        Book book=findBookByTitle(title);
        if(book!=null&& loggedIn.borrowBook(book)){
            //loggedIn.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        }
        else{
            System.out.println("Book is either unavailable or borrow limit reached.");
        }
    }

    private static void returnBook(){
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine();

        Book book = findBookByTitle(title);
        if (book != null && !book.isAvailable) {
            loggedIn.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or it wasn't borrowed.");
        }
    }
    private static Member findOrCreateMember(/*String UserId*/String username ) {
        for (Member member : members) {
            if (member.username.equals(username)) {
                return member;
            }
        }
        Member newMember = new Member(/*UserId,*/username);
        members.add(newMember);
        return newMember;
    }
    private static Book findBookByTitle(String title){
        for(Book book:books){
            if(book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
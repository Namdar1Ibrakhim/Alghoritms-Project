package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class Information {
    public Scanner s = new Scanner(System.in);
    Map<String, Person> map = new HashMap<>();
    //hash map: get operation time complexity is O(1)
    //hash map: containseKey() is O(1)


    public void addPerson(Person person, String login){
        map.put(login, person);
    }
public void init () {
    Person p1 = new Person();
    Person p2 = new Person();
    Person p3 = new Person();
    Person p4 = new Person();
    Person p5 = new Person();

    p1.setName("p1");
    p1.setSurname("p1");
    p1.setAge(18);
    p1.setMail("mail@mail.ru");
    p1.setPol("m");
    p1.setTel("87777777777");
    p1.setBDate("01012000");
    p1.setLogin("p1");
    p1.setParol("12");


    p2.setName("p2");
    p2.setSurname("p2");
    p2.setAge(19);
    p2.setMail("qwerty@mail.ru");
    p2.setPol("f");
    p2.setTel("89777777777");
    p1.setBDate("02022002");
    p2.setLogin("p2");
    p2.setParol("12");


    p3.setName("p3");
    p4.setName("p4");
    p5.setName("p5");

    map.put("p1", p1);
    map.put("p2", p2);
    map.put("p3", p3);
    map.put("p4", p4);
    map.put("p5", p5);

    p1.setFriends("p2");
    p1.setFriends("p3");
    p1.setFriends("p4");
    p1.setFriends("p5");

    p2.setFriends("p3");
    p2.setFriends("p4");

    p3.setFriends("p2");
    p3.setFriends("p4");
    p3.setFriends("p5");
}
    int uu=0;
    ////////MENU//////////
    public void glavMenu(){
        init();

            System.out.println("Welcome to the social network \n1) Log In: \n2) Register");
            int a = s.nextInt();
            if(a==1){
                avtor();
            }else if(a==2){
                registr();
            }else {
                uu++;
                glavMenu();
            }
    }
    //////AVTORIZATION///////
    public void avtor(){
        System.out.println("To log in, enter your login ");
        String log = s.next();

        if(!map.containsKey(log)){
            System.out.println("User not found!");
            glavMenu();
        } else {
            System.out.println("Enter your account password: "+ map.get(log).getName());
            String parol = s.next();

            if(parol.equals(map.get(log).getParol())){
                mystr(log);
                yu=0;
            }else {
                System.out.println("Invalid password!");
                avtor();
            }

        }
    }
    //////////REGISTRATIN////////////
    public void registr(){
        try {
            Person person = new Person();
            System.out.println("To register, enter: ");
            System.out.println("Name: ");
            String name = s.next();
            person.setName(name);

            System.out.println("Surname: ");
            String surname = s.next();
            person.setSurname(surname);

            System.out.println("Age: ");
            int age = s.nextInt();
            person.setAge(age);
            System.out.println("Email: ");
            String mail = s.next();
            person.setMail(mail);
            System.out.println("Gender(m/f): ");
            String pol = s.next();
            person.setPol(pol);
            System.out.println("Phone number: ");
            String tel = s.next();
            person.setTel(tel);

            System.out.println("Date of Birth: ");
            String bdate = s.next();
            person.setBDate(bdate);

            boolean ii = false;
            String login = "";
            int str = 0;

            while (ii == false) {
                if (str == 0) {
                    System.out.println("Enter a unique login: ");
                    str++;
                } else {
                    System.out.println("Login is not unique, enter another: ");
                }
                login = s.next();

                if (!map.containsKey(login)) {
                    ii = true;
                }
            }


            System.out.println("Enter the password: ");
            String parol = s.next();

            person.setLogin(login);
            person.setParol(parol);

            addPerson(person, login);
            System.out.println(name + " " + surname + ". The registration was successful!\n");
            glavMenu();
        }catch (Exception e){
            registr();
        }
    }

    int yu = 0;


    ///////////MYSTR///////////
    public void mystr(String login){
        Person person = map.get(login);
        if(yu==0) {
            System.out.println("\nWelcome to the social network: ");
            yu++;
        }
        System.out.println("\n0. Log out of your account: \n1. Personal cabinet \n2. Friends \n3. Publications \n4. Black List");
        int vyb = s.nextInt();
        switch (vyb){
            case 0:
                System.out.println("Do you want to log out of your account? : \n1. YES \n2. NO");
                int u = s.nextInt();
                if(u==1){
                    glavMenu();
                }else{
                    mystr(login);
                }
            case 1:
                System.out.println("Personal Information: ");
                System.out.println("___________________");
                System.out.println("Name Surname: " + person.getName() + " " + person.getSurname());
                System.out.print(("Gender: "));
                System.out.println((person.getPol()).equals("m") ?"Male":"Female");
                System.out.println("Date of Birth: " + person.getBDate() + "\nAge: " +person.getAge());
                System.out.println("Email: " + person.getMail());
                System.out.println("Phone number: "+ person.getTel());
                mystr(login);
                break;
            case 2:
                friends(person, login);
                break;
            case 3:
                publication(person);
                break;
            case 4:
                cs(login);
                break;
            default:
        }
    }

    ////////////BLOCKLIST/////////////
    public void cs(String login){
        Person person = map.get(login);
        Set<String> chs = person.getChs();
        if(person.chs.size()==0){
            System.out.println("Your BlackList is empty.");
        }else{
        System.out.println("Your blacklist of users: ");
        int i = 1;
            for (String set : chs) {
                System.out.println(i + ": " + set);
                i++;
            }
        }
        System.out.println("****************");
        System.out.println("0. To the main menu");
        System.out.println("1. Add a user to an black list: ");
        System.out.println("2. Remove a user from an black list: ");
        int otv = s.nextInt();
        if(otv==0){
            mystr(login);
        }if(otv==1){
            System.out.println("Enter the user login: ");
            String log = s.next();
            if(!map.containsKey(log)) {
                System.out.println("User not found\n");
                cs(login);
            }else if(chs.contains(log)){
                System.out.println("The user is black list\n");
                cs(login);
            }else{
                person.addChs(log);
                System.out.println("The user has been added to the black list\n");
                cs(login);
            }
        }else if(otv==2){
            System.out.println("Enter the user login");
            String log = s.next();
            if(!map.containsKey(log)) {
                System.out.println("User not found\n");
                cs(login);
            }else if(!chs.contains(log)){
                System.out.println("The user is not on the black list\n");
                cs(login);
            }else{
                person.removeChs(log);
                System.out.println("The user has been removed from the black list.\n");
                cs(login);
            }
        }
    }


    public void friends(Person person, String log) {
        System.out.println("Friends List");
        System.out.println("___________________");


        if (person.friends.size() == 0){
            System.out.println("The friends list is empty");
        } else {
            for (int i = 0; i < person.friends.size(); i++) {
                System.out.println((i + 1) + " " + person.friends.get(i));
            }
        }

        System.out.println("-1. Exit to the main menu");
        System.out.println("0. Search for friends:(subscribe)");
        System.out.println("1. Delete a friend(Unsubscribe)");
        System.out.println("2. Go to fried's profile");
        System.out.println("3. View the closes friend");


        System.out.println("****************");
        int a = s.nextInt();
        if (a == -1) {
            mystr(log);
        } else if (a == 0) {
            System.out.println("Enter the user's login: ");
            String tg = s.next();
            int inde = -1;

            if(map.containsKey(tg)){
                inde++;
            }

            if (inde != -1) {
                if(tg.equals(log)){
                    System.out.println("You can't add yourself as a friend");
                }else if(person.friends.contains(tg)) {
                    System.out.println("The user " + map.get(tg).getName() + " " + map.get(tg).getSurname() + " is your friend");
                } else {
                    System.out.println("Add a user as a friend? 1. Yes/2. No");
                    int op = s.nextInt();
                    if (op == 1) {
                        person.setFriends(tg);
                        System.out.println("The user " + map.get(tg).getName() + " has been added to friends");
                        friends(person, log);
                    } else {
                        friends(person, log);

                    }
                }
            } else {
                System.out.println("User not found");
                friends(person, log);
                System.out.println();
            }
        } else if (a == 1) {
            System.out.println("To remove a user from friends, enter a login: ");
            String lo = s.next();
            if(person.friends.contains(lo)) {
                person.deleteFriends(lo);
            }
            friends(person, log);

        } else if (a==2){
            System.out.print("Go to friend's personal cabinet: ");
            String ll = s.next();
            if(map.containsKey(ll) && person.friends.contains(ll)) {
                friendStr(ll, log);
            }else{
                System.out.println("The user does not exists or this user is not in your friends");
                friends(person, log);
            }
        }else if(a==3){
            System.out.println("Which your subscriber has the highest number of common subscribers using Trees");
            System.out.println(theClosestFollower(person, map).getName());
            System.out.println("*****************");
            mystr(person.getLogin());
        }
    }

    /////////////FRIENDSTR/////////////
    public void friendStr(String login, String mylog){
        Person frperson = map.get(login);
        System.out.println("****************");
        System.out.println("Information: ");
        System.out.println(frperson.getName() + " " + frperson.getSurname());
        System.out.println(frperson.getPol());
        System.out.println(frperson.getBDate() + " " + frperson.getAge() + " y.o!");
        System.out.println(frperson.getMail());
        System.out.println(frperson.getTel());
        System.out.println("----------------");
        System.out.println("0.Go to personal cabinet\n1. View publication");
        int ou = s.nextInt();
        if(ou==1) {
            publication(frperson);
        }else{
            mystr(mylog);
        }
    }

    /////////Publication///////
    public void publication(Person person){
        System.out.println("Publications: ");
        System.out.println("1. Publish a post: ");
        System.out.println("2. View posts: ");
        System.out.println("---------------------");
        Scanner sc = new Scanner(System.in);
        int vy = sc.nextInt();
        Posts posts = new Posts();
        if(vy==1){
            System.out.println("Enter what you want to publish: ");
            sc.nextLine();
            String opub = sc.nextLine();


            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String dat = formatter.format(date);

            posts.setDatePublication(dat);
            posts.addPost(opub);
            person.setPostsList(posts);
            System.out.println("Your post has been successfully published!!!");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            publication(person);
            sc.close();

        }else{
            System.out.println("0. Main menu");
            System.out.println("1. View posts");
            System.out.println("2. Sorting posts by likes");
            System.out.println("3. Get k popular posts");
            int chos = s.nextInt();

            List<Posts> postsList = person.getPostsList();

            if (chos==0){
                mystr(person.getLogin());
            }else if(chos==1){
                System.out.println("Posts by user : " + person.getName());
                if(postsList.size()==0){
                    System.out.println("There is not a single post");
                }
            for (int i = 0; i < postsList.size(); i++) {
                System.out.println("-------------------------");
                System.out.println("Post № "+ (i+1));
                System.out.println(postsList.get(i).getPost());
                System.out.println("-------------------------");
                System.out.println("Date of publication:" + postsList.get(i).getDatePublication());
                System.out.println("Number of likes: "+postsList.get(i).getCountLike());
                System.out.println("_________________________");
                System.out.println("0. Like");
                System.out.println("1. Open comments");
                System.out.println("2. See who liked");
                System.out.println("3. Continue viewing");
                System.out.println("4. Main menu");
                int bb = s.nextInt();

                if(bb==0){
                    postsList.get(i).setCount();
                    postsList.get(i).setLikeStr(person.getName());
                    publication(person);
                    continue;
                }else if(bb==1){
                    System.out.println("1. Write a comment");
                    System.out.println("2. View comments");
                    int oo = s.nextInt();
                    if(oo==1){
                        System.out.println("Write a comment");
                        postsList.get(i).napcomment(s.next());
                    }else if(oo==2){
                        System.out.println(postsList.get(i).comenty());
                    }
                }else if(bb==2){
                    if(postsList.get(i).getCountLike()==0){
                        System.out.println("No one liked");
                    }else{
                        System.out.println(postsList.get(i).getLikeStr());
                    }
                }else if(bb==3){
                    continue;
                }else{
                    mystr(person.getLogin());
                }
            }
            System.out.println("1. Publications panel\n2. Main menu");
            int a = sc.nextInt();
            if(a==1){
                publication(person);
                sc.close();
            }else{
                mystr(person.getLogin());
            }
        }else if(chos==2){
                ArrayList<Posts> list = (ArrayList<Posts>) ((ArrayList<Posts>)postsList).clone();
                System.out.println("1. Sorting using QuickSort");//O(nlogn)
                System.out.println("2. Sorting using MergeSort");//O(nlogn)
                System.out.println("3. Sorting using BubbleSort");//O(n^2)
                System.out.println("4. Sorting using InsertionSort");//O(n^2)
                System.out.println("5. Reverse sorting");
                int oper =  s.nextInt();
                System.out.println("****************");
                if(oper==1) {
                    quickSort(list, 0, list.size() - 1);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getPost());
                        System.out.println("Number of likes: " + list.get(i).getCountLike());
                        System.out.println("----------------");
                    }
                    System.out.println("*****************");
                    publication(person);
                }else if (oper==2){
                    mergeSort(list);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getPost());
                        System.out.println("Number of likes: " + list.get(i).getCountLike());
                        System.out.println("----------------");
                    }
                    System.out.println("*****************");
                    publication(person);
                }else if (oper==3){
                    bubbleSort(list);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getPost());
                        System.out.println("Number of likes: " + list.get(i).getCountLike());
                        System.out.println("----------------");
                    }
                    System.out.println("*****************");
                    publication(person);
                }else if(oper==4){
                    insertionSort(list);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getPost());
                        System.out.println("Number of likes: " + list.get(i).getCountLike());
                        System.out.println("----------------");
                    }
                    System.out.println("*****************");
                    publication(person);
                }else{
                    quickReverse(list, 0, list.size() - 1);
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).getPost());
                        System.out.println("Number of likes: " + list.get(i).getCountLike());
                        System.out.println("----------------");
                    }
                    System.out.println("*****************");
                    publication(person);

                }
            }else{
                System.out.println("Enter a number of posts: ");
                int k = sc.nextInt();
                List<Posts> temp = getKMaxPosts(postsList, k);
                for (Posts p: temp) {
                    System.out.println(p.getPost());
                    System.out.println("Number of likes: " + p.getCountLike());
                    System.out.println("----------------");
                }
                System.out.println("*****************");
                publication(person);
            }
        }

        }

    /////////INSERTIONSORT///////////
    private void insertionSort(List<Posts> postsList) {
        int n = postsList.size();
        for (int i = 1; i < n; ++i) {
            Posts key = postsList.get(i);
            int j = i - 1;

            while (j >= 0 && postsList.get(j).getCountLike() > key.getCountLike()) {
                postsList.set(j + 1, postsList.get(j));
                j = j - 1;
            }
            postsList.set(j + 1, key);
        }
    }

    //////////QUICKSORT///////////
    private static void quickSort(List<Posts> postsList, int l, int r){
        if(l>=r)return;
        int pi = partition(postsList, l, r);
        quickSort(postsList, l, pi - 1);
        quickSort(postsList, pi+1, r);

    }
    private static int partition(List<Posts> postsList, int l, int r){
        int pivot = postsList.get(r).countLike;
        int ptr = l-1;

        for (int i = l; i < r; i++) {
            if(postsList.get(i).countLike < pivot){
                ptr++;
                swap(ptr, i, postsList);
            }
        }
        swap(ptr+1, r, postsList);
        return ptr+1;
    }
    private static void swap(int ptr, int i, List<Posts> postsList){
        Posts temp = postsList.get(ptr);
        postsList.set(ptr, postsList.get(i));
        postsList.set(i, temp);
    }
    ////////////////////////

    ///////////REVERSE SORTING//////////
    private static void quickReverse(List<Posts> postsList, int l, int r){
        if(l>=r)return;
        int pi = partitionReverse(postsList, l, r);
        quickReverse(postsList, l, pi - 1);
        quickReverse(postsList, pi+1, r);

    }
    private static int partitionReverse(List<Posts> postsList, int l, int r){
        int pivot = postsList.get(r).countLike;
        int ptr = l-1;

        for (int i = l; i < r; i++) {
            if(postsList.get(i).countLike > pivot){
                ptr++;
                swapReverse(ptr, i, postsList);
            }
        }
        swapReverse(ptr+1, r, postsList);
        return ptr+1;
    }
    private static void swapReverse(int ptr, int i, List<Posts> postsList){
        Posts temp = postsList.get(ptr);
        postsList.set(ptr, postsList.get(i));
        postsList.set(i, temp);
    }


    /////////////BUBBLESORT///////////
    private void bubbleSort(List<Posts> postsList) {
        int n = postsList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (postsList.get(j).getCountLike() > postsList.get(j + 1).getCountLike()) {
                    // swap arr[j+1] and arr[j]
                    Posts temp = postsList.get(j);
                    postsList.set(j, postsList.get(j + 1));
                    postsList.set(j + 1, temp);
                }
    }
    /////////////////////////

    ///////////MERGESORT////////////
    private static void mergeSort(List<Posts> postsList){
        int n = postsList.size();
        if(n==1)return;

        int mid = n/2;
        List<Posts> post1 = new ArrayList<>();
        List<Posts> post2 = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            post1.add(postsList.get(i));
        }
        for (int i = mid; i < n; i++) {
            post2.add(postsList.get(i));
        }

        mergeSort(post1);
        mergeSort(post2);
        merge(postsList, post1, post2);
    }

    private static void merge(List<Posts> postsList, List<Posts> post1, List<Posts> post2){
        int left = post1.size();
        int right = post2.size();
        int i=0;
        int j=0;

        int idx = 0;
        while (i<left && j<right){
            if(post1.get(i).getCountLike() < post2.get(j).getCountLike()){
                postsList.set(idx, post1.get(i));
                i++;
                idx++;
            }else{
                postsList.set(idx, post2.get(j));
                j++;
                idx++;
            }
        }
        for (int ll = i; ll < left; ll++) {
            postsList.set(idx++, post1.get(ll));
        }
        for (int rr = j; rr < right; rr++) {
            postsList.set(idx++, post2.get(rr));
        }
    }
    //////////////////////

    /*
    12)
    Our structure does not need using any hashtable to get number of likes.
    Every object has a variable named countLike which counts number of likes;
    */
    public int getNumberOfLikes(Posts post) {
        int result = 0;
        post.getCountLike();
        return result;
    }

    /*
    10)
    Priority queues are built on the top to the max heap
    */

    public static List<Posts> getKMaxPosts(List<Posts> posts, int k){
        List<Posts> result = new ArrayList<>();
        PriorityQueue queue = new PriorityQueue(posts.size());
        for (Posts p: posts) {
            queue.insert(p);
        }
        for (int i = 0; i < Math.min(posts.size(), k); i++) {
            result.add(queue.remove());
        }
        return result;
    }

    /*
    13)
    Using TreeMap entry set
    */

    public static Person theClosestFollower(Person person, Map<String, Person> chel){

        Tree tree = new Tree();
        for (String s: person.friends) {
            List<String> l1 = new ArrayList<>();
            l1.addAll(person.friends);
            List<String> l2 = new ArrayList<>();
            l2.addAll(chel.get(s).friends);
            l1.retainAll(l2);
            tree.put(s, l1.size());
        }

        return chel.get(tree.getMax().str);
    }

}
class Tree {
    Node head;
    public Tree(){

    }
    public void put(String s, int i) {
        if (head == null) {
            head = new Node(i, s);
            return;
        }
        Node temp = head;
        Node parent = null;
        while (temp!=null) {
            parent = temp;
            if (temp.value > i) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (parent.value > i) {
            parent.left = new Node(i, s);
        } else {
            parent.right = new Node(i, s);
        }
    }
    public Node getMax(){
        Node temp = head;
        if (head==null) {
            return null;
        }
        while (temp.right!=null) {
            temp = temp.right;
        }
        return temp;
    }
}
class Node {
    Node left;
    Node right;
    String str;
    int value;
    public Node(int v, String s) {
        value = v;
        str = s;
    }
}

class PriorityQueue
{
    private Posts[] maxheap;
    private int heapSize, capacity;


    public PriorityQueue(int capacity)
    {
        this.capacity = capacity + 1;
        maxheap = new Posts[this.capacity];
        heapSize = 0;
    }


    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    public int size()
    {
        return heapSize;
    }

    public void insert(Posts newPost)
    {

        maxheap[++heapSize] = newPost;
        int pos = heapSize;
        while (pos != 1 && newPost.getCountLike() > maxheap[pos/2].getCountLike())
        {
            maxheap[pos] = maxheap[pos/2];
            pos /=2;
        }
        maxheap[pos] = newPost;
    }

    public Posts remove()
    {
        int parent, child;
        Posts item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = maxheap[1];
        temp = maxheap[heapSize--];

        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && maxheap[child].getCountLike() < maxheap[child + 1].getCountLike())
                child++;
            if (temp.getCountLike() >= maxheap[child].getCountLike())
                break;

            maxheap[parent] = maxheap[child];
            parent = child;
            child *= 2;
        }
        maxheap[parent] = temp;

        return item;
    }
}
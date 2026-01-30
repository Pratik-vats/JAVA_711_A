public class student {
    int uid;
    String name;
    int section;

    student(){
        uid=0;
        name = "none";
        section = 0;
    }
    student(int uid , String name , int section){
        this.uid = uid;
        this.name = name;
        this.section = section;
    }

    void display(){
        System.out.println("Uid  = " + uid);
        System.out.println("Name = " + name);
        System.out.println("Section = "+ section);
    }

    public static void main(String a[]){
        student obj = new student(101 , "Pratik" , 711);
        obj.display();
    }
}


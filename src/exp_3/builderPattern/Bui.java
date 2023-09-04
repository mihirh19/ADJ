package exp_3.builderPattern;


class Student {
    String Name, address, phone;
    static class Builder{
        String Name, address, phone;
        public Builder setName(String Name){
            this.Name = Name;
            return this;
        }
        public Builder setAddress(String address){
            this.address = address;
            return this;
        }
        public Builder setPhone(String phone){
            this.phone = phone;
            return this;
        }
        public Student build(){


            return new Student(this.Name, this.address, this.phone);
        }
    }
    private Student(String name, String add, String ph){
        this.Name = name;
        this.address = add;
        this.phone = ph;
    }

}
public class Bui {
    public static void main(String[] args) {
        Student s = new Student.Builder().setName("Mihir").setAddress("Nadiad").setPhone("96645760078").build();
        System.out.println(s.Name);
        System.out.println(s.address);
        System.out.println(s.phone);
    }
}

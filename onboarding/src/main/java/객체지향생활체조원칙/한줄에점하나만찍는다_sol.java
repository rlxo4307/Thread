package 객체지향생활체조원칙;

 class 한줄에점하나만찍는다_sol {
     private static void main(String[] args) {
         Korea2 ko = new Korea2(new Name2());
         System.out.println(ko.koreaName());
     }
 }

class Korea2 {
    private final Name2 name;
    Korea2(Name2 name) {
        this.name = name;
    }
    String koreaName(){
        return name.get();
    }
}

class Name2 {
    private String name = "한국";
    String get(){
        return name;
    }
}

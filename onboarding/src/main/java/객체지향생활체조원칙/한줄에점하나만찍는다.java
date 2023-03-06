package 객체지향생활체조원칙;

class 한줄에점하나만찍는다 {
    Korea1 ko = new Korea1(new Name1());
    void KoreaNameIsWhat(){
        ko.koreaName().get();
    }
}

class Korea1 {
    private final Name1 korea;
    Korea1(Name1 korea) {
        this.korea = korea;
    }
    Name1 koreaName(){
        return korea;
    }
}

class Name1 {
    private String name = "한국";
    String get(){
        return name;
    }
}
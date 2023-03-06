package 객체지향생활체조원칙;

 class 한줄에점하나만찍는다_sol {
        Korea1 ko = new Korea1(new Name1());
        void KoreaNameIsWhat(){
            ko.koreaName();
        }
    }

class Korea2 {
    private final Name1 korea;
    Korea2(Name1 korea) {
        this.korea = korea;
    }
    String koreaName(){
        return korea.get();
    }
}

class Name2 {
    private String name = "한국";
    String get(){
        return name;
    }
}

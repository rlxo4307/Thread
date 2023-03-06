package 객체지향생활체조원칙;

public class 한줄에점하나만찍는다_sol {
    class 한줄에점하나만찍는다 {
        Korea ko = new Korea(new Name());
        void KoreaNameIsWhat(){
            ko.koreaName();
        }
    }

    class Korea {
        private final Name korea;
        Korea(Name korea) {
            this.korea = korea;
        }
        String koreaName(){
            return korea.get();
        }
    }

    class Name {
        private String name = "한국";
        String get(){
            return name;
        }
    }
}

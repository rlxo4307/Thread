package 객체지향생활체조원칙;

import java.util.LinkedList;

class 일급컬렉션을쓴다_sol {
    private LinkedList<Integer> computerIp;
    public 일급컬렉션을쓴다_sol(LinkedList<Integer> computerIp){
        this.computerIp = computerIp;
    }
    public int getIp(int computer){

        return computerIp.get(computer);
    }
}
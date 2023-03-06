package 객체지향생활체조원칙;

import java.util.LinkedList;
class 일급컬렉션을쓴다 {
    private int computer;
    private int[] ip;
    public 일급컬렉션을쓴다(int computer, int[] ip){
        this.computer = computer;
        this.ip = ip;
    }
    public int getIp(int computer){
        return ip[computer];
    }
}
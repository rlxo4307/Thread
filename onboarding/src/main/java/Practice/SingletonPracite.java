package Practice;
class SingletonPracite {
    private static SingletonPracite maInstance = null;
    private SingletonPracite(){}

    public static SingletonPracite getInstance(){
            if (maInstance == null) {
                synchronized (SingletonPracite.class) {
                    maInstance = new SingletonPracite();
                }
            }
        return maInstance;
    }
}
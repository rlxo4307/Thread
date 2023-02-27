package Practice;
class LazyHolderSingleton {
    private LazyHolderSingleton(){}

    public static LazyHolderSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton();
    }

}

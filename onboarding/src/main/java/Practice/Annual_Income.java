package Practice;

class MyAge {
    private Year year;
    public void older(int getAge){
        this.year = year.older(getAge);
    }
}

class Year {
    private int age;
    public Year(final int age){
        valide(age);
        this.age = age;
    }
    public Year older(int getAge){
        return new Year(getAge + this.age);
    }
    private void valide(int age){
        if(age<=0) throw new IllegalArgumentException();
    }
}

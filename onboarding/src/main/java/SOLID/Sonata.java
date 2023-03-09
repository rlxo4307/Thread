package SOLID;
class Sonata implements Car{
    private String name = "Sonata";
    public Sonata(){
        toString();
    }
    @Override
    public String toString(){
        return name;
    }
}

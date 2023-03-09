package SOLID;
class Sonata implements Car{
    private String name = "Sonata";
    public Sonata(){
        getName();
    }
    @Override
    public String getName(){
        return name;
    }
}

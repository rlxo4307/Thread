package SOLID;

class Avante implements Car{
    private String name = "Avante";
    public Avante(){
        getName();
    }
    @Override
    public String getName(){
        return name;
    }

}

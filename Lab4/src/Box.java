public class Box<T> {
    private T obj;

    public Box(){}

    public Box(T obj) {
        this.obj = obj;
    }

    public T get() {
        T copy = this.obj;
        this.obj = null;
        return copy;
    }

    public void put(T obj) throws Exception {
        if (this.obj != null) throw new Exception("В коробке уже есть объект");
        else this.obj = obj;
    }

    public Boolean IsEmpty(){
        return obj == null;
    }

}


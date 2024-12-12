public class Student implements Comparable<Student>{
    private String name;
    private int[] marks;

    public Student(String name){
        this.name = name;
        this.marks = new int[]{};
    }

    public Student(String name, int[] marks) throws Exception{
        for (int i = 0; i < marks.length; i++)
            if (marks[i] < 2 || marks[i] > 5)
                throw new Exception("Оценки могут иметь значения от 2 до 5");
        this.name = name;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int[] getMarks(){
        return marks;
    }

    public void setMarks(int[] marks){
        this.marks = marks;
    }

    public void ToString(){
        System.out.print(name + ": ");
        for (int i = 0; i < marks.length; i++){
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    public void ChangeMark(int value, int pos){
        marks[pos] = value;
    }

    public double avgMarks(){
        double sumMarks = 0;
        for (int i = 0; i < marks.length; i++)
            sumMarks += marks[i];
        if (sumMarks == 0) return 0;
        return sumMarks / marks.length;
    }

    public String IsCool(){
        if (marks.length == 0) return "Не отличнинк";

        int count = 0;
        for (int i = 0; i < marks.length; i++)
            if (marks[i] == 5) count++;

        if (count == marks.length) return "Отличник";
        return "Не отличник";
    }

    @Override
    public int compareTo(Student other) {
        if (this.avgMarks() > other.avgMarks()) {
            return 1;
        } else if (this.avgMarks() < other.avgMarks()) {
            return -1;
        } else {
            return 0;
        }
    }
}
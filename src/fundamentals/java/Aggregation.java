package fundamentals.java;

//When a class has another class in their atributes but both can keep existing if one of those do not.
public class Aggregation {
  private List<Teacher> teachers;

  public Aggregation(List<Teacher> teachers) {
    this.teachers = teachers;
  }

  public void listAggreTeachers(){
    teachers.forEach(t -> System.out.println(t.getName());
  }
}
 

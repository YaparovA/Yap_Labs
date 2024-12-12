public class superClass {
    public static Box PointInBox(Box box) throws Exception {
        Point3D point = new Point3D(Math.random(), Math.random(), Math.random());
        box.put(point);
        return box;
    }
}

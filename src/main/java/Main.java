public class Main {

    public static void main(String[] args) {
        String name = "morpheus";
        String job = "leader";
        String result = String.format("{%s: %s}", guotes(name), guotes(job));
    System.out.println(result);
}

    public static String guotes (String s){
        return "\"" + s + "\"";
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            UI uiCalc = new UI();
            uiCalc.init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

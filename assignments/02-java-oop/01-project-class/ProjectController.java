public class ProjectController {
    public static void main(String[] args) {
        Project test = new Project("get rich quick scheme");

        System.out.println(test.getName());

        Project test2 = new Project("great idea", "It's a great idea");

        // System.out.println(test2.getDescription() +" "+ test2.getName());

        // test.setDescription("ok idea");
        // System.out.println(test.getDescription());

        // test.setName("New Idea name");
        // System.out.println(test.getName());
       System.out.println(test2.elevatorPitch());

       Project test3 = new Project();
       System.out.println(test3.getDescription());
    }
}
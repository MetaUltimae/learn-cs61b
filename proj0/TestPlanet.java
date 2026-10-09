public class TestPlanet{
    static Planet p1 = new Planet(
        3.5,
        4,
        8,
        2,
        5,
        null
    );
    static Planet p2 = new Planet(
        2.5,
        7,
        12,
        1,
        6,
        null
    );

    public static void show(Planet p){
        System.out.println("this planet's propertis:");
        System.out.println("position of x:" + p.xxPos);
        System.out.println("position of y:" + p.yyPos);
        System.out.println("velocity of x:" + p.xxVel);
        System.out.println("velocity of y:" + p.yyVel);
        System.out.println("mass:" + p.mass);
        System.out.println("================================");
        System.out.println();
    }


    public static void main(String[] args){
        show(p1);
        show(p2);
        System.out.println("force of between of p1 and p2:");
        System.out.println(p1.calcForceExertedBy(p2));
    }
}

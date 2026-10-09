public class NBody{
    public static double readRadius(String path){
        In in = new In(path);
        in.readDouble();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int range = in.readInt();
        Planet[] planets = new Planet[range];

        in.readDouble();
        for(int i = 0;i < range;i++){
            Planet planet = new Planet(
                in.readDouble(),
                in.readDouble(),
                in.readDouble(),
                in.readDouble(),
                in.readDouble(),
                in.readString()
            );
            planets[i] = planet;
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setCanvasSize(768,768);
        StdDraw.setScale(-radius,radius);
        StdDraw.picture(0,0,"images/starfield.jpg",radius * 2,radius * 2);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        while(t < T){
            for(int i = 0;i < planets.length;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for(int i = 0;i < planets.length;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg",radius * 2,radius * 2);
            for(Planet p:planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

        StdOut.printf("%d\n",planets.length);
        StdOut.printf("%.2e\n",radius);
        for(Planet p:planets){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            p.xxPos,p.yyPos,p.xxVel,
                            p.yyVel,p.mass,p.imgFileName);
        }
        
            
            
    }

}

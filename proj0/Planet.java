public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p){
        double m1 = this.mass;
        double m2 = p.mass;
        double r = this.calcDistance(p);
        return G * m1 * m2 /(r * r);
    }
        
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double f = calcForceExertedBy(p);
        return f * dy / r;
    }
    
    public double calcNetForceExertedByX(Planet[] ps){
        double nf = 0;
        for(Planet p : ps){
            if(this.equals(p))
                continue;
            double f = this.calcForceExertedByX(p);
            nf += f;
        }
        return nf;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double nf = 0;
        for(Planet p : ps){
            if(this.equals(p))
                continue;
            double f = this.calcForceExertedByY(p);
            nf += f;
        }
        return nf;
    }

    public void update(double dt,double fX,double fY){
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        double vX = this.xxVel + aX * dt;
        double vY = this.yyVel + aY * dt;
        double pX = this.xxPos + vX * dt;
        double pY = this.yyPos + vY * dt;

        this.xxVel = vX;
        this.yyVel = vY;
        this.xxPos = pX;
        this.yyPos = pY;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
    }


}

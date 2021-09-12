package br.inatel.cdg.algebra.scene;

public class Reta {
    public Ponto p1;
    public Ponto p2;

    public Reta(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double coefAng(){
        return (this.p2.y - this.p1.y)/(this.p2.x - this.p1.x);
    }

    public double coefLinear(){
        double coefAng;
        coefAng = (this.p2.y - this.p1.y)/(this.p2.x - this.p1.x);
        return this.p1.y - coefAng * this.p1.x;
    }
}

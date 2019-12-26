package jp.ac.uryukyu.ie.e195740;

public class Hero extends LivingThing {

    public Hero (String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage) {
        int hitPoint = this.getHitPoint();
        this.setHitPoint(hitPoint -= damage);
        if( this.getHitPoint() < 0 ) {
            this.setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", this.getName());
        }
    }
}

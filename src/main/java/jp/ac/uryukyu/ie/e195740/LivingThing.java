package jp.ac.uryukyu.ie.e195740;

/**
 * LivingThingクラス
 * String name; //名前
 * int hitPoint; //HP
 * int attack; //攻撃力
 * boolean dead //生死状態 true == died.
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP 最大HP
     * @param attack 攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * deadを返すメソッド。
     * @return dead 死んでるかどうかの真偽
     */
    public boolean isDead(){
        return  dead;
    }

    /**
     * nameを返すメソッド。
     * @return name 名前
     */
    public String getName(){
        return name;
    }

    /**
     * hitPointを返すメソッド。
     * @return hitPoint HP
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * 死んでるかどうかを設定するメソッド。
     * @param sDead 死んでるかどうかの真偽
     */
    public void setDead(boolean sDead){
        dead = sDead;
    }

    /**
     * HPを設定するためのメソッド。
     * @param setHitPoint HP
     */
    public void setHitPoint(int setHitPoint){
        hitPoint = setHitPoint;
    }

    /**
     * 相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(!dead) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}


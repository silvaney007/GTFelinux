package org.academiadecodigo.felinux.gtfo.characters.enemies;

import org.academiadecodigo.felinux.gtfo.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class CowBoss extends Enemy {

    private int movementCounter = 0;

    public CowBoss(int posX, int posY, String spriteName) {
        super(EnemyAreaType.COW_BOSS, posX, posY, spriteName, 10);
    }

    @Override
    public void move(){

        if (isDead()) {
            return;
        }

        if(movementCounter < 25) {
            this.moveUp();
            movementCounter++;
         return;
        }

        this.moveDown();
        movementCounter++;

        if (movementCounter > 50){
            movementCounter = 0;
        }
    }
    @Override
    public void moveUp() {

        if (enemyField.getArea().getY() >= getEnemy().getY()) {
            getEnemy().translate(0, Field.getCellSize() * 2);
            getArea().getBoundArea().translate(0, Field.getCellSize() * 2);
            return;
        }
        getEnemy().translate(0, -Field.getCellSize() * 2);
        getArea().getBoundArea().translate(0, -Field.getCellSize() * 2);

    }

    //Override from character, checks direction to make enemy not walk backwards in case of being a car
    @Override
    public void moveDown() {

        if (enemyField.getArea().getySize() <= getEnemy().getMaxY() - enemyField.getArea().getY()) {
            getEnemy().translate(0, -Field.getCellSize() * 2);
            getArea().getBoundArea().translate(0, -Field.getCellSize() * 2);
            return;
        }
        getEnemy().translate(0, Field.getCellSize() * 2);
        getArea().getBoundArea().translate(0, Field.getCellSize() * 2);

    }

    @Override
    public void interact() {

    }
}

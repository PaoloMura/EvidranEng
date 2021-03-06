package engine.entity;

import engine.core.tick;
import engine.draw.drawable;
import engine.draw.facade;
import engine.physics.Moveable;
import javafx.scene.canvas.Canvas;

/***
 * a moveable object with a facade
 *
 * when creating a "Game" the developer creates their own entities by extending this class
 * and overwriting the tick method as well as supplying a facade object
 */
public abstract class entity extends Moveable implements drawable, tick {

    facade f;

    public entity(entity e) {
        super(e.getSuper());
    }

    protected Moveable getSuper() {
        return super.clone();
    }

    @Override
    public void draw(Canvas board) {
        f.giveVolume(super.getVolume());
        f.draw(board);
    }

    protected void setFacade(facade f) {
        this.f = f;
    }

    public boolean equals(entity e) {
        if(super.equals(e.getSuper())) {return true;}
        return false;
    }
}

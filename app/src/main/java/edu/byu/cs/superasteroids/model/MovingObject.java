package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;
import android.graphics.RectF;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.core.GraphicsUtils;

/**
 * Any obect that moves on screen is a moving object.
 * @author Scott Leland Crossen
 */
public abstract class MovingObject extends PositionedObject {
/*
FIELDS
 */
    protected enum ROTATION_DRIFT {CLOCKW, COUNTERCLOCKW, NONE};
    /**
     * The drift-speed of the object's rotation.
     */
    private static float ROTATION_DRIFT_SPEED=(float)20;
    /**
     * The speed of the object
     */
    protected int speed;
    /**
     * The direction the object is moving
     */
    protected float direction;
    private boolean is_hit=false;
    protected RectF bound;
    private ROTATION_DRIFT rot_drift = ROTATION_DRIFT.NONE;
    Debug debug=new Debug(7);
/*
CONSTRUCTORS
 */
    /**
     * The constructor of the positioned object
     * @param image     how the object looks
     * @param position  where the object is located.
     * @param _speed     the speed of the object
     * @param _rotation   the direction of the speed of the object
     */
    public MovingObject(Image image, PointF position, int _speed, float _rotation){
        super(image, position);
        speed=_speed;
        direction = _rotation;
        resetBounds();
    }
/*
METHODS
 */
    /**
     * Redraw the object according to how much time has past.
     */
    public void update(double elapsedTime){
        GraphicsUtils.MoveObjectResult new_pos = GraphicsUtils.moveObject(getPosition(), getBound(), speed, GraphicsUtils.degreesToRadians(direction), elapsedTime);
        if (rot_drift == ROTATION_DRIFT.CLOCKW) // Add on rotation drift amount since last time.
            setRotation((float)(getRotation() + ROTATION_DRIFT_SPEED * elapsedTime));
        else if (rot_drift == ROTATION_DRIFT.COUNTERCLOCKW)
            setRotation((float)(getRotation() - ROTATION_DRIFT_SPEED * elapsedTime));
        setMapCoords(new_pos.getNewObjPosition(), new_pos.getNewObjBounds());
    }
    /**
     * Time to be removed?
     */
    public boolean needsDeletion() {
        return is_hit;
    }
    /**
     * Time to be removed.
     */
    public void touch() {
        is_hit = true;
    }
    /**
     * Sets the current position
     * @param point
     */
    @Override
    public void setPosition(PointF point) {
        float width = bound.width();
        float height = bound.height();
        setMapCoords(point, new RectF(point.x - width / 2, point.y - height / 2, point.x + width / 2, point.y + height / 2));
    }
    /**
     * Resets the bounding box of the object used for collisions
     */
    public void resetBounds() {
        float max_dim;
        if (image.getHeight() > image.getWidth()) // Get the max between the two.
            max_dim = image.getHeight();
        else
            max_dim = image.getWidth();
        max_dim = max_dim*getScale();
        bound = new RectF(getPosition().x - max_dim / 2, getPosition().y - max_dim / 2, getPosition().x + max_dim / 2, getPosition().y + max_dim / 2);
    }
    /**
     * Sets the current position.
     * @param point     desired position
     * @param _bound    the bounding rectangle.
     */
    public void setMapCoords(PointF point, RectF _bound) {
        super.setPosition(point);
        bound = _bound;
    }
    /**
     * The setter for the scale of the moving object. Also resets bounds accordingly.
     */
    @Override
    public void setScale(float _scale) {
        super.setScale(_scale);
        resetBounds();
    }
    /**
     * The method enable a slight drift in rotation
     */
    public void enableRotationDrift() {
        if (Math.random() < .5) // 50% chance of cw or ccw rotation
            rot_drift = ROTATION_DRIFT.CLOCKW;
        else
            rot_drift = ROTATION_DRIFT.COUNTERCLOCKW;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The setter for direction of the object movement.
     * @param _direction
     */
    public void setDirection(float _direction) {
        direction=(_direction%360); // Only allow directions in the range. Scale appropriately.
        if(direction<0) direction+=360; // In case the value is negative.
    }
    /**
     * The getter for direction
     */
    public float getDirection(){return direction;}
    /**
     * The getter for the rotation drift speed
     * @return  the rotation drift speed
     */
    public float getRotationDriftSpeed() {return ROTATION_DRIFT_SPEED;}
    /**
     * The getter for the translational speed
     * @return  the translational speed
     */
    public int getSpeed() {return speed;}
    /**
     * The setter for the speed
     */
    public void setSpeed(int _speed){speed=_speed;}
    /**
     * The getter of the bounding box.
     */
    public RectF getBound() {return bound;}
}

package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the parts of a ship
 * @author Scott Leland Crossen
 */
public class Cannon extends ShipPart {
/*
FIELDS
 */
    /**
     * Where the image location is stored for the projectiles
     */
    private Image attack_image;
    /**
     * Where the sound is stored that is played when the cannon fires
     */
    private String attack_sound;
    /**
     * The power of the cannon is stored here
     */
    private int damage;
    /**
     * The location of where the projectiles leave the cannon is stored here
     */
    private MountPoint nozzle;
    private int attack_sound_content_id;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for a cannon
     * @param image         how the cannon looks
     * @param mount_point   where the cannon mounts onto the mainbody
     * @param _nozzle       where the projectiles leave the cannon from
     * @param _attack_image what the projectiles look like
     * @param _attack_sound the sound the cannon makes when it fires
     * @param _damage       how powerful the weapon is
     */
    public Cannon(Image image, MountPoint mount_point, MountPoint _nozzle, Image _attack_image, String _attack_sound, int _damage) {
        super(image, mount_point);
        nozzle = _nozzle;
        attack_image = _attack_image;
        attack_sound = _attack_sound;
        damage = _damage;
        attack_sound_content_id = -1;
    }
/*
METHODS
 */
    /**
     * The getter for the mount point where this part attaches.
     * @param main_body the main body it attaches to
     * @return the created mount point
     */
    @Override
    public MountPoint getBodyAttachPoint(MainBody main_body) {
        return main_body.getCannonAttach();
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter of the projectile image.
     * @return  the projectile image.
     */
    public Image getAttackImage() {return attack_image;}
    /**
     * The setter of the projectile image.
     * @param _attack_image   the projectile image.
     */
    public void setAttackImage(Image _attack_image) {attack_image = _attack_image;}
    /**
     * The setter of the projectile sound.
     * @return  the projectile sound.
     */
    public String getAttackSound() {return attack_sound;}
    /**
     * The setter of the projectile sound.
     * @param _attack_sound  the projectile sound.
     */
    public void setAttackSound(String _attack_sound) {attack_sound = attack_sound;}
    /**
     * The getter for the damage the cannon does
     * @return  the damage value.
     */
    public int getAttackSoundID() {return attack_sound_content_id;}
    /**
     * The getter for the attack sound ID
     */
    public void setAttackSoundID(int _id) {attack_sound_content_id = _id;}
    /**
     * The getter for the damage
     */
    public int getDamage() {return damage;}
    /**
     * The setter for the damage the cannon does.
     * @param damage    the damage value.
     */
    public void setDamage(int damage) {this.damage = damage;}
    /**
     * The getter of the mount-point of the nozzle.
     * @return  the mount-point of the nozzle.
     */
    public MountPoint getNozzle() {return nozzle;}
    /**
     * The setter of the mount-point of the nozzle.
     * @param nozzle    the mount-point of the nozzle.
     */
    public void setNozzle(MountPoint nozzle) {this.nozzle = nozzle;}
}

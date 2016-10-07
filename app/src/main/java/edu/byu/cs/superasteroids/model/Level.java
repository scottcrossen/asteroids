package edu.byu.cs.superasteroids.model;

import java.util.List;

import edu.byu.cs.superasteroids.model.asteroids.Asteroid;

/**
 * The level includes that information pertinent to the level being played.
 * @author Scott Leland Crossen
 */
public class Level {
/*
FIELDS
 */
    /**
    * The level index of the instantiated level is stored here.
    */
    private int level_number;
    /**
     * The title of the associated level is stored here as a string.
     */
    private String title;
    /**
     * The level hint of the current level is stored here as a string.
     */
    private String hint;
    /**
     * The width of the map of the level is stored here as a string.
     */
    private int width;
    /**
     * The height of the map of the level is stored here as a string.
     */
    private int height;
    /**
     * The path to the music file that plays during this level is stored here as a string.
     */
    private String music;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the level class
     * @param _level_number         the corresponding level number
     * @param _title                the title of the level
     * @param _hint                 the level hint
     * @param _width                the width of the level
     * @param _height               the height of the level
     * @param _music                the background music of the level
     * @param _background_objects   the background objects on the level
     * @param _level_asteroids      the asteroids on the level
     */
    public Level(int _level_number, String _title, String _hint, int _width, int _height, String _music, List<BackgroundObject> _background_objects, List<Asteroid> _level_asteroids) {}
/*
METHODS
 */
    /**
     * The draw method goes through all visible objects and draws them on the map.
     */
    public void draw() {}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the level number.
     * @return  the level number
     */
    public int getLevel_number() {
        return level_number;
    }
    /**
     * The getter for the level title
     * @return  the level title
     */
    public String getTitle() {
        return title;
    }
    /**
     * The getter for the level hint
     * @return
     */
    public String getHint() {
        return hint;
    }
    /**
     * The getter for the level width
     * @return  the level width
     */
    public int getWidth() {
        return width;
    }
    /**
     * The getter for the level height
     * @return  the level height
     */
    public int getHeight() {
        return height;
    }
    /**
     * The getter for the level music
     * @return  the level music
     */
    public String getMusic() {
        return music;
    }
}

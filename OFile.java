package kodia.kodia;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

/** Represents a custom and accessible YAML file manager.
 *
 * @author Antoine Blondon
 * @since 1.0
 *
 */
public class OFile {

    private File file;


    /** Creates an OFile with the specified name as its title.
     *
     * @param path A String representing the title of the file.
     */
    public OFile(String path) {
        File file = new File(String.format("plugins/General/%s.yml", path));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        this.file = file;
    }



    /** Creates an OFile with the specified string as its title in the specified folder.
     *  Dir: plugins/{folder}/{name}.yml
     *
     * @param folder The folder of the file.
     * @param path A String representing the name of the file.
     */
    public OFile(String folder, String path) {
        String f = folder.toLowerCase();
        String n = path.toLowerCase();

        File file = new File("plugins/"+ f +"/" + n + ".yml");
        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        this.file = file;
    }



    /** Sets the element at the path of this OFile to a new value.
     *
     * @param path A String representing the path of the element to change.
     * @param value An Object representing the new value of the changed element.
     */
    public void set(String path, Object value) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        conf.set(path, value);
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /** Gets an int at the specified path of this OFile.
     *
     * @param path A String representing the path of the int to get.
     * @return The int located at the specified path in this OFile.
     */
    public int getInt(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        if(conf.get(path) == null) {
            set(path, 0);
        }
        return conf.getInt(path);
    }

    /** Gets a String at the specified path of this OFile.
     *
     * @param path A String representing the path of the String to get.
     * @return The String located at the specified path in this OFile.
     */
    public String getString(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        if(conf.get(path) == null) {
            set(path, "");
        }
        return conf.getString(path);
    }

    /** Gets a boolean at the specified path of this OFile.
     *
     * @param path A String representing the path of the boolean to get.
     * @return The boolean located at the specified path in this OFile.
     */
    public boolean getBoolean(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        if(conf.get(path) == null) {
            set(path, false);
        }
        return conf.getBoolean(path);
    }


    /** Gets a List of unknown data type at the specified path of this OFile.
     *
     * @param path A String representing the path of the List to get.
     * @return The List of unknown data type located at the specified path in this OFile.
     */
    public List<?> getList(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        if(conf.get(path) == null) {
            set(path, new ArrayList<>());

        }
        return conf.getList(path);
    }


    /** Gets a Map of unknown data types at the specified path of this OFile.
     *
     * @param path A String representing the path of the Map to get.
     * @return The Map of unknown data types located at the specified path in this OFile.
     */
    public Map<?, ?> getMap(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        if(conf.get(path) == null) {
            set(path, new HashMap<>());
        }
        return conf.getMapList(path).get(0);
    }


    /** Gets an Object at the specified path of this OFile.
     *
     * @param path A String representing the path of the Object to get.
     * @return The Object located at the specified path in this OFile.
     */
    public Object get(String path) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        return conf.get(path);
    }



    /** Checks if the element located at the specified path of this OFile is null.
     *
     * @param path A String representing the path of the element to check.
     * @return True if the element is null. False otherwise.
     */
    public boolean isNull(String path) {
        return YamlConfiguration.loadConfiguration(file).get(path) == null;
    }

    /** Adds a specified value to the int located at the specified path of this OFile.
     *
     * @param path A String representing the path of the int to increment.
     * @param value An int representing the value to add.
     */
    public void addToInt(String path, int value) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        conf.set(path, conf.getInt(path)+value);
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Adds an element to the List located at the specified path of this OFile.
     *
     * @param path A String representing the path of the List.
     * @param element An Object to add to the specified List.
     */
    @SuppressWarnings("unchecked")
    public void addToList(String path, Object element) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        List<Object> list = new ArrayList<>();

        if(conf.get(path) != null) {
            list = (List<Object>) conf.getList(path);
        }

        list.add(element);

        conf.set(path, list);
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Removes an element from the List located at the specified path of this OFile.
     *
     * @param path A String representing the path of the List.
     * @param o An Object to remove from the specified List.
     */
    @SuppressWarnings("unchecked")
    public void removeFromList(String path, Object o) {
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        List<Object> list = new ArrayList<>();

        if(conf.get(path) != null) {
            list = (List<Object>) conf.getList(path);
        }

        list.remove(o);

        conf.set(path, list);
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /** Gets the File from this OFile.
     *
     * @return A File with the path of this OFile.
     */
    public File toFile() {
        return file;
    }

    /** Gets the YamlConfiguration from this OFile.
     *
     * @return A YamlConfiguration got from the File of this OFile.
     */
    public YamlConfiguration toYaml() {
        return YamlConfiguration.loadConfiguration(file);
    }


    /**
     * Retrieves a set of keys from the YAML configuration section at the specified path.
     * This method can operate in two modes, determined by the `deep` parameter: if `deep` is true,
     * it will return all keys within the configuration section, including nested ones; if `deep` is false,
     * only first-level keys are returned.
     *
     * @param path A string representing the path to the configuration section from which the keys are to be fetched.
     *             If the path is null or does not exist, an empty set is returned.
     * @param deep A boolean indicating whether to fetch keys recursively (`true`) or only at the first level (`false`).
     * @return A set of strings containing the keys found at the specified path. If the specified path does not
     *         lead to a valid configuration section or is null, an empty set is returned. This ensures that the method
     *         call is safe and will not result in a NullPointerException.
     */
    public Set<String> keys(String path, boolean deep) {
        ConfigurationSection config = toYaml().getConfigurationSection(path);
        if(config == null) return new HashSet<>();
        return config.getKeys(deep);
    }


}
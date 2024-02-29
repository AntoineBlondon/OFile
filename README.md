# OFile - YAML Configuration Manager for Bukkit/Spigot Plugins

`OFile` is a Java class designed to simplify interactions with YAML configuration files within Bukkit and Spigot Minecraft server plugins. It provides an easy-to-use API for reading and writing data to YAML files, making plugin development more efficient and straightforward.

## Features

- Easy creation and management of YAML configuration files.
- Supports basic CRUD operations for configuration data.
- Automatic handling of file creation and existence checks.
- Methods for reading and writing various data types, including strings, integers, booleans, lists, and maps.

## Getting Started

### Prerequisites

- JDK 8 or newer.
- Bukkit or Spigot server.

### Installation

To use `OFile` in your project, follow these steps:

1. Download the `OFile.java` file from this repository.
2. Add the file to your plugin's source code directory.
3. Ensure your project is set up to compile with the Bukkit/Spigot API.

### Usage

Here's a quick example to get you started:

```java
import kodia.kodia.OFile;

public class YourPluginClass {

    public void someMethod() {
        // Creating a new OFile instance for "example" config
        OFile configFile = new OFile("example");

        // Setting a value
        configFile.set("path.to.value", "This is a value");

        // Getting a value
        String value = configFile.getString("path.to.value");
        System.out.println(value); // Outputs: This is a value
    }
}
```

Replace `"example"` with the name of your YAML file (without the `.yml` extension), and adapt the code to fit your plugin's structure and requirements.

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.
